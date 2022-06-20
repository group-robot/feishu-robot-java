package io.github.group.robot.feishu.core.constants;

/**
 * img 模式
 *
 * @author bing_huang
 * @date 2021/12/16
 */
public enum ImgMode {
    /**
     * 铺模式
     */
    FIT_HORIZONTAL("fit_horizontal"),
    /**
     * 居中裁剪模式
     */
    CROP_CENTER("crop_center");
    private final String value;

    ImgMode(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
