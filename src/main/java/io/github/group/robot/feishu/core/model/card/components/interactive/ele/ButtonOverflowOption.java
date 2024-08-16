package io.github.group.robot.feishu.core.model.card.components.interactive.ele;

import io.github.group.robot.feishu.core.constants.TextTag;
import io.github.group.robot.feishu.core.model.Builder;
import io.github.group.robot.feishu.core.model.IMessage;
import io.github.group.robot.feishu.core.model.card.components.ele.ContentI18n;
import io.github.group.robot.feishu.core.model.card.components.ele.UrlEl;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

/**
 * 卡片组件 - 交互 - 折叠按钮组-option
 *
 * @author <a href="mailto:huangbing0730@gmail">hb0730</a>
 * @date 2024/8/7
 */
@Getter
@Setter
public class ButtonOverflowOption implements IMessage {
    /**
     * 按钮上的文本
     */
    private ContentI18n text;
    /**
     * 为按钮添加多端的跳转链接。
     */
    private UrlEl multiUrl;
    /**
     * 该按钮的回传参数值。
     */
    private String value;


    @Override
    public Map<String, Object> toMessage() {
        Map<String, Object> message = new java.util.HashMap<>(3);
        if (text != null) {
            Map<String, Object> textMap = text.toMessage();
            textMap.put("tag", TextTag.PLAIN_TEXT.getValue());
            message.put("text", textMap);
        }
        if (multiUrl != null) {
            message.put("multi_url", multiUrl.toMessage());
        }
        if (value != null) {
            message.put("value", value);
        }
        return message;
    }

    public static OverflowButtonOptionBuilder builder() {
        return new OverflowButtonOptionBuilder();
    }

    /**
     * 构造器
     */
    public static class OverflowButtonOptionBuilder implements Builder<ButtonOverflowOption> {
        private final ButtonOverflowOption buttonOverflowOption = new ButtonOverflowOption();

        private OverflowButtonOptionBuilder() {
        }

        /**
         * 按钮上的文本
         *
         * @param text 按钮上的文本
         * @return .
         */
        public OverflowButtonOptionBuilder setText(ContentI18n text) {
            buttonOverflowOption.setText(text);
            return this;
        }

        /**
         * 为按钮添加多端的跳转链接。
         *
         * @param multiUrl 为按钮添加多端的跳转链接。
         * @return .
         */
        public OverflowButtonOptionBuilder setMultiUrl(UrlEl multiUrl) {
            buttonOverflowOption.setMultiUrl(multiUrl);
            return this;
        }

        /**
         * 该按钮的回传参数值。
         *
         * @param value 该按钮的回传参数值。
         * @return .
         */
        public OverflowButtonOptionBuilder setValue(String value) {
            buttonOverflowOption.setValue(value);
            return this;
        }

        @Override
        public ButtonOverflowOption build() {
            return buttonOverflowOption;
        }
    }
}
