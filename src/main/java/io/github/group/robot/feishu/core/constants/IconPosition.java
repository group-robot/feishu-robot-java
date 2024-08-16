package io.github.group.robot.feishu.core.constants;

import lombok.Getter;

/**
 * 图标的位置
 *
 * @author <a href="mailto:huangbing0730@gmail">hb0730</a>
 * @date 2024/7/30
 */
@Getter
public enum IconPosition {
    /**
     * 图标在标题区域最左侧
     */
    LEFT("left"),
    /**
     * 图标在标题区域最右侧
     */
    RIGHT("right"),
    /**
     * 图标在文本右侧
     */
    FOLLOW_TEXT("follow_text");

    private final String value;

    IconPosition(String value) {
        this.value = value;
    }
}
