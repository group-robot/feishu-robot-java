package io.github.group.robot.feishu.core.model.card.components.content.table;

import io.github.group.robot.feishu.core.constants.DataType;
import io.github.group.robot.feishu.core.constants.HorizontalAlign;
import io.github.group.robot.feishu.core.model.Builder;
import io.github.group.robot.feishu.core.model.IMessage;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

/**
 * 卡片组件 - 展示 - 表格 - 列
 *
 * @author <a href="mailto:huangbing0730@gmail">hb0730</a>
 * @date 2024/8/2
 */
@Getter
@Setter
public class Column implements IMessage {
    /**
     * 自定义列的标记。用于唯一指定行数据对象数组中，需要将数据填充至这一行的具体哪个单元格中。
     */
    private String name;
    /**
     * 列的显示名称
     */
    private String displayName;
    /**
     * 列的宽度
     * <p>
     * auto：自动宽度 <br>
     * 自定义宽度：自定义表格的列宽度，如 120px。取值范围是 [80px,600px] 的整数<br>
     * 自定义宽度百分比：自定义列宽度占当前表格画布宽度的百分比（表格画布宽度 = 卡片宽度-卡片左右内边距），如 25%。取值范围是 [1%,100%]
     */
    private String width;
    /**
     * 列的水平对齐方式
     */
    private HorizontalAlign horizontalAlign;
    /**
     * 列的数据类型
     */
    private DataType dataType;
    /**
     * 数字格式,仅当 <code>dataType</code>为 <code>number</code> 时有效
     */
    private NumberFormat format;
    /**
     * 日期格式,仅当 <code>dataType</code>为 <code>date</code> 时有效.你可按需选择以下日期时间占位符，并使用任意分隔符组合。
     * <ul>
     * <li>YYYY：年份，如 2021</li>
     * <li>MM：月份，如 01</li>
     * <li>DD：日期，如 01</li>
     * <li>HH：小时，如 01</li>
     * <li>mm：分钟，如 01</li>
     * <li>ss：秒，如 01</li>
     * </ul>
     * 例如：YYYY-MM-DD HH:mm:ss 表示 2021-01-01 01:01:01 <br>
     */
    private String dateFormat;

    @Override
    public Map<String, Object> toMessage() {
        Map<String, Object> message = new java.util.HashMap<>(6);
        if (name != null) {
            message.put("name", name);
        }
        if (displayName != null) {
            message.put("display_name", displayName);
        }
        if (width != null) {
            message.put("width", width);
        }
        if (horizontalAlign != null) {
            message.put("horizontal_align", horizontalAlign.getValue());
        }
        if (dataType != null) {
            message.put("data_type", dataType.getValue());
        }
        if (format != null) {
            message.put("format", format.toMessage());
        }
        if (dateFormat != null) {
            message.put("date_format", dateFormat);
        }
        return message;
    }

    public static ColumnBuilder builder() {
        return ColumnBuilder.builder();
    }

    /**
     * 构造器
     */
    public static class ColumnBuilder implements Builder<Column> {
        private final Column column;

        private ColumnBuilder() {
            this.column = new Column();
        }

        public static ColumnBuilder builder() {
            return new ColumnBuilder();
        }

        /**
         * 自定义列的标记。用于唯一指定行数据对象数组中，需要将数据填充至这一行的具体哪个单元格中。
         *
         * @param name 自定义列的标记
         * @return ColumnBuilder
         */
        public ColumnBuilder setName(String name) {
            this.column.setName(name);
            return this;
        }

        /**
         * 列的显示名称
         *
         * @param displayName 列的显示名称
         * @return ColumnBuilder
         */
        public ColumnBuilder setDisplayName(String displayName) {
            this.column.setDisplayName(displayName);
            return this;
        }

        /**
         * 列的宽度
         * <p>
         * auto：自动宽度 <br>
         * 自定义宽度：自定义表格的列宽度，如 120px。取值范围是 [80px,600px] 的整数<br>
         * 自定义宽度百分比：自定义列宽度占当前表格画布宽度的百分比（表格画布宽度 = 卡片宽度-卡片左右内边距），如 25%。取值范围是 [1%,100%]
         *
         * @param width 列的宽度
         * @return ColumnBuilder
         */
        public ColumnBuilder setWidth(String width) {
            this.column.setWidth(width);
            return this;
        }

        /**
         * 列的水平对齐方式
         *
         * @param horizontalAlign 列的水平对齐方式
         * @return ColumnBuilder
         */
        public ColumnBuilder setHorizontalAlign(HorizontalAlign horizontalAlign) {
            this.column.setHorizontalAlign(horizontalAlign);
            return this;
        }

        /**
         * 列的数据类型
         *
         * @param dataType 列的数据类型
         * @return ColumnBuilder
         */
        public ColumnBuilder setDataType(DataType dataType) {
            this.column.setDataType(dataType);
            return this;
        }

        /**
         * 数字格式,仅当 <code>dataType</code>为 <code>number</code> 时有效
         *
         * @param format 数字格式
         * @return ColumnBuilder
         */
        public ColumnBuilder setFormat(NumberFormat format) {
            this.column.setFormat(format);
            return this;
        }

        /**
         * 日期格式,仅当 <code>dataType</code>为 <code>date</code> 时有效.你可按需选择以下日期时间占位符，并使用任意分隔符组合。
         * <ul>
         * <li>YYYY：年份，如 2021</li>
         * <li>MM：月份，如 01</li>
         * <li>DD：日期，如 01</li>
         * <li>HH：小时，如 01</li>
         * <li>mm：分钟，如 01</li>
         * <li>ss：秒，如 01</li>
         * </ul>
         * 例如：YYYY-MM-DD HH:mm:ss 表示 2021-01-01 01:01:01 <br>
         *
         * @param dateFormat 日期格式
         * @return ColumnBuilder
         */
        public ColumnBuilder setDateFormat(String dateFormat) {
            this.column.setDateFormat(dateFormat);
            return this;
        }

        @Override
        public Column build() {
            return this.column;
        }
    }
}
