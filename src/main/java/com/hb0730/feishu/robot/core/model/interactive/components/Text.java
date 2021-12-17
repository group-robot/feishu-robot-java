package com.hb0730.feishu.robot.core.model.interactive.components;

import com.hb0730.feishu.robot.core.model.Tag;
import com.hb0730.feishu.robot.core.constants.TextTag;
import com.hb0730.feishu.robot.core.model.IMessage;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

/**
 * 可内嵌非交互元素<br>
 * text
 *
 * @author bing_huang
 * @date 2021/12/16
 */
@Getter
@Setter
@Builder
public class Text implements IMessage, Tag {
    /**
     * 元素标签
     */
    private TextTag tag;
    /**
     * 文本内容
     */
    private String content;
    /**
     * 内容显示行数
     */
    private Integer lines;

    @Override
    public Map<String, Object> toMessage() {
        Map<String, Object> message = new HashMap<>();
        message.put("tag", this.tag.getValue());
        message.put("content", this.content);
        message.put("lines", this.lines);
        return message;
    }

    @Override
    public String tag() {
        return this.tag.getValue();
    }
}
