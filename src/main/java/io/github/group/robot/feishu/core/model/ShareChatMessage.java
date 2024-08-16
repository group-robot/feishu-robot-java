package io.github.group.robot.feishu.core.model;

import io.github.group.robot.feishu.core.constants.MessageType;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

/**
 * 发送群名片
 *
 * @author <a href="mailto:huangbing0730@gmail">hb0730</a>
 * @date 2024/8/16
 */
@Getter
@Setter
public class ShareChatMessage extends BaseMessage {
    /**
     * 群名片的 chat_id
     */
    private String shareChatId;

    public ShareChatMessage() {
        super();
    }

    /**
     * 群名片的 chat_id
     *
     * @param shareChatId 群名片的 chat_id
     */
    public ShareChatMessage(String shareChatId) {
        super();
        this.shareChatId = shareChatId;
    }


    /**
     * 群名片的 chat_id
     *
     * @param shareChatId 群名片的 chat_id
     * @return .
     */
    public ShareChatMessage setShareChatId(String shareChatId) {
        this.shareChatId = shareChatId;
        return this;
    }

    @Override
    protected void init() {
        this.msgType = MessageType.SHARE_CHAT;
    }

    @Override
    public Map<String, Object> toMessage() {
        Map<String, Object> message = new HashMap<>(2);
        message.put("msg_type", this.msgType.getValue());
        Map<String, Object> content = new HashMap<>(1);
        content.put("share_chat_id", this.shareChatId);
        message.put("content", content);
        return message;
    }

    /**
     * 创建发送群名片
     *
     * @return {@link ShareChatMessage}
     */
    public static ShareChatMessage of() {
        return new ShareChatMessage();
    }

    /**
     * 创建发送群名片
     *
     * @param shareChatId 群名片的 chat_id
     * @return {@link ShareChatMessage}
     */
    public static ShareChatMessage of(String shareChatId) {
        return new ShareChatMessage(shareChatId);
    }
}
