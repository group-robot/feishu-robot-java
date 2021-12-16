package com.hb0730.feishu.robot.core.model.post.tag;

import com.hb0730.feishu.robot.core.model.IMessage;

import java.util.Map;

/**
 * tag
 *
 * @author bing_huang
 * @date 2021/12/16
 */
public abstract class PostTag implements IMessage {
    public PostTag() {
        setTag();
    }

    /**
     * tag
     */
    protected String tag;

    /**
     * 设置 tag
     */
    protected abstract void setTag();

    /**
     * 获取tag
     *
     * @return tag
     */
    public String getTag() {
        return this.tag;
    }

    /**
     * 转map
     *
     * @return map
     */
    @Override
    public abstract Map<String, Object> toMessage();
}
