package io.github.group.robot.feishu.core.model;

import io.github.group.robot.feishu.core.constants.MessageType;
import lombok.Getter;
import lombok.Setter;

/**
 * 请求消息抽象
 *
 * @author bing_huang
 * @date 2021/12/16
 */
@Getter
@Setter
public abstract class BaseMessage implements IMessage {
    private static final long serialVersionUID = -6688658072214711090L;

    public BaseMessage() {
        init();
    }

    /**
     * 消息类型
     */
    protected MessageType msgType;

    /**
     * get message type
     *
     * @return message type
     */
    public MessageType getMsgType() {
        return this.msgType;
    }

    /**
     * 初始化MessageType等
     */
    protected abstract void init();
}
