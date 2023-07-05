package io.github.group.robot.feishu.core.model.interactive.components.action.ele;

import io.github.group.robot.feishu.core.constants.TextTag;
import io.github.group.robot.feishu.core.model.IMessage;
import io.github.group.robot.feishu.core.model.interactive.components.Text;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

/**
 * 卡片 > 可内嵌交互元素 > url
 *
 * @author <a href="mailto:huangbing0730@gmail">hb0730</a>
 * @date 2021/12/16
 */
@Getter
@Setter
public class Confirm implements IMessage {

    public static Confirm build() {
        return new Confirm();
    }

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
