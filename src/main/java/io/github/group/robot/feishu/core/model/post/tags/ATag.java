package io.github.group.robot.feishu.core.model.post.tags;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

/**
 * A标签
 *
 * @author <a href="mailto:huangbing0730@gmail">hb0730</a>
 * @date 2024/8/16
 */
@Getter
@Setter
public class ATag implements PostTag {
    private final String tag = "a";
    /**
     * 超链接的文本内容。
     */
    private String text;
    /**
     * 超链接的 URL。
     */
    private String href;

    /**
     * @param text 超链接的文本内容。
     * @param href 超链接的 URL。
     */
    public ATag(String text, String href) {
        this.text = text;
        this.href = href;
    }

    public ATag() {
    }

    /**
     * 设置文本内容
     *
     * @param text 文本内容
     * @return {@link ATag}
     */
    public ATag setText(String text) {
        this.text = text;
        return this;
    }

    /**
     * 设置超链接的 URL
     *
     * @param href 超链接的 URL
     * @return {@link ATag}
     */
    public ATag setHref(String href) {
        this.href = href;
        return this;
    }

    @Override
    public String getTag() {
        return tag;
    }

    @Override
    public Map<String, Object> toMessage() {
        Map<String, Object> message = new HashMap<>(3);
        message.put("tag", tag);
        message.put("text", text);
        message.put("href", href);
        return message;
    }

    /**
     * 构建者
     *
     * @return this
     */
    public static ATag of(String text, String href) {
        return new ATag(text, href);
    }

    /**
     * 构建者
     */
    public static ATag of() {
        return new ATag();
    }

}
