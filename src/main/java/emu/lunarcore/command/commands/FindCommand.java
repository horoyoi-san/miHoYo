package emu.lunarcore.command.commands;

import emu.lunarcore.command.Command;
import emu.lunarcore.command.CommandArgs;
import emu.lunarcore.command.CommandHandler;
import emu.lunarcore.util.JsonUtils;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;

@Command(
        label = "find",
        aliases = {"f"},
        permission = "player.find",
        desc = "/find [关键词] - 查询游戏中所有带有此关键词的文本."
)
public class FindCommand implements CommandHandler {

    private Map<Long, String> textMap;
    private static final int RESULTS_PER_PAGE = 50; // 每页显示的结果数量

    public FindCommand() {
        loadTextMap();
    }

    private void loadTextMap() {
        String language = "CHS";
        try {
            textMap = JsonUtils.loadToMap("resources/TextMap/TextMap" + language + ".json", Long.class, String.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void execute(CommandArgs args) {
        if (args.size() == 0) {
            args.sendMessage("请提供一个关键词。");
            return;
        }

        String keyword = args.get(0);
        List<String> results = new ArrayList<>();
        
        // 收集所有匹配的结果
        for (Map.Entry<Long, String> entry : textMap.entrySet()) {
            if (entry.getValue().contains(keyword)) {
                results.add(entry.getKey() + ": " + entry.getValue());
            }
        }

        if (!results.isEmpty()) {
            // 分页发送结果
            List<String> pages = createPages(results);
            for (int i = 0; i < pages.size(); i++) {
                args.sendMessage("第 " + (i + 1) + " 页/共 " + pages.size() + " 页:\n" + pages.get(i));
            }
        } else {
            args.sendMessage("没有找到带有关键词 '" + keyword + "' 的文本。");
        }
    }

    // 创建每页的结果
    // 创建每页的结果
private List<String> createPages(List<String> allResults) {
    List<String> pages = new ArrayList<>();
    StringBuilder page = new StringBuilder();

    for (int i = 0; i < allResults.size(); i++) {
        if (i > 0 && i % RESULTS_PER_PAGE == 0) {
            pages.add(page.toString().trim()); // 添加当前页并去除尾部空格
            page.setLength(0); // 清空当前页内容
        }
        page.append("结果 ").append(i + 1).append(": ").append(allResults.get(i)).append("; "); // 使用分号作为分隔符
    }

    if (page.length() > 0) {
        pages.add(page.toString().trim()); // 添加最后一页，并去掉末尾的空格
    }

    return pages;
    }
}
