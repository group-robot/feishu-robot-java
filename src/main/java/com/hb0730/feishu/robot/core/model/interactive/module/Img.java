package com.hb0730.feishu.robot.core.model.interactive.module;

import com.hb0730.feishu.robot.core.Tag;
import com.hb0730.feishu.robot.core.constants.ImgMode;
import com.hb0730.feishu.robot.core.model.IMessage;
import com.hb0730.feishu.robot.core.model.interactive.components.Text;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

/**
 * 图片模块
 *
 * @author bing_huang
 * @date 2021/12/16
 */
@Getter
@Setter
@Builder
public class Img extends AbstractModule {
    private final String tag = "img";
    /**
     * 图片资源
     */
    private String imgKey;
    /**
     * hover图片时弹出的Tips文案
     */
    private Text alt;
    /**
     * 图片标题
     */
    private Text title;
    /**
     * 自定义图片的最大展示宽度。
     */
    private Integer customWidth;
    /**
     * 是否展示为紧凑型的图片。
     */
    private Boolean compactWidth;
    /**
     * 图片显示模式。
     */
    private ImgMode mode;
    /**
     * 点击后是否放大图片
     */
    private Boolean preview;

    @Override
    public String tag() {
        return tag;
    }

    @Override
    public Map<String, Object> toMessage() {
        Map<String, Object> message = new HashMap<>(3);
        message.put("tag", tag());
        message.put("img_key", this.imgKey);
        message.put("alt", this.alt.toMessage());
        if (null != this.title) {
            message.put("title", this.title.toMessage());
        }
        message.put("custom_width", this.compactWidth);
        message.put("compact_width", this.compactWidth);
        if (null != this.mode) {
            message.put("mod", this.mode.getValue());
        }
        if (null != this.preview) {
            message.put("preview", this.preview);
        }
        return message;
    }
}
