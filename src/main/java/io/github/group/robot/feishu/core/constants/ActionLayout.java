package io.github.group.robot.feishu.core.constants;

import lombok.Getter;

/**
 * @author <a href="mailto:huangbing0730@gmail">hb0730</a>
 * @date 2024/8/8
 */
@Getter
public enum ActionLayout {
    /**
     * 二等分布局，每行两列交互元素。
     */
    BISECTED("bisected"),
    /**
     * 三等分布局，每行三列交互元素。
     */
    TRISECTION("trisection"),
    /**
     * ：流式布局，元素会按自身大小横向排列并在空间不够的时候折行。
     */
    FLOW("flow"),
    ;
    private final String value;

    ActionLayout(String value) {
        this.value = value;
    }
}
