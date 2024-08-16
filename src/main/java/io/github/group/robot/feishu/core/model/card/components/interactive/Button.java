package io.github.group.robot.feishu.core.model.card.components.interactive;

import io.github.group.robot.feishu.core.constants.ActionType;
import io.github.group.robot.feishu.core.constants.ButtonSize;
import io.github.group.robot.feishu.core.constants.ButtonType;
import io.github.group.robot.feishu.core.constants.TextTag;
import io.github.group.robot.feishu.core.model.Builder;
import io.github.group.robot.feishu.core.model.card.components.CardTag;
import io.github.group.robot.feishu.core.model.card.components.ele.ConfirmEl;
import io.github.group.robot.feishu.core.model.card.components.ele.IconEl;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

/**
 * 卡片组件 - 交互 - 按钮
 *
 * @author <a href="mailto:huangbing0730@gmail">hb0730</a>
 * @date 2024/8/7
 */
@Getter
@Setter
public class Button implements CardTag {
    private final String tag = "button";
    /**
     * 按钮的类型
     */
    private ButtonType type;
    /**
     * 按钮的大小
     */
    private ButtonSize size;
    /**
     * 按钮的宽度
     * <ul>
     * <li>default：默认宽度</li>
     * <li>fill：卡片最大支持宽度</li>
     * <li>[100,∞)px：自定义宽度。如 120px。超出卡片宽度时将按最大支持宽度展示</li>
     * </ul>
     */
    private String width;
    /**
     * 按钮上的文本
     */
    private String text;
    /**
     * 添加图标作为文本前缀图标。支持自定义或使用图标库中的图标。
     */
    private IconEl icon;
    /**
     * 用户在 PC 端将光标悬浮在交互容器上方时的文案提醒。默认为空。
     */
    private String hoverTips;
    /**
     * 是否禁用按钮
     */
    private Boolean disabled;
    /**
     * 按钮禁用时的文案提醒。默认为空。
     */
    private String disabledTips;
    /**
     * 二次确认弹窗配置
     */
    private ConfirmEl confirm;
    /**
     * 配置交互类型和具体交互行为。支持同时生效跳转链接和回传交互
     */
    private Object behaviors;
    /**
     * 表单容器的唯一标识
     */
    private String name;
    /**
     * 是否必填
     */
    private Boolean required;

    /**
     * 交互类型
     */
    private ActionType actionType;

    /**
     * 点击按钮后的跳转链接。该字段与 multi_url 字段不可同时设置。
     */
    private String url;
    /**
     * 点击按钮后的跳转链接。该字段与 url 字段不可同时设置。
     */
    private String multiUrl;
    /**
     * 该字段用于配置回传交互。当用户点击交互组件后，会将 value 的值返回给接收回调数据的服务器
     */
    private Map<String, Object> value;
    /**
     * 是否同时生效上述历史字段配置的跳转链接交互和回传交互。默认仅生效跳转链接交互。
     */
    private Boolean complexInteraction;

    @Override
    public Map<String, Object> toMessage() {
        Map<String, Object> message = new java.util.HashMap<>(13);
        message.put("tag", tag);
        if (null != type) {
            message.put("type", type.getValue());
        }
        if (null != size) {
            message.put("size", size.getValue());
        }
        if (null != width) {
            message.put("width", width);
        }
        if (null != text) {
            Map<String, Object> textMap = new java.util.HashMap<>(2);
            textMap.put("tag", TextTag.PLAIN_TEXT.getValue());
            textMap.put("content", text);

            message.put("text", textMap);
        }
        if (null != icon) {
            message.put("icon", icon.toMessage());
        }
        if (null != hoverTips) {
            Map<String, Object> hoverTipsMap = new java.util.HashMap<>(2);
            hoverTipsMap.put("tag", TextTag.PLAIN_TEXT.getValue());
            hoverTipsMap.put("content", hoverTips);

            message.put("hover_tips", hoverTipsMap);
        }

        if (null != disabled) {
            message.put("disabled", disabled);
        }
        if (null != disabledTips) {
            Map<String, Object> disabledTipsMap = new java.util.HashMap<>(2);
            disabledTipsMap.put("tag", TextTag.PLAIN_TEXT.getValue());
            disabledTipsMap.put("content", disabledTips);

            message.put("disabled_tips", disabledTipsMap);
        }
        if (null != confirm) {
            message.put("confirm", confirm.toMessage());
        }
        if (null != behaviors) {
            message.put("behaviors", behaviors);
        }
        if (null != name) {
            message.put("name", name);
        }
        if (null != required) {
            message.put("required", required);
        }
        if (null != actionType) {
            message.put("action_type", actionType.getValue());
        }

        if (null != url) {
            message.put("url", url);
        }
        if (null != multiUrl) {
            message.put("multi_url", multiUrl);
        }
        if (null != value) {
            message.put("value", value);
        }
        if (null != complexInteraction) {
            message.put("complex_interaction", complexInteraction);
        }
        return message;
    }

    public static ButtonBuilder builder() {
        return new ButtonBuilder();
    }

    /**
     * 构造器
     */
    public static class ButtonBuilder implements Builder<Button> {
        private final Button button = new Button();

        private ButtonBuilder() {
        }

        /**
         * 按钮的类型
         *
         * @param type 按钮的类型
         * @return {@link ButtonBuilder}
         */
        public ButtonBuilder setType(ButtonType type) {
            button.setType(type);
            return this;
        }

        /**
         * 按钮的大小
         *
         * @param size 按钮的大小
         * @return {@link ButtonBuilder}
         */
        public ButtonBuilder setSize(ButtonSize size) {
            button.setSize(size);
            return this;
        }

        /**
         * 按钮的宽度
         * <ul>
         * <li>default：默认宽度</li>
         * <li>fill：卡片最大支持宽度</li>
         * <li>[100,∞)px：自定义宽度。如 120px。超出卡片宽度时将按最大支持宽度展示</li>
         * </ul>
         *
         * @param width 按钮的宽度
         * @return {@link ButtonBuilder}
         */
        public ButtonBuilder setWidth(String width) {
            button.setWidth(width);
            return this;
        }

        /**
         * 按钮上的文本
         *
         * @param text 按钮上的文本
         * @return {@link ButtonBuilder}
         */
        public ButtonBuilder setText(String text) {
            button.setText(text);
            return this;
        }

        /**
         * 添加图标作为文本前缀图标。支持自定义或使用图标库中的图标。
         *
         * @param icon 图标
         * @return {@link ButtonBuilder}
         */
        public ButtonBuilder setIcon(IconEl icon) {
            button.setIcon(icon);
            return this;
        }

        /**
         * 用户在 PC 端将光标悬浮在交互容器上方时的文案提醒。默认为空。
         *
         * @param hoverTips 提醒
         * @return {@link ButtonBuilder}
         */
        public ButtonBuilder setHoverTips(String hoverTips) {
            button.setHoverTips(hoverTips);
            return this;
        }

        /**
         * 是否禁用按钮
         *
         * @param disabled 是否禁用按钮
         * @return {@link ButtonBuilder}
         */
        public ButtonBuilder setDisabled(Boolean disabled) {
            button.setDisabled(disabled);
            return this;
        }

        /**
         * 按钮禁用时的文案提醒。默认为空。
         *
         * @param disabledTips 提醒
         * @return {@link ButtonBuilder}
         */
        public ButtonBuilder setDisabledTips(String disabledTips) {
            button.setDisabledTips(disabledTips);
            return this;
        }

        /**
         * 二次确认弹窗配置
         *
         * @param confirm 二次确认弹窗配置
         * @return {@link ButtonBuilder}
         */
        public ButtonBuilder setConfirm(ConfirmEl confirm) {
            button.setConfirm(confirm);
            return this;
        }

        /**
         * 配置交互类型和具体交互行为。支持同时生效跳转链接和回传交互
         *
         * @param behaviors 交互类型和具体交互行为
         * @return {@link ButtonBuilder}
         */
        public ButtonBuilder setBehaviors(Object behaviors) {
            button.setBehaviors(behaviors);
            return this;
        }

        /**
         * 表单容器的唯一标识
         *
         * @param name 表单容器的唯一标识
         * @return {@link ButtonBuilder}
         */
        public ButtonBuilder setName(String name) {
            button.setName(name);
            return this;
        }

        /**
         * 交互类型
         *
         * @param actionType 交互类型
         * @return {@link ButtonBuilder}
         */
        public ButtonBuilder setActionType(ActionType actionType) {
            button.setActionType(actionType);
            return this;
        }

        /**
         * 是否必填
         *
         * @param required 是否必填
         * @return {@link ButtonBuilder}
         */
        public ButtonBuilder setRequired(Boolean required) {
            button.setRequired(required);
            return this;
        }

        /**
         * 点击按钮后的跳转链接。该字段与 multi_url 字段不可同时设置。
         *
         * @param url 跳转链接
         * @return {@link ButtonBuilder}
         */
        public ButtonBuilder setUrl(String url) {
            button.setUrl(url);
            return this;
        }

        /**
         * 点击按钮后的跳转链接。该字段与 url 字段不可同时设置。
         *
         * @param multiUrl 跳转链接
         * @return {@link ButtonBuilder}
         */
        public ButtonBuilder setMultiUrl(String multiUrl) {
            button.setMultiUrl(multiUrl);
            return this;
        }

        /**
         * 该字段用于配置回传交互。当用户点击交互组件后，会将 value 的值返回给接收回调数据的服务器
         *
         * @param value 回传交互
         * @return {@link ButtonBuilder}
         */
        public ButtonBuilder setValue(Map<String, Object> value) {
            button.setValue(value);
            return this;
        }

        /**
         * 该字段用于配置回传交互。当用户点击交互组件后，会将 value 的值返回给接收回调数据的服务器
         *
         * @param key   key
         * @param value value
         * @return {@link ButtonBuilder}
         */
        public ButtonBuilder setValue(String key, Object value) {
            Map<String, Object> map = new HashMap<>();
            map.put(key, value);
            button.setValue(map);
            return this;
        }

        /**
         * 该字段用于配置回传交互。当用户点击交互组件后，会将 value 的值返回给接收回调数据的服务器
         *
         * @param key   key
         * @param value value
         * @return {@link ButtonBuilder}
         */
        public ButtonBuilder putValue(String key, Object value) {
            if (null == button.getValue()) {
                button.setValue(new HashMap<>());
            }
            button.getValue().put(key, value);
            return this;
        }

        /**
         * 该字段用于配置回传交互。当用户点击交互组件后，会将 value 的值返回给接收回调数据的服务器
         *
         * @param value value
         * @return {@link ButtonBuilder}
         */
        public ButtonBuilder putValue(Map<String, Object> value) {
            if (null == button.getValue()) {
                button.setValue(new HashMap<>());
            }
            button.getValue().putAll(value);
            return this;
        }

        /**
         * 是否同时生效上述历史字段配置的跳转链接交互和回传交互。默认仅生效跳转链接交互。
         *
         * @param complexInteraction 是否同时生效
         * @return {@link ButtonBuilder}
         */
        public ButtonBuilder setComplexInteraction(Boolean complexInteraction) {
            button.setComplexInteraction(complexInteraction);
            return this;
        }


        @Override
        public Button build() {
            return button;
        }
    }
}
