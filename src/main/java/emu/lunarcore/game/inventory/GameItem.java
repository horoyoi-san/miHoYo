package emu.lunarcore.game.inventory;

import dev.morphia.annotations.AlsoLoad;
import dev.morphia.annotations.Entity;
import dev.morphia.annotations.Id;
import dev.morphia.annotations.Indexed;
import dev.morphia.annotations.LoadOnly;
import emu.lunarcore.LunarCore;
import emu.lunarcore.data.GameData;
import emu.lunarcore.data.GameDepot;
import emu.lunarcore.data.excel.ItemExcel;
import emu.lunarcore.data.excel.RelicMainAffixExcel;
import emu.lunarcore.data.excel.RelicSubAffixExcel;
import emu.lunarcore.game.avatar.BaseAvatar;
import emu.lunarcore.game.enums.AvatarPropertyType;
import emu.lunarcore.game.enums.ItemMainType;
import emu.lunarcore.game.inventory.GameItemSubAffix;
import emu.lunarcore.game.player.Player;
import emu.lunarcore.proto.EquipmentOuterClass;
import emu.lunarcore.proto.ItemOuterClass;
import emu.lunarcore.proto.MaterialOuterClass;
import emu.lunarcore.proto.PileItemOuterClass;
import emu.lunarcore.proto.PlayerSyncScNotifyOuterClass;
import emu.lunarcore.proto.RelicOuterClass;
import emu.lunarcore.server.game.Syncable;
import emu.lunarcore.util.Utils;
import emu.lunarcore.util.WeightedList;
import it.unimi.dsi.fastutil.ints.IntOpenHashSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.bson.types.ObjectId;

@Entity(value="items", useDiscriminator=false)
public class GameItem
implements Syncable {
    @Id
    private ObjectId id;
    @Indexed
    private int ownerUid;
    private transient int internalUid;
    private transient ItemExcel excel;
    private int itemId;
    private int count;
    private int level;
    private int exp;
    private int totalExp;
    private int promotion;
    private int rank;
    private boolean locked;
    private boolean discarded;
    private int mainAffix;
    private List<GameItemSubAffix> subAffixes;
    @Indexed
    private ObjectId equipAvatarId;
    private transient BaseAvatar equipAvatar;
    @LoadOnly
    @AlsoLoad(value={"equipAvatar"})
    private int equipAvatarExcelId;

    @Deprecated
    public GameItem() {
    }

    public GameItem(int itemId) {
        this((ItemExcel)GameData.getItemExcelMap().get(itemId));
    }

    public GameItem(int itemId, int count) {
        this((ItemExcel)GameData.getItemExcelMap().get(itemId), count);
    }

    public GameItem(ItemExcel data2) {
        this(data2, 1);
    }

    public GameItem(ItemExcel excel, int count) {
        this(excel, count, 0);
    }

    public GameItem(ItemExcel excel, int count, int overrideMainAffix) {
        this.itemId = excel.getId();
        this.excel = excel;
        switch (excel.getItemMainType()) {
            case Virtual: {
                this.count = count;
                break;
            }
            case Equipment: {
                this.count = 1;
                this.level = 1;
                this.rank = 1;
                break;
            }
            case Relic: {
                this.count = 1;
                if (this.getExcel().getRelicExcel() == null) break;
                if (overrideMainAffix > 0) {
                    this.mainAffix = overrideMainAffix;
                } else {
                    RelicMainAffixExcel affix = GameDepot.getRandomRelicMainAffix(this.getExcel().getRelicExcel().getMainAffixGroup());
                    if (affix != null) {
                        this.mainAffix = affix.getAffixID();
                    }
                }
                int baseSubAffixes = Math.min(Math.max(this.getExcel().getRarity().getVal() - 2, 0), 3);
                this.addSubAffixes(Utils.randomRange(baseSubAffixes, baseSubAffixes + 1));
                this.sortSubAffixes();
                break;
            }
            default: {
                this.count = Math.min(count, excel.getPileLimit());
            }
        }
    }

    public void setOwner(Player player) {
        this.ownerUid = player.getUid();
        this.internalUid = player.getInventory().getNextItemInternalUid();
    }

    public void setExcel(ItemExcel excel) {
        this.excel = excel;
    }

    public ItemMainType getItemMainType() {
        return this.excel.getItemMainType();
    }

    public int getEquipSlot() {
        return this.excel.getEquipSlot();
    }

    public boolean isEquipped() {
        return this.getEquipAvatarId() != null;
    }

    public boolean isDestroyable() {
        return !this.isLocked() && !this.isEquipped();
    }

    public boolean setCount(int count) {
        if (this.count != count) {
            this.count = count;
            return true;
        }
        return false;
    }

    public boolean setEquipAvatar(BaseAvatar baseAvatar) {
        if (baseAvatar == null && this.isEquipped()) {
            this.equipAvatarId = null;
            this.equipAvatar = null;
            this.equipAvatarExcelId = 0;
            return true;
        }
        if (this.equipAvatarId != baseAvatar.getId()) {
            this.equipAvatarId = baseAvatar.getId();
            this.equipAvatar = baseAvatar;
            this.equipAvatarExcelId = 0;
            return true;
        }
        return false;
    }

    public void resetSubAffixes() {
        if (this.subAffixes != null) {
            this.subAffixes.clear();
        } else {
            this.subAffixes = new ArrayList<GameItemSubAffix>();
        }
    }

    public void addSubAffixes(int quantity) {
        for (int i = 0; i < quantity; ++i) {
            this.addSubAffix();
        }
    }

    public void addSubAffix() {
        if (this.subAffixes == null) {
            this.subAffixes = new ArrayList<GameItemSubAffix>();
        }
        if (this.subAffixes.size() < 4) {
            this.addNewSubAffix();
        } else {
            this.upgradeRandomSubAffix();
        }
    }

    private void addNewSubAffix() {
        List<RelicSubAffixExcel> affixList = GameDepot.getRelicSubAffixList(this.getExcel().getRelicExcel().getSubAffixGroup());
        if (affixList == null) {
            return;
        }
        AvatarPropertyType mainAffixProperty = AvatarPropertyType.Unknown;
        RelicMainAffixExcel mainAffix = GameData.getRelicMainAffixExcel(this.getExcel().getRelicExcel().getMainAffixGroup(), this.mainAffix);
        if (mainAffix != null) {
            mainAffixProperty = mainAffix.getProperty();
        }
        IntOpenHashSet blacklist = new IntOpenHashSet();
        for (GameItemSubAffix gameItemSubAffix : this.getSubAffixes()) {
            blacklist.add(gameItemSubAffix.getId());
        }
        WeightedList<RelicSubAffixExcel> randomList = new WeightedList<RelicSubAffixExcel>();
        for (RelicSubAffixExcel affix : affixList) {
            if (affix.getProperty() == mainAffixProperty || blacklist.contains(affix.getAffixID())) continue;
            randomList.add(10.0, affix);
        }
        if (randomList.size() == 0) {
            return;
        }
        RelicSubAffixExcel relicSubAffixExcel = (RelicSubAffixExcel)randomList.next();
        this.subAffixes.add(new GameItemSubAffix(relicSubAffixExcel));
    }

    private void upgradeRandomSubAffix() {
        GameItemSubAffix subAffix = Utils.randomElement(this.subAffixes);
        RelicSubAffixExcel subAffixExcel = GameData.getRelicSubAffixExcel(this.getExcel().getRelicExcel().getSubAffixGroup(), subAffix.getId());
        subAffix.incrementCount(subAffixExcel.getStepNum());
    }

    public int getCurrentSubAffixCount() {
        if (this.subAffixes == null) {
            return 0;
        }
        return this.subAffixes.stream().reduce(0, (subtotal, subAffix) -> subtotal + subAffix.getCount(), Integer::sum);
    }

    public int getMaxNormalSubAffixCount() {
        return this.getExcel().getRarity().getVal() - 1 + (int)Math.floor((double)this.getLevel() / 3.0);
    }

    public void sortSubAffixes() {
        if (this.subAffixes == null || this.subAffixes.size() == 0) {
            return;
        }
        Collections.sort(this.subAffixes);
    }

    public void save() {
        if (this.count > 0 && this.ownerUid > 0) {
            LunarCore.getGameDatabase().save(this);
        } else if (this.getId() != null) {
            LunarCore.getGameDatabase().delete(this);
        }
    }

    @Override
    public void onSync(PlayerSyncScNotifyOuterClass.PlayerSyncScNotify proto) {
        switch (this.getExcel().getItemMainType().getTabType()) {
            case MATERIAL: {
                proto.addMaterialList(this.toMaterialProto());
                break;
            }
            case RELIC: {
                if (this.getCount() > 0) {
                    proto.addRelicList(this.toRelicProto());
                    break;
                }
                proto.addDelRelicList(this.getInternalUid());
                break;
            }
            case EQUIPMENT: {
                if (this.getCount() > 0) {
                    proto.addEquipmentList(this.toEquipmentProto());
                    break;
                }
                proto.addDelEquipmentList(this.getInternalUid());
                break;
            }
        }
    }

    public MaterialOuterClass.Material toMaterialProto() {
        MaterialOuterClass.Material proto = MaterialOuterClass.Material.newInstance().setTid(this.getItemId()).setNum(this.getCount());
        return proto;
    }

    public RelicOuterClass.Relic toRelicProto() {
        RelicOuterClass.Relic proto = RelicOuterClass.Relic.newInstance().setTid(this.getItemId()).setUniqueId(this.getInternalUid()).setLevel(this.getLevel()).setExp(this.getExp()).setIsProtected(this.isLocked()).setIsDiscarded(this.isDiscarded()).setMainAffixId(this.mainAffix);
        if (this.getEquipAvatar() != null) {
            proto.setEquipAvatarId(this.getEquipAvatar().getExcelId());
        }
        if (this.subAffixes != null) {
            for (GameItemSubAffix subAffix : this.subAffixes) {
                proto.addSubAffixList(subAffix.toProto());
            }
        }
        return proto;
    }

    public EquipmentOuterClass.Equipment toEquipmentProto() {
        EquipmentOuterClass.Equipment proto = EquipmentOuterClass.Equipment.newInstance().setTid(this.getItemId()).setUniqueId(this.getInternalUid()).setLevel(this.getLevel()).setExp(this.getExp()).setIsProtected(this.isLocked()).setPromotion(this.getPromotion()).setRank(this.getRank());
        if (this.getEquipAvatar() != null) {
            proto.setEquipAvatarId(this.getEquipAvatar().getExcelId());
        }
        return proto;
    }

    public PileItemOuterClass.PileItem toPileProto() {
        return PileItemOuterClass.PileItem.newInstance().setItemId(this.getItemId()).setItemNum(this.getCount());
    }

    public ItemOuterClass.Item toProto() {
        return ItemOuterClass.Item.newInstance().setItemId(this.getItemId()).setNum(this.getCount()).setLevel(this.getLevel()).setMainAffixId(this.getMainAffix()).setRank(this.getRank()).setPromotion(this.getPromotion()).setUniqueId(this.getInternalUid());
    }

    public ObjectId getId() {
        return this.id;
    }

    public int getOwnerUid() {
        return this.ownerUid;
    }

    public int getInternalUid() {
        return this.internalUid;
    }

    public ItemExcel getExcel() {
        return this.excel;
    }

    public int getItemId() {
        return this.itemId;
    }

    public int getCount() {
        return this.count;
    }

    public int getLevel() {
        return this.level;
    }

    public int getExp() {
        return this.exp;
    }

    public int getTotalExp() {
        return this.totalExp;
    }

    public int getPromotion() {
        return this.promotion;
    }

    public int getRank() {
        return this.rank;
    }

    public boolean isLocked() {
        return this.locked;
    }

    public boolean isDiscarded() {
        return this.discarded;
    }

    public int getMainAffix() {
        return this.mainAffix;
    }

    public List<GameItemSubAffix> getSubAffixes() {
        return this.subAffixes;
    }

    public ObjectId getEquipAvatarId() {
        return this.equipAvatarId;
    }

    public BaseAvatar getEquipAvatar() {
        return this.equipAvatar;
    }

    public int getEquipAvatarExcelId() {
        return this.equipAvatarExcelId;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public void setTotalExp(int totalExp) {
        this.totalExp = totalExp;
    }

    public void setPromotion(int promotion) {
        this.promotion = promotion;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    public void setDiscarded(boolean discarded) {
        this.discarded = discarded;
    }

    public void setMainAffix(int mainAffix) {
        this.mainAffix = mainAffix;
    }
}

