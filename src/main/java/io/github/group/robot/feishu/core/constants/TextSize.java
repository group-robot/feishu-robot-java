package io.github.group.robot.feishu.core.constants;

import lombok.Getter;

/**
 * 文本大小
 *
 * @author <a href="mailto:huangbing0730@gmail">hb0730</a>
 * @date 2024/7/26
 */
@Getter
public enum TextSize {
    /**
     * 特大标题（30px）
     */
    Heading0("heading-0"),
    /**
     * 一级标题（24px）
     */
    Heading1("heading-1"),
    /**
     * 二级标题（20px）
     */
    Heading2("heading-2"),
    /**
     * 三级标题（18px）
     */
    Heading3("heading-3"),
    /**
     * 四级标题（16px）
     */
    Heading4("heading-4"),
    /**
     * 标题（16px）
     */
    Heading("heading"),
    /**
     * 正文（14px）
     */
    Normal("normal"),
    /**
     * 辅助性文字（12px）
     */
    Notation("notation"),
    /**
     * 30px
     */
    XXXXLarge("xxxx-large"),
    /**
     * 24px
     */
    XXXLarge("xxx-large"),
    /**
     * 20px
     */
    XXLarge("xx-large"),
    /**
     * 18px
     */
    XLarge("x-large"),
    /**
     * 16px
     */
    Large("large"),
    /**
     * 14px
     */
    Medium("medium"),
    /**
     * 12px
     */
    Small("small"),
    /**
     * 10px
     */
    XSmall("x-small"),
    ;

    private final String value;

    TextSize(String value) {
        this.value = value;
    }
}
