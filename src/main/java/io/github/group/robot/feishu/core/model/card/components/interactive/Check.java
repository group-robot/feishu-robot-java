package io.github.group.robot.feishu.core.model.card.components.interactive;

import io.github.group.robot.feishu.core.constants.TextTag;
import io.github.group.robot.feishu.core.model.Builder;
import io.github.group.robot.feishu.core.model.card.components.CardTag;
import io.github.group.robot.feishu.core.model.card.components.ele.ConfirmEl;
import io.github.group.robot.feishu.core.model.card.components.ele.TextEl;
import io.github.group.robot.feishu.core.model.card.components.interactive.ele.CheckButtonArea;
import io.github.group.robot.feishu.core.model.card.components.interactive.ele.CheckedStyle;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

/**
 * 卡片组件 - 交互 - 勾选器
 *
 * @author <a href="mailto:huangbing0730@gmail">hb0730</a>
 * @date 2024/8/8
 */
@Setter
@Getter
public class Check implements CardTag {
    private final String tag = "checker";
    /**
     * 勾选器的唯一标识
     */
    private String name;
    /**
     * 勾选器的初始勾选状态
     */
    private Boolean checked;
    /**
     * 勾选器组件内的普通文本信息。
     */
    private TextEl text;
    /**
     * 当光标悬浮在勾选器上时，勾选器整体是否有阴影效果。
     */
    private Boolean overallCheckable;
    /**
     * PC 端勾选器内按钮的展示规则。移动端始终显示按钮。
     */
    private CheckButtonArea buttonArea;
    /**
     * 勾选状态样式。
     */
    private CheckedStyle checkedStyle;
    /**
     * 组件整体的外边距，支持填写单值或多值：
     * <p>
     * 单值：如 "4px"，表示组件的四个外边距都为 4px<br>
     * 多值：如 "4px 12px 4px 12px"，表示容器内上、右、下、左的内边距分别为 4px，12px，4px，12px。四个值必填，使用空格间隔<br>
     */
    private String margin;
    /**
     * 组件整体的内边距，支持填写单值或多值：
     * <p>
     * 单值：如 "4px"，表示组件的四个内边距都为 4px<br>
     * 多值：如 "4px 12px 4px 12px"，表示容器内上、右、下、左的内边距分别为 4px，12px，4px，12px。四个值必填，使用空格间隔<br>
     */
    private String padding;
    /**
     * 二次确认弹窗标题。
     */
    private ConfirmEl confirm;
    /**
     * 配置交互类型和具体交互行为。(集合)
     */
    private Object behaviors;
    /**
     * 光标悬浮在勾选器上时展示的提示文案。
     */
    private String hoverTips;
    /**
     * 勾选器是否禁用
     */
    private Boolean disabled;
    /**
     * 勾选器禁用后，用户将光标悬浮在勾选器上时展示的禁用提示文案。
     */
    private String disabledTips;

    @Override
    public Map<String, Object> toMessage() {
        Map<String, Object> message = new java.util.HashMap<>(15);
        message.put("tag", tag);
        if (name != null) {
            message.put("name", name);
        }
        if (checked != null) {
            message.put("checked", checked);
        }
        if (text != null) {
            message.put("text", text.toMessage());
        }
        if (overallCheckable != null) {
            message.put("overall_checkable", overallCheckable);
        }
        if (buttonArea != null) {
            message.put("button_area", buttonArea.toMessage());
        }
        if (checkedStyle != null) {
            message.put("checked_style", checkedStyle.toMessage());
        }
        if (margin != null) {
            message.put("margin", margin);
        }
        if (padding != null) {
            message.put("padding", padding);
        }
        if (confirm != null) {
            message.put("confirm", confirm.toMessage());
        }
        if (behaviors != null) {
            message.put("behaviors", behaviors);
        }
        if (hoverTips != null) {
            Map<String, Object> hoverTips = new java.util.HashMap<>(2);
            hoverTips.put("tag", TextTag.PLAIN_TEXT.getValue());
            hoverTips.put("content", this.hoverTips);
            message.put("hover_tips", hoverTips);
        }
        if (disabled != null) {
            message.put("disabled", disabled);
        }
        if (disabledTips != null) {
            Map<String, Object> disabledTips = new java.util.HashMap<>(2);
            disabledTips.put("tag", TextTag.PLAIN_TEXT.getValue());
            disabledTips.put("content", this.disabledTips);
            message.put("disabled_tips", disabledTips);
        }
        return message;
    }

    public static CheckBuilder builder() {
        return new CheckBuilder();
    }

    /**
     * 构造器
     */
    public static class CheckBuilder implements Builder<Check> {
        private final Check check = new Check();

        private CheckBuilder() {
        }

        /**
         * 设置勾选器的唯一标识
         *
         * @param name 勾选器的唯一标识
         * @return this
         */
        public CheckBuilder setName(String name) {
            check.setName(name);
            return this;
        }

        /**
         * 设置勾选器的初始勾选状态
         *
         * @param checked 勾选器的初始勾选状态
         * @return this
         */
        public CheckBuilder setChecked(Boolean checked) {
            check.setChecked(checked);
            return this;
        }

        /**
         * 设置勾选器组件内的普通文本信息。
         *
         * @param text 勾选器组件内的普通文本信息。
         * @return this
         */
        public CheckBuilder setText(TextEl text) {
            check.setText(text);
            return this;
        }

        /**
         * 设置当光标悬浮在勾选器上时，勾选器整体是否有阴影效果。
         *
         * @param overallCheckable 当光标悬浮在勾选器上时，勾选器整体是否有阴影效果。
         * @return this
         */
        public CheckBuilder setOverallCheckable(Boolean overallCheckable) {
            check.setOverallCheckable(overallCheckable);
            return this;
        }

        /**
         * 设置PC 端勾选器内按钮的展示规则。移动端始终显示按钮。
         *
         * @param buttonArea PC 端勾选器内按钮的展示规则。移动端始终显示按钮。
         * @return this
         */
        public CheckBuilder setButtonArea(CheckButtonArea buttonArea) {
            check.setButtonArea(buttonArea);
            return this;
        }

        /**
         * 设置勾选状态样式。
         *
         * @param checkedStyle 勾选状态样式。
         * @return this
         */
        public CheckBuilder setCheckedStyle(CheckedStyle checkedStyle) {
            check.setCheckedStyle(checkedStyle);
            return this;
        }

        /**
         * 设置组件整体的外边距，支持填写单值或多值：
         * <p>
         * 单值：如 "4px"，表示组件的四个外边距都为 4px<br>
         * 多值：如 "4px 12px 4px 12px"，表示容器内上、右、下、左的内边距分别为 4px，12px，4px，12px。四个值必填，使用空格间隔<br>
         *
         * @param margin 组件整体的外边距
         * @return this
         */
        public CheckBuilder setMargin(String margin) {
            check.setMargin(margin);
            return this;
        }

        /**
         * 设置组件整体的内边距，支持填写单值或多值：
         * <p>
         * 单值：如 "4px"，表示组件的四个内边距都为 4px<br>
         * 多值：如 "4px 12px 4px 12px"，表示容器内上、右、下、左的内边距分别为 4px，12px，4px，12px。四个值必填，使用空格间隔<br>
         *
         * @param padding 组件整体的内边距
         * @return this
         */
        public CheckBuilder setPadding(String padding) {
            check.setPadding(padding);
            return this;
        }

        /**
         * 设置二次确认弹窗标题。
         *
         * @param confirm 二次确认弹窗标题
         * @return this
         */
        public CheckBuilder setConfirm(ConfirmEl confirm) {
            check.setConfirm(confirm);
            return this;
        }

        /**
         * 设置配置交互类型和具体交互行为。(集合)
         *
         * @param behaviors 配置交互类型和具体交互行为
         * @return this
         */
        public CheckBuilder setBehaviors(Object behaviors) {
            check.setBehaviors(behaviors);
            return this;
        }

        /**
         * 设置光标悬浮在勾选器上时展示的提示文案。
         *
         * @param hoverTips 光标悬浮在勾选器上时展示的提示文案
         * @return this
         */
        public CheckBuilder setHoverTips(String hoverTips) {
            check.setHoverTips(hoverTips);
            return this;
        }

        /**
         * 设置勾选器是否禁用
         *
         * @param disabled 勾选器是否禁用
         * @return this
         */
        public CheckBuilder setDisabled(Boolean disabled) {
            check.setDisabled(disabled);
            return this;
        }

        /**
         * 设置勾选器禁用后，用户将光标悬浮在勾选器上时展示的禁用提示文案。
         *
         * @param disabledTips 勾选器禁用后，用户将光标悬浮在勾选器上时展示的禁用提示文案
         * @return this
         */
        public CheckBuilder setDisabledTips(String disabledTips) {
            check.setDisabledTips(disabledTips);
            return this;
        }

        @Override
        public Check build() {
            return check;
        }
    }
}
