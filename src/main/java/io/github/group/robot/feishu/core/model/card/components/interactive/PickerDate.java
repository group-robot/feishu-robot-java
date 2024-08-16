package io.github.group.robot.feishu.core.model.card.components.interactive;

import io.github.group.robot.feishu.core.constants.TextTag;
import io.github.group.robot.feishu.core.model.Builder;
import io.github.group.robot.feishu.core.model.card.components.CardTag;
import io.github.group.robot.feishu.core.model.card.components.ele.ConfirmEl;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

/**
 * 卡片组件 - 交互 - 日期选择器
 *
 * @author <a href="mailto:huangbing0730@gmail">hb0730</a>
 * @date 2024/8/7
 */
@Getter
@Setter
public class PickerDate implements CardTag {
    private final String tag = "date_picker";
    /**
     * 该日期选择器组件的唯一标识
     */
    private String name;
    /**
     * 日期的内容是否必选
     */
    private Boolean required;
    /**
     * 是否禁用该日期选择器
     */
    private Boolean disabled;
    /**
     * 日期选择器的占位符
     */
    private String placeholder;
    /**
     * 日期选择器组件的宽度
     * <ul>
     * <li>default：默认宽度</li>
     * <li>fill：卡片最大支持宽度</li>
     * <li>[100,∞)px：自定义宽度。如 120px。超出卡片宽度时将按最大支持宽度展示</li>
     * </ul>
     */
    private String width;
    /**
     * 日期选择器的初始日期,格式为 <code>yyyy-MM-dd</code>
     */
    private String initialDate;
    /**
     * 设置交互的回传数据，当用户点击交互组件的选项后，会将 value 的值返回给接收回调数据的服务器
     */
    private Map<String, Object> value;
    /**
     * 二次确认弹窗配置
     */
    private ConfirmEl confirm;

    @Override
    public Map<String, Object> toMessage() {
        Map<String, Object> message = new java.util.HashMap<>(9);
        message.put("tag", tag);
        if (name != null) {
            message.put("name", name);
        }
        if (required != null) {
            message.put("required", required);
        }
        if (disabled != null) {
            message.put("disabled", disabled);
        }
        if (placeholder != null) {
            Map<String, Object> placeholderMap = new java.util.HashMap<>(2);
            placeholderMap.put("content", this.placeholder);
            placeholderMap.put("tag", TextTag.PLAIN_TEXT.getValue());

            message.put("placeholder", placeholderMap);
        }
        if (width != null) {
            message.put("width", width);
        }
        if (initialDate != null) {
            message.put("initial_date", initialDate);
        }
        if (value != null) {
            message.put("value", value);
        }
        if (confirm != null) {
            message.put("confirm", confirm.toMessage());
        }
        return message;
    }

    public static PickerDateBuilder builder() {
        return new PickerDateBuilder();
    }

    /**
     * 构造器
     */
    public static class PickerDateBuilder implements Builder<PickerDate> {
        private final PickerDate pickerDate = new PickerDate();

        private PickerDateBuilder() {
        }

        /**
         * 该日期选择器组件的唯一标识
         *
         * @param name 该日期选择器组件的唯一标识
         * @return .
         */
        public PickerDateBuilder setName(String name) {
            pickerDate.setName(name);
            return this;
        }

        /**
         * 日期的内容是否必选
         *
         * @param required 日期的内容是否必选
         * @return .
         */
        public PickerDateBuilder setRequired(Boolean required) {
            pickerDate.setRequired(required);
            return this;
        }

        /**
         * 是否禁用该日期选择器
         *
         * @param disabled 是否禁用该日期选择器
         * @return .
         */
        public PickerDateBuilder setDisabled(Boolean disabled) {
            pickerDate.setDisabled(disabled);
            return this;
        }

        /**
         * 日期选择器的占位符
         *
         * @param placeholder 日期选择器的占位符
         * @return .
         */
        public PickerDateBuilder setPlaceholder(String placeholder) {
            pickerDate.setPlaceholder(placeholder);
            return this;
        }

        /**
         * 日期选择器组件的宽度
         * <ul>
         * <li>default：默认宽度</li>
         * <li>fill：卡片最大支持宽度</li>
         * <li>[100,∞)px：自定义宽度。如 120px。超出卡片宽度时将按最大支持宽度展示</li>
         * </ul>
         *
         * @param width 日期选择器组件的宽度
         * @return .
         */
        public PickerDateBuilder setWidth(String width) {
            pickerDate.setWidth(width);
            return this;
        }

        /**
         * 日期选择器的初始日期,格式为 <code>yyyy-MM-dd</code>
         *
         * @param initialDate 日期选择器的初始日期
         * @return .
         */
        public PickerDateBuilder setInitialDate(String initialDate) {
            pickerDate.setInitialDate(initialDate);
            return this;
        }

        /**
         * 设置交互的回传数据，当用户点击交互组件的选项后，会将 value 的值返回给接收回调数据的服务器
         *
         * @param value 交互的回传数据
         * @return .
         */
        public PickerDateBuilder setValue(Map<String, Object> value) {
            pickerDate.setValue(value);
            return this;
        }

        /**
         * 设置交互的回传数据，当用户点击交互组件的选项后，会将 value 的值返回给接收回调数据的服务器
         *
         * @param key   交互的回传数据的key
         * @param value 交互的回传数据的value
         * @return .
         */
        public PickerDateBuilder setValue(String key, Object value) {
            Map<String, Object> map = new java.util.HashMap<>(1);
            map.put(key, value);
            pickerDate.setValue(map);
            return this;
        }

        /**
         * 设置交互的回传数据，当用户点击交互组件的选项后，会将 value 的值返回给接收回调数据的服务器
         *
         * @param key   交互的回传数据的key
         * @param value 交互的回传数据的value
         * @return .
         */
        public PickerDateBuilder putValue(String key, Object value) {
            Map<String, Object> map = pickerDate.getValue();
            if (map == null) {
                map = new java.util.HashMap<>();
                pickerDate.setValue(map);
            }
            map.put(key, value);
            return this;
        }

        /**
         * 设置交互的回传数据，当用户点击交互组件的选项后，会将 value 的值返回给接收回调数据的服务器
         *
         * @param value 交互的回传数据
         * @return .
         */
        public PickerDateBuilder putValue(Map<String, Object> value) {
            Map<String, Object> map = pickerDate.getValue();
            if (map == null) {
                map = new java.util.HashMap<>();
                pickerDate.setValue(map);
            }
            map.putAll(value);
            return this;
        }

        /**
         * 二次确认弹窗配置
         *
         * @param confirm 二次确认弹窗配置
         * @return .
         */
        public PickerDateBuilder setConfirm(ConfirmEl confirm) {
            pickerDate.setConfirm(confirm);
            return this;
        }

        @Override
        public PickerDate build() {
            return pickerDate;
        }
    }
}
