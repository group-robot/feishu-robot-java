package io.github.group.robot.feishu.core.constants;

/**
 * text tag
 *
 * @author bing_huang
 * @date 2021/12/16
 */
public enum TextTag {
    /**
     * lark_md
     */
    LARK_MD("lark_md"),
    /**
     * plain_text
     */
    PLAIN_TEXT("plain_text");

    private final String value;

    TextTag(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
