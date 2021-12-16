package com.hb0730.feishu.robot.core.model.interactive.components;

import com.hb0730.feishu.robot.core.model.IMessage;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

/**
 * 可内嵌非交互元素<br>
 * Field
 *
 * @author bing_huang
 * @date 2021/12/16
 */
@Getter
@Setter
@Builder
public class Field implements IMessage {
    /**
     * 是否并排布局
     */
    private boolean isShort;
    /**
     * 国际化文本内容
     */
    private Text text;

    @Override
    public Map<String, Object> toMessage() {
        Map<String, Object> message = new HashMap<>(2);
        message.put("is_short", this.isShort);
        message.put("text", this.text.toMessage());
        return message;
    }
}
