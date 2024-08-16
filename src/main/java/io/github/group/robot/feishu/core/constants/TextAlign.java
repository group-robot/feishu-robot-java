package io.github.group.robot.feishu.core.constants;

import lombok.Getter;

/**
 * 文本内容的对齐方式
 *
 * @author <a href="mailto:huangbing0730@gmail">hb0730</a>
 * @date 2023/7/5
 */
@Getter
public enum TextAlign {
    /**
     * 左对齐
     */
    LEFT("left"),
    /**
     * 居中对齐
     */
    CENTER("center"),
    /**
     * 右对齐
     */
    RIGHT("right"),
    ;
    private final String value;

    TextAlign(String value) {
        this.value = value;
    }

}
