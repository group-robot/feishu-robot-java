package io.github.group.robot.feishu.core.model.interactive.components.module;

import io.github.group.robot.feishu.core.constants.TextAlign;
import io.github.group.robot.feishu.core.model.Builder;
import io.github.group.robot.feishu.core.model.interactive.components.action.ele.Url;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

/**
 * 卡片 >  Markdown模块
 *
 * @author <a href="mailto:huangbing0730@gmail">hb0730</a>
 * @date 2021/12/16
 */
@Getter
@Setter
public class MarkdownModule extends AbstractModule {
    private final String tag = "markdown";
    /**
     * 使用已支持的markdown语法构造markdown内容
     */
    private String content;
    /**
     * 设置文本内容的对齐方式,默认左对齐
     */
    private TextAlign textAlign = TextAlign.Left;
    /**
     * 差异化跳转
     */
    private Url href;

    @Override
    public String tag() {
        return tag;
    }

    @Override
    public Map<String, Object> toMessage() {
        Map<String, Object> message = new HashMap<>(2);
        message.put("tag", tag());
        if (null != this.textAlign) {
            message.put("text_align", this.textAlign.getValue());
        }
        message.put("content", content);
        if (null != this.href) {
            message.put("href", this.href.toMessage());
        }
        return message;
    }

    /**
     * 构造器
     *
     * @return .
     */
    public static MarkdownModuleBuilder builder() {
        return new MarkdownModuleBuilder();
    }

    /**
     * {@link MarkdownModule} 构造器
     */
    public static class MarkdownModuleBuilder implements Builder<MarkdownModule> {
        private final MarkdownModule markdownModule;

        private MarkdownModuleBuilder() {
            this.markdownModule = new MarkdownModule();
        }

        /**
         * 使用已支持的markdown语法构造markdown内容
         *
         * @param content .
         * @return .
         */
        public MarkdownModuleBuilder content(String content) {
            this.markdownModule.setContent(content);
            return this;
        }

        /**
         * 设置文本内容的对齐方式,默认左对齐
         *
         * @param textAlign .
         * @return .
         */
        public MarkdownModuleBuilder textAlign(TextAlign textAlign) {
            this.markdownModule.setTextAlign(textAlign);
            return this;
        }

        /**
         * 差异化跳转
         *
         * @param href .
         * @return .
         */
        public MarkdownModuleBuilder href(Url href) {
            this.markdownModule.setHref(href);
            return this;
        }

        @Override
        public MarkdownModule build() {
            return this.markdownModule;
        }

    }

}
