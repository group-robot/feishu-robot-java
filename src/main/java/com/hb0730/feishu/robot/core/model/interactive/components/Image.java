package com.hb0730.feishu.robot.core.model.interactive.components;

import com.hb0730.feishu.robot.core.model.IMessage;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

/**
 * 可内嵌非交互元素<br>
 * Image
 *
 * @author bing_huang
 * @date 2021/12/16
 */
@Getter
@Setter
@Builder
public class Image implements IMessage {
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
}
