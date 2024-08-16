package io.github.group.robot.feishu.core.constants;

import lombok.Getter;

/**
 * 按钮类型
 *
 * @author <a href="mailto:huangbing0730@gmail">hb0730</a>
 * @date 2024/8/7
 */
@Getter
public enum ButtonType {
    /**
     * 黑色字体按钮，有边框
     */
    DEFAULT("default"),
    /**
     * 蓝色字体按钮，有边框
     */
    PRIMARY("primary"),
    /**
     * 红色字体按钮，有边框
     */
    DANGER("danger"),
    /**
     * 黑色字体按钮，无边框
     */
    TEXT("text"),
    /**
     * 蓝色字体按钮，无边框
     */
    PRIMARY_TEXT("primary_text"),
    /**
     * 红色字体按钮，无边框
     */
    DANGER_TEXT("danger_text"),
    /**
     * 蓝底白字按钮
     */
    PRIMARY_Filled("primary_filled"),
    /**
     * 红底白字按钮
     */
    DANGER_Filled("danger_filled"),
    /**
     * 镭射按钮
     */
    LASER("laser"),
    ;
    private final String value;

    ButtonType(String value) {
        this.value = value;
    }
}
