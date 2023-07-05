package io.github.group.robot.feishu.core.model.interactive.components;

import io.github.group.robot.feishu.core.model.Builder;
import io.github.group.robot.feishu.core.model.IMessage;
import io.github.group.robot.feishu.core.model.Tag;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

/**
 * 卡片 >可内嵌非交互元素 > Image
 *
 * @author <a href="mailto:huangbing0730@gmail">hb0730</a>
 * @date 2021/12/16
 */
@Getter
@Setter
public class Image implements IMessage, Tag {
    private final String tag = "img";
    /**
     * 图片资源
     */
    private String imgKey;
    /**
     * 图片hover说明
     */
    private Text alt;
    /**
     * 点击后是否放大图片
     */
    private Boolean preview = true;

    @Override
    public Map<String, Object> toMessage() {
        Map<String, Object> message = new HashMap<>(4);
        message.put("tag", this.tag);
        message.put("img_key", this.imgKey);
        message.put("alt", this.alt.toMessage());
        message.put("preview", this.preview);
        return message;
    }

    @Override
    public String tag() {
        return this.tag;
    }

    /**
     * 构造器
     *
     * @return .
     */
    public static ImageBuilder builder() {
        return new ImageBuilder();
    }

    /**
     * {@link Image} 构造器
     */
    public static class ImageBuilder implements Builder<Image> {
        private final Image image;

        private ImageBuilder() {
            this.image = new Image();
        }

        /**
         * create builder
         *
         * @return .
         */
        public static ImageBuilder builder() {
            return new ImageBuilder();
        }

        /**
         * 图片资源
         *
         * @param imgKey .
         * @return .
         */
        public ImageBuilder imgKey(String imgKey) {
            this.image.setImgKey(imgKey);
            return this;
        }

        /**
         * 图片hover说明
         *
         * @param alt .
         * @return .
         */
        public ImageBuilder alt(Text alt) {
            this.image.setAlt(alt);
            return this;
        }

        /**
         * 点击后是否放大图片,默认true
         *
         * @param preview .
         * @return .
         */
        public ImageBuilder preview(Boolean preview) {
            this.image.setPreview(preview);
            return this;
        }

        @Override
        public Image build() {
            return this.image;
        }
    }

}
