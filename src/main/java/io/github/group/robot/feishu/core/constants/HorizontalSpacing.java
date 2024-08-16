package io.github.group.robot.feishu.core.constants;

import lombok.Getter;

/**
 * 水平间距
 *
 * @author <a href="mailto:huangbing0730@gmail">hb0730</a>
 * @date 2024/7/27
 */
@Getter
public enum HorizontalSpacing {
    /**
     * 默认,默认间距，8px
     */
    DEFAULT("default"),
    /**
     * 小,窄间距，4px
     */
    SMALL("small"),
    /**
     * 大,大间距，12px
     */
    LARGE("large");
    private final String value;

    HorizontalSpacing(String value) {
        this.value = value;
    }
}
