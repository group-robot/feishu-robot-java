package io.github.group.robot.feishu.core.model.card.components;

import io.github.group.robot.feishu.core.model.IMessage;

/**
 * 卡片-标签
 *
 * @author <a href="mailto:huangbing0730@gmail">hb0730</a>
 * @date 2024/8/8
 */
public interface CardTag extends IMessage {
    /**
     * 获取标签
     *
     * @return 标签
     */
    String getTag();
}
