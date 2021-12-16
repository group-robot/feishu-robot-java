package com.hb0730.feishu.robot.core.model;

import com.hb0730.feishu.robot.core.constants.MessageType;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

/**
 * 文本消息
 *
 * @author bing_huang
 * @date 2021/12/16
 */
@Getter
@Setter
@Builder
public class TextMessage extends BaseMessage {
    /**
     * 内容
     */
    private String content;
    /**
     * 是否at所有
     */
    private Boolean atAll;

    @Override
    protected void init() {
        this.msgType = MessageType.TEXT;
    }

    @Override
    public Map<String, Object> toMessage() {
        Map<String, Object> contentMap = new HashMap<>(1);
        if (this.atAll) {
            contentMap.put("text", "<at user_id=\"all\">所有</at> " + this.content);
        } else {
            contentMap.put("text", this.content);
        }
        Map<String, Object> textMap = new HashMap<>(2);
        textMap.put("msg_type", this.msgType.getValue());
        textMap.put("content", contentMap);
        return textMap;
    }
}
