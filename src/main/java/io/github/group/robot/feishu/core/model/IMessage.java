package io.github.group.robot.feishu.core.model;

import java.io.Serializable;
import java.util.Map;

/**
 * 消息 用于json转换
 *
 * @author <a href="mailto:huangbing0730@gmail">hb0730</a>
 * @date 2021/12/16
 */
public interface IMessage extends Serializable {
    /**
     * 返回Message对象组装出来的Map对象，供后续JSON序列化
     *
     * @return Map
     */
    Map<String, Object> toMessage();
}
