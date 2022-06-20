package io.github.group.robot.feishu.core.model.interactive.components.action.ele;

import io.github.group.robot.feishu.core.constants.TextTag;
import io.github.group.robot.feishu.core.model.IMessage;
import io.github.group.robot.feishu.core.model.interactive.components.Text;
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
     * 弹框标题,仅支持"plain_text"
     */
    private Text title;
    /**
     * 弹框内容,仅支持"plain_text"
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
