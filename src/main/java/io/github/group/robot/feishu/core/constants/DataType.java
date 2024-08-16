package io.github.group.robot.feishu.core.constants;

import lombok.Getter;

/**
 * 数据类型
 *
 * @author <a href="mailto:huangbing0730@gmail">hb0730</a>
 * @date 2024/8/2
 */
@Getter
public enum DataType {
    /**
     * 文本
     */
    TEXT("text"),
    /**
     * 支持部分 markdown 格式的文本
     */
    LARK_MD("lark_md"),
    /**
     * 选项标签
     */
    OPTIONS("options"),
    /**
     * 数字
     */
    NUMBER("number"),
    /**
     * 人员
     */
    PERSON("persons"),
    /**
     * 日期时间
     */
    DATE("date"),
    /**
     * 支持完整 Markdown 语法的文本内容
     */
    MARKDOWN("markdown"),
    ;

    private final String value;

    DataType(String value) {
        this.value = value;
    }
}
