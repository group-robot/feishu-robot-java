package io.github.group.robot.feishu.core.constants;

import lombok.Getter;

/**
 * 图标标签
 *
 * @author <a href="mailto:huangbing0730@gmail">hb0730</a>
 * @date 2024/7/27
 */
@Getter
public enum IconTag {
    /**
     * 使用图标库中的图标
     */
    STANDARD_ICON("standard_icon"),
    /**
     * 使用自定义图标
     */
    CUSTOM_ICON("custom_icon"),

    ;
    private final String value;

    IconTag(String value) {
        this.value = value;
    }
}
