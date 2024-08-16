package io.github.group.robot.feishu.core.constants;

import lombok.Getter;

/**
 * 按钮大小
 *
 * @author <a href="mailto:huangbing0730@gmail">hb0730</a>
 * @date 2024/8/7
 */
@Getter
public enum ButtonSize {
    /**
     * 超小尺寸，PC 端为 24 px；移动端为 28 px
     */
    TINY("tiny"),
    /**
     * 小尺寸，PC 端为 28 px；移动端为 28 px
     */
    SMALL("small"),
    /**
     * 中等尺寸，PC 端为 32 px；移动端为 36 px
     */
    MEDIUM("medium"),
    /**
     * 大尺寸，PC 端为 40 px；移动端为 48 px
     */
    LARGE("large"),
    ;
    private final String value;

    ButtonSize(String value) {
        this.value = value;
    }
}
