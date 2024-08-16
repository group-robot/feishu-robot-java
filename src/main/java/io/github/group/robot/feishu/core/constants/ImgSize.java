package io.github.group.robot.feishu.core.constants;

import lombok.Getter;

/**
 * 图片尺寸
 *
 * @author <a href="mailto:huangbing0730@gmail">hb0730</a>
 * @date 2024/7/30
 */
@Getter
public enum ImgSize {
    /**
     * 大图，尺寸为 160 × 160，适用于多图混排。
     */
    LARGE("large"),
    /**
     * 中图，尺寸为 80 × 80，适用于图文混排的封面图。
     */
    MEDIUM("medium"),
    /**
     * 小图，尺寸为 40 × 40，适用于人员头像。
     */
    SMALL("small"),
    /**
     * 超小图，尺寸为 16 × 16，适用于图标、备注。
     */
    TINY("tiny"),
    /**
     * 通栏图，适用于高宽比小于 16:9 的图片，图片的宽度将撑满卡片宽度。
     */
    STRETCH_WITHOUT_PADDING("stretch_without_padding"),
    /**
     * 超大图，适用于高宽比小于 16:9 的图片。
     */
    STRETCH("stretch"),
    ;
    private final String value;

    ImgSize(String value) {
        this.value = value;
    }
}
