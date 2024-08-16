package io.github.group.robot.feishu.core.model.card.components.content;

import io.github.group.robot.feishu.core.constants.ImgSize;
import io.github.group.robot.feishu.core.constants.ScaleType;
import io.github.group.robot.feishu.core.constants.TextTag;
import io.github.group.robot.feishu.core.model.Builder;
import io.github.group.robot.feishu.core.model.card.components.CardTag;
import io.github.group.robot.feishu.core.model.card.components.ele.ContentI18n;
import io.github.group.robot.feishu.core.model.card.components.ele.ImageEl;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

/**
 * 卡片-展示-图片
 *
 * @author <a href="mailto:huangbing0730@gmail">hb0730</a>
 * @date 2024/7/30
 */
@Getter
@Setter
public class Img implements CardTag {
    private final String tag = "img";
    /**
     * 图片信息
     */
    private ImageEl img;
    /**
     * 图片标题。示例值：
     */
    private ContentI18n title;
    /**
     * 图片的圆角半径，单位是像素（px）。取值遵循以下格式：
     * <p>
     * [0,∞]px <br>
     * [0,100]% <br>
     */
    private String cornerRadius;
    /**
     * 图片的缩放模式
     */
    private ScaleType scaleType;
    /**
     * 图片尺寸
     *
     * @see io.github.group.robot.feishu.core.constants.ImgSize
     */
    private String size;
    /**
     * 是否透明
     */
    private Boolean transparent;
    /**
     * 点击后是否放大图片
     */
    private Boolean preview;

    @Override
    public Map<String, Object> toMessage() {
        Map<String, Object> message = img.toMessage();
        if (title != null) {
            Map<String, Object> titleMsg = title.toMessage();
            titleMsg.put("tag", TextTag.PLAIN_TEXT.getValue());
            message.put("title", titleMsg);
        }
        if (cornerRadius != null) {
            message.put("corner_radius", cornerRadius);
        }
        if (scaleType != null) {
            message.put("scale_type", scaleType.getValue());
        }

        if (size != null) {
            message.put("size", size);
        }

        if (transparent != null) {
            message.put("transparent", transparent);
        }

        if (preview != null) {
            message.put("preview", preview);
        }
        message.put("tag", tag);
        return message;
    }

    public static ImgBuilder builder() {
        return new ImgBuilder();
    }

    /**
     * {@link Img} 构造器
     */
    public static class ImgBuilder implements Builder<Img> {
        private final Img img = new Img();

        private ImgBuilder() {
        }


        /**
         * 添加图片信息
         *
         * @param img 图片信息
         * @return .
         */
        public ImgBuilder setImg(ImageEl img) {
            this.img.setImg(img);
            return this;
        }

        /**
         * 图片标题
         *
         * @param title 图片标题
         * @return .
         */
        public ImgBuilder setTile(ContentI18n title) {
            img.setTitle(title);
            return this;
        }

        /**
         * 添加图片的圆角半径
         *
         * @param cornerRadius 图片的圆角半径
         * @return .
         */
        public ImgBuilder setCornerRadius(String cornerRadius) {
            img.setCornerRadius(cornerRadius);
            return this;
        }

        /**
         * 添加图片的缩放模式
         *
         * @param scaleType 图片的缩放模式
         * @return .
         */
        public ImgBuilder setCaleType(ScaleType scaleType) {
            img.setScaleType(scaleType);
            return this;
        }

        /**
         * 添加图片尺寸
         *
         * @param size 图片尺寸
         * @return .
         */
        public ImgBuilder setSize(String size) {
            img.setSize(size);
            return this;
        }

        /**
         * 添加图片尺寸
         *
         * @param size 图片尺寸
         * @return .
         */
        public ImgBuilder setSize(ImgSize size) {
            img.setSize(size.getValue());
            return this;
        }

        /**
         * 添加是否透明
         *
         * @param transparent 是否透明
         * @return .
         */
        public ImgBuilder setTransparent(Boolean transparent) {
            img.setTransparent(transparent);
            return this;
        }

        /**
         * 添加点击后是否放大图片
         *
         * @param preview 点击后是否放大图片
         * @return .
         */
        public ImgBuilder setPreview(Boolean preview) {
            img.setPreview(preview);
            return this;
        }

        @Override
        public Img build() {
            return img;
        }
    }
}
