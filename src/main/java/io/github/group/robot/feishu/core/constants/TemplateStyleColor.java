package io.github.group.robot.feishu.core.constants;

/**
 * 标题样式表
 *
 * @author <a href="mailto:huangbing0730@gmail">hb0730</a>
 * @date 2023/7/5
 */
public enum TemplateStyleColor {
    Blue("blue"),
    Wathet("wathet"),
    Turquoise("turquoise"),
    Green("green"),
    Yellow("yellow"),
    Orange("orange"),
    Red("red"),
    Carmine("carmine"),
    Violet("violet"),
    Purple("purple"),
    Indigo("indigo"),
    Grey("grey"),
    Default("default"),
    ;
    private final String value;

    TemplateStyleColor(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
