package io.github.group.robot.feishu.core.constants;

import lombok.Getter;

/**
 * 输入框类型
 *
 * @author <a href="mailto:huangbing0730@gmail">hb0730</a>
 * @date 2024/8/2
 */
@Getter
public enum InputType {
    /**
     * 普通文本
     */
    TEXT("text"),
    /**
     * 多行文本，即可输入包含换行符的多行文本内容。换行符在回调中以 \n 返回
     */
    MULTILINE_TEXT("multiline_text"),
    /**
     * 密码。用户输入的文本内容将以“•”显示
     */
    PASSWORD("password"),
    ;
    private final String value;

    InputType(String value) {
        this.value = value;
    }
}
