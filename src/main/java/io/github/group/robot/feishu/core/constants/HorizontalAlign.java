package io.github.group.robot.feishu.core.constants;

import lombok.Getter;

/**
 * 列容器水平对齐的方式
 *
 * @author <a href="mailto:huangbing0730@gmail">hb0730</a>
 * @date 2023/7/5
 */
@Getter
public enum HorizontalAlign {
    /**
     * 左对齐
     */
    Left("left"),
    /**
     * 居中对齐
     */
    Center("center"),
    /**
     * 右对齐
     */
    Right("right"),
    ;
    private final String value;

    HorizontalAlign(String value) {
        this.value = value;
    }
}
