package com.hb0730.feishu.robot.core.model;

import com.hb0730.feishu.robot.core.constants.MessageType;

import java.util.Map;

/**
 * 卡片
 *
 * @author bing_huang
 * @date 2021/12/16
 */
public class InteractiveMessage extends BaseMessage {
    @Override
    protected void init() {
        msgType = MessageType.INTERACTIVE;
    }

    @Override
    public Map<String, Object> toMessage() {
        return null;
    }
}
