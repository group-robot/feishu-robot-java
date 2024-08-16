package io.github.group.robot.feishu.core.model.card.components.ele;

import io.github.group.robot.feishu.core.constants.TextTag;
import io.github.group.robot.feishu.core.model.IMessage;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

/**
 * 图片
 *
 * @author <a href="mailto:huangbing0730@gmail">hb0730</a>
 * @date 2024/8/2
 */
@Getter
@Setter
public class ImageEl implements IMessage {
    private final String tag = "img";
    /**
     * 图片地址
     */
    private String imageUrl;
    /**
     * 国际化配置
     */
    private Map<String, String> i18nImgKey;
    /**
     * 悬浮（hover）在图片上时展示的说明文案
     */
    private ContentI18n alt;

    public ImageEl() {
    }

    public ImageEl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    /**
     * 设置图片地址
     *
     * @param imageUrl 图片地址
     * @return 图片
     */
    public ImageEl setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    /**
     * 设置国际化配置
     *
     * @param i18nImgKey 国际化配置
     * @return 图片
     */
    public ImageEl setI18nImgKey(Map<String, String> i18nImgKey) {
        this.i18nImgKey = i18nImgKey;
        return this;
    }

    /**
     * 设置国际化配置
     *
     * @param key   国际化配置的key
     * @param value 国际化配置的value
     * @return 图片
     */
    public ImageEl setI18nImgKey(String key, String value) {
        Map<String, String> map = new java.util.HashMap<>(1);
        map.put(key, value);
        this.i18nImgKey = map;
        return this;
    }

    /**
     * 添加国际化配置
     *
     * @param key   国际化配置的key
     * @param value 国际化配置的value
     * @return 图片
     */
    public ImageEl addI18nImgKey(String key, String value) {
        if (this.i18nImgKey == null) {
            this.i18nImgKey = new java.util.HashMap<>();
        }
        this.i18nImgKey.put(key, value);
        return this;
    }

    /**
     * 添加国际化配置
     *
     * @param i18nImgKey 国际化配置
     * @return 图片
     */
    public ImageEl addI18nImgKey(Map<String, String> i18nImgKey) {
        if (this.i18nImgKey == null) {
            this.i18nImgKey = new java.util.HashMap<>();
        }
        this.i18nImgKey.putAll(i18nImgKey);
        return this;
    }

    /**
     * 设置悬浮（hover）在图片上时展示的说明文案
     *
     * @param alt 说明文案
     * @return 图片
     */
    public ImageEl setAlt(ContentI18n alt) {
        this.alt = alt;
        return this;
    }


    @Override
    public Map<String, Object> toMessage() {
        Map<String, Object> map = new java.util.HashMap<>(4);
        map.put("tag", tag);
        map.put("img_key", imageUrl);
        if (i18nImgKey != null) {
            map.put("i18n_img_key", i18nImgKey);
        }
        if (alt != null) {
            Map<String, Object> message = alt.toMessage();
            message.put("tag", TextTag.PLAIN_TEXT.getValue());
            map.put("alt", message);
        }
        return map;
    }

    /**
     * 创建图片
     *
     * @param imageUrl 图片地址
     * @return 图片
     */
    public static ImageEl of(String imageUrl) {
        return new ImageEl(imageUrl);
    }

    /**
     * 创建图片
     *
     * @return 图片
     */
    public static ImageEl of() {
        return new ImageEl();
    }

}
