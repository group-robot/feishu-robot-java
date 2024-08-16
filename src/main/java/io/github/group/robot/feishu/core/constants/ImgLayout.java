package io.github.group.robot.feishu.core.constants;

import lombok.Getter;

/**
 * 图片布局
 *
 * @author <a href="mailto:huangbing0730@gmail">hb0730</a>
 * @date 2024/8/8
 */
@Getter
public enum ImgLayout {
    /**
     * 每个选项的图片宽度撑满父容器宽度，高度按图片大小等比例缩放。
     */
    STRETCH("stretch"),
    /**
     * 二等分排布，每个选项图片宽度占父容器的 1/2，高度按图片大小等比例缩放。
     */
    BISECT("bisect"),
    /**
     * 三等分排布，每个选项图片宽度占父容器的 1/3，高度按图片大小等比例缩放。
     */
    TRISECT("trisect"),
    ;

    private final String value;

    ImgLayout(String value) {
        this.value = value;
    }
}
