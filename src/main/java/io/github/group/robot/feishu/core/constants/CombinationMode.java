package io.github.group.robot.feishu.core.constants;

import lombok.Getter;

/**
 * 多图混排的方式
 *
 * @author <a href="mailto:huangbing0730@gmail">hb0730</a>
 * @date 2024/8/2
 */
@Getter
public enum CombinationMode {
    /**
     * 双图混排，最多可排布两张图。
     */
    DOUBLE("double"),
    /**
     * 三图混排，最多可排布三张图。
     */
    TRIPLE("triple"),
    /**
     * 等分双列图混排，每行两个等大的正方形图，最多可排布三行，即六张图。
     */
    BISECT("bisect"),
    /**
     * 等分三列图混排，每行三个等大的正方形图，最多可排布三行，即九张图。
     */
    TRISECT("trisect"),
    ;
    private final String value;

    CombinationMode(String value) {
        this.value = value;
    }
}
