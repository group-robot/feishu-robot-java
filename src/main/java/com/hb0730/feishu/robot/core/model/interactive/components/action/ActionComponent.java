package com.hb0730.feishu.robot.core.model.interactive.components.action;

import com.hb0730.feishu.robot.core.Tag;
import com.hb0730.feishu.robot.core.model.IMessage;

/**
 * 交互式组件
 *
 * @author bing_huang
 * @date 2021/12/16
 */
public abstract class ActionComponent implements IMessage, Tag {
    /**
     * get tag
     *
     * @return tag
     */
    @Override
    public abstract String tag();
}
