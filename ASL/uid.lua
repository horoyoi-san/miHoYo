local function beta_text()
  local gameObject = CS.UnityEngine.GameObject.Find("UIRoot/AboveDialog/BetaHintDialog(Clone)")

  if gameObject then
      local textComponent = gameObject:GetComponentInChildren(typeof(CS.RPG.Client.LocalizedText))

      if textComponent then
          textComponent.text = "<color=#ff0400>T</color><color=#ff0400>h</color><color=#ffffff>a</color><color=#000dff>i</color><color=#000dff>l</color> <color=#ffffff>a</color><color=#ff0400>n</color><color=#ff0400>d</color>|<color=#ff0000>Horoyoi-san SR</color>"
      else
          -- log:write("No Text component found on the game object")
      end
  else
      -- log:write("Game object not found")
  end
end

local function mhy_text()
  local gameObject = CS.UnityEngine.GameObject.Find("IDMAP1")

  if gameObject then
      local textComponent = gameObject:GetComponentInChildren(typeof(CS.RPG.Client.MessageBoxDialogUtil))

      if textComponent then
          textComponent.ShowAboveDialogText = false
      else
          -- log:write("No Text component found on the game object")
      end
  else
      -- log:write("Game object not found")
  end
end

local function modify_ping_texts()
  local OldPing = CS.UnityEngine.GameObject.Find("/UIRoot/Page/MazeMainPage(Clone)/RightTopArea/NetStatusPanel/NetStatusPanel(Clone)/Connected/Time")
  local OldPing2 = CS.UnityEngine.GameObject.Find("/UIRoot/Page/BattleGamePhaseUI(Clone)/FunctionArea/NetStatusPanel/NetStatusPanel/Connected/Time")

  if OldPing then
    local NewPing = CS.UnityEngine.GameObject.Instantiate(OldPing, OldPing.transform.parent)
    NewPing.name = "Time(Clone)"
    NewPing:GetComponent("Text").text = tostring("<color=#00e1ff>Horoyoi-san SR</color>")
    OldPing:SetActive(false)
  end

  if OldPing2 then
    local NewPing2 = CS.UnityEngine.GameObject.Instantiate(OldPing2, OldPing2.transform.parent)
    NewPing2.name = "Time2(Clone)"
    OldPing2:SetActive(false)
    NewPing2:GetComponent("Text").text = tostring("<color=#ff0400>T</color><color=#ff0400>h</color><color=#ffffff>a</color><color=#000dff>i</color><color=#000dff>l</color><color=#ffffff>a</color><color=#ff0400>n</color><color=#ff0400>d</color>|<color=#ff0000>Horoyoi-san SR</color>")
  end
end

xpcall(function()
  local obj = CS.UnityEngine.GameObject.Find("TeamMemberIconChibi02 (1)")
  if obj then
      obj:GetComponentInChildren(typeof(CS.RPG.Client.LocalizedText)).text = "<color=#00e1ff>Horoyoi-san SR</color>"
  end
end, function() end)

local on_error = function(error)
  CS.UnityEngine.Application.targetFrameRate = 90
  CS.UnityEngine.QualitySettings.vSyncCount = 0
  local files = io.open("./error.txt", "w")
  files:write(error)
  files:close()
end

xpcall(modify_ping_texts, on_error)
xpcall(version_text, on_error)
xpcall(beta_text, on_error)
xpcall(mhy_text, on_error)
