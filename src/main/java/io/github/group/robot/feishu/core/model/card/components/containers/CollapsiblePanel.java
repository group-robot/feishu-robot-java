package io.github.group.robot.feishu.core.model.card.components.containers;

import io.github.group.robot.feishu.core.model.Builder;
import io.github.group.robot.feishu.core.model.IMessage;
import io.github.group.robot.feishu.core.model.card.components.CardTag;
import io.github.group.robot.feishu.core.model.card.components.containers.ele.CollapsiblePanelHeader;
import io.github.group.robot.feishu.core.model.card.components.ele.BorderEl;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 卡片组件 - 容器 - 折叠面板
 *
 * @author <a href="mailto:huangbing0730@gmail">hb0730</a>
 * @date 2024/7/30
 */
@Getter
@Setter
public class CollapsiblePanel implements CardTag {
    private final String tag = "collapsible_panel";
    /**
     * 面板是否展开
     */
    private Boolean expanded;
    /**
     * 折叠面板的背景色，默认为透明
     *
     * @see <a href="https://open.feishu.cn/document/uAjLw4CM/ukzMukzMukzM/feishu-cards/enumerations-for-fields-related-to-color">颜色枚举值</a>
     */
    private String backgroundStyle;
    /**
     * 折叠面板的标题设置。
     */
    private CollapsiblePanelHeader header;
    /**
     * 折叠面板的边框设置
     */
    private BorderEl border;
    /**
     * 面板内元素垂直边距设置。
     */
    private String verticalSpacing;
    /**
     * 内容区的内边距。值的取值范围为 [0,28]px。支持填写单值或多值。
     * <p>
     * 单值：如 "4px"，表示组件内四个内边距都为 4px <br>
     * 多值：如 "4px 12px 4px 12px"，表示容器内上、右、下、左的内边距分别为 4px，12px，4px，12px。四个值必填，使用空格间隔 <br>
     */
    private String padding;
    /**
     * 折叠面板的内容元素
     */
    private List<IMessage> elements;

    @Override
    public Map<String, Object> toMessage() {
        Map<String, Object> message = new HashMap<>(8);
        message.put("tag", tag);
        message.put("expanded", expanded);
        if (backgroundStyle != null) {
            message.put("background_style", backgroundStyle);
        }
        if (header != null) {
            message.put("header", header.toMessage());
        }
        if (border != null) {
            message.put("border", border.toMessage());
        }
        if (verticalSpacing != null) {
            message.put("vertical_spacing", verticalSpacing);
        }
        if (padding != null) {
            message.put("padding", padding);
        }
        if (elements != null) {
            List<Map<String, Object>> elements = new ArrayList<>(this.elements.size());
            for (IMessage element : this.elements) {
                elements.add(element.toMessage());
            }
            message.put("elements", elements);
        }
        return message;
    }

    /**
     * 构建折叠面板
     *
     * @return .
     */
    public static CollapsiblePanelBuilder builder() {
        return new CollapsiblePanelBuilder();
    }

    /**
     * 构建者
     */
    public static class CollapsiblePanelBuilder implements Builder<CollapsiblePanel> {
        private final CollapsiblePanel collapsiblePanel = new CollapsiblePanel();

        private CollapsiblePanelBuilder() {
        }

        /**
         * 设置面板是否展开
         *
         * @param expanded .
         * @return .
         */
        public CollapsiblePanelBuilder setExpanded(Boolean expanded) {
            collapsiblePanel.setExpanded(expanded);
            return this;
        }

        /**
         * 设置折叠面板的背景色
         *
         * @param backgroundStyle .
         * @return .
         */
        public CollapsiblePanelBuilder setBackgroundStyle(String backgroundStyle) {
            collapsiblePanel.setBackgroundStyle(backgroundStyle);
            return this;
        }

        /**
         * 设置折叠面板的标题设置
         *
         * @param header .
         * @return .
         */
        public CollapsiblePanelBuilder setHeader(CollapsiblePanelHeader header) {
            collapsiblePanel.setHeader(header);
            return this;
        }

        /**
         * 设置折叠面板的边框设置
         *
         * @param border .
         * @return .
         */
        public CollapsiblePanelBuilder setBorder(BorderEl border) {
            collapsiblePanel.setBorder(border);
            return this;
        }

        /**
         * 设置面板内元素垂直边距设置
         *
         * @param verticalSpacing .
         * @return .
         */
        public CollapsiblePanelBuilder setVerticalSpacing(String verticalSpacing) {
            collapsiblePanel.setVerticalSpacing(verticalSpacing);
            return this;
        }

        /**
         * 设置内容区的内边距
         *
         * @param padding .
         * @return .
         */
        public CollapsiblePanelBuilder setPadding(String padding) {
            collapsiblePanel.setPadding(padding);
            return this;
        }

        /**
         * 设置折叠面板的内容元素
         *
         * @param elements .
         * @return .
         */
        public CollapsiblePanelBuilder setElements(List<IMessage> elements) {
            collapsiblePanel.setElements(elements);
            return this;
        }

        /**
         * 设置折叠面板的内容元素
         *
         * @param elements .
         * @return .
         */
        public CollapsiblePanelBuilder setElements(IMessage... elements) {
            collapsiblePanel.setElements(Arrays.asList(elements));
            return this;
        }

        /**
         * 添加折叠面板的内容元素
         *
         * @param element .
         * @return .
         */
        public CollapsiblePanelBuilder addElement(IMessage element) {
            if (collapsiblePanel.getElements() == null) {
                collapsiblePanel.setElements(new ArrayList<>());
            }
            collapsiblePanel.getElements().add(element);
            return this;
        }

        /**
         * 添加折叠面板的内容元素
         *
         * @param elements .
         * @return .
         */
        public CollapsiblePanelBuilder addElement(IMessage... elements) {
            if (collapsiblePanel.getElements() == null) {
                collapsiblePanel.setElements(new ArrayList<>());
            }
            collapsiblePanel.getElements().addAll(Arrays.asList(elements));
            return this;
        }

        /**
         * 添加折叠面板的内容元素
         *
         * @param elements .
         * @return .
         */
        public CollapsiblePanelBuilder addElement(List<IMessage> elements) {
            if (collapsiblePanel.getElements() == null) {
                collapsiblePanel.setElements(new ArrayList<>());
            }
            collapsiblePanel.getElements().addAll(elements);
            return this;
        }

        public CollapsiblePanel build() {
            return collapsiblePanel;
        }
    }


}
