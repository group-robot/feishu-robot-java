package io.github.group.robot.feishu.core.model.card.components.ele;

import io.github.group.robot.feishu.core.constants.IconTag;
import io.github.group.robot.feishu.core.model.Builder;
import io.github.group.robot.feishu.core.model.IMessage;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

/**
 * 添加图标作为文本前缀图标。支持自定义或使用图标库中的图标。
 *
 * @author <a href="mailto:huangbing0730@gmail">hb0730</a>
 * @date 2024/7/27
 */
@Getter
@Setter
public class IconEl implements IMessage {
    /**
     * 图标标签
     */
    private IconTag tag;
    /**
     * 图标标签为 standard_icon 时，使用图标库中的图标
     *
     * @see <a href="https://open.feishu.cn/document/uAjLw4CM/ukzMukzMukzM/feishu-cards/enumerations-for-icons">图标库</a>
     */
    private String token;
    /**
     * 图标的颜色。支持设置线性和面性图标（即 token 末尾为 outlined 或 filled 的图标）的颜色。当 tag 为 standard_icon 时生效。枚举值参见颜色枚举值。
     *
     * @see <a href="https://open.feishu.cn/document/uAjLw4CM/ukzMukzMukzM/feishu-cards/enumerations-for-fields-related-to-color">颜色枚举值</a>
     */
    private String color;
    /**
     * 自定义前缀图标的图片 key。当 tag 为 custom_icon 时生效。
     */
    private String imgKey;
    /**
     * 图片资源的 Key 的国际化配置。当 tag 为 custom_icon 时生效。
     */
    private Map<String, String> i18nImgKey;
    /**
     * 图标的尺寸。支持 "[1,999] [1,999]px"。
     */
    private String size;

    @Override
    public Map<String, Object> toMessage() {
        Map<String, Object> map = new HashMap<>(2);
        map.put("tag", tag.getValue());
        if (null != token) {
            map.put("token", token);
        }
        if (null != color) {
            map.put("color", color);
        }
        if (null != imgKey) {
            map.put("img_key", imgKey);
        }
        if (null != i18nImgKey) {
            map.put("i18n_img_key", i18nImgKey);
        }
        if (null != size) {
            map.put("size", size);
        }
        return map;
    }

    /**
     * 构建者
     *
     * @return this
     */
    public static IconElBuilder builder() {
        return new IconElBuilder();
    }

    /**
     * 构建者
     */
    public static class IconElBuilder implements Builder<IconEl> {
        private final IconEl iconEl = new IconEl();

        public static IconElBuilder builder() {
            return new IconElBuilder();
        }

        /**
         * 设置图标标签
         *
         * @param tag 图标标签
         * @return this
         */
        public IconElBuilder setTag(IconTag tag) {
            iconEl.setTag(tag);
            return this;
        }

        /**
         * 设置图标标签为 standard_icon 时，使用图标库中的图标
         *
         * @param token 图标库中的图标
         * @return this
         */
        public IconElBuilder setToken(String token) {
            iconEl.setToken(token);
            return this;
        }

        /**
         * 设置图标的颜色
         *
         * @param color 颜色
         * @return this
         */
        public IconElBuilder setColor(String color) {
            iconEl.setColor(color);
            return this;
        }

        /**
         * 设置自定义前缀图标的图片 key
         *
         * @param imgKey 图片 key
         * @return this
         */
        public IconElBuilder setImgKey(String imgKey) {
            iconEl.setImgKey(imgKey);
            return this;
        }

        /**
         * 设置图片资源的 Key 的国际化配置
         *
         * @param i18nImgKey 图片资源的 Key 的国际化配置
         * @return this
         */
        public IconElBuilder setI18nImgKey(Map<String, String> i18nImgKey) {
            iconEl.setI18nImgKey(i18nImgKey);
            return this;
        }

        /**
         * 设置图片资源的 Key 的国际化配置
         *
         * @param key   key
         * @param value value
         * @return this
         */
        public IconElBuilder setI18nImgKey(String key, String value) {
            Map<String, String> i18nImgKey = new HashMap<>();
            i18nImgKey.put(key, value);
            iconEl.setI18nImgKey(i18nImgKey);
            return this;
        }

        /**
         * 设置图片资源的 Key 的国际化配置
         *
         * @param key   key
         * @param value value
         * @return this
         */
        public IconElBuilder addI18nImgKey(String key, String value) {
            if (iconEl.getI18nImgKey() == null) {
                iconEl.setI18nImgKey(new HashMap<>());
            }
            iconEl.getI18nImgKey().put(key, value);
            return this;
        }

        /**
         * 设置图片资源的 Key 的国际化配置
         *
         * @param i18nImgKey 图片资源的 Key 的国际化配置
         * @return this
         */
        public IconEl addI18nImgKey(Map<String, String> i18nImgKey) {
            if (iconEl.getI18nImgKey() == null) {
                iconEl.setI18nImgKey(new HashMap<>());
            }
            iconEl.getI18nImgKey().putAll(i18nImgKey);
            return iconEl;
        }

        /**
         * 设置图标的尺寸
         *
         * @param size 尺寸
         * @return this
         */
        public IconElBuilder setSize(String size) {
            iconEl.setSize(size);
            return this;
        }

        @Override
        public IconEl build() {
            return iconEl;
        }
    }
}
