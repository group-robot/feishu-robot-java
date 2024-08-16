package io.github.group.robot.feishu.core.model.card.components.containers.ele;

import io.github.group.robot.feishu.core.constants.VerticalAlign;
import io.github.group.robot.feishu.core.model.Builder;
import io.github.group.robot.feishu.core.model.IMessage;
import io.github.group.robot.feishu.core.model.card.components.ele.UrlEl;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 卡片组件 - 容器 - 分栏 - 分栏中列（column）
 *
 * @author <a href="mailto:huangbing0730@gmail">hb0730</a>
 * @date 2024/7/29
 */
@Getter
@Setter
public class Column implements IMessage {
    private final String tag = "column";

    /**
     * 列的背景色样式
     */
    private String backgroundStyle;

    /**
     * 列宽度。仅 flex_mode 为 none 时，生效此属性
     * <ul>
     *  <li>auto：列宽度与列内元素宽度一致</li>
     *  <li>weighted:列宽度按 weight 参数定义的权重分布</li>
     *  <li>具体数值，如 100px。取值范围为 [16,600]px</li>
     * </ul>
     */
    private String width;
    /**
     * 当 width 字段取值为 weighted 时生效，表示当前列的宽度占比。取值范围为 1 ~ 5 之间的整数。
     */
    private Integer weight;
    /**
     * 列内组件的水平对齐方式。
     */

    private VerticalAlign verticalAlign;
    /**
     * 列内组件的纵向间距。
     * <ul>
     *  <li>default：默认间距，8px</li>
     *  <li>medium：中等间距</li>
     *  <li>large：大间距</li>
     *  <li>具体数值，如 8px。取值范围为 [0,28]px</li>
     * </ul>
     */
    private String verticalSpacing;
    /**
     * 列的内边距。值的取值范围为 [0,28]px。
     * <p>
     * 单值，如 "10px"，表示列的四个外边距都为 10 px。<br>
     * 多值，如 "4px 12px 4px 12px"，表示列的上、右、下、左的外边距分别为 4px，12px，4px，12px。四个值必填，使用空格间隔。
     */
    private String padding;
    /**
     * 列容器中内嵌的组件。可内嵌组件参考上文嵌套关系。
     */
    private List<IMessage> elements;
    /**
     * 设置点击列时的交互配置。当前仅支持跳转交互。如果布局容器内有交互组件，则优先响应交互组件定义的交互。
     */
    private UrlEl action;

    @Override
    public Map<String, Object> toMessage() {
        Map<String, Object> message = new HashMap<>(9);
        message.put("tag", this.tag);
        if (null != this.backgroundStyle) {
            message.put("background_style", this.backgroundStyle);
        }
        if (null != this.width) {
            message.put("width", this.width);
        }
        if (null != this.weight) {
            message.put("weight", this.weight);
        }
        if (null != this.verticalAlign) {
            message.put("vertical_align", this.verticalAlign.getValue());
        }
        if (null != this.verticalSpacing) {
            message.put("vertical_spacing", this.verticalSpacing);
        }
        if (null != this.padding) {
            message.put("padding", this.padding);
        }
        if (null != this.elements) {
            List<Map<String, Object>> elements = new ArrayList<>(this.elements.size());
            for (IMessage element : this.elements) {
                elements.add(element.toMessage());
            }
            message.put("elements", elements);
        }
        if (null != this.action) {
            Map<String, Object> multiUrl = new HashMap<>(1);
            multiUrl.put("url", this.action.toMessage());
            message.put("action", multiUrl);
        }
        return message;
    }

    public static ColumnBuilder builder() {
        return new ColumnBuilder();
    }

    /**
     * {@link  Column} 构建器
     */
    public static class ColumnBuilder implements Builder<Column> {
        private final Column column = new Column();

        private ColumnBuilder() {
        }

        /**
         * 列的背景色样式
         *
         * @param backgroundStyle .
         * @return .
         */
        public ColumnBuilder setBackgroundStyle(String backgroundStyle) {
            this.column.setBackgroundStyle(backgroundStyle);
            return this;
        }

        /**
         * 列宽度。仅 flex_mode 为 none 时，生效此属性
         * <ul>
         *  <li>auto：列宽度与列内元素宽度一致</li>
         *  <li>weighted:列宽度按 weight 参数定义的权重分布</li>
         *  <li>具体数值，如 100px。取值范围为 [16,600]px</li>
         * </ul>
         *
         * @param width .
         * @return .
         */
        public ColumnBuilder setWidth(String width) {
            this.column.setWidth(width);
            return this;
        }

        /**
         * 当 width 字段取值为 weighted 时生效，表示当前列的宽度占比。取值范围为 1 ~ 5 之间的整数。
         *
         * @param weight .
         * @return .
         */
        public ColumnBuilder setWeight(String weight) {
            this.column.setWeight(Integer.parseInt(weight));
            return this;
        }

        /**
         * 当 width 字段取值为 weighted 时生效，表示当前列的宽度占比。取值范围为 1 ~ 5 之间的整数。
         *
         * @param weight .
         * @return .
         */
        public ColumnBuilder setWeight(Integer weight) {
            this.column.setWeight(weight);
            return this;
        }

        /**
         * 列内组件的水平对齐方式。
         *
         * @param verticalAlign .
         * @return .
         */
        public ColumnBuilder setVerticalAlign(VerticalAlign verticalAlign) {
            this.column.setVerticalAlign(verticalAlign);
            return this;
        }

        /**
         * 列内组件的纵向间距。
         * <ul>
         *  <li>default：默认间距，8px</li>
         *  <li>medium：中等间距</li>
         *  <li>large：大间距</li>
         *  <li>具体数值，如 8px。取值范围为 [0,28]px</li>
         * </ul>
         *
         * @param verticalSpacing .
         * @return .
         */
        public ColumnBuilder setVerticalSpacing(String verticalSpacing) {
            this.column.setVerticalSpacing(verticalSpacing);
            return this;
        }

        /**
         * 列的内边距。值的取值范围为 [0,28]px。
         * <p>
         * 单值，如 "10px"，表示列的四个外边距都为 10 px。<br>
         * 多值，如 "4px 12px 4px 12px"，表示列的上、右、下、左的外边距分别为 4px，12px，4px，12px。四个值必填，使用空格间隔。
         *
         * @param padding .
         * @return .
         */
        public ColumnBuilder setPadding(String padding) {
            this.column.setPadding(padding);
            return this;
        }

        /**
         * 设置列容器中内嵌的组件。可内嵌组件参考上文嵌套关系。
         *
         * @param elements .
         * @return .
         */
        public ColumnBuilder setElements(List<IMessage> elements) {
            this.column.setElements(elements);
            return this;
        }

        /**
         * 设置列容器中内嵌的组件。可内嵌组件参考上文嵌套关系。
         *
         * @param elements .
         * @return .
         */
        public ColumnBuilder setElements(IMessage... elements) {
            List<IMessage> list = new ArrayList<>(elements.length);
            list.addAll(Arrays.asList(elements));
            this.column.setElements(list);
            return this;
        }

        /**
         * 新增 列容器中内嵌的组件。可内嵌组件参考上文嵌套关系。
         *
         * @param element .
         * @return .
         */
        public ColumnBuilder addElement(IMessage element) {
            if (null == this.column.getElements()) {
                this.column.setElements(new ArrayList<>());
            }
            this.column.getElements().add(element);
            return this;
        }

        /**
         * 新增 列容器中内嵌的组件。可内嵌组件参考上文嵌套关系。
         *
         * @param elements .
         * @return .
         */
        public ColumnBuilder addElement(IMessage... elements) {
            if (null == this.column.getElements()) {
                this.column.setElements(new ArrayList<>());
            }
            for (IMessage element : elements) {
                this.column.getElements().add(element);
            }
            return this;
        }

        /**
         * 设置点击列时的交互配置。当前仅支持跳转交互。如果布局容器内有交互组件，则优先响应交互组件定义的交互。
         *
         * @param action .
         * @return .
         */
        public ColumnBuilder setAction(UrlEl action) {
            this.column.setAction(action);
            return this;
        }


        @Override
        public Column build() {
            return this.column;
        }
    }
}
