package io.github.group.robot.feishu.core.constants;

import lombok.Getter;

/**
 * flex布局模式
 *
 * @author <a href="mailto:huangbing0730@gmail">hb0730</a>
 * @date 2024/7/27
 */
@Getter
public enum FlexMode {
    /**
     * none: 不做布局上的自适应，在窄屏幕下按比例压缩列宽度
     */
    NONE("none"),
    /**
     * stretch: 列布局变为行布局，且每列（行）宽度强制拉伸为 100%，所有列自适应为上下堆叠排布
     */
    STRETCH("stretch"),
    /**
     * flow: 列流式排布（自动换行），当一行展示不下一列时，自动换至下一行展示
     */
    FLOW("flow"),
    /**
     * wrap: 两列等分布局
     */
    BISECT("bisect"),
    /**
     * trisect: 三列等分布局
     */
    TRISECT("trisect"),

    ;
    private final String value;

    FlexMode(String value) {
        this.value = value;
    }
}
