package io.github.group.robot.feishu.core.model.card.components.content;

import io.github.group.robot.feishu.core.model.Builder;
import io.github.group.robot.feishu.core.model.card.components.CardTag;
import io.github.group.robot.feishu.core.model.card.components.content.table.Column;
import io.github.group.robot.feishu.core.model.card.components.content.table.HeaderStyle;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 卡片组件 - 展示 - 表格
 *
 * @author <a href="mailto:huangbing0730@gmail">hb0730</a>
 * @date 2024/8/2
 */
@Getter
@Setter
public class Table implements CardTag {
    private final String tag = "table";

    /**
     * 每页最大展示的数据行数。支持 [1,10] 整数。
     */
    private Integer pageSize;
    /**
     * 表格的行高。单元格高度如无法展示一整行内容，则上下裁剪内容。
     * <ul>
     * <li>low：低</li>
     * <li>medium：中</li>
     * <li>high：高</li>
     * <li>[32,124]px：自定义行高，单位为像素，如 40px。取值范围是 [32,124]</li>
     * </ul>
     */
    private String rowHeight;
    /**
     * 表头样式
     */
    private HeaderStyle headerStyle;
    /**
     * 表格列信息
     */
    private List<Column> columns;
    /**
     * 行对象数组。与列定义对应的数据。用 "name":VALUE 的形式，定义每一行的数据内容。name即你自定义的列标记。
     */
    private List<Object> rows;

    @Override
    public Map<String, Object> toMessage() {
        Map<String, Object> message = new java.util.HashMap<>(5);
        message.put("tag", tag);
        if (pageSize != null) {
            message.put("page_size", pageSize);
        }
        if (rowHeight != null) {
            message.put("row_height", rowHeight);
        }
        if (headerStyle != null) {
            message.put("header_style", headerStyle.toMessage());
        }
        if (columns != null) {
            List<Map<String, Object>> columnList = this.columns
                    .stream().map(Column::toMessage)
                    .collect(Collectors.toList());
            message.put("columns", columnList);
        }
        if (rows != null) {
            message.put("rows", rows);
        }
        return message;
    }

    /**
     * 创建 TableBuilder
     *
     * @return TableBuilder
     */
    public static TableBuilder builder() {
        return new TableBuilder();
    }

    /**
     * 构造器
     */
    public static class TableBuilder implements Builder<Table> {
        private final Table table = new Table();

        private TableBuilder() {
        }

        /**
         * 每页最大展示的数据行数。支持 [1,10] 整数。
         *
         * @param pageSize 每页最大展示的数据行数
         * @return TableBuilder
         */
        public TableBuilder setPageSize(Integer pageSize) {
            this.table.setPageSize(pageSize);
            return this;
        }

        /**
         * 表格的行高。单元格高度如无法展示一整行内容，则上下裁剪内容。
         * <ul>
         * <li>low：低</li>
         * <li>medium：中</li>
         * <li>high：高</li>
         * <li>[32,124]px：自定义行高，单位为像素，如 40px。取值范围是 [32,124]</li>
         * </ul>
         *
         * @param rowHeight 表格的行高
         * @return TableBuilder
         */
        public TableBuilder setRowHeight(String rowHeight) {
            this.table.setRowHeight(rowHeight);
            return this;
        }

        /**
         * 表头样式
         *
         * @param headerStyle 表头样式
         * @return TableBuilder
         */
        public TableBuilder setHeaderStyle(HeaderStyle headerStyle) {
            this.table.setHeaderStyle(headerStyle);
            return this;
        }

        /**
         * 表头样式
         *
         * @param headerStyle 表头样式
         * @return TableBuilder
         */
        public TableBuilder setHeaderStyle(HeaderStyle.HeaderStyleBuilder headerStyle) {
            this.table.setHeaderStyle(headerStyle.build());
            return this;
        }

        /**
         * 表格列信息
         *
         * @param columns 表格列信息
         * @return TableBuilder
         */
        public TableBuilder setColumns(List<Column> columns) {
            this.table.setColumns(columns);
            return this;
        }

        /**
         * 表格列信息
         *
         * @param columns 表格列信息
         * @return TableBuilder
         */
        public TableBuilder setColumns(Column.ColumnBuilder... columns) {
            this.table.setColumns(java.util.Arrays.stream(columns)
                    .map(Column.ColumnBuilder::build)
                    .collect(Collectors.toList()));
            return this;
        }

        /**
         * 表格列信息
         *
         * @param columns 表格列信息
         * @return TableBuilder
         */
        public TableBuilder setColumns(Column... columns) {
            this.table.setColumns(java.util.Arrays.asList(columns));
            return this;
        }

        /**
         * 表格列信息
         *
         * @param column 表格列信息
         * @return TableBuilder
         */
        public TableBuilder setColumns(Column column) {
            this.table.setColumns(java.util.Collections.singletonList(column));
            return this;
        }

        /**
         * 表格列信息
         *
         * @param columns 表格列信息
         * @return TableBuilder
         */
        public TableBuilder addColumn(List<Column> columns) {
            if (this.table.getColumns() == null) {
                this.table.setColumns(new java.util.ArrayList<>());
            }
            this.table.getColumns().addAll(columns);
            return this;
        }

        /**
         * 表格列信息
         *
         * @param columns 表格列信息
         * @return TableBuilder
         */
        public TableBuilder addColumn(Column.ColumnBuilder... columns) {
            if (this.table.getColumns() == null) {
                this.table.setColumns(new java.util.ArrayList<>());
            }
            this.table.getColumns().addAll(java.util.Arrays.stream(columns)
                    .map(Column.ColumnBuilder::build)
                    .collect(Collectors.toList()));
            return this;
        }

        /**
         * 表格列信息
         *
         * @param columns 表格列信息
         * @return TableBuilder
         */
        public TableBuilder addColumn(Column... columns) {
            if (this.table.getColumns() == null) {
                this.table.setColumns(new java.util.ArrayList<>());
            }
            this.table.getColumns().addAll(java.util.Arrays.asList(columns));
            return this;
        }

        /**
         * 表格列信息
         *
         * @param column 表格列信息
         * @return TableBuilder
         */
        public TableBuilder addColumn(Column column) {
            if (this.table.getColumns() == null) {
                this.table.setColumns(new java.util.ArrayList<>());
            }
            this.table.getColumns().add(column);
            return this;
        }

        /**
         * 行对象数组。与列定义对应的数据。用 "name":VALUE 的形式，定义每一行的数据内容。name即你自定义的列标记。
         *
         * @param rows 行对象数组
         * @return TableBuilder
         */
        public TableBuilder setRows(List<Object> rows) {
            this.table.setRows(rows);
            return this;
        }

        /**
         * 行对象数组。与列定义对应的数据。用 "name":VALUE 的形式，定义每一行的数据内容。name即你自定义的列标记。
         *
         * @param rows 行对象数组
         * @return TableBuilder
         */
        public TableBuilder setRows(Object... rows) {
            this.table.setRows(java.util.Arrays.asList(rows));
            return this;
        }

        /**
         * 行对象数组。与列定义对应的数据。用 "name":VALUE 的形式，定义每一行的数据内容。name即你自定义的列标记。
         *
         * @param rows 行对象数组
         * @return TableBuilder
         */
        public TableBuilder addRows(List<Object> rows) {
            if (this.table.getRows() == null) {
                this.table.setRows(new java.util.ArrayList<>());
            }
            this.table.getRows().addAll(rows);
            return this;
        }

        /**
         * 行对象数组。与列定义对应的数据。用 "name":VALUE 的形式，定义每一行的数据内容。name即你自定义的列标记。
         *
         * @param rows 行对象数组
         * @return TableBuilder
         */
        public TableBuilder addRows(Object... rows) {
            if (this.table.getRows() == null) {
                this.table.setRows(new java.util.ArrayList<>());
            }
            this.table.getRows().addAll(java.util.Arrays.asList(rows));
            return this;
        }

        /**
         * 行对象数组。与列定义对应的数据。用 "name":VALUE 的形式，定义每一行的数据内容。name即你自定义的列标记。
         *
         * @param rows 行对象数组
         * @return TableBuilder
         */
        public TableBuilder addRows(Object rows) {
            if (this.table.getRows() == null) {
                this.table.setRows(new java.util.ArrayList<>());
            }
            this.table.getRows().add(rows);
            return this;
        }

        @Override
        public Table build() {
            return this.table;
        }
    }
}
