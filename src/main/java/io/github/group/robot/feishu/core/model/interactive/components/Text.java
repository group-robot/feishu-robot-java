package io.github.group.robot.feishu.core.model.interactive.components;

import io.github.group.robot.feishu.core.constants.TextTag;
import io.github.group.robot.feishu.core.model.Builder;
import io.github.group.robot.feishu.core.model.IMessage;
import io.github.group.robot.feishu.core.model.Tag;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

/**
 * 卡片 > 可内嵌非交互元素 > text
 *
 * @author <a href="mailto:huangbing0730@gmail">hb0730</a>
 * @date 2021/12/16
 */
@Getter
@Setter
public class Text implements IMessage, Tag {
    /**
     * 元素标签
     */
    private TextTag tag;
    /**
     * 文本内容
     */
    private String content;
    /**
     * 内容显示行数
     */
    private Integer lines;

    @Override
    public Map<String, Object> toMessage() {
        Map<String, Object> message = new HashMap<>();
        message.put("tag", this.tag.getValue());
        message.put("content", this.content);
        message.put("lines", this.lines);
        return message;
    }

    @Override
    public String tag() {
        return this.tag.getValue();
    }

    /**
     * 构造器
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
        private final Text text;

        private TextBuilder() {
            this.text = new Text();
        }

        /**
         * create {@link TextBuilder}
         *
         * @return .
         */
        public static TextBuilder builder() {
            return new TextBuilder();
        }

        /**
         * text 标签
         *
         * @param tag .
         * @return .
         */
        public TextBuilder tag(TextTag tag) {
            this.text.setTag(tag);
            return this;
        }

        /**
         * text 内容
         *
         * @param content .
         * @return .
         */
        public TextBuilder content(String content) {
            this.text.setContent(content);
            return this;
        }

        /**
         * text 显示行数
         *
         * @param lines .
         * @return .
         */
        public TextBuilder lines(Integer lines) {
            this.text.setLines(lines);
            return this;
        }

        @Override
        public Text build() {
            return this.text;
        }
    }


}
