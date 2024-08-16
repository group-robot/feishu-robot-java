package io.github.group.robot.feishu.core.model.card.components.containers;

import io.github.group.robot.feishu.core.constants.FlexMode;
import io.github.group.robot.feishu.core.constants.HorizontalAlign;
import io.github.group.robot.feishu.core.constants.HorizontalSpacing;
import io.github.group.robot.feishu.core.model.Builder;
import io.github.group.robot.feishu.core.model.card.components.CardTag;
import io.github.group.robot.feishu.core.model.card.components.containers.ele.Column;
import io.github.group.robot.feishu.core.model.card.components.ele.UrlEl;
import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 卡片组件 - 容器 - 分栏
 *
 * @author <a href="mailto:huangbing0730@gmail">hb0730</a>
 * @date 2024/7/27
 */
@Getter
@Setter
public class ColumnSet implements CardTag {
    private final String tag = "column_set";

    /**
     * 各列之间的水平分栏间距
     * <ul>
     * <li>default:默认间距，8px</li>
     * <li>small:窄间距，4px</li>
     * <li>large:大间距，12px</li>
     * <li>[0,28px]：自定义间距</li>
     * </ul>
     *
     * @see io.github.group.robot.feishu.core.constants.HorizontalSpacing
     */
    private String horizontalSpacing;
    /**
     * 各列之间的垂直分栏间距
     *
     * @see io.github.group.robot.feishu.core.constants.HorizontalAlign
     */
    private HorizontalAlign horizontalAlign;
    /**
     * 列的外边距。值的取值范围为 [0,28]px
     * <p>
     * 单值，如 "10px"，表示列的四个外边距都为 10 px。<br>
     * 多值，如 "4px 12px 4px 12px"，表示列的上、右、下、左的外边距分别为 4px，12px，4px，12px。四个值必填，使用空格间隔。<br>
     */
    private String margin;
    /**
     * 移动端和 PC 端的窄屏幕下，各列的自适应方式
     */
    private FlexMode flexMode;
    /**
     * 分栏的背景色样式
     */
    private String backgroundStyle;
    /**
     * 分栏中列的配置
     */
    private List<Column> columns;
    /**
     * 设置点击分栏时的交互配置。当前仅支持跳转交互。如果布局容器内有交互组件，则优先响应交互组件定义的交互。
     */
    private UrlEl action;

    @Override
    public Map<String, Object> toMessage() {
        Map<String, Object> message = new HashMap<>(7);
        message.put("tag", tag);
        if (null != this.horizontalSpacing) {
            message.put("horizontal_spacing", this.horizontalSpacing);
        }
        if (null != this.horizontalAlign) {
            message.put("horizontal_align", this.horizontalAlign.getValue());
        }
        if (null != this.margin) {
            message.put("margin", this.margin);
        }
        if (null != this.flexMode) {
            message.put("flex_mode", this.flexMode.getValue());
        }
        if (null != this.backgroundStyle) {
            message.put("background_style", this.backgroundStyle);
        }
        if (null != this.columns) {
            List<Map<String, Object>> columns = new java.util.ArrayList<>(this.columns.size());
            for (Column column : this.columns) {
                columns.add(column.toMessage());
            }
            message.put("columns", columns);
        }
        if (null != this.action) {
            Map<String, Object> multiUrl = new HashMap<>(1);
            multiUrl.put("multi_url", this.action.toMessage());
            message.put("action", multiUrl);
        }
        return message;
    }

    /**
     * 创建 ColumnSetBuilder
     *
     * @return ColumnSetBuilder
     */
    public static ColumnSetBuilder builder() {
        return new ColumnSetBuilder();
    }

    /**
     * {@link ColumnSet} 构建器
     */
    public static class ColumnSetBuilder implements Builder<ColumnSet> {
        private final ColumnSet columnSet = new ColumnSet();

        private ColumnSetBuilder() {
        }


        /**
         * 各列之间的水平分栏间距
         * <ul>
         * <li>default:默认间距，8px</li>
         * <li>small:窄间距，4px</li>
         * <li>large:大间距，12px</li>
         * <li>[0,28px]：自定义间距</li>
         * </ul>
         *
         * @param horizontalSpacing .
         * @return .
         */
        public ColumnSetBuilder setHorizontalSpacing(String horizontalSpacing) {
            this.columnSet.setHorizontalSpacing(horizontalSpacing);
            return this;
        }

        /**
         * 各列之间的水平分栏间距
         * <ul>
         * <li>default:默认间距，8px</li>
         * <li>small:窄间距，4px</li>
         * <li>large:大间距，12px</li>
         * <li>[0,28px]：自定义间距</li>
         * </ul>
         *
         * @param horizontalSpacing .
         * @return .
         */
        public ColumnSetBuilder setHorizontalSpacing(HorizontalSpacing horizontalSpacing) {
            this.columnSet.setHorizontalSpacing(horizontalSpacing.getValue());
            return this;
        }

        /**
         * 各列之间的垂直分栏间距
         *
         * @param horizontalAlign .
         * @return .
         */
        public ColumnSetBuilder setHorizontalAlign(HorizontalAlign horizontalAlign) {
            this.columnSet.setHorizontalAlign(horizontalAlign);
            return this;
        }

        /**
         * 列的外边距。值的取值范围为 [0,28]px
         * <p>
         * 单值，如 "10px"，表示列的四个外边距都为 10 px。<br>
         * 多值，如 "4px 12px 4px 12px"，表示列的上、右、下、左的外边距分别为 4px，12px，4px，12px。四个值必填，使用空格间隔。<br>
         *
         * @param margin .
         * @return .
         */
        public ColumnSetBuilder setMargin(String margin) {
            this.columnSet.setMargin(margin);
            return this;
        }

        /**
         * 移动端和 PC 端的窄屏幕下，各列的自适应方式
         *
         * @param flexMode .
         * @return .
         */
        public ColumnSetBuilder setFlexMode(FlexMode flexMode) {
            this.columnSet.setFlexMode(flexMode);
            return this;
        }

        /**
         * 分栏的背景色样式
         *
         * @param backgroundStyle .
         * @return .
         */
        public ColumnSetBuilder setBackgroundStyle(String backgroundStyle) {
            this.columnSet.setBackgroundStyle(backgroundStyle);
            return this;
        }

        /**
         * 设置 分栏中列的配置
         *
         * @param columns .
         * @return .
         */
        public ColumnSetBuilder setColumns(List<Column> columns) {
            this.columnSet.setColumns(columns);
            return this;
        }

        /**
         * 设置 分栏中列的配置
         *
         * @param columns .
         * @return .
         */
        public ColumnSetBuilder setColumns(Column... columns) {
            List<Column> list = new java.util.ArrayList<>(columns.length);
            list.addAll(Arrays.asList(columns));
            this.columnSet.setColumns(list);
            return this;
        }

        /**
         * 新增 分栏中列的配置
         *
         * @param columns .
         * @return .
         */
        public ColumnSetBuilder addColumn(Column... columns) {
            if (null == this.columnSet.getColumns()) {
                this.columnSet.setColumns(new java.util.ArrayList<>());
            }
            for (Column column : columns) {
                this.columnSet.getColumns().add(column);
            }
            return this;
        }

        /**
         * 新增 分栏中列的配置
         *
         * @param column .
         * @return .
         */
        public ColumnSetBuilder addColumn(Column column) {
            if (null == this.columnSet.getColumns()) {
                this.columnSet.setColumns(new java.util.ArrayList<>());
            }
            this.columnSet.getColumns().add(column);
            return this;
        }

        /**
         * 设置点击分栏时的交互配置。当前仅支持跳转交互。如果布局容器内有交互组件，则优先响应交互组件定义的交互。
         *
         * @param action .
         * @return .
         */
        public ColumnSetBuilder setAction(UrlEl action) {
            this.columnSet.setAction(action);
            return this;
        }

        public ColumnSet build() {
            return this.columnSet;
        }
    }
}
