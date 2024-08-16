package io.github.group.robot.feishu.core.model.card.components.content;

import io.github.group.robot.feishu.core.constants.TextTag;
import io.github.group.robot.feishu.core.model.card.components.CardTag;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

/**
 * 卡片-展示-标题
 *
 * @author <a href="mailto:huangbing0730@gmail">hb0730</a>
 * @date 2024/7/26
 */
@Getter
@Setter
public class Title implements CardTag {
    private final String tag = TextTag.PLAIN_TEXT.getValue();
    /**
     * 标题内容
     */
    private String content;
    /**
     * 国际化
     */
    private Map<String, String> i18n;

    public Title() {
    }

    public Title(String content) {
        this.content = content;
    }

    /**
     * 设置标题内容
     *
     * @param content 标题内容
     * @return this
     */
    public Title setContent(String content) {
        this.content = content;
        return this;
    }

    /**
     * 添加国际化
     *
     * @param i18n 语言
     * @return this
     */
    public Title setI18n(Map<String, String> i18n) {
        this.i18n = i18n;
        return this;
    }

    /**
     * 添加国际化
     *
     * @param key   语言
     * @param value 内容
     * @return this
     */
    public Title addI18n(String key, String value) {
        if (this.i18n == null) {
            this.i18n = new HashMap<>();
        }
        this.i18n.put(key, value);
        return this;
    }

    /**
     * 添加国际化
     *
     * @param i18n 语言
     * @return this
     */
    public Title addI18n(Map<String, String> i18n) {
        if (this.i18n == null) {
            this.i18n = new HashMap<>();
        }
        this.i18n.putAll(i18n);
        return this;
    }

    @Override
    public Map<String, Object> toMessage() {
        Map<String, Object> message = new HashMap<>();
        message.put("tag", tag);
        message.put("content", this.content);
        if (this.i18n != null) {
            message.put("i18n_content", this.i18n);
        }
        return message;
    }

    /**
     * 创建 {@link Title}
     *
     * @param content 标题内容
     * @return .
     */
    public static Title of(String content) {
        return new Title(content);
    }

    /**
     * 创建 {@link Title}
     *
     * @return .
     */
    public static Title of() {
        return new Title();
    }
}
