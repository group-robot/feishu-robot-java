package io.github.group.robot.feishu.core.model.card.components.content.table;

import io.github.group.robot.feishu.core.constants.TextAlign;
import io.github.group.robot.feishu.core.constants.TextSize;
import io.github.group.robot.feishu.core.model.Builder;
import io.github.group.robot.feishu.core.model.IMessage;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

/**
 * 卡片组件 - 展示 - 表格 - 表头样式
 *
 * @author <a href="mailto:huangbing0730@gmail">hb0730</a>
 * @date 2024/8/2
 */
@Getter
@Setter
public class HeaderStyle implements IMessage {
    /**
     * 表头文本对齐方式
     */
    private TextAlign textAlign;
    /**
     * 表头文本大小
     */
    private TextSize textSize;
    /**
     * 表头背景色,默认: none
     * <ul>
     * <li>grey：灰色</li>
     * <li>none：无背景色</li>
     * </ul>
     */
    private String backgroundStyle;
    /**
     * 表头文本颜色
     * <ul>
     * <li>default：客户端浅色主题模式下为黑色；客户端深色主题模式下为白色</li>
     * <li>grey：灰色</li>
     * </ul>
     */
    private String textColor;
    /**
     * 表头文本是否加粗
     */
    private Boolean bold;
    /**
     * 表头文本的行数。支持大于等于 1 的整数
     */
    private Integer lines;

    @Override
    public Map<String, Object> toMessage() {
        Map<String, Object> message = new java.util.HashMap<>(6);
        if (textAlign != null) {
            message.put("text_align", textAlign.getValue());
        }
        if (textSize != null) {
            message.put("text_size", textSize.getValue());
        }
        if (backgroundStyle != null) {
            message.put("background_style", backgroundStyle);
        }
        if (textColor != null) {
            message.put("text_color", textColor);
        }
        if (bold != null) {
            message.put("bold", bold);
        }
        if (lines != null) {
            message.put("lines", lines);
        }
        return message;
    }

    public static HeaderStyleBuilder builder() {
        return new HeaderStyleBuilder();
    }

    /**
     * 构造器
     */
    public static class HeaderStyleBuilder implements Builder<HeaderStyle> {
        private final HeaderStyle headerStyle = new HeaderStyle();

        private HeaderStyleBuilder() {
        }


        /**
         * 表头文本对齐方式
         *
         * @param textAlign 表头文本对齐方式
         * @return HeaderStyleBuilder
         */
        public HeaderStyleBuilder setTextAlign(TextAlign textAlign) {
            headerStyle.setTextAlign(textAlign);
            return this;
        }

        /**
         * 表头文本大小
         *
         * @param textSize 表头文本大小
         * @return HeaderStyleBuilder
         */
        public HeaderStyleBuilder setTextSize(TextSize textSize) {
            headerStyle.setTextSize(textSize);
            return this;
        }

        /**
         * 表头背景色,默认: none
         * <ul>
         * <li>grey：灰色</li>
         * <li>none：无背景色</li>
         * </ul>
         *
         * @param backgroundStyle 表头背景色
         * @return HeaderStyleBuilder
         */
        public HeaderStyleBuilder setBackgroundStyle(String backgroundStyle) {
            headerStyle.setBackgroundStyle(backgroundStyle);
            return this;
        }

        /**
         * 表头文本颜色
         * <ul>
         * <li>default：客户端浅色主题模式下为黑色；客户端深色主题模式下为白色</li>
         * <li>grey：灰色</li>
         * </ul>
         *
         * @param textColor 表头文本颜色
         * @return HeaderStyleBuilder
         */
        public HeaderStyleBuilder setTextColor(String textColor) {
            headerStyle.setTextColor(textColor);
            return this;
        }

        /**
         * 表头文本是否加粗
         *
         * @param bold 表头文本是否加粗
         * @return HeaderStyleBuilder
         */
        public HeaderStyleBuilder setBold(Boolean bold) {
            headerStyle.setBold(bold);
            return this;
        }

        /**
         * 表头文本的行数。支持大于等于 1 的整数
         *
         * @param lines 表头文本的行数
         * @return HeaderStyleBuilder
         */
        public HeaderStyleBuilder setLines(Integer lines) {
            headerStyle.setLines(lines);
            return this;
        }

        @Override
        public HeaderStyle build() {
            return headerStyle;
        }
    }
}
