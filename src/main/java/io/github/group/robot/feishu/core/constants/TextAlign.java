package io.github.group.robot.feishu.core.constants;

/**
 * 文本内容的对齐方式
 *
 * @author <a href="mailto:huangbing0730@gmail">hb0730</a>
 * @date 2023/7/5
 */
public enum TextAlign {
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

    TextAlign(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
