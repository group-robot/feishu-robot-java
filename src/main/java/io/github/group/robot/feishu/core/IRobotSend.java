package io.github.group.robot.feishu.core;

import io.github.group.robot.feishu.core.model.BaseMessage;

/**
 * 发送消息
 *
 * @author bing_huang
 * @date 2021/12/16
 */
public interface IRobotSend {
    /**
     * 发送消息
     *
     * @param message 消息
     * @return 响应
     */
    Response send(BaseMessage message);
}
