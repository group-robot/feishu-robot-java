package io.github.group.robot.feishu.core.constants;

import lombok.Getter;

/**
 * text tag
 *
 * @author <a href="mailto:huangbing0730@gmail">hb0730</a>
 * @date 2021/12/16
 */
@Getter
public enum TextTag {
    /**
     * lark_md
     */
    LARK_MD("lark_md"),
    /**
     * plain_text
     */
    PLAIN_TEXT("plain_text"),
    /**
     * markdown
     */
    MARKDOWN("markdown"),
    ;

    private final String value;

    TextTag(String value) {
        this.value = value;
    }

}
