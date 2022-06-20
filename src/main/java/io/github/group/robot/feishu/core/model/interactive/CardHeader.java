package io.github.group.robot.feishu.core.model.interactive;

import io.github.group.robot.feishu.core.model.IMessage;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

/**
 * card 头
 *
 * @author bing_huang
 * @date 2021/12/16
 */
@Getter
@Setter
@Builder
public class CardHeader implements IMessage {
    /**
     * title
     */
    private CardTitle title;
    /**
     * 主题色
     */
    private String template;

    @Override
    public Map<String, Object> toMessage() {
        Map<String, Object> message = new HashMap<>();
        message.put("title", this.title.toMessage());
        message.put("template", this.template);
        return message;
    }
}
