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
 * 卡片组件- 交互 - 时间选择器
 *
 * @author <a href="mailto:huangbing0730@gmail">hb0730</a>
 * @date 2024/8/8
 */
@Getter
@Setter
public class PickerTime implements CardTag {
    private final String tag = "picker_time";
    /**
     * 该时间选择器组件的唯一标识
     */
    private String name;
    /**
     * 时间的内容是否必选
     */
    private Boolean required;
    /**
     * 是否禁用该时间选择器
     */
    private Boolean disabled;
    /**
     * 时间选择器组件的初始选项值。格式为 <code>HH:mm</code>
     */
    private String initialTime;
    /**
     * 时间选择器的占位符
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
        if (initialTime != null) {
            message.put("initial_time", initialTime);
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

    public static PickerTimeBuilder builder() {
        return new PickerTimeBuilder();
    }

    /**
     * {@link PickerTime} builder static inner class
     */
    public static class PickerTimeBuilder implements Builder<PickerTime> {
        private final PickerTime pickerTime;

        private PickerTimeBuilder() {
            this.pickerTime = new PickerTime();
        }


        /**
         * 该时间选择器组件的唯一标识
         *
         * @param name 该时间选择器组件的唯一标识
         * @return this
         */
        public PickerTimeBuilder setName(String name) {
            this.pickerTime.setName(name);
            return this;
        }

        /**
         * 时间的内容是否必选
         *
         * @param required 时间的内容是否必选
         * @return this
         */
        public PickerTimeBuilder setRequired(Boolean required) {
            this.pickerTime.setRequired(required);
            return this;
        }

        /**
         * 是否禁用该时间选择器
         *
         * @param disabled 是否禁用该时间选择器
         * @return this
         */
        public PickerTimeBuilder setDisabled(Boolean disabled) {
            this.pickerTime.setDisabled(disabled);
            return this;
        }

        /**
         * 时间选择器组件的初始选项值。格式为 <code>HH:mm</code>
         *
         * @param initialTime 时间选择器组件的初始选项值
         * @return this
         */
        public PickerTimeBuilder setInitialTime(String initialTime) {
            this.pickerTime.setInitialTime(initialTime);
            return this;
        }

        /**
         * 时间选择器的占位符
         *
         * @param placeholder 时间选择器的占位符
         * @return this
         */
        public PickerTimeBuilder setPlaceholder(String placeholder) {
            this.pickerTime.setPlaceholder(placeholder);
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
         * @return this
         */
        public PickerTimeBuilder setWidth(String width) {
            this.pickerTime.setWidth(width);
            return this;
        }

        /**
         * 设置交互的回传数据，当用户点击交互组件的选项后，会将 value 的值返回给接收回调数据的服务器
         *
         * @param value 交互的回传数据
         * @return this
         */
        public PickerTimeBuilder setValue(Map<String, Object> value) {
            this.pickerTime.setValue(value);
            return this;
        }

        /**
         * 设置交互的回传数据，当用户点击交互组件的选项后，会将 value 的值返回给接收回调数据的服务器
         *
         * @param key   key
         * @param value value
         * @return this
         */
        public PickerTimeBuilder setValue(String key, Object value) {
            Map<String, Object> map = new HashMap<>();
            map.put(key, value);
            this.pickerTime.setValue(map);
            return this;
        }

        /**
         * 设置交互的回传数据，当用户点击交互组件的选项后，会将 value 的值返回给接收回调数据的服务器
         *
         * @param key   key
         * @param value value
         * @return this
         */
        public PickerTimeBuilder putValue(String key, Object value) {
            if (this.pickerTime.getValue() == null) {
                this.pickerTime.setValue(new HashMap<>());
            }
            this.pickerTime.getValue().put(key, value);
            return this;
        }

        /**
         * 设置交互的回传数据，当用户点击交互组件的选项后，会将 value 的值返回给接收回调数据的服务器
         *
         * @param value value
         * @return this
         */
        public PickerTimeBuilder putValue(Map<String, Object> value) {
            if (this.pickerTime.getValue() == null) {
                this.pickerTime.setValue(new HashMap<>());
            }
            this.pickerTime.getValue().putAll(value);
            return this;
        }

        /**
         * 二次确认弹窗配置
         *
         * @param confirm 二次确认弹窗配置
         * @return this
         */
        public PickerTimeBuilder setConfirm(ConfirmEl confirm) {
            this.pickerTime.setConfirm(confirm);
            return this;
        }

        @Override
        public PickerTime build() {
            return this.pickerTime;
        }
    }
}
