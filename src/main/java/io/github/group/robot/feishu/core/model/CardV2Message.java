package io.github.group.robot.feishu.core.model;

import io.github.group.robot.feishu.core.constants.MessageType;
import io.github.group.robot.feishu.core.model.card.CardBody;
import io.github.group.robot.feishu.core.model.card.CardConfig;
import io.github.group.robot.feishu.core.model.card.CardHeader;
import io.github.group.robot.feishu.core.model.card.CardLink;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

/**
 * 消息卡片 <a href="https://open.feishu.cn/document/client-docs/bot-v3/add-custom-bot#4996824a">发送消息卡片</a>
 *
 * @author <a href="mailto:huangbing0730@gmail">hb0730</a>
 * @date 2024/8/8
 */
@Getter
@Setter
public class CardV2Message extends BaseMessage {
    /**
     * 标题组件相关配置。详情参考标题组件。
     */
    private CardHeader header;
    /**
     * card_link 字段用于指定卡片整体的点击跳转链接。你可以配置一个默认链接，也可以分别为 PC 端、Android 端、iOS 端配置不同的跳转链接。
     */
    private CardLink cardLink;
    /**
     * config 用于配置卡片的全局行为，包括流式更新模式、是否允许被转发、是否为共享卡片等。
     */
    private CardConfig config;
    /**
     * 卡片正文，包含一个名为 elements 的数组，用于放置各类组件。
     */
    private CardBody body;

    @Override
    public Map<String, Object> toMessage() {
        Map<String, Object> message = new HashMap<>(2);
        message.put("msg_type", msgType.getValue());

        Map<String, Object> cardContent = new HashMap<>(4);
        if (header != null) {
            cardContent.put("header", header.toMessage());
        }
        if (cardLink != null) {
            cardContent.put("card_link", cardLink.toMessage());
        }
        if (config != null) {
            cardContent.put("config", config.toMessage());
        }
        if (body != null) {
            cardContent.put("body", body.toMessage());
        }
        cardContent.put("schema", "2.0");
        message.put("card", cardContent);
        return message;
    }

    @Override
    protected void init() {
        msgType = MessageType.INTERACTIVE;
    }

    public static InteractiveMessageBuilder builder() {
        return new InteractiveMessageBuilder();
    }

    public static class InteractiveMessageBuilder implements Builder<CardV2Message> {
        private final CardV2Message cardV2Message;

        private InteractiveMessageBuilder() {
            this.cardV2Message = new CardV2Message();
        }

        /**
         * 设置标题组件相关配置
         *
         * @param header 标题组件相关配置
         * @return .
         */
        public InteractiveMessageBuilder setHeader(CardHeader header) {
            this.cardV2Message.setHeader(header);
            return this;
        }

        /**
         * 设置card_link 字段用于指定卡片整体的点击跳转链接
         *
         * @param cardLink card_link 字段用于指定卡片整体的点击跳转链接
         * @return .
         */
        public InteractiveMessageBuilder setCardLink(CardLink cardLink) {
            this.cardV2Message.setCardLink(cardLink);
            return this;
        }

        /**
         * 设置config 用于配置卡片的全局行为
         *
         * @param config config 用于配置卡片的全局行为
         * @return .
         */
        public InteractiveMessageBuilder setConfig(CardConfig config) {
            this.cardV2Message.setConfig(config);
            return this;
        }

        /**
         * 设置卡片正文
         *
         * @param body 卡片正文
         * @return .
         */
        public InteractiveMessageBuilder setBody(CardBody body) {
            this.cardV2Message.setBody(body);
            return this;
        }

        @Override
        public CardV2Message build() {
            return this.cardV2Message;
        }
    }
}
