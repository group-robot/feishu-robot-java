package io.github.group.robot.feishu.core.model.card.components.content;

import io.github.group.robot.feishu.core.constants.TextTag;
import io.github.group.robot.feishu.core.model.card.components.CardTag;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

/**
 * 卡片-展示-副标题信息
 *
 * @author <a href="mailto:huangbing0730@gmail">hb0730</a>
 * @date 2024/7/26
 */
@Getter
@Setter
public class SubTitle implements CardTag {
    private final String tag = TextTag.PLAIN_TEXT.getValue();
    /**
     * 内容
     */
    private String content;
    /**
     * 国际化
     */
    private Map<String, String> i18n;

    public SubTitle() {
    }

    public SubTitle(String content) {
        this.content = content;
    }

    /**
     * 设置内容
     *
     * @param content 内容
     * @return this
     */
    public SubTitle setContent(String content) {
        this.content = content;
        return this;
    }

    /**
     * 添加国际化
     *
     * @param i18n 语言
     * @return this
     */
    public SubTitle setI18n(Map<String, String> i18n) {
        this.i18n = i18n;
        return this;
    }

    /**
     * 添加国际化
     *
     * @param lang    语言
     * @param content 内容
     * @return this
     */
    public SubTitle addI18n(String lang, String content) {
        if (this.i18n == null) {
            this.i18n = new HashMap<>();
        }
        this.i18n.put(lang, content);
        return this;
    }

    /**
     * 添加国际化
     *
     * @param i18n 语言
     * @return this
     */
    public SubTitle addI18n(Map<String, String> i18n) {
        if (this.i18n == null) {
            this.i18n = new HashMap<>();
        }
        this.i18n.putAll(i18n);
        return this;
    }

    @Override
    public Map<String, Object> toMessage() {
        Map<String, Object> message = new HashMap<>();
        if (content != null) {
            message.put("content", this.content);
        }
        if (i18n != null) {
            message.put("i18n_content", this.i18n);
        }
        message.put("tag", tag);
        return message;
    }

    /**
     * 构建者
     */
    public static SubTitle of(String content) {
        return new SubTitle(content);
    }

    /**
     * 构建者
     */
    public static SubTitle of() {
        return new SubTitle();
    }
}
