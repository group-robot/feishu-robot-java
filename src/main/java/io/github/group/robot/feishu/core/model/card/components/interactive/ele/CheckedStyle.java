package io.github.group.robot.feishu.core.model.card.components.interactive.ele;

import io.github.group.robot.feishu.core.model.IMessage;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

/**
 * 卡片组件 - 交互 - 勾选器 - 勾选状态样式
 *
 * @author <a href="mailto:huangbing0730@gmail">hb0730</a>
 * @date 2024/8/8
 */
@Getter
@Setter
public class CheckedStyle implements IMessage {
    /**
     * 是否展示内容区的贯穿式删除线。
     */
    private Boolean showStrikethrough;
    /**
     * 内容区的不透明度。取值范围为 [0,1] 之间的数字，不限小数位数。。
     */
    private Float opacity;

    public CheckedStyle() {
    }

    public CheckedStyle(Boolean showStrikethrough, Float opacity) {
        this.showStrikethrough = showStrikethrough;
        this.opacity = opacity;
    }


    /**
     * 设置是否展示内容区的贯穿式删除线。
     *
     * @param showStrikethrough 是否展示内容区的贯穿式删除线。
     * @return this
     */
    public CheckedStyle setShowStrikethrough(Boolean showStrikethrough) {
        this.showStrikethrough = showStrikethrough;
        return this;
    }

    /**
     * 设置内容区的不透明度。取值范围为 [0,1] 之间的数字，不限小数位数。。
     *
     * @param opacity 内容区的不透明度
     * @return this
     */
    public CheckedStyle setOpacity(Float opacity) {
        this.opacity = opacity;
        return this;
    }

    @Override
    public Map<String, Object> toMessage() {
        Map<String, Object> message = new java.util.HashMap<>(2);
        if (showStrikethrough != null) {
            message.put("show_strikethrough", showStrikethrough);
        }
        if (opacity != null) {
            message.put("opacity", opacity);
        }
        return message;
    }

    /**
     * 创建勾选状态样式
     *
     * @param showStrikethrough 是否展示内容区的贯穿式删除线。
     * @param opacity           内容区的不透明度
     * @return 勾选状态样式
     */
    public static CheckedStyle of(Boolean showStrikethrough, Float opacity) {
        return new CheckedStyle(showStrikethrough, opacity);
    }

    /**
     * 创建勾选状态样式
     *
     * @return 勾选状态样式
     */
    public static CheckedStyle of() {
        return new CheckedStyle();
    }
}
