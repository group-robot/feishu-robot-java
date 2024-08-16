package io.github.group.robot.feishu.core.model.card.components.interactive.ele;

import io.github.group.robot.feishu.core.constants.TextTag;
import io.github.group.robot.feishu.core.model.IMessage;
import io.github.group.robot.feishu.core.model.card.components.ele.IconEl;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

/**
 * 卡片组件 - 交互 - 下拉选择-选项
 *
 * @author <a href="mailto:huangbing0730@gmail">hb0730</a>
 * @date 2024/8/7
 */
@Getter
@Setter
public class SelectOption implements IMessage {
    /**
     * 选项的名称
     */
    private String text;
    /**
     * 添加图标作为文本前缀图标。支持自定义或使用图标库中的图标。
     */
    private IconEl icon;
    /**
     * 自定义选项回调值
     */
    private String value;

    public SelectOption() {
    }

    public SelectOption(String text, String value) {
        this.text = text;
        this.value = value;
    }

    public SelectOption setText(String text) {
        this.text = text;
        return this;
    }

    public SelectOption setIcon(IconEl icon) {
        this.icon = icon;
        return this;
    }

    public SelectOption setValue(String value) {
        this.value = value;
        return this;
    }

    @Override
    public Map<String, Object> toMessage() {
        Map<String, Object> message = new HashMap<>(3);
        Map<String, Object> textMap = new HashMap<>(2);
        textMap.put("content", text);
        textMap.put("tag", TextTag.PLAIN_TEXT.getValue());
        message.put("text", textMap);
        if (icon != null) {
            message.put("icon", icon.toMessage());
        }
        message.put("value", value);
        return message;
    }

    public static SelectOption of(String text, String value) {
        return new SelectOption(text, value);
    }

    public static SelectOption of() {
        return new SelectOption();
    }
}
