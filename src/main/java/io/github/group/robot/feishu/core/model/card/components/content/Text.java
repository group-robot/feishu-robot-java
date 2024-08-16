package io.github.group.robot.feishu.core.model.card.components.content;

import io.github.group.robot.feishu.core.model.Builder;
import io.github.group.robot.feishu.core.model.card.components.CardTag;
import io.github.group.robot.feishu.core.model.card.components.ele.IconEl;
import io.github.group.robot.feishu.core.model.card.components.ele.TextEl;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

/**
 * 卡片-展示-普通文本
 *
 * @author <a href="mailto:huangbing0730@gmail">hb0730</a>
 * @date 2024/7/26
 */
@Getter
@Setter
public class Text implements CardTag {
    private final String tag = "div";
    /**
     * 文本内容
     */
    private TextEl text;
    /**
     * 图标
     */
    private IconEl icon;

    public Text() {
    }

    public Text(TextEl text, IconEl icon) {
        this.text = text;
        this.icon = icon;
    }

    @Override
    public Map<String, Object> toMessage() {
        Map<String, Object> message = new HashMap<>(2);
        message.put("tag", tag);
        message.put("text", text.toMessage());
        if (icon != null) {
            message.put("icon", icon.toMessage());
        }
        return message;
    }

    /**
     * 创建 {@link TextBuilder}
     *
     * @return .
     */
    public static TextBuilder builder() {
        return new TextBuilder();
    }


    /**
     * {@link Text} 构造器
     */
    public static class TextBuilder implements Builder<Text> {
        private final Text text = new Text();

        private TextBuilder() {
        }

        /**
         * 添加文本内容
         *
         * @param text 文本内容
         * @return .
         */
        public TextBuilder setText(TextEl text) {
            this.text.setText(text);
            return this;
        }

        /**
         * 添加图标
         *
         * @param icon 图标
         * @return .
         */
        public TextBuilder setIcon(IconEl icon) {
            this.text.setIcon(icon);
            return this;
        }

        @Override
        public Text build() {
            return this.text;
        }
    }

}
