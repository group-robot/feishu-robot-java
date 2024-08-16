package io.github.group.robot.feishu.core.model.post.tags;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

/**
 * img 标签
 *
 * @author <a href="mailto:huangbing0730@gmail">hb0730</a>
 * @date 2024/8/16
 */
@Getter
@Setter
public class ImgTag implements PostTag {
    private final String tag = "img";
    /**
     * 图片 URL
     */
    private String imageKey;

    /**
     * @param imageKey 图片 URL
     */
    public ImgTag(String imageKey) {
        this.imageKey = imageKey;
    }

    public ImgTag() {
    }

    /**
     * 设置图片 URL
     *
     * @param imageKey 图片 URL
     * @return {@link ImgTag}
     */
    public ImgTag setImageKey(String imageKey) {
        this.imageKey = imageKey;
        return this;
    }

    @Override
    public String getTag() {
        return tag;
    }

    @Override
    public Map<String, Object> toMessage() {
        Map<String, Object> message = new HashMap<>(2);
        message.put("tag", tag);
        message.put("image_key", imageKey);
        return message;
    }

    /**
     * 创建 img 标签
     *
     * @param imageKey 图片 URL
     * @return {@link ImgTag}
     */
    public static ImgTag of(String imageKey) {
        return new ImgTag(imageKey);
    }

    /**
     * 创建 img 标签
     *
     * @return {@link ImgTag}
     */
    public static ImgTag of() {
        return new ImgTag();
    }
}
