package com.hb0730.feishu.robot.core.model.interactive.module;

import com.hb0730.feishu.robot.core.Tag;
import com.hb0730.feishu.robot.core.model.IMessage;
import lombok.Builder;

import java.util.HashMap;
import java.util.Map;

/**
 * 分割线模块
 *
 * @author bing_huang
 * @date 2021/12/16
 */
@Builder
public class Hr extends AbstractModule {
    private final String tag = "hr";

    @Override
    public String tag() {
        return tag;
    }

    @Override
    public Map<String, Object> toMessage() {
        Map<String, Object> message = new HashMap<>(1);
        message.put("tag", tag());
        return message;
    }
}
