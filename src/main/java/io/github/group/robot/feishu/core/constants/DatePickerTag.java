package io.github.group.robot.feishu.core.constants;

/**
 * date_picker 元素标签
 *
 * @author bing_huang
 * @date 2021/12/16
 */
public enum DatePickerTag {
    /**
     * 日期
     */
    DATE_PICKER("date_picker"),
    /**
     * 时间
     */
    PICKER_TIME("picker_time"),
    /**
     * 日期+时间
     */
    PICKER_DATETIME("picker_datetime"),
    ;
    private final String value;

    DatePickerTag(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

