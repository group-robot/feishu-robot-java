package io.github.group.robot.feishu.core.model.interactive.components.action;

import io.github.group.robot.feishu.core.model.Tag;
import io.github.group.robot.feishu.core.model.IMessage;

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
