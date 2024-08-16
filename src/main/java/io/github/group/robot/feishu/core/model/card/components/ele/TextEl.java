package io.github.group.robot.feishu.core.model.card.components.ele;

import io.github.group.robot.feishu.core.constants.TextAlign;
import io.github.group.robot.feishu.core.constants.TextSize;
import io.github.group.robot.feishu.core.model.Builder;
import io.github.group.robot.feishu.core.model.IMessage;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

/**
 * 配置卡片的普通文本信息
 *
 * @author <a href="mailto:huangbing0730@gmail">hb0730</a>
 * @date 2024/7/26
 */
@Setter
@Getter
public class TextEl implements IMessage {
    /**
     * 文本内容,当 tag 为 lark_md 时，支持部分 Markdown 语法的文本内容
     */
    private ContentI18n content;

    /**
     * 文本大小,
     *
     * @see io.github.group.robot.feishu.core.constants.TextSize
     */
    private String textSize;
    /**
     * 文本颜色
     */
    private String textColor;
    /**
     * 文本对齐方式
     */
    private TextAlign textAlign;
    /**
     * 内容最大显示行数，超出设置行的内容用 ... 省略。
     */
    private Integer lines;

    @Override
    public Map<String, Object> toMessage() {
        Map<String, Object> map = content.toMessage();
        if (textSize != null) {
            map.put("text_size", textSize);
        }
        if (textColor != null) {
            map.put("text_color", textColor);
        }
        if (textAlign != null) {
            map.put("text_align", textAlign.getValue());
        }
        if (lines != null) {
            map.put("lines", lines);
        }
        return map;
    }

    /**
     * 创建一个 TextEl 对象
     *
     * @return TextEl 对象
     */
    public static TextElBuilder builder() {
        return new TextElBuilder();
    }

    public static class TextElBuilder implements Builder<TextEl> {

        private final TextEl textEl = new TextEl();

        private TextElBuilder() {
        }

        /**
         * 文本内容
         *
         * @param content 文本内容
         * @return 当前对象
         */
        public TextElBuilder setContent(ContentI18n content) {
            textEl.setContent(content);
            return this;
        }

        /**
         * 文本大小
         *
         * @param textSize 文本大小
         * @return 当前对象
         */
        public TextElBuilder setTextSize(String textSize) {
            textEl.setTextSize(textSize);
            return this;
        }

        /**
         * 文本大小
         *
         * @param textSize 文本大小
         * @return 当前对象
         */
        public TextElBuilder setTextSize(TextSize textSize) {
            textEl.setTextSize(textSize.getValue());
            return this;
        }

        /**
         * 文本颜色
         *
         * @param textColor 文本颜色
         * @return 当前对象
         */
        public TextElBuilder setTextColor(String textColor) {
            textEl.setTextColor(textColor);
            return this;
        }

        /**
         * 文本对齐方式
         *
         * @param textAlign 文本对齐方式
         * @return 当前对象
         */
        public TextElBuilder setTextAlign(TextAlign textAlign) {
            textEl.setTextAlign(textAlign);
            return this;
        }

        /**
         * 内容最大显示行数，超出设置行的内容用 ... 省略。
         *
         * @param lines 行数
         * @return 当前对象
         */
        public TextElBuilder setLines(Integer lines) {
            textEl.setLines(lines);
            return this;
        }


        @Override
        public TextEl build() {
            return textEl;
        }
    }
}
