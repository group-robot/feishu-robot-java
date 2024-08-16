package io.github.group.robot.feishu.core.model.card.components.content.table;

import io.github.group.robot.feishu.core.model.IMessage;
import lombok.Getter;

import java.util.Map;

/**
 * 卡片组件 - 展示 - 表格 - 数字格式
 *
 * @author <a href="mailto:huangbing0730@gmail">hb0730</a>
 * @date 2024/8/2
 */
@Getter
public class NumberFormat implements IMessage {
    /**
     * 数字的小数点位数。默认不限制小数点位数，原样透传展示开发者输入的数字。可填 0~10 的整数。小数点位数为 0 表示取整数。
     */
    private Integer precision;

    /**
     * 数字的小数点位数
     *
     * @param precision 数字的小数点位数
     * @return NumberFormat
     */
    public NumberFormat setPrecision(Integer precision) {
        this.precision = precision;
        return this;
    }

    /**
     * 数字前的货币单位。不填或为空不展示。可填 1 个字符的货币单位文本，如 “¥”。
     */
    private String symbol;

    /**
     * 数字前的货币单位
     *
     * @param symbol 数字前的货币单位
     * @return NumberFormat
     */
    public NumberFormat setSymbol(String symbol) {
        this.symbol = symbol;
        return this;
    }

    /**
     * 是否生效按千分位逗号分割的数字样式。
     */
    private Boolean separator;

    /**
     * 是否生效按千分位逗号分割的数字样式
     *
     * @param separator 是否生效按千分位逗号分割的数字样式
     * @return NumberFormat
     */
    public NumberFormat setSeparator(Boolean separator) {
        this.separator = separator;
        return this;
    }

    /**
     * 创建数字格式
     *
     * @return NumberFormat
     */
    public static NumberFormat of() {
        return new NumberFormat();
    }

    @Override
    public Map<String, Object> toMessage() {
        Map<String, Object> message = new java.util.HashMap<>(3);
        if (precision != null) {
            message.put("precision", precision);
        }
        if (symbol != null) {
            message.put("symbol", symbol);
        }
        if (separator != null) {
            message.put("separator", separator);
        }
        return message;
    }
}
