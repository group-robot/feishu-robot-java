package io.github.group.robot.feishu.core.constants;

import lombok.Getter;

/**
 * 图表颜色主题
 *
 * @author <a href="mailto:huangbing0730@gmail">hb0730</a>
 * @date 2024/8/2
 */
@Getter
public enum ChartColorTheme {
    /**
     * 默认样式，与飞书客户端主题样式一致。
     */
    BRAND("brand"),
    /**
     * 同色系彩虹色。
     */
    RAINBOW("rainbow"),
    /**
     * 互补色。
     */
    COMPLEMENTARY("complementary"),
    /**
     * 反差色。
     */
    CONVERSE("converse"),
    /**
     * primary
     */
    PRIMARY("primary"),
    ;
    private final String value;

    ChartColorTheme(String value) {
        this.value = value;
    }
}
