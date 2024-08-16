package io.github.group.robot.feishu.core.constants;

import lombok.Getter;

/**
 * 垂直对齐方式
 *
 * @author <a href="mailto:huangbing0730@gmail">hb0730</a>
 * @date 2024/7/29
 */
@Getter
public enum VerticalAlign {
    /**
     * 上对齐
     */
    TOP("top"),
    /**
     * 居中对齐
     */
    CENTER("center"),
    /**
     * 下对齐
     */
    BOTTOM("bottom"),
    ;
    private final String value;

    VerticalAlign(String value) {
        this.value = value;
    }
}
