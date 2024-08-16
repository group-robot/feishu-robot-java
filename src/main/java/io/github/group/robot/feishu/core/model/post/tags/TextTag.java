package io.github.group.robot.feishu.core.model.post.tags;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

/**
 * 文本标签
 *
 * @author <a href="mailto:huangbing0730@gmail">hb0730</a>
 * @date 2024/8/16
 */
@Getter
@Setter
public class TextTag implements PostTag {
    private final String tag = "text";
    /**
     * 文本内容
     */
    private String text;
    /**
     * 表示是否 unescape 解码。默认值为 false，未用到 unescape 时可以不填。
     */
    private Boolean unEscape;
    /**
     * 表示是否换行。默认值为 false，未用到 enter 时可以不填。
     */
    private Boolean enter;

    public TextTag(String text) {
        this.text = text;
    }

    public TextTag(String text, Boolean unEscape) {
        this.text = text;
        this.unEscape = unEscape;
    }

    public TextTag() {
    }

    /**
     * 设置文本内容
     *
     * @param text 文本内容
     * @return {@link TextTag}
     */
    public TextTag setText(String text) {
        this.text = text;
        return this;
    }

    /**
     * 设置是否 unescape 解码
     *
     * @param unEscape 是否 unescape 解码
     * @return {@link TextTag}
     */
    public TextTag setUnEscape(Boolean unEscape) {
        this.unEscape = unEscape;
        return this;
    }

    /**
     * 设置是否换行
     *
     * @param enter 是否换行
     * @return {@link TextTag}
     */
    public TextTag setEnter(Boolean enter) {
        this.enter = enter;
        return this;
    }

    /**
     * 设置是否换行
     *
     * @return {@link TextTag}
     */
    public TextTag enter() {
        this.enter = true;
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
        String _text = text;
        if (null != enter && enter) {
            _text = text + "\n";
        }
        message.put("text", _text);
        if (null != unEscape) {
            message.put("un_escape", unEscape);
        }
        return message;
    }

    /**
     * 创建文本标签
     *
     * @param text 文本内容
     * @return {@link TextTag}
     */
    public static TextTag of(String text) {
        return new TextTag(text);
    }

    /**
     * 创建文本标签
     *
     * @param text     文本内容
     * @param unEscape 是否 unescape 解码
     * @return {@link TextTag}
     */
    public static TextTag of(String text, Boolean unEscape) {
        return new TextTag(text, unEscape);
    }

    /**
     * 创建文本标签
     *
     * @return {@link TextTag}
     */
    public static TextTag of() {
        return new TextTag();
    }
}
