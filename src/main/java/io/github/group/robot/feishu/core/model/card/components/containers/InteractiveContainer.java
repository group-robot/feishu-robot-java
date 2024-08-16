package io.github.group.robot.feishu.core.model.card.components.containers;

import io.github.group.robot.feishu.core.constants.TextTag;
import io.github.group.robot.feishu.core.model.Builder;
import io.github.group.robot.feishu.core.model.IMessage;
import io.github.group.robot.feishu.core.model.card.components.CardTag;
import io.github.group.robot.feishu.core.model.card.components.ele.ConfirmEl;
import io.github.group.robot.feishu.core.model.card.components.ele.ContentI18n;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

/**
 * 卡片组件 - 容器 - 交互容器
 *
 * @author <a href="mailto:huangbing0730@gmail">hb0730</a>
 * @date 2024/7/30
 */
@Getter
@Setter
public class InteractiveContainer implements CardTag {
    private final String tag = "interactive_container";
    /**
     * 交互容器的宽度。
     * <ul>
     *  <li>fill：卡片最大支持宽度</li>
     *  <li>weighted:宽度按 weight 参数定义的权重分布</li>
     *  <li>[16,999]px：自定义宽度，如 "20px"。最小宽度为 16px</li>
     * </ul>
     */
    private String width;
    /**
     * 交互容器的高度。
     * <ul>
     *  <li>auto：自适应高度</li>
     *  <li>[10,999]px：自定义高度，如 "20px"</li>
     * </ul>
     */
    private String height;

    /**
     * 交互容器的背景色样式
     * <ul>
     *  <li>default：默认背景色</li>
     *  <li>laser：镭射渐变彩色样式</li>
     *  <li>卡片支持的颜色枚举值和 RGBA 语法自定义颜色</li>
     * </ul>
     */
    private String backgroundStyle;
    /**
     * 是否展示边框，粗细固定为 1px。
     */
    private Boolean hasBorder;
    /**
     * 边框颜色
     *
     * @see <a href="https://open.feishu.cn/document/uAjLw4CM/ukzMukzMukzM/feishu-cards/enumerations-for-fields-related-to-color">颜色枚举值</a>
     */
    private String borderColor;
    /**
     * 交互容器的圆角半径，单位是像素（px）或百分比（%）。取值遵循以下格式：
     * <ul>
     *  <li>[0,∞]px，如 "10px"</li>
     *  <li>[0,100]%，如 "30%"</li>
     * </ul>
     */
    private String cornerRadius;
    /**
     * 交互容器的内边距。值的取值范围为 [0,28]px
     * <p>
     * 单值，如 "10px"，表示列的四个外边距都为 10 px。<br>
     * 多值，如 "4px 12px 4px 12px"，表示列的上、右、下、左的外边距分别为 4px，12px，4px，12px。四个值必填，使用空格间隔。
     */
    private String padding;

    /**
     * 设置点击交互容器时的交互配置,只需要value值
     */
    private List<Object> behaviors;
    /**
     * 用户在 PC 端将光标悬浮在交互容器上方时的文案提醒
     */
    private ContentI18n hoverTipsContent;
    /**
     * 是否禁用交互容器。
     */
    private Boolean disabled;
    /**
     * 禁用交互容器后，用户触发交互时的弹窗文案提醒
     */
    private ContentI18n disabledTipsContent;
    /**
     * 二次确认弹窗配置。
     */
    private ConfirmEl confirm;
    /**
     * 交互容器内嵌的组件。仅支持内嵌普通文本、富文本、图片、备注、分栏、勾选器、交互容器组件。
     */
    private List<IMessage> elements;


    @Override
    public Map<String, Object> toMessage() {
        Map<String, Object> message = new java.util.HashMap<>(12);
        message.put("tag", tag);
        if (null != width) {
            message.put("width", width);
        }
        if (null != height) {
            message.put("height", height);
        }
        if (null != backgroundStyle) {
            message.put("background_style", backgroundStyle);
        }
        if (null != hasBorder) {
            message.put("has_border", hasBorder);
        }
        if (null != borderColor) {
            message.put("border_color", borderColor);
        }
        if (null != cornerRadius) {
            message.put("corner_radius", cornerRadius);
        }
        if (null != padding) {
            message.put("padding", padding);
        }
        if (null != behaviors) {
            message.put("behaviors", behaviors);
        }
        if (null != hoverTipsContent) {
            Map<String, Object> hoverTips = hoverTipsContent.toMessage();
            hoverTips.put("tag", TextTag.PLAIN_TEXT.getValue());
            message.put("hover_tips", hoverTips);
        }
        if (null != disabled) {
            message.put("disabled", disabled);
        }
        if (null != disabledTipsContent) {
            Map<String, Object> disabledTips = disabledTipsContent.toMessage();
            disabledTips.put("tag", TextTag.PLAIN_TEXT.getValue());
            message.put("disabled_tips", disabledTips);
        }
        if (null != confirm) {
            message.put("confirm", confirm.toMessage());
        }
        if (null != elements) {
            List<Map<String, Object>> elements = new java.util.ArrayList<>(this.elements.size());
            for (IMessage element : this.elements) {
                elements.add(element.toMessage());
            }
            message.put("elements", elements);
        }
        return message;
    }

    /**
     * 创建交互容器
     *
     * @return .
     */
    public static InteractiveContainerBuilder builder() {
        return new InteractiveContainerBuilder();
    }

    public static class InteractiveContainerBuilder implements Builder<InteractiveContainer> {
        private final InteractiveContainer interactiveContainer = new InteractiveContainer();

        private InteractiveContainerBuilder() {
        }

        /**
         * 交互容器的宽度。
         * <ul>
         *  <li>fill：卡片最大支持宽度</li>
         *  <li>weighted:宽度按 weight 参数定义的权重分布</li>
         *  <li>[16,999]px：自定义宽度，如 "20px"。最小宽度为 16px</li>
         * </ul>
         *
         * @param width 交互容器的宽度。
         * @return .
         */
        public InteractiveContainerBuilder setWidth(String width) {
            interactiveContainer.setWidth(width);
            return this;
        }

        /**
         * 交互容器的高度。
         * <ul>
         *  <li>auto：自适应高度</li>
         *  <li>[10,999]px：自定义高度，如 "20px"</li>
         * </ul>
         *
         * @param height 交互容器的高度。
         * @return .
         */
        public InteractiveContainerBuilder setHeight(String height) {
            interactiveContainer.setHeight(height);
            return this;
        }

        /**
         * 交互容器的背景色样式
         * <ul>
         *  <li>default：默认背景色</li>
         *  <li>laser：镭射渐变彩色样式</li>
         *  <li>卡片支持的颜色枚举值和 RGBA 语法自定义颜色</li>
         * </ul>
         *
         * @param backgroundStyle 交互容器的背景色样式
         * @return .
         */
        public InteractiveContainerBuilder setBackgroundStyle(String backgroundStyle) {
            interactiveContainer.setBackgroundStyle(backgroundStyle);
            return this;
        }

        /**
         * 是否展示边框，粗细固定为 1px。
         *
         * @param hasBorder 是否展示边框，粗细固定为 1px。
         * @return .
         */
        public InteractiveContainerBuilder setHasBorder(Boolean hasBorder) {
            interactiveContainer.setHasBorder(hasBorder);
            return this;
        }

        /**
         * 边框颜色
         *
         * @param borderColor 边框颜色
         * @return .
         * @see <a href="https://open.feishu.cn/document/uAjLw4CM/ukzMukzMukzM/feishu-cards/enumerations-for-fields-related-to-color">颜色枚举值</a>
         */
        public InteractiveContainerBuilder setBorderColor(String borderColor) {
            interactiveContainer.setBorderColor(borderColor);
            return this;
        }

        /**
         * 交互容器的圆角半径，单位是像素（px）或百分比（%）。取值遵循以下格式：
         * <ul>
         *  <li>[0,∞]px，如 "10px"</li>
         *  <li>[0,100]%，如 "30%"</li>
         * </ul>
         *
         * @param cornerRadius 交互容器的圆角半径
         * @return .
         */
        public InteractiveContainerBuilder setCornerRadius(String cornerRadius) {
            interactiveContainer.setCornerRadius(cornerRadius);
            return this;
        }

        /**
         * 交互容器的内边距。值的取值范围为 [0,28]px
         * <p>
         * 单值，如 "10px"，表示列的四个外边距都为 10 px。<br>
         * 多值，如 "4px 12px 4px 12px"，表示列的上、右、下、左的外边距分别为 4px，12px，4px，12px。四个值必填，使用空格间隔。
         *
         * @param padding 交互容器的内边距
         * @return .
         */
        public InteractiveContainerBuilder setPadding(String padding) {
            interactiveContainer.setPadding(padding);
            return this;
        }

        /**
         * 设置点击交互容器时的交互配置,只需要value值
         *
         * @param behaviors 点击交互容器时的交互配置
         * @return .
         */
        public InteractiveContainerBuilder setBehaviors(List<Object> behaviors) {
            interactiveContainer.setBehaviors(behaviors);
            return this;
        }

        /**
         * 设置点击交互容器时的交互配置,只需要value值
         *
         * @param behaviors 点击交互容器时的交互配置
         * @return .
         */
        public InteractiveContainerBuilder setBehaviors(Object... behaviors) {
            List<Object> list = new java.util.ArrayList<>(behaviors.length);
            list.addAll(java.util.Arrays.asList(behaviors));
            interactiveContainer.setBehaviors(list);
            return this;
        }

        /**
         * 添加点击交互容器时的交互配置,只需要value值
         *
         * @param behavior 点击交互容器时的交互配置
         * @return .
         */
        public InteractiveContainerBuilder addBehavior(Object... behavior) {
            if (null == interactiveContainer.getBehaviors()) {
                interactiveContainer.setBehaviors(new java.util.ArrayList<>());
            }
            interactiveContainer.getBehaviors().add(behavior);
            return this;
        }

        /**
         * 添加点击交互容器时的交互配置,只需要value值
         *
         * @param behavior 点击交互容器时的交互配置
         * @return .
         */
        public InteractiveContainerBuilder addBehavior(List<Object> behavior) {
            if (null == interactiveContainer.getBehaviors()) {
                interactiveContainer.setBehaviors(new java.util.ArrayList<>());
            }
            interactiveContainer.getBehaviors().add(behavior);
            return this;
        }

        /**
         * 用户在 PC 端将光标悬浮在交互容器上方时的文案提醒
         *
         * @param hoverTipsContent 用户在 PC 端将光标悬浮在交互容器上方时的文案提醒
         * @return .
         */
        public InteractiveContainerBuilder setHoverTipsContent(ContentI18n hoverTipsContent) {
            interactiveContainer.setHoverTipsContent(hoverTipsContent);
            return this;
        }

        /**
         * 是否禁用交互容器。
         *
         * @param disabled 是否禁用交互容器
         * @return .
         */
        public InteractiveContainerBuilder setDisabled(Boolean disabled) {
            interactiveContainer.setDisabled(disabled);
            return this;
        }

        /**
         * 禁用交互容器后，用户触发交互时的弹窗文案提醒
         *
         * @param disabledTipsContent 禁用交互容器后，用户触发交互时的弹窗文案提醒
         * @return .
         */
        public InteractiveContainerBuilder setDisabledTipsContent(ContentI18n disabledTipsContent) {
            interactiveContainer.setDisabledTipsContent(disabledTipsContent);
            return this;
        }

        /**
         * 二次确认弹窗配置。
         *
         * @param confirm 二次确认弹窗配置
         * @return .
         */
        public InteractiveContainerBuilder setConfirm(ConfirmEl confirm) {
            interactiveContainer.setConfirm(confirm);
            return this;
        }

        /**
         * 交互容器内嵌的组件。仅支持内嵌普通文本、富文本、图片、备注、分栏、勾选器、交互容器组件。
         *
         * @param elements 交互容器内嵌的组件
         * @return .
         */
        public InteractiveContainerBuilder setElements(List<IMessage> elements) {
            interactiveContainer.setElements(elements);
            return this;
        }

        /**
         * 交互容器内嵌的组件。仅支持内嵌普通文本、富文本、图片、备注、分栏、勾选器、交互容器组件。
         *
         * @param elements 交互容器内嵌的组件
         * @return .
         */
        public InteractiveContainerBuilder setElements(IMessage... elements) {
            List<IMessage> list = new java.util.ArrayList<>(elements.length);
            list.addAll(java.util.Arrays.asList(elements));
            interactiveContainer.setElements(list);
            return this;
        }

        /**
         * 添加交互容器内嵌的组件。仅支持内嵌普通文本、富文本、图片、备注、分栏、勾选器、交互容器组件。
         *
         * @param element 交互容器内嵌的组件
         * @return .
         */
        public InteractiveContainerBuilder addElement(IMessage element) {
            if (null == interactiveContainer.getElements()) {
                interactiveContainer.setElements(new java.util.ArrayList<>());
            }
            interactiveContainer.getElements().add(element);
            return this;
        }

        /**
         * 添加交互容器内嵌的组件。仅支持内嵌普通文本、富文本、图片、备注、分栏、勾选器、交互容器组件。
         *
         * @param elements 交互容器内嵌的组件
         * @return .
         */
        public InteractiveContainerBuilder addElements(IMessage... elements) {
            if (null == interactiveContainer.getElements()) {
                interactiveContainer.setElements(new java.util.ArrayList<>());
            }
            for (IMessage element : elements) {
                interactiveContainer.getElements().add(element);
            }
            return this;
        }

        /**
         * 添加交互容器内嵌的组件。仅支持内嵌普通文本、富文本、图片、备注、分栏、勾选器、交互容器组件。
         *
         * @param elements 交互容器内嵌的组件
         * @return .
         */
        public InteractiveContainerBuilder addElements(List<IMessage> elements) {
            if (null == interactiveContainer.getElements()) {
                interactiveContainer.setElements(new java.util.ArrayList<>());
            }
            interactiveContainer.getElements().addAll(elements);
            return this;
        }

        @Override
        public InteractiveContainer build() {
            return interactiveContainer;
        }
    }
}
