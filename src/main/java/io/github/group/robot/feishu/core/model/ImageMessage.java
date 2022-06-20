package io.github.group.robot.feishu.core.model;

import io.github.group.robot.feishu.core.constants.MessageType;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

/**
 * 图片
 *
 * @author bing_huang
 * @date 2021/12/16
 */
@Getter
@Setter
@Builder
public class ImageMessage extends BaseMessage {
    /**
     * 图片的唯一标识
     */
    private String imageKey;

    @Override
    protected void init() {
        msgType = MessageType.IMAGE;
    }

    @Override
    public Map<String, Object> toMessage() {
        Map<String, Object> imageMap = new HashMap<>(1);
        imageMap.put("image_key", this.imageKey);
        Map<String, Object> message = new HashMap<>(2);
        message.put("msg_type", this.msgType.getValue());
        message.put("content", imageMap);
        return message;
    }
}
