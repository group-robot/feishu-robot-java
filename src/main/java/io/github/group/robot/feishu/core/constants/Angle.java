package io.github.group.robot.feishu.core.constants;

import lombok.Getter;

/**
 * 角度
 *
 * @author <a href="mailto:huangbing0730@gmail">hb0730</a>
 * @date 2024/7/30
 */
@Getter
public enum Angle {
    /**
     * 逆时针旋转180度
     */
    DEG_180("-180"),
    /**
     * 逆时针旋转90度
     */
    DEG_90("-90"),
    /**
     * 顺时针旋转90度
     */
    DEG_90_CLOCKWISE("90"),
    /**
     * 顺时针旋转180度
     */
    DEG_180_CLOCKWISE("180"),
    ;
    private final String value;

    Angle(String value) {
        this.value = value;
    }
}
