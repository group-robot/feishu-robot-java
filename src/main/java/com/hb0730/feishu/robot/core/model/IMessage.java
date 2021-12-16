package com.hb0730.feishu.robot.core.model;

import java.io.Serializable;
import java.util.Map;

/**
 * 消息 用于json转换
 *
 * @author bing_huang
 * @date 2021/12/16
 */
public interface IMessage extends Serializable {
    /**
     * 返回Message对象组装出来的Map对象，供后续JSON序列化
     *
     * @return Map
     */
    public abstract Map<String, Object> toMessage();
}
