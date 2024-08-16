package io.github.group.robot.feishu.core.model.card.components.interactive;

import io.github.group.robot.feishu.core.constants.InputType;
import io.github.group.robot.feishu.core.constants.TextTag;
import io.github.group.robot.feishu.core.model.Builder;
import io.github.group.robot.feishu.core.model.card.components.CardTag;
import io.github.group.robot.feishu.core.model.card.components.ele.ConfirmEl;
import io.github.group.robot.feishu.core.model.card.components.ele.FallbackEl;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

/**
 * 卡片组件 - 交互 - 输入框
 *
 * @author <a href="mailto:huangbing0730@gmail">hb0730</a>
 * @date 2024/8/2
 */
@Getter
@Setter
public class Input implements CardTag {
    private final String tag = "input";
    /**
     * 输入框的唯一标识
     */
    private String name;
    /**
     * 输入框的内容是否必填
     */
    private Boolean required;
    /**
     * 是否禁用该输入框
     */
    private Boolean disabled;
    /**
     * 占位文本的内容，最多支持 100 个字符。例如：“请输入内容”。
     */
    private String placeholder;
    /**
     * 输入框中为用户预填写的内容。展示为用户在输入框中输入文本后待提交的样式
     */
    private String defaultValue;
    /**
     * 默认值的国际化配置
     */
    private Map<String, String> i18nDefaultValue;
    /**
     * 输入框的宽度
     * <ul>
     * <li>default：默认宽度</li>
     * <li>fill：卡片最大支持宽度</li>
     * <li>[100,∞)px：自定义宽度。超出卡片宽度时将按最大支持宽度展示</li>
     * </ul>
     */
    private String width;
    /**
     * 输入框的最大长度,可取 1~1,000 范围内的整数
     */
    private Integer maxLength;
    /**
     * 输入框的类型
     */
    private InputType inputType;
    /**
     * 当输入类型为密码类型时，是否展示如下所示的前缀图
     */
    private Boolean showIcon;
    /**
     * 输入框的行数，仅在输入类型为多行文本时有效
     */
    private Integer rows;
    /**
     * 是否自适应高度，仅在输入类型为多行文本时有效
     */
    private Boolean autoResize;
    /**
     * 输入框的最大行数，仅在输入类型为多行文本时有效
     */
    private Integer maxRows;
    /**
     * 文本标签，即对输入框的描述，用于提示用户要填写的内容
     */
    private String label;
    /**
     * 文本标签的位置
     */
    private String labelPosition;
    /**
     * 你可在交互事件中自定义回传数据，支持 string 或 object 数据类型。
     */
    private Object value;
    /**
     * 二次确认弹窗配置
     */
    private ConfirmEl confirm;
    /**
     * 设置输入框组件的降级文案
     */
    private FallbackEl fallback;

    @Override
    public Map<String, Object> toMessage() {
        Map<String, Object> message = new java.util.HashMap<>(16);
        message.put("tag", tag);
        if (null != name) {
            message.put("name", name);
        }
        if (null != required) {
            message.put("required", required);
        }
        if (null != disabled) {
            message.put("disabled", disabled);
        }
        if (null != placeholder) {
            Map<String, Object> placeholderMap = new java.util.HashMap<>(2);
            placeholderMap.put("content", placeholder);
            placeholderMap.put("tag", TextTag.PLAIN_TEXT.getValue());
            message.put("placeholder", placeholderMap);
        }
        if (null != defaultValue) {
            message.put("default_value", defaultValue);
        }
        if (null != i18nDefaultValue) {
            message.put("i18n_default_value", i18nDefaultValue);
        }
        if (null != width) {
            message.put("width", width);
        }
        if (null != maxLength) {
            message.put("max_length", maxLength);
        }
        if (null != inputType) {
            message.put("input_type", inputType.getValue());
        }
        if (null != showIcon) {
            message.put("show_icon", showIcon);
        }
        if (null != rows) {
            message.put("rows", rows);
        }
        if (null != autoResize) {
            message.put("auto_resize", autoResize);
        }
        if (null != maxRows) {
            message.put("max_rows", maxRows);
        }
        if (null != label) {
            Map<String, Object> labelMap = new java.util.HashMap<>(2);
            labelMap.put("content", label);
            labelMap.put("tag", TextTag.PLAIN_TEXT.getValue());
            message.put("label", labelMap);
        }
        if (null != labelPosition) {
            message.put("label_position", labelPosition);
        }
        if (null != value) {
            message.put("value", value);
        }
        if (null != confirm) {
            message.put("confirm", confirm.toMessage());
        }
        if (null != fallback) {
            message.put("fallback", fallback.toMessage());
        }
        return message;
    }

    public static InputBuilder builder() {
        return new InputBuilder();
    }

    /**
     * 构造器
     */
    public static class InputBuilder implements Builder<Input> {
        private final Input input = new Input();

        private InputBuilder() {
        }

        /**
         * 输入框的唯一标识
         *
         * @param name 输入框的唯一标识
         * @return .
         */
        public InputBuilder setName(String name) {
            input.setName(name);
            return this;
        }

        /**
         * 输入框的内容是否必填
         *
         * @param required 输入框的内容是否必填
         * @return .
         */
        public InputBuilder setRequired(Boolean required) {
            input.setRequired(required);
            return this;
        }

        /**
         * 是否禁用该输入框
         *
         * @param disabled 是否禁用该输入框
         * @return .
         */
        public InputBuilder setDisabled(Boolean disabled) {
            input.setDisabled(disabled);
            return this;
        }

        /**
         * 占位文本的内容，最多支持 100 个字符。例如：“请输入内容”。
         *
         * @param placeholder 占位文本的内容
         * @return .
         */
        public InputBuilder setPlaceholder(String placeholder) {
            input.setPlaceholder(placeholder);
            return this;
        }

        /**
         * 输入框中为用户预填写的内容。展示为用户在输入框中输入文本后待提交的样式
         *
         * @param defaultValue 输入框中为用户预填写的内容
         * @return .
         */
        public InputBuilder setDefaultValue(String defaultValue) {
            input.setDefaultValue(defaultValue);
            return this;
        }

        /**
         * 默认值的国际化配置
         *
         * @param i18nDefaultValue 默认值的国际化配置
         * @return .
         */
        public InputBuilder setI18nDefaultValue(Map<String, String> i18nDefaultValue) {
            input.setI18nDefaultValue(i18nDefaultValue);
            return this;
        }

        /**
         * 默认值的国际化配置
         *
         * @param key   key
         * @param value value
         * @return .
         */
        public InputBuilder setI18nDefaultValue(String key, String value) {
            Map<String, String> i18nDefaultValue = new java.util.HashMap<>(1);
            i18nDefaultValue.put(key, value);
            input.setI18nDefaultValue(i18nDefaultValue);
            return this;
        }

        /**
         * 默认值的国际化配置
         *
         * @param key   .
         * @param value .
         * @return .
         */
        public InputBuilder addI18nDefaultValue(String key, String value) {
            if (input.getI18nDefaultValue() == null) {
                input.setI18nDefaultValue(new java.util.HashMap<>());
            }
            input.getI18nDefaultValue().put(key, value);
            return this;
        }

        /**
         * 默认值的国际化配置
         *
         * @param i18nDefaultValue 默认值的国际化配置
         * @return .
         */
        public InputBuilder addI18nDefaultValue(Map<String, String> i18nDefaultValue) {
            if (input.getI18nDefaultValue() == null) {
                input.setI18nDefaultValue(new java.util.HashMap<>());
            }
            input.getI18nDefaultValue().putAll(i18nDefaultValue);
            return this;
        }

        /**
         * 输入框的宽度
         * <ul>
         * <li>default：默认宽度</li>
         * <li>fill：卡片最大支持宽度</li>
         * <li>[100,∞)px：自定义宽度。超出卡片宽度时将按最大支持宽度展示</li>
         * </ul>
         *
         * @param width 输入框的宽度
         * @return .
         */
        public InputBuilder setWidth(String width) {
            input.setWidth(width);
            return this;
        }

        /**
         * 输入框的最大长度,可取 1~1,000 范围内的整数
         *
         * @param maxLength 输入框的最大长度
         * @return .
         */
        public InputBuilder setMaxLength(Integer maxLength) {
            input.setMaxLength(maxLength);
            return this;
        }

        /**
         * 输入框的类型
         *
         * @param inputType 输入框的类型
         * @return .
         */
        public InputBuilder setInputType(InputType inputType) {
            input.setInputType(inputType);
            return this;
        }

        /**
         * 当输入类型为密码类型时，是否展示如下所示的前缀图
         *
         * @param showIcon 是否展示如下所示的前缀图
         * @return .
         */
        public InputBuilder setShowIcon(Boolean showIcon) {
            input.setShowIcon(showIcon);
            return this;

        }

        /**
         * 输入框的行数，仅在输入类型为多行文本时有效
         *
         * @param rows 输入框的行数
         * @return .
         */
        public InputBuilder setRows(Integer rows) {
            input.setRows(rows);
            return this;
        }

        /**
         * 是否自适应高度，仅在输入类型为多行文本时有效
         *
         * @param autoResize 是否自适应高度
         * @return .
         */
        public InputBuilder setAutoResize(Boolean autoResize) {
            input.setAutoResize(autoResize);
            return this;
        }

        /**
         * 输入框的最大行数，仅在输入类型为多行文本时有效
         *
         * @param maxRows 输入框的最大行数
         * @return .
         */
        public InputBuilder setMaxRows(Integer maxRows) {
            input.setMaxRows(maxRows);
            return this;
        }

        /**
         * 文本标签，即对输入框的描述，用于提示用户要填写的内容
         *
         * @param label 文本标签
         * @return .
         */
        public InputBuilder setLabel(String label) {
            input.setLabel(label);
            return this;
        }

        /**
         * 文本标签的位置
         *
         * @param labelPosition 文本标签的位置
         * @return .
         */
        public InputBuilder setLabelPosition(String labelPosition) {
            input.setLabelPosition(labelPosition);
            return this;
        }

        /**
         * 你可在交互事件中自定义回传数据，支持 string 或 object 数据类型。
         *
         * @param value 你可在交互事件中自定义回传数据
         * @return .
         */
        public InputBuilder setValue(Object value) {
            input.setValue(value);
            return this;
        }

        /**
         * 二次确认弹窗配置
         *
         * @param confirm 二次确认弹窗配置
         * @return .
         */
        public InputBuilder setConfirm(ConfirmEl confirm) {
            input.setConfirm(confirm);
            return this;
        }

        /**
         * 设置输入框组件的降级文案
         *
         * @param fallback 设置输入框组件的降级文案
         * @return .
         */
        public InputBuilder setFallback(FallbackEl fallback) {
            input.setFallback(fallback);
            return this;
        }

        @Override
        public Input build() {
            return input;
        }
    }
}
