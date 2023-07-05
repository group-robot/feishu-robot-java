package io.github.group.robot.feishu.core.model.interactive.components.action;

import io.github.group.robot.feishu.core.model.IMessage;
import io.github.group.robot.feishu.core.model.Tag;

/**
 * 卡片 > 交互式组件
 *
 * @author <a href="mailto:huangbing0730@gmail">hb0730</a>
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
