package io.github.group.robot.feishu.core.model.interactive;

import io.github.group.robot.feishu.core.model.IMessage;
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
     * 是否允许卡片被转发。客户端版本要求为3.31.0
     */
    private Boolean enableForward;
    /**
     * 更新卡片的内容是否对所有收到这张卡片的人员可见
     */
    private Boolean updateMulti;
    /**
     * 是否根据屏幕宽度动态调整消息卡片宽度
     */
    private Boolean wideScreenMode;

    @Override
    public Map<String, Object> toMessage() {
        Map<String, Object> message = new HashMap<>(3);
        message.put("wide_screen_mode", this.wideScreenMode == null || this.wideScreenMode);
        message.put("enable_forward", this.enableForward != null && this.enableForward);
        message.put("update_multi", this.updateMulti == null || this.updateMulti);
        return message;
    }
}
