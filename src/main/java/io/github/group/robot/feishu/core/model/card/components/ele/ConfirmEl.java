package io.github.group.robot.feishu.core.model.card.components.ele;

import io.github.group.robot.feishu.core.constants.TextTag;
import io.github.group.robot.feishu.core.model.IMessage;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

/**
 * 二次确认弹窗配置
 *
 * @author <a href="mailto:huangbing0730@gmail">hb0730</a>
 * @date 2024/8/7
 */
@Getter
@Setter
public class ConfirmEl implements IMessage {
    /**
     * 二次确认弹窗标题的内容。
     */
    private String title;
    /**
     * 国际化配置
     */
    private Map<String, String> titleI18n;
    /**
     * 二次确认弹窗文本的具体内容。
     */
    private String content;
    /**
     * 国际化配置
     */
    private Map<String, String> contentI18n;

    public ConfirmEl() {
    }

    public ConfirmEl(String title, String content) {
        this.title = title;
        this.content = content;
    }

    /**
     * 设置二次确认弹窗标题的内容
     *
     * @param title 二次确认弹窗标题的内容
     * @return 二次确认弹窗配置
     */
    public ConfirmEl setTitle(String title) {
        this.title = title;
        return this;
    }

    /**
     * 设置二次确认弹窗文本的具体内容
     *
     * @param content 二次确认弹窗文本的具体内容
     * @return 二次确认弹窗配置
     */
    public ConfirmEl setContent(String content) {
        this.content = content;
        return this;
    }

    /**
     * 设置国际化配置
     *
     * @param titleI18n 国际化配置
     * @return 二次确认弹窗配置
     */
    public ConfirmEl setTitleI18n(Map<String, String> titleI18n) {
        this.titleI18n = titleI18n;
        return this;
    }

    /**
     * 设置国际化配置
     *
     * @param key   key
     * @param value value
     * @return 二次确认弹窗配置
     */
    public ConfirmEl setTitleI18n(String key, String value) {
        if (titleI18n == null) {
            titleI18n = new HashMap<>();
        }
        titleI18n.put(key, value);
        return this;
    }

    /**
     * 设置国际化配置
     *
     * @param contentI18n 国际化配置
     * @return 二次确认弹窗配置
     */
    public ConfirmEl setContentI18n(Map<String, String> contentI18n) {
        this.contentI18n = contentI18n;
        return this;
    }

    /**
     * 设置国际化配置
     *
     * @param key   key
     * @param value value
     * @return 二次确认弹窗配置
     */
    public ConfirmEl setContentI18n(String key, String value) {
        if (contentI18n == null) {
            contentI18n = new HashMap<>();
        }
        contentI18n.put(key, value);
        return this;
    }


    @Override
    public Map<String, Object> toMessage() {
        Map<String, Object> map = new HashMap<>(2);
        if (title != null) {
            Map<String, Object> titleMap = new HashMap<>(2);
            titleMap.put("tag", TextTag.PLAIN_TEXT.getValue());
            titleMap.put("content", title);
            if (titleI18n != null && !titleI18n.isEmpty()) {
                titleMap.put("i18n_content", titleI18n);
            }
            map.put("title", titleMap);
        }
        if (content != null) {
            Map<String, Object> contentMap = new HashMap<>(2);
            contentMap.put("tag", TextTag.PLAIN_TEXT.getValue());
            contentMap.put("content", content);
            if (contentI18n != null && !contentI18n.isEmpty()) {
                contentMap.put("i18n_content", contentI18n);
            }
            map.put("text", contentMap);
        }

        return map;
    }

    /**
     * 创建一个二次确认弹窗配置
     *
     * @return 二次确认弹窗配置
     */
    public static ConfirmEl of() {
        return new ConfirmEl();
    }

    /**
     * 创建一个二次确认弹窗配置
     *
     * @param title   二次确认弹窗标题的内容
     * @param content 二次确认弹窗文本的具体内容
     * @return 二次确认弹窗配置
     */
    public static ConfirmEl of(String title, String content) {
        return new ConfirmEl(title, content);
    }
}
