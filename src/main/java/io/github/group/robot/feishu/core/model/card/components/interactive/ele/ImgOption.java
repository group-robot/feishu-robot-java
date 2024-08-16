package io.github.group.robot.feishu.core.model.card.components.interactive.ele;

import io.github.group.robot.feishu.core.constants.TextTag;
import io.github.group.robot.feishu.core.model.Builder;
import io.github.group.robot.feishu.core.model.IMessage;
import io.github.group.robot.feishu.core.model.card.components.ele.ContentI18n;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

/**
 * 卡片组件 - 交互 - 图片选项-选项
 *
 * @author <a href="mailto:huangbing0730@gmail">hb0730</a>
 * @date 2024/8/8
 */
@Getter
@Setter
public class ImgOption implements IMessage {
    /**
     * 图片资源的 Key
     */
    private String imgKey;
    /**
     * 图片资源的 Key 的国际化配置
     */
    private Map<String, String> i18nImgKey;
    /**
     * 自定义每个图片选项的回传参数
     */
    private String value;
    /**
     * 是否禁用某个图片选项
     */
    private Boolean disabled;
    /**
     * 禁用某个图片选项后，用户将光标悬浮在选项上或点击选项时展示的禁用提示文案
     */
    private ContentI18n disabledTips;
    /**
     * 用户将光标悬浮在选项上时展示的提示文案
     */
    private ContentI18n hoverTips;

    @Override
    public Map<String, Object> toMessage() {
        Map<String, Object> message = new HashMap<>(5);
        message.put("img_key", imgKey);
        if (i18nImgKey != null) {
            message.put("i18n_img_key", i18nImgKey);
        }
        if (value != null) {
            message.put("value", value);
        }
        if (disabled != null) {
            message.put("disabled", disabled);
        }
        if (disabledTips != null) {
            Map<String, Object> tips = disabledTips.toMessage();
            tips.put("tag", TextTag.PLAIN_TEXT.getValue());
            message.put("disabled_tips", tips);
        }

        if (hoverTips != null) {
            Map<String, Object> tips = hoverTips.toMessage();
            tips.put("tag", TextTag.PLAIN_TEXT.getValue());
            message.put("hover_tips", tips);
        }
        return message;
    }

    public static ImgOptionBuilder builder() {
        return new ImgOptionBuilder();
    }

    /**
     * 构造器
     */
    public static class ImgOptionBuilder implements Builder<ImgOption> {
        private final ImgOption imgOption = new ImgOption();

        private ImgOptionBuilder() {
        }

        /**
         * 图片资源的 Key
         *
         * @param imgKey 图片资源的 Key
         * @return ImgOptionBuilder
         */
        public ImgOptionBuilder setImgKey(String imgKey) {
            imgOption.setImgKey(imgKey);
            return this;
        }

        /**
         * 图片资源的 Key 的国际化配置
         *
         * @param imgKeyI18n 图片资源的 Key 的国际化配置
         * @return ImgOptionBuilder
         */
        public ImgOptionBuilder setI18nImgKey(Map<String, String> imgKeyI18n) {
            imgOption.setI18nImgKey(imgKeyI18n);
            return this;
        }

        /**
         * 图片资源的 Key 的国际化配置
         *
         * @param key   key
         * @param value value
         * @return ImgOptionBuilder
         */
        public ImgOptionBuilder setI18nImgKey(String key, String value) {
            Map<String, String> imgKeyI18n = new HashMap<>();
            imgKeyI18n.put(key, value);
            imgOption.setI18nImgKey(imgKeyI18n);
            return this;
        }

        /**
         * 图片资源的 Key 的国际化配置
         *
         * @param key   key
         * @param value value
         * @return ImgOptionBuilder
         */
        public ImgOptionBuilder addI18nImgKey(String key, String value) {
            if (imgOption.getI18nImgKey() == null) {
                imgOption.setI18nImgKey(new HashMap<>());
            }
            imgOption.getI18nImgKey().put(key, value);
            return this;
        }

        /**
         * 图片资源的 Key 的国际化配置
         *
         * @param imgKeyI18n 图片资源的 Key 的国际化配置
         * @return ImgOptionBuilder
         */
        public ImgOptionBuilder addI18nImgKey(Map<String, String> imgKeyI18n) {
            if (imgOption.getI18nImgKey() == null) {
                imgOption.setI18nImgKey(new HashMap<>());
            }
            imgOption.getI18nImgKey().putAll(imgKeyI18n);
            return this;
        }

        /**
         * 自定义每个图片选项的回传参数
         *
         * @param value 自定义每个图片选项的回传参数
         * @return ImgOptionBuilder
         */
        public ImgOptionBuilder setValue(String value) {
            imgOption.setValue(value);
            return this;
        }

        /**
         * 是否禁用某个图片选项
         *
         * @param disabled 是否禁用某个图片选项
         * @return ImgOptionBuilder
         */
        public ImgOptionBuilder setDisabled(Boolean disabled) {
            imgOption.setDisabled(disabled);
            return this;
        }

        /**
         * 禁用某个图片选项后，用户将光标悬浮在选项上或点击选项时展示的禁用提示文案
         *
         * @param disabledTips 禁用某个图片选项后，用户将光标悬浮在选项上或点击选项时展示的禁用提示文案
         * @return ImgOptionBuilder
         */
        public ImgOptionBuilder setDisabledTips(ContentI18n disabledTips) {
            imgOption.setDisabledTips(disabledTips);
            return this;
        }

        /**
         * 用户将光标悬浮在选项上时展示的提示文案
         *
         * @param hoverTips 用户将光标悬浮在选项上时展示的提示文案
         * @return ImgOptionBuilder
         */
        public ImgOptionBuilder setHoverTips(ContentI18n hoverTips) {
            imgOption.setHoverTips(hoverTips);
            return this;
        }

        @Override
        public ImgOption build() {
            return imgOption;
        }
    }
}
