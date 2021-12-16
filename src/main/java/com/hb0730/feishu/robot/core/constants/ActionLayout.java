package com.hb0730.feishu.robot.core.constants;

/**
 * 交互模块 布局
 *
 * @author bing_huang
 * @date 2021/12/16
 */
public enum ActionLayout {
    /**
     * 二等分布局
     */
    BISECTED("bisected"),
    /**
     * 三等分布局
     */
    TRISECTION("trisection"),
    /**
     * 流式布局
     */
    FLOW("flow"),
    ;

    private final String value;

    ActionLayout(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
