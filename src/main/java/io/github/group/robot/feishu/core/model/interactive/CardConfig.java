package io.github.group.robot.feishu.core.model.interactive;

import io.github.group.robot.feishu.core.model.Builder;
import io.github.group.robot.feishu.core.model.IMessage;
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
     * 是否根据屏幕宽度动态调整消息卡片宽度
     */
    @Deprecated
    private Boolean wideScreenMode;

    @Override
    public Map<String, Object> toMessage() {
        Map<String, Object> message = new HashMap<>(3);
        message.put("wide_screen_mode", this.wideScreenMode == null || this.wideScreenMode);
        message.put("enable_forward", this.enableForward != null && this.enableForward);
        if (null != this.wideScreenMode) {
            message.put("update_multi", this.updateMulti);
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
         * create {@link CardConfigBuilder}
         *
         * @return .
         */
        public static CardConfigBuilder builder() {
            return new CardConfigBuilder();
        }


        /**
         * 是否允许卡片被转发。客户端版本要求为3.31.0,默认为true
         *
         * @param enableForward .
         * @return .
         */
        public CardConfigBuilder enableForward(Boolean enableForward) {
            this.cardConfig.setEnableForward(enableForward);
            return this;
        }

        /**
         * 更新卡片的内容是否对所有收到这张卡片的人员可见,默认为false
         *
         * @param updateMulti .
         * @return .
         */
        public CardConfigBuilder updateMulti(Boolean updateMulti) {
            this.cardConfig.setUpdateMulti(updateMulti);
            return this;
        }

        /**
         * 是否根据屏幕宽度动态调整消息卡片宽度
         *
         * @param wideScreenMode .
         * @return .
         */
        @Deprecated
        public CardConfigBuilder wideScreenMode(Boolean wideScreenMode) {
            this.cardConfig.setWideScreenMode(wideScreenMode);
            return this;
        }

        @Override
        public CardConfig build() {
            return this.cardConfig;
        }
    }
}
