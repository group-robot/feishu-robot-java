package io.github.group.robot.feishu.core.constants;

import lombok.Getter;

/**
 * 选择器边框样式
 *
 * @author <a href="mailto:huangbing0730@gmail">hb0730</a>
 * @date 2024/8/7
 */
@Getter
public enum SelectType {
    /**
     * 带边框样式
     */
    DEFAULT("default"),
    /**
     * 不带边框的纯文本样式
     */
    Text("text"),
    ;
    private final String value;

    SelectType(String value) {
        this.value = value;
    }
}
