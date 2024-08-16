package io.github.group.robot.feishu.core.model.post.tags;

import io.github.group.robot.feishu.core.model.IMessage;

/**
 * 标签
 *
 * @author <a href="mailto:huangbing0730@gmail">hb0730</a>
 * @date 2024/8/16
 */
public interface PostTag extends IMessage {
    /**
     * 获取标签
     *
     * @return 标签
     */
    String getTag();
}
