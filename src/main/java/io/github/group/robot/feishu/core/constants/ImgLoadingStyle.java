package io.github.group.robot.feishu.core.constants;

import lombok.Getter;

/**
 * 图片加载等状态时的组件风格样式
 *
 * @author <a href="mailto:huangbing0730@gmail">hb0730</a>
 * @date 2024/8/8
 */
@Getter
public enum ImgLoadingStyle {
    /**
     * 默认灰色样式
     */
    DEFAULT("default"),
    /**
     * 彩色渐变样式，建议 AI 场景使用
     */
    LASER("laser"),
    ;
    private final String value;

    ImgLoadingStyle(String value) {
        this.value = value;
    }
}
