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
     * create {@link  ImageMessageBuilder}
     *
     * @return {@link  ImageMessageBuilder}
     */
    public static ImageMessageBuilder builder() {
        return new ImageMessageBuilder();
    }

    /**
     * {@link ImageMessage} builder static inner class
     */
    public static class ImageMessageBuilder implements Builder<ImageMessage> {
        private final ImageMessage imageMessage;

        private ImageMessageBuilder() {
            this.imageMessage = new ImageMessage();
        }

        /**
         * create {@link ImageMessageBuilder}
         *
         * @return this
         */
        public static ImageMessageBuilder builder() {
            return new ImageMessageBuilder();
        }

        /**
         * 图片的唯一标识，可以通过上传图片 API 获取。
         *
         * @param imageKey .
         * @return this
         */
        public ImageMessageBuilder imageKey(String imageKey) {
            this.imageMessage.setImageKey(imageKey);
            return this;
        }


        @Override
        public ImageMessage build() {
            return this.imageMessage;
        }
    }
}
