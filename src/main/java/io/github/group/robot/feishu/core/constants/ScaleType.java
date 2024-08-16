package io.github.group.robot.feishu.core.constants;

import lombok.Getter;

/**
 * 裁剪模式
 *
 * @author <a href="mailto:huangbing0730@gmail">hb0730</a>
 * @date 2024/7/30
 */
@Getter
public enum ScaleType {
    /**
     * 居中裁剪
     */
    CROP_CENTER("crop_center"),
    /**
     * 顶部裁剪
     */
    CROP_TOP("crop_top"),
    /**
     * 完整展示不裁剪
     */
    FIT_HORIZONTAL("fit_horizontal"),
    ;

    private final String value;

    ScaleType(String value) {
        this.value = value;
    }
}
