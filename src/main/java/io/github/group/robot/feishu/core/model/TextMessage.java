package io.github.group.robot.feishu.core.model;

import io.github.group.robot.feishu.core.constants.MessageType;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * 文本消息 <a href="https://open.feishu.cn/document/client-docs/bot-v3/add-custom-bot#756b882f">发送文本消息</a>
 *
 * @author <a href="mailto:huangbing0730@gmail">hb0730</a>
 * @date 2021/12/16
 */
@Getter
public class TextMessage extends BaseMessage {
    public TextMessage() {
        super();
    }

    public TextMessage(String content) {
        super();
        this.content = content;
    }

    /**
     * 内容
     */
    private String content;


    /**
     * 设置内容
     *
     * @param content 内容
     * @return this
     */
    public TextMessage setContent(String content) {
        this.content = content;
        return this;
    }

    /**
     * 是否at所有
     */
    private Boolean atAll;

    /**
     * 设置at所有
     *
     * @param atAll 是否at所有
     * @return this
     */
    public TextMessage setAtAll(Boolean atAll) {
        this.atAll = atAll;
        return this;
    }

    /**
     * at所有
     *
     * @return this
     */
    public TextMessage atAll() {
        this.atAll = true;
        return this;
    }

    @Override
    protected void init() {
        this.msgType = MessageType.TEXT;
    }

    @Override
    public Map<String, Object> toMessage() {
        Map<String, Object> contentMap = new HashMap<>(1);
        if (Boolean.TRUE.equals(this.atAll)) {
            contentMap.put("text", "<at user_id=\"all\">所有</at> " + this.content);
        } else {
            contentMap.put("text", this.content);
        }
        Map<String, Object> textMap = new HashMap<>(2);
        textMap.put("msg_type", this.msgType.getValue());
        textMap.put("content", contentMap);
        return textMap;
    }


    /**
     * 创建一个文本消息
     *
     * @param content 内容
     * @return 文本消息
     */
    public static TextMessage of(String content) {
        return new TextMessage(content);
    }

    /**
     * 创建一个文本消息
     *
     * @param content 内容
     * @param atAll   是否at所有
     * @return 文本消息
     */
    public static TextMessage of(String content, Boolean atAll) {
        return new TextMessage(content)
                .setAtAll(atAll);
    }

    /**
     * 创建一个空的文本消息
     *
     * @return 文本消息
     */
    public static TextMessage of() {
        return new TextMessage();
    }
}
