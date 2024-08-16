package io.github.group.robot.feishu.core.model.card.components.ele;

import io.github.group.robot.feishu.core.constants.TextTag;
import io.github.group.robot.feishu.core.model.IMessage;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

/**
 * 内容国际化
 *
 * @author <a href="mailto:huangbing0730@gmail">hb0730</a>
 * @date 2024/8/15
 */
@Getter
@Setter
public class ContentI18n implements IMessage {
    /**
     * 文本标签
     */
    private TextTag tag = TextTag.PLAIN_TEXT;
    /**
     * 文本内容
     */
    private String content;
    /**
     * 国际化配置
     */
    private Map<String, String> i18n;

    public ContentI18n() {
    }

    public ContentI18n(String content) {
        this.content = content;
    }

    public ContentI18n(TextTag tag, String content) {
        this.tag = tag;
        this.content = content;
    }

    public ContentI18n setContent(String content) {
        this.content = content;
        return this;
    }

    /**
     * 设置标签
     *
     * @param tag 标签
     * @return {@link ContentI18n}
     */
    public ContentI18n setTag(TextTag tag) {
        this.tag = tag;
        return this;
    }

    /**
     * 设置国际化
     *
     * @param i18n 国际化
     * @return {@link ContentI18n}
     */
    public ContentI18n setI18n(Map<String, String> i18n) {
        this.i18n = i18n;
        return this;
    }

    /**
     * 设置国际化
     *
     * @param key   key
     * @param value value
     * @return {@link ContentI18n}
     */
    public ContentI18n setI18n(String key, String value) {
        if (i18n == null) {
            i18n = new java.util.HashMap<>();
        }
        i18n.put(key, value);
        return this;
    }

    /**
     * 添加国际化
     *
     * @param key   key
     * @param value value
     * @return {@link ContentI18n}
     */
    public ContentI18n addI18n(String key, String value) {
        if (i18n == null) {
            i18n = new java.util.HashMap<>();
        }
        i18n.put(key, value);
        return this;
    }

    /**
     * 添加国际化
     *
     * @param i18n 国际化
     * @return {@link ContentI18n}
     */
    public ContentI18n addI18n(Map<String, String> i18n) {
        if (this.i18n == null) {
            this.i18n = new java.util.HashMap<>(i18n.size());
        }
        this.i18n.putAll(i18n);
        return this;
    }

    @Override
    public Map<String, Object> toMessage() {
        Map<String, Object> map = new java.util.HashMap<>(3);
        map.put("tag", tag.getValue());
        map.put("content", content);
        if (i18n != null && !i18n.isEmpty()) {
            map.put("i18n_content", i18n);
        }
        return map;
    }


    /**
     * 创建一个内容国际化
     *
     * @return 内容国际化
     */
    public static ContentI18n of() {
        return new ContentI18n();
    }

    /**
     * 创建一个内容国际化
     *
     * @param content 内容
     * @return 内容国际化
     */
    public static ContentI18n of(String content) {
        return new ContentI18n(content);
    }

    /**
     * 创建一个内容国际化
     *
     * @param tag     标签
     * @param content 内容
     * @return 内容国际化
     */
    public static ContentI18n of(TextTag tag, String content) {
        return new ContentI18n(tag, content);
    }
}
