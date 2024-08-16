package io.github.group.robot.feishu.core.model.card.components.content;

import io.github.group.robot.feishu.core.constants.TextAlign;
import io.github.group.robot.feishu.core.constants.TextSize;
import io.github.group.robot.feishu.core.model.Builder;
import io.github.group.robot.feishu.core.model.card.components.CardTag;
import io.github.group.robot.feishu.core.model.card.components.ele.IconEl;
import io.github.group.robot.feishu.core.model.card.components.ele.UrlEl;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

/**
 * 卡片-展示-富文本
 *
 * @author <a href="mailto:huangbing0730@gmail">hb0730</a>
 * @date 2024/7/30
 */
@Getter
@Setter
public class Markdown implements CardTag {
    private final String tag = "markdown";
    /**
     * 设置文本内容的对齐方式
     */
    private TextAlign textAlign;
    /**
     * 文本大小
     *
     * @see io.github.group.robot.feishu.core.constants.TextSize
     */
    private String textSize;
    /**
     * 添加图标作为文本前缀图标
     */
    private IconEl icon;
    /**
     * 配置差异化跳转链接
     */
    private UrlEl href;
    /**
     * Markdown 文本内容
     */
    private String content;
    /**
     * 国际化
     */
    private Map<String, String> i18n;
    /**
     * 是否换行
     */
    private boolean enter;

    @Override
    public Map<String, Object> toMessage() {
        Map<String, Object> message = new java.util.HashMap<>(5);
        message.put("tag", tag);
        if (textAlign != null) {
            message.put("text_align", textAlign.getValue());
        }
        if (textSize != null) {
            message.put("text_size", textSize);
        }
        if (icon != null) {
            message.put("icon", icon.toMessage());
        }
        if (href != null) {
            Map<String, Object> hrefMap = href.toMessage();
            Map<String, Object> urlValue = new java.util.HashMap<>(1);
            urlValue.put("urlVal", hrefMap);
            message.put("href", urlValue);
        }
        String content = this.content;
        if (enter) {
            content = content + "\n";
        }
        message.put("content", content);
        if (i18n != null) {
            message.put("i18n_content", i18n);
        }
        return message;
    }

    /**
     * 创建 {@link MarkdownBuilder}
     *
     * @return {@link MarkdownBuilder}
     */
    public static MarkdownBuilder builder() {
        return new MarkdownBuilder();
    }

    /**
     * {@link Markdown} 构造器
     */
    public static class MarkdownBuilder implements Builder<Markdown> {
        private final Markdown markdown = new Markdown();

        private MarkdownBuilder() {
        }

        /**
         * 设置文本内容的对齐方式
         *
         * @param textAlign 对齐方式
         * @return .
         */
        public MarkdownBuilder setTextAlign(TextAlign textAlign) {
            this.markdown.setTextAlign(textAlign);
            return this;
        }

        /**
         * 设置文本大小
         *
         * @param textSize 文本大小
         * @return .
         */
        public MarkdownBuilder setTextSize(String textSize) {
            this.markdown.setTextSize(textSize);
            return this;
        }

        /**
         * 设置文本大小
         *
         * @param textSize 文本大小
         * @return .
         */
        public MarkdownBuilder setTextSize(TextSize textSize) {
            this.markdown.setTextSize(textSize.getValue());
            return this;
        }

        /**
         * 添加图标作为文本前缀图标
         *
         * @param icon 图标
         * @return .
         */
        public MarkdownBuilder setIcon(IconEl icon) {
            this.markdown.setIcon(icon);
            return this;
        }

        /**
         * 配置差异化跳转链接
         *
         * @param href 链接
         * @return .
         */
        public MarkdownBuilder setHref(UrlEl href) {
            this.markdown.setHref(href);
            return this;
        }

        /**
         * 设置Markdown 文本内容
         *
         * @param content Markdown 文本内容
         * @return .
         */
        public MarkdownBuilder setContent(String content) {
            this.markdown.setContent(content);
            return this;
        }

        /**
         * 设置Markdown 文本内容
         *
         * @param content Markdown 文本内容
         * @param enter   是否换行
         * @return .
         */
        public MarkdownBuilder setContent(String content, boolean enter) {
            this.markdown.setContent(content);
            this.markdown.setEnter(enter);
            return this;
        }

        public MarkdownBuilder setI18n(Map<String, String> i18n) {

            this.markdown.setI18n(i18n);
            return this;
        }

        /**
         * 添加国际化
         *
         * @param key   key
         * @param value value
         * @return .
         */
        public MarkdownBuilder setI18n(String key, String value) {
            this.markdown.getI18n().put(key, value);
            return this;
        }

        /**
         * 添加国际化
         *
         * @param key   .
         * @param value .
         * @return .
         */
        public MarkdownBuilder addI18n(String key, String value) {
            if (this.markdown.getI18n() == null) {
                this.markdown.setI18n(new java.util.HashMap<>());
            }
            this.markdown.getI18n().put(key, value);
            return this;
        }

        /**
         * 添加国际化
         *
         * @param i18n .
         * @return .
         */
        public MarkdownBuilder addI18n(Map<String, String> i18n) {
            if (this.markdown.getI18n() == null) {
                this.markdown.setI18n(new java.util.HashMap<>());
            }
            this.markdown.getI18n().putAll(i18n);
            return this;
        }


        /**
         * 设置是否换行
         *
         * @param enter 是否换行
         * @return .
         */
        public MarkdownBuilder setEnter(boolean enter) {
            this.markdown.setEnter(enter);
            return this;
        }

        /**
         * 添加换行
         *
         * @return .
         */
        public MarkdownBuilder addEnter() {
            this.markdown.setEnter(true);
            return this;
        }

        /**
         * 移除换行
         *
         * @return .
         */
        public MarkdownBuilder removeEnter() {
            this.markdown.setEnter(false);
            return this;
        }

        @Override
        public Markdown build() {
            return this.markdown;
        }
    }

}
