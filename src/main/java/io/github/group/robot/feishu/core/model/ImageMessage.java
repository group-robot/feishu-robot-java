package io.github.group.robot.feishu.core.model;

import io.github.group.robot.feishu.core.constants.MessageType;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

/**
 * 图片 <a href="https://open.feishu.cn/document/client-docs/bot-v3/add-custom-bot#132a114c">发送图片</a>
 *
 * @author <a href="mailto:huangbing0730@gmail">hb0730</a>
 * @date 2021/12/16
 */
@Getter
@Setter
public class ImageMessage extends BaseMessage {
    public ImageMessage() {
        super();
    }

    public ImageMessage(String imageKey) {
        super();
        this.imageKey = imageKey;
    }

    /**
     * 图片的唯一标识
     */
    private String imageKey;

    @Override
    protected void init() {
        msgType = MessageType.IMAGE;
    }

    /**
     * 图片的唯一标识
     *
     * @param imageKey 图片的唯一标识
     * @return .
     */
    public ImageMessage setImageKey(String imageKey) {
        this.imageKey = imageKey;
        return this;
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

    /**
     * 图片
     *
     * @param imageKey 图片的唯一标识
     * @return .
     */
    public static ImageMessage of(String imageKey) {
        return new ImageMessage(imageKey);
    }

    /**
     * 图片
     *
     * @return .
     */
    public static ImageMessage of() {
        return new ImageMessage();
    }
}
