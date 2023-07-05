package io.github.group.robot.feishu.core.model;

import io.github.group.robot.feishu.core.constants.MessageType;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

/**
 * 文本消息 <a href="https://open.feishu.cn/document/client-docs/bot-v3/add-custom-bot#756b882f">发送文本消息</a>
 *
 * @author <a href="mailto:huangbing0730@gmail">hb0730</a>
 * @date 2021/12/16
 */
@Getter
@Setter
public class TextMessage extends BaseMessage {
    public TextMessage() {
        super();
    }

    public TextMessage(String content) {
        super();
        this.content = content;
    }

    /**
     * 内容
     */
    private String content;
    /**
     * 是否at所有
     */
    private Boolean atAll;

    @Override
    protected void init() {
        this.msgType = MessageType.TEXT;
    }

    @Override
    public Map<String, Object> toMessage() {
        Map<String, Object> contentMap = new HashMap<>(1);
        if (this.atAll) {
            contentMap.put("text", "<at user_id=\"all\">所有</at> " + this.content);
        } else {
            contentMap.put("text", this.content);
        }
        Map<String, Object> textMap = new HashMap<>(2);
        textMap.put("msg_type", this.msgType.getValue());
        textMap.put("content", contentMap);
        return textMap;
    }

    /**
     * create {@link  TextMessageBuilder}
     *
     * @return {@link  TextMessageBuilder}
     */
    public static TextMessageBuilder builder() {
        return TextMessageBuilder.builder();
    }

    /**
     * {@link  TextMessage} Builder
     */
    public static class TextMessageBuilder implements Builder<TextMessage> {
        private final TextMessage message;

        /**
         * create {@link  TextMessageBuilder}
         *
         * @return this
         */
        public static TextMessageBuilder builder() {
            return new TextMessageBuilder(new TextMessage());
        }

        private TextMessageBuilder(TextMessage message) {
            this.message = message;
        }

        /**
         * set content
         *
         * @param content content
         * @return this
         */
        public TextMessageBuilder content(String content) {
            this.message.setContent(content);
            return this;
        }

        /**
         * set at_all
         *
         * @param atAll .
         * @return this
         */
        public TextMessageBuilder atAll(Boolean atAll) {
            this.message.setAtAll(atAll);
            return this;
        }

        @Override
        public TextMessage build() {
            return this.message;
        }
    }
}
