package com.hb0730.feishu.robot.core.model.interactive;

import com.hb0730.feishu.robot.core.model.IMessage;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

/**
 * 卡片属性
 *
 * @author bing_huang
 * @date 2021/12/16
 */
@Getter
@Setter
@Builder
public class CardConfig implements IMessage {
    /**
     * 是否允许卡片被转发。
     */
    private Boolean enableForward = true;
    /**
     * 更新卡片的内容是否对所有收到这张卡片的人员可见
     */
    private Boolean updateMulti = false;
    /**
     * 是否根据屏幕宽度动态调整消息卡片宽度
     */
    private Boolean wideScreenMode = true;

    @Override
    public Map<String, Object> toMessage() {
        Map<String, Object> message = new HashMap<>();
        message.put("wide_screen_mode", this.wideScreenMode);
        message.put("enable_forward", this.enableForward);
        message.put("update_multi", this.updateMulti);
        return message;
    }
}
