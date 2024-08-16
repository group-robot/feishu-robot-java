package io.github.group.robot.feishu.core.model.card;

import io.github.group.robot.feishu.core.model.Builder;
import io.github.group.robot.feishu.core.model.IMessage;
import io.github.group.robot.feishu.core.model.card.components.ConfigStyle;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

/**
 * 卡片属性
 *
 * @author <a href="mailto:huangbing0730@gmail">hb0730</a>
 * @date 2021/12/16
 */
@Getter
@Setter
public class CardConfig implements IMessage {
    /**
     * 是否允许卡片被转发。客户端版本要求为3.31.0
     */
    private Boolean enableForward;
    /**
     * 更新卡片的内容是否对所有收到这张卡片的人员可见
     */
    private Boolean updateMulti;
    /**
     * 消息卡片宽度,默认为default
     * <p>
     * default: 默认宽度,PC 端宽版、iPad 端上的宽度上限为 600px。<br>
     * compact: 紧凑宽度模式。PC 端宽版、iPad 端上的宽度上限为 400px。<br>
     * fill: 撑满聊天窗口宽度。<br>
     */
    private String widthMode;
    /**
     * 是否使用自定义翻译数据,默认为false
     * <p>
     * true：在用户点击消息翻译后，使用 i18n 对应的目标语种作为翻译结果。若 i18n 取不到，则使用当前内容请求飞书的机器翻译。<br>
     * false：不使用自定义翻译数据，直接请求飞书的机器翻译。<br>
     */
    private Boolean useCustomTranslation;

    /**
     * 转发的卡片是否仍然支持回传交互。默认为false
     */
    private Boolean enableForwardInteraction;
    /**
     * 添加自定义字号和颜色的样式
     */
    private ConfigStyle style;

    @Override
    public Map<String, Object> toMessage() {
        Map<String, Object> message = new HashMap<>(5);
        if (null != enableForward) {
            message.put("enable_forward", enableForward);
        }
        if (null != updateMulti) {
            message.put("update_multi", updateMulti);
        }
        if (null != widthMode) {
            message.put("width_mode", widthMode);
        }
        if (null != useCustomTranslation) {
            message.put("use_custom_translation", useCustomTranslation);
        }
        if (null != enableForwardInteraction) {
            message.put("enable_forward_interaction", enableForwardInteraction);
        }
        if (null != style) {
            message.put("style", style.toMessage());
        }

        return message;
    }

    /**
     * 构造器
     *
     * @return .
     */
    public static CardConfigBuilder builder() {
        return new CardConfigBuilder();
    }

    /**
     * {@link CardConfig} 构造器
     */
    public static class CardConfigBuilder implements Builder<CardConfig> {
        private final CardConfig cardConfig;

        private CardConfigBuilder() {
            this.cardConfig = new CardConfig();
        }

        /**
         * 是否允许卡片被转发。客户端版本要求为3.31.0
         *
         * @param enableForward 是否允许卡片被转发
         * @return .
         */
        public CardConfigBuilder setEnableForward(Boolean enableForward) {
            this.cardConfig.setEnableForward(enableForward);
            return this;
        }

        /**
         * 允许卡片被转发
         *
         * @return .
         */
        public CardConfigBuilder setEnableForward() {
            this.cardConfig.setEnableForward(true);
            return this;
        }

        /**
         * 禁止卡片被转发
         *
         * @return .
         */
        public CardConfigBuilder setDisableForward() {
            this.cardConfig.setEnableForward(false);
            return this;
        }

        /**
         * 更新卡片的内容是否对所有收到这张卡片的人员可见
         *
         * @param updateMulti 更新卡片的内容是否对所有收到这张卡片的人员可见
         * @return .
         */
        public CardConfigBuilder setUpdateMulti(Boolean updateMulti) {
            this.cardConfig.setUpdateMulti(updateMulti);
            return this;
        }

        /**
         * 更新卡片的内容是否对所有收到这张卡片的人员可见
         *
         * @return .
         */
        public CardConfigBuilder setEnableUpdateMulti() {
            this.cardConfig.setUpdateMulti(true);
            return this;
        }

        /**
         * 更新卡片的内容是否对所有收到这张卡片的人员可见
         *
         * @return .
         */
        public CardConfigBuilder setDisableUpdateMulti() {
            this.cardConfig.setUpdateMulti(false);
            return this;
        }

        /**
         * 消息卡片宽度,默认为default
         * <p>
         * default: 默认宽度,PC 端宽版、iPad 端上的宽度上限为 600px。<br>
         * compact: 紧凑宽度模式。PC 端宽版、iPad 端上的宽度上限为 400px。<br>
         * fill: 撑满聊天窗口宽度。<br>
         *
         * @param widthMode 消息卡片宽度
         * @return .
         */
        public CardConfigBuilder setWidthMode(String widthMode) {
            this.cardConfig.setWidthMode(widthMode);
            return this;
        }

        /**
         * 是否使用自定义翻译数据,默认为false
         * <p>
         * true：在用户点击消息翻译后，使用 i18n 对应的目标语种作为翻译结果。若 i18n 取不到，则使用当前内容请求飞书的机器翻译。<br>
         * false：不使用自定义翻译数据，直接请求飞书的机器翻译。<br>
         *
         * @param useCustomTranslate 是否使用自定义翻译数据
         * @return .
         */
        public CardConfigBuilder setUseCustomTranslate(Boolean useCustomTranslate) {
            this.cardConfig.setUseCustomTranslation(useCustomTranslate);
            return this;
        }

        /**
         * 使用自定义翻译数据
         *
         * @return .
         */
        public CardConfigBuilder setUseCustomTranslate() {
            this.cardConfig.setUseCustomTranslation(true);
            return this;
        }

        /**
         * 不使用自定义翻译数据
         *
         * @return .
         */
        public CardConfigBuilder setDisableCustomTranslate() {
            this.cardConfig.setUseCustomTranslation(false);
            return this;
        }

        /**
         * 转发的卡片是否仍然支持回传交互。默认为false
         *
         * @param enableForwardInteraction 转发的卡片是否仍然支持回传交互
         * @return .
         */
        public CardConfigBuilder setEnableForwardInteraction(Boolean enableForwardInteraction) {
            this.cardConfig.setEnableForwardInteraction(enableForwardInteraction);
            return this;
        }

        /**
         * 转发的卡片仍然支持回传交互
         *
         * @return .
         */
        public CardConfigBuilder setEnableForwardInteraction() {
            this.cardConfig.setEnableForwardInteraction(true);
            return this;
        }

        /**
         * 转发的卡片不支持回传交互
         *
         * @return .
         */
        public CardConfigBuilder setDisableForwardInteraction() {
            this.cardConfig.setEnableForwardInteraction(false);
            return this;
        }

        /**
         * 添加自定义字号和颜色的样式
         *
         * @param style 添加自定义字号和颜色的样式
         * @return .
         */
        public CardConfigBuilder setStyle(ConfigStyle style) {
            this.cardConfig.setStyle(style);
            return this;
        }

        @Override
        public CardConfig build() {
            return this.cardConfig;
        }
    }
}
