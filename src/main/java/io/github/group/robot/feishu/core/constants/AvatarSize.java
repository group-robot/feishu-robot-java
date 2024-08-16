package io.github.group.robot.feishu.core.constants;

import lombok.Getter;

/**
 * 头像大小
 *
 * @author <a href="mailto:huangbing0730@gmail">hb0730</a>
 * @date 2024/8/2
 */
@Getter
public enum AvatarSize {
    /**
     * 超小尺寸
     */
    EXTRA_SMALL("extra_small"),
    /**
     * 小尺寸
     */
    SMALL("small"),
    /**
     * 中等尺寸
     */
    MEDIUM("medium"),
    /**
     * 大尺寸
     */
    LARGE("large"),
    ;
    private final String value;

    AvatarSize(String value) {
        this.value = value;
    }
}
