package io.github.group.robot.feishu.core.model.card.components.interactive.ele;

import io.github.group.robot.feishu.core.model.IMessage;
import io.github.group.robot.feishu.core.model.card.components.interactive.Button;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 卡片组件 - 交互 - 勾选器 - 按钮区配置。
 *
 * @author <a href="mailto:huangbing0730@gmail">hb0730</a>
 * @date 2024/8/8
 */
@Getter
@Setter
public class CheckButtonArea implements IMessage {
    /**
     * PC 端勾选器内按钮的展示规则
     * <ul>
     * <li>always: 按钮始终显示。</li>
     * <li>hover: 鼠标悬浮在勾选器上时显示。</li>
     * </ul>
     */
    private String pcDisplayRule;

    /**
     * 在勾选器中添加并配置按钮。最多可配置三个按钮。
     */
    private List<Button> buttons;

    public CheckButtonArea() {
    }


    public CheckButtonArea(String pcDisplayRule, List<Button> buttons) {
        this.pcDisplayRule = pcDisplayRule;
        this.buttons = buttons;
    }


    /**
     * 设置 PC 端勾选器内按钮的展示规则
     * <ul>
     * <li>always: 按钮始终显示。</li>
     * <li>hover: 鼠标悬浮在勾选器上时显示。</li>
     * </ul>
     */
    public CheckButtonArea setPcDisplayRule(String pcDisplayRule) {
        this.pcDisplayRule = pcDisplayRule;
        return this;
    }

    /**
     * 设置在勾选器中添加并配置按钮。最多可配置三个按钮。
     *
     * @param buttons 按钮
     * @return CheckButtonArea
     */
    public CheckButtonArea setButtons(List<Button> buttons) {
        this.buttons = buttons;
        return this;
    }

    /**
     * 设置在勾选器中添加并配置按钮。最多可配置三个按钮。
     *
     * @param buttons 按钮
     * @return CheckButtonArea
     */
    public CheckButtonArea setButtons(Button... buttons) {
        if (this.buttons == null) {
            this.buttons = new ArrayList<>();
        }
        Collections.addAll(this.buttons, buttons);
        return this;
    }

    /**
     * 添加按钮
     *
     * @param button 按钮
     * @return CheckButtonArea
     */
    public CheckButtonArea addButton(Button... button) {
        if (this.buttons == null) {
            this.buttons = new ArrayList<>();
        }
        Collections.addAll(this.buttons, button);
        return this;
    }

    /**
     * 添加按钮
     *
     * @param buttons 按钮
     * @return CheckButtonArea
     */
    public CheckButtonArea addButton(List<Button> buttons) {
        if (this.buttons == null) {
            this.buttons = new ArrayList<>();
        }
        this.buttons.addAll(buttons);
        return this;
    }

    @Override
    public Map<String, Object> toMessage() {
        Map<String, Object> message = new HashMap<>(2);
        if (pcDisplayRule != null) {
            message.put("pc_display_rule", pcDisplayRule);
        }
        if (buttons != null) {
            List<Map<String, Object>> buttonMap = new ArrayList<>(buttons.size());
            for (Button button : buttons) {
                buttonMap.add(button.toMessage());
            }
            message.put("buttons", buttonMap);
        }
        return message;
    }

    /**
     * 创建一个 CheckButtonArea 对象
     *
     * @param pcDisplayRule PC 端勾选器内按钮的展示规则
     * @param buttons       在勾选器中添加并配置按钮。最多可配置三个按钮。
     * @return CheckButtonArea 对象
     */
    public static CheckButtonArea of(String pcDisplayRule, List<Button> buttons) {
        return new CheckButtonArea(pcDisplayRule, buttons);
    }

    /**
     * 创建一个 CheckButtonArea 对象
     *
     * @return CheckButtonArea 对象
     */
    public static CheckButtonArea of() {
        return new CheckButtonArea();
    }
}
