package io.github.group.robot.feishu.core.constants;

import lombok.Getter;

/**
 * 人员样式
 *
 * @author <a href="mailto:huangbing0730@gmail">hb0730</a>
 * @date 2024/8/12
 */
@Getter
public enum PersonStyle {
    /**
     * 默认样式
     */
    NORMAL("normal"),
    /**
     * 胶囊样式
     */
    CAPSULE("capsule"),
    ;

    private final String value;

    PersonStyle(String value) {
        this.value = value;
    }
}
