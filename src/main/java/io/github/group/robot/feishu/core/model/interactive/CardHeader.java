package io.github.group.robot.feishu.core.model.interactive;

import io.github.group.robot.feishu.core.model.Builder;
import io.github.group.robot.feishu.core.model.IMessage;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

/**
 * 卡片标题
 *
 * @author <a href="mailto:huangbing0730@gmail">hb0730</a>
 * @date 2021/12/16
 */
@Getter
@Setter
public class CardHeader implements IMessage {
    /**
     * 卡片标题-内容
     */
    private CardTitle title;
    /**
     * 主题色
     *
     * @see io.github.group.robot.feishu.core.constants.TemplateStyleColor
     */
    private String template;

    @Override
    public Map<String, Object> toMessage() {
        Map<String, Object> message = new HashMap<>();
        message.put("title", this.title.toMessage());
        message.put("template", this.template);
        return message;
    }

    /**
     * 构造器
     *
     * @return .
     */
    public static CardHeaderBuilder builder() {
        return new CardHeaderBuilder();
    }

    /**
     * {@link CardHeader} 构造器
     */
    public static class CardHeaderBuilder implements Builder<CardHeader> {
        private final CardHeader cardHeader;

        private CardHeaderBuilder() {
            this.cardHeader = new CardHeader();
        }

        /**
         * create {@link CardHeaderBuilder}
         *
         * @return .
         */
        public static CardHeaderBuilder builder() {
            return new CardHeaderBuilder();
        }

        /**
         * 卡片标题-内容
         *
         * @param title .
         * @return .
         */
        public CardHeaderBuilder title(CardTitle title) {
            this.cardHeader.setTitle(title);
            return this;
        }

        /**
         * 主题色
         *
         * @param template .
         * @return .
         */
        public CardHeaderBuilder template(String template) {
            this.cardHeader.setTemplate(template);
            return this;
        }

        @Override
        public CardHeader build() {
            return this.cardHeader;
        }
    }
}
