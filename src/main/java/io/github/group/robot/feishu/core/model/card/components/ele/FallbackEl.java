package io.github.group.robot.feishu.core.model.card.components.ele;

import io.github.group.robot.feishu.core.constants.TextTag;
import io.github.group.robot.feishu.core.model.IMessage;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

/**
 * 设置输入框组件的降级文案
 *
 * @author <a href="mailto:huangbing0730@gmail">hb0730</a>
 * @date 2024/8/7
 */
@Getter
@Setter
public class FallbackEl implements IMessage {
    private final String tag = "fallback_text";
    /**
     * 自定义降级文案的具体内容。
     */
    private String content;

    public FallbackEl() {
    }

    public FallbackEl(String content) {
        this.content = content;
    }

    public FallbackEl setContent(String content) {
        this.content = content;
        return this;
    }

    @Override
    public Map<String, Object> toMessage() {
        Map<String, Object> message = new HashMap<>(2);
        if (null != content) {
            Map<String, Object> contentMap = new HashMap<>(2);
            contentMap.put("content", content);
            contentMap.put("tag", TextTag.PLAIN_TEXT.getValue());

            message.put("tag", tag);
            message.put("text", contentMap);
        }
        return message;
    }

    public static FallbackEl of() {
        return new FallbackEl();
    }

    public static FallbackEl of(String content) {
        return new FallbackEl(content);
    }
}
