package com.hb0730.feishu.robot.core.model.interactive.module;

import com.hb0730.feishu.robot.core.model.interactive.components.action.ele.Url;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

/**
 * Markdown模块
 *
 * @author bing_huang
 * @date 2021/12/16
 */
@Getter
@Setter
@Builder
public class MarkdownModule extends AbstractModule{
    private final String tag = "markdown";
    /**
     * 使用已支持的markdown语法构造markdown内容
     */
    private String content;
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
        message.put("content", content);
        if (null != this.href) {
            message.put("href", this.href.toMessage());
        }
        return message;
    }
}
