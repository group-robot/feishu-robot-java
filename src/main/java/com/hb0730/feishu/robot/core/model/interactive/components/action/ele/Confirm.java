package com.hb0730.feishu.robot.core.model.interactive.components.action.ele;

import com.hb0730.feishu.robot.core.constants.TextTag;
import com.hb0730.feishu.robot.core.model.IMessage;
import com.hb0730.feishu.robot.core.model.interactive.components.Text;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

/**
 * 可内嵌交互元素<br>
 * url
 *
 * @author bing_huang
 * @date 2021/12/16
 */
@Getter
@Setter
@Builder
public class Confirm implements IMessage {
    /**
     * 弹框标题
     */
    private Text title;
    /**
     * 弹框内容
     */
    private Text text;

    @Override
    public Map<String, Object> toMessage() {
        Map<String, Object> message = new HashMap<>(2);
        this.title.setTag(TextTag.PLAIN_TEXT);
        this.text.setTag(TextTag.PLAIN_TEXT);
        message.put("title", this.title.toMessage());
        message.put("text", this.text.toMessage());
        return message;
    }
}
