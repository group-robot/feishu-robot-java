package io.github.group.robot.feishu.core.model.card.components.behaviors;

import io.github.group.robot.feishu.core.model.IMessage;

/**
 * @author <a href="mailto:huangbing0730@gmail">hb0730</a>
 * @date 2024/8/8
 */
public interface BehaviorType extends IMessage {
    /**
     * 声明交互类型
     *
     * @return 声明交互类型
     */
    String getType();
}
