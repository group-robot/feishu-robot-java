package io.github.group.robot.feishu.core.model.post.tag;

import io.github.group.robot.feishu.core.model.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

/**
 * 富文本 图片标签：img
 *
 * @author <a href="mailto:huangbing0730@gmail">hb0730</a>
 * @date 2021/12/16
 */
@Getter
@Setter
public class ImgTag extends PostTag {
    /**
     * 图片的唯一标识
     */
    private String imageKey;
    /**
     * 图片的高
     */
    @Deprecated
    private Integer height;
    /**
     * 图片的宽
     */
    @Deprecated
    private Integer width;


    @Override
    public String tag() {
        return "img";
    }

    @Override
    public Map<String, Object> toMessage() {
        Map<String, Object> imgMap = new HashMap<>(4);
        imgMap.put("tag", tag());
        imgMap.put("image_key", this.imageKey);
        if (this.height != null) {
            imgMap.put("height", this.height);
        }
        if (this.width != null) {
            imgMap.put("width", this.width);
        }
        return imgMap;
    }

    /**
     * 构建器
     *
     * @return .
     */
    public static ImgTagBuilder builder() {
        return ImgTagBuilder.builder();
    }

    /**
     * {@link  ImgTag} 构建器
     */
    public static class ImgTagBuilder implements Builder<ImgTag> {
        private final ImgTag imgTag;

        private ImgTagBuilder() {
            this.imgTag = new ImgTag();
        }

        /**
         * create {@link  ImgTagBuilder}
         *
         * @return .
         */
        public static ImgTagBuilder builder() {
            return new ImgTagBuilder();
        }

        /**
         * 图片的唯一标识
         *
         * @param imageKey .
         * @return .
         */
        public ImgTagBuilder imageKey(String imageKey) {
            this.imgTag.setImageKey(imageKey);
            return this;
        }

        /**
         * 图片的高
         *
         * @param height .
         * @return .
         */
        public ImgTagBuilder height(Integer height) {
            this.imgTag.setHeight(height);
            return this;
        }

        /**
         * 图片的宽
         *
         * @param width .
         * @return .
         */
        public ImgTagBuilder width(Integer width) {
            this.imgTag.setWidth(width);
            return this;
        }

        @Override
        public ImgTag build() {
            return this.imgTag;
        }
    }
}
