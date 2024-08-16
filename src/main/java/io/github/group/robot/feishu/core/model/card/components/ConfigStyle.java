package io.github.group.robot.feishu.core.model.card.components;

import io.github.group.robot.feishu.core.constants.TextSize;
import io.github.group.robot.feishu.core.model.Builder;
import io.github.group.robot.feishu.core.model.IMessage;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

/**
 * 卡片-Config属性-Style样式
 *
 * @author <a href="mailto:huangbing0730@gmail">hb0730</a>
 * @date 2024/7/26
 */
@Getter
@Setter
public class ConfigStyle implements IMessage {
    /**
     * 文本大小
     */
    private Map<String, FontSize> textSize;
    /**
     * 文本颜色
     */
    private Map<String, Color> textColor;


    @Override
    public Map<String, Object> toMessage() {
        Map<String, Object> map = new java.util.HashMap<>(2);
        if (textSize != null) {
            Map<String, Object> sizeMap = new java.util.HashMap<>(textSize.size());
            textSize.forEach((k, v) -> sizeMap.put(k, v.toMessage()));
            map.put("text_size", sizeMap);
        }
        if (textColor != null) {
            Map<String, Object> colorMap = new java.util.HashMap<>(textColor.size());
            textColor.forEach((k, v) -> colorMap.put(k, v.toMessage()));
            map.put("text_color", colorMap);
        }
        return map;
    }

    /**
     * 构建者
     *
     * @return this
     */
    public static ConfigStyleBuilder builder() {
        return new ConfigStyleBuilder();
    }

    /**
     * 构建者
     */
    public static class ConfigStyleBuilder implements Builder<ConfigStyle> {
        private final ConfigStyle style = new ConfigStyle();

        public static ConfigStyleBuilder builder() {
            return new ConfigStyleBuilder();
        }

        /**
         * 设置文本大小
         *
         * @param textSize 文本大小
         * @return this
         */
        public ConfigStyleBuilder setTextSize(Map<String, FontSize> textSize) {
            style.setTextSize(textSize);
            return this;
        }

        /**
         * 添加文本大小
         *
         * @param key   key
         * @param value value
         * @return this
         */
        public ConfigStyleBuilder addTextSize(String key, FontSize value) {
            if (style.textSize == null) {
                style.textSize = new java.util.HashMap<>(1);
            }
            style.textSize.put(key, value);
            return this;
        }

        /**
         * 设置文本颜色
         *
         * @param textColor 文本颜色
         * @return this
         */
        public ConfigStyleBuilder setTextColor(Map<String, Color> textColor) {
            style.setTextColor(textColor);
            return this;
        }

        /**
         * 添加文本颜色
         *
         * @param key   key
         * @param value value
         * @return this
         */
        public ConfigStyleBuilder addTextColor(String key, Color value) {
            if (style.textColor == null) {
                style.textColor = new java.util.HashMap<>(1);
            }
            style.textColor.put(key, value);
            return this;
        }


        @Override
        public ConfigStyle build() {
            return style;
        }
    }

    /**
     * 文本大小
     */
    public static class FontSize implements IMessage {
        /**
         * 默认大小,默认为中等
         *
         * @see TextSize
         */
        private String defaultSize = TextSize.Medium.getValue();
        /**
         * PC端大小，默认为中等
         *
         * @see TextSize
         */
        private String pc = TextSize.Medium.getValue();
        /**
         * 移动端大小，默认为大
         *
         * @see TextSize
         */
        private String mobile = TextSize.Large.getValue();

        public FontSize(String defaultSize, String pc, String mobile) {
            this.defaultSize = defaultSize;
            this.pc = pc;
            this.mobile = mobile;
        }

        public FontSize(TextSize defaultSize, TextSize pc, TextSize mobile) {
            this.defaultSize = defaultSize.getValue();
            this.pc = pc.getValue();
            this.mobile = mobile.getValue();
        }

        public FontSize() {
        }

        /**
         * 设置默认大小
         *
         * @param defaultSize 默认大小
         * @return this
         */
        public FontSize setDefault(TextSize defaultSize) {
            this.defaultSize = defaultSize.getValue();
            return this;
        }

        /**
         * 设置默认大小
         *
         * @param defaultSize 默认大小
         * @return this
         */
        public FontSize setDefault(String defaultSize) {
            this.defaultSize = defaultSize;
            return this;
        }

        /**
         * 设置PC端大小
         *
         * @param pc PC端大小
         * @return this
         */
        public FontSize setPc(TextSize pc) {
            this.pc = pc.getValue();
            return this;
        }

        /**
         * 设置PC端大小
         *
         * @param pc PC端大小
         * @return this
         */
        public FontSize setPc(String pc) {
            this.pc = pc;
            return this;
        }

        /**
         * 设置移动端大小
         *
         * @param mobile 移动端大小
         * @return this
         */
        public FontSize setMobile(TextSize mobile) {
            this.mobile = mobile.getValue();
            return this;
        }

        /**
         * 设置移动端大小
         *
         * @param mobile 移动端大小
         * @return this
         */
        public FontSize setMobile(String mobile) {
            this.mobile = mobile;
            return this;
        }

        @Override
        public Map<String, Object> toMessage() {
            Map<String, Object> map = new java.util.HashMap<>(3);
            if (defaultSize != null) {
                map.put("default", defaultSize);
            }
            if (pc != null) {
                map.put("pc", pc);
            }
            if (mobile != null) {
                map.put("mobile", mobile);
            }

            return map;
        }
    }

    /**
     * 文本颜色
     */
    public static class Color implements IMessage {
        /**
         * 浅色主题下的自定义颜色语法
         */
        private String lightMode = "rgba(5,157,178,0.52)";
        /**
         * 深色主题下的自定义颜色语法
         */
        private String darkMode = "rgba(78,23,108,0.49)";

        public Color(String lightMode, String darkMode) {
            this.lightMode = lightMode;
            this.darkMode = darkMode;
        }

        public Color() {
        }

        /**
         * 设置浅色主题下的自定义颜色语法
         *
         * @param lightMode 浅色主题下的自定义颜色语法
         * @return this
         */
        public Color setLightMode(String lightMode) {
            this.lightMode = lightMode;
            return this;
        }

        /**
         * 设置深色主题下的自定义颜色语法
         *
         * @param darkMode 深色主题下的自定义颜色语法
         * @return this
         */
        public Color setDarkMode(String darkMode) {
            this.darkMode = darkMode;
            return this;
        }

        @Override
        public Map<String, Object> toMessage() {
            Map<String, Object> map = new java.util.HashMap<>(2);
            if (lightMode != null) {
                map.put("light_mode", lightMode);
            }
            if (darkMode != null) {
                map.put("dark_mode", darkMode);
            }
            return map;
        }
    }
}
