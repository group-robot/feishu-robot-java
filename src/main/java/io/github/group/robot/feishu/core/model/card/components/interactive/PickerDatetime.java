package io.github.group.robot.feishu.core.model.card.components.interactive;

import io.github.group.robot.feishu.core.constants.TextTag;
import io.github.group.robot.feishu.core.model.Builder;
import io.github.group.robot.feishu.core.model.card.components.CardTag;
import io.github.group.robot.feishu.core.model.card.components.ele.ConfirmEl;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

/**
 * 卡片组件 - 交互 - 日期时间选择器
 *
 * @author <a href="mailto:huangbing0730@gmail">hb0730</a>
 * @date 2024/8/8
 */
@Getter
@Setter
public class PickerDatetime implements CardTag {
    private final String tag = "picker_datetime";
    /**
     * 该日期时间选择器组件的唯一标识
     */
    private String name;
    /**
     * 日期时间的内容是否必选
     */
    private Boolean required;
    /**
     * 是否禁用该日期时间选择器
     */
    private Boolean disabled;
    /**
     * 日期日期时间选择器组件的初始选项值。格式为 <code>yyyy-MM-dd HH:mm</code>
     */
    private String initialDatetime;
    /**
     * 日期时间选择器的占位符
     */
    private String placeholder;
    /**
     * 日期时间选择器组件的宽度
     * <ul>
     * <li>default：默认宽度</li>
     * <li>fill：卡片最大支持宽度</li>
     * <li>[100,∞)px：自定义宽度。如 120px。超出卡片宽度时将按最大支持宽度展示</li>
     * </ul>
     */
    private String width;
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
        Map<String, Object> message = new HashMap<>(9);
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
        if (initialDatetime != null) {
            message.put("initial_datetime", initialDatetime);
        }
        if (placeholder != null) {
            Map<String, Object> placeholderMap = new HashMap<>(2);
            placeholderMap.put("content", this.placeholder);
            placeholderMap.put("tag", TextTag.PLAIN_TEXT.getValue());
            message.put("placeholder", placeholderMap);
        }
        if (width != null) {
            message.put("width", width);
        }
        if (value != null) {
            message.put("value", value);
        }
        if (confirm != null) {
            message.put("confirm", confirm.toMessage());
        }
        return message;
    }

    public static PickerDatetimeBuilder builder() {
        return new PickerDatetimeBuilder();
    }

    /**
     * {@link PickerDatetime} builder static inner class
     */
    public static class PickerDatetimeBuilder implements Builder<PickerDatetime> {
        private final PickerDatetime pickerDatetime;

        private PickerDatetimeBuilder() {
            this.pickerDatetime = new PickerDatetime();
        }

        /**
         * 设置日期时间选择器组件的唯一标识
         *
         * @param name 日期时间选择器组件的唯一标识
         * @return this
         */
        public PickerDatetimeBuilder setName(String name) {
            this.pickerDatetime.setName(name);
            return this;
        }

        /**
         * 设置日期时间的内容是否必选
         *
         * @param required 是否必选
         * @return this
         */
        public PickerDatetimeBuilder setRequired(Boolean required) {
            this.pickerDatetime.setRequired(required);
            return this;
        }

        /**
         * 设置是否禁用该日期时间选择器
         *
         * @param disabled 是否禁用
         * @return this
         */
        public PickerDatetimeBuilder setDisabled(Boolean disabled) {
            this.pickerDatetime.setDisabled(disabled);
            return this;
        }

        /**
         * 设置日期时间选择器组件的初始选项值。格式为 <code>yyyy-MM-dd HH:mm</code>
         *
         * @param initialDatetime 初始选项值
         * @return this
         */
        public PickerDatetimeBuilder setInitialDatetime(String initialDatetime) {
            this.pickerDatetime.setInitialDatetime(initialDatetime);
            return this;
        }

        /**
         * 设置日期时间选择器的占位符
         *
         * @param placeholder 占位符
         * @return this
         */
        public PickerDatetimeBuilder setPlaceholder(String placeholder) {
            this.pickerDatetime.setPlaceholder(placeholder);
            return this;
        }

        /**
         * 设置日期时间选择器组件的宽度
         *
         * @param width 宽度
         * @return this
         */
        public PickerDatetimeBuilder setWidth(String width) {
            this.pickerDatetime.setWidth(width);
            return this;
        }

        /**
         * 设置交互的回传数据，当用户点击交互组件的选项后，会将 value 的值返回给接收回调数据的服务器
         *
         * @param value 回传数据
         * @return this
         */
        public PickerDatetimeBuilder setValue(Map<String, Object> value) {
            this.pickerDatetime.setValue(value);
            return this;
        }

        /**
         * 设置交互的回传数据，当用户点击交互组件的选项后，会将 value 的值返回给接收回调数据的服务器
         *
         * @param key   key
         * @param value value
         * @return this
         */
        public PickerDatetimeBuilder setValue(String key, Object value) {
            Map<String, Object> map = new HashMap<>();
            map.put(key, value);
            this.pickerDatetime.setValue(map);
            return this;
        }

        /**
         * 设置交互的回传数据，当用户点击交互组件的选项后，会将 value 的值返回给接收回调数据的服务器
         *
         * @param key   key
         * @param value value
         * @return this
         */
        public PickerDatetimeBuilder putValue(String key, Object value) {
            if (this.pickerDatetime.getValue() == null) {
                this.pickerDatetime.setValue(new HashMap<>());
            }
            this.pickerDatetime.getValue().put(key, value);
            return this;
        }

        /**
         * 设置交互的回传数据，当用户点击交互组件的选项后，会将 value 的值返回给接收回调数据的服务器
         *
         * @param value value
         * @return this
         */
        public PickerDatetimeBuilder putValue(Map<String, Object> value) {
            if (this.pickerDatetime.getValue() == null) {
                this.pickerDatetime.setValue(new HashMap<>());
            }
            this.pickerDatetime.getValue().putAll(value);
            return this;
        }

        /**
         * 设置二次确认弹窗配置
         *
         * @param confirm 二次确认弹窗配置
         * @return this
         */
        public PickerDatetimeBuilder setConfirm(ConfirmEl confirm) {
            this.pickerDatetime.setConfirm(confirm);
            return this;
        }

        @Override
        public PickerDatetime build() {
            return this.pickerDatetime;
        }
    }
}
