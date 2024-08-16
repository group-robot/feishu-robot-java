package io.github.group.robot.feishu.core.model.card.components.containers.ele;

import io.github.group.robot.feishu.core.constants.Angle;
import io.github.group.robot.feishu.core.constants.IconPosition;
import io.github.group.robot.feishu.core.constants.VerticalAlign;
import io.github.group.robot.feishu.core.model.Builder;
import io.github.group.robot.feishu.core.model.IMessage;
import io.github.group.robot.feishu.core.model.card.components.ele.ContentI18n;
import io.github.group.robot.feishu.core.model.card.components.ele.IconEl;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

/**
 * 折叠面板 - 头部
 *
 * @author <a href="mailto:huangbing0730@gmail">hb0730</a>
 * @date 2024/7/30
 */
@Getter
@Setter
public class CollapsiblePanelHeader implements IMessage {
    /**
     * 标题
     */
    private ContentI18n title;
    /**
     * 折叠面板标题区域的背景颜色设置，默认为透明色
     */
    private String backgroundColor;
    /**
     * 折叠面板标题区域的垂直对齐方式
     */
    private VerticalAlign verticalAlign;
    /**
     * 折叠面板标题区域的内边距
     * <p>
     * 单值：如 "4px"，表示组件内四个内边距都为 4px <br>
     * 多值：如 "4px 12px 4px 12px"，表示容器内上、右、下、左的内边距分别为 4px，12px，4px，12px。四个值必填，使用空格间隔 <br>
     */
    private String padding;
    /**
     * 添加图标作为标题前缀或后缀图标
     */
    private IconEl icon;
    /**
     * 图标的位置
     */
    private IconPosition iconPosition;
    /**
     * 折叠面板展开时图标旋转的角度，正值为顺时针，负值为逆时针
     * <p>
     * <ul>
     *  <li>逆时针旋转180度：-180</li>
     *  <li>逆时针旋转90度：-90</li>
     *  <li>顺时针旋转90度：90</li>
     *  <li>顺时针旋转180度：180</li>
     * </ul>
     */
    private String iconExpandedAngle;


    @Override
    public Map<String, Object> toMessage() {
        Map<String, Object> map = new HashMap<>(7);
        if (title != null) {
            map.put("title", title.toMessage());
        }
        if (backgroundColor != null) {
            map.put("background_color", backgroundColor);
        }
        if (verticalAlign != null) {
            map.put("vertical_align", verticalAlign.getValue());
        }
        if (padding != null) {
            map.put("padding", padding);
        }
        if (icon != null) {
            map.put("icon", icon.toMessage());
        }
        if (iconPosition != null) {
            map.put("icon_position", iconPosition.getValue());
        }
        if (iconExpandedAngle != null) {
            map.put("icon_expanded_angle", Integer.parseInt(iconExpandedAngle));
        }
        return map;
    }

    public static CollapsiblePanelHeaderBuilder builder() {
        return new CollapsiblePanelHeaderBuilder();
    }

    /**
     * 构建者
     */
    public static class CollapsiblePanelHeaderBuilder implements Builder<CollapsiblePanelHeader> {
        private final CollapsiblePanelHeader collapsiblePanelHeader = new CollapsiblePanelHeader();

        private CollapsiblePanelHeaderBuilder() {
        }

        /**
         * 设置标题
         *
         * @param title 标题
         * @return this
         */
        public CollapsiblePanelHeaderBuilder setTitle(ContentI18n title) {
            collapsiblePanelHeader.setTitle(title);
            return this;
        }

        /**
         * 设置背景颜色
         *
         * @param backgroundColor 背景颜色
         * @return this
         */
        public CollapsiblePanelHeaderBuilder setBackgroundColor(String backgroundColor) {
            collapsiblePanelHeader.setBackgroundColor(backgroundColor);
            return this;
        }

        /**
         * 设置垂直对齐方式
         *
         * @param verticalAlign 垂直对齐方式
         * @return this
         */
        public CollapsiblePanelHeaderBuilder setVerticalAlign(VerticalAlign verticalAlign) {
            collapsiblePanelHeader.setVerticalAlign(verticalAlign);
            return this;
        }

        /**
         * 设置内边距
         *
         * @param padding 内边距
         * @return this
         */
        public CollapsiblePanelHeaderBuilder setPadding(String padding) {
            collapsiblePanelHeader.setPadding(padding);
            return this;
        }

        /**
         * 设置图标
         *
         * @param icon 图标
         * @return this
         */
        public CollapsiblePanelHeaderBuilder setIcon(IconEl icon) {
            collapsiblePanelHeader.setIcon(icon);
            return this;
        }

        /**
         * 设置图标位置
         *
         * @param iconPosition 图标位置
         * @return this
         */
        public CollapsiblePanelHeaderBuilder setIconPosition(IconPosition iconPosition) {
            collapsiblePanelHeader.setIconPosition(iconPosition);
            return this;
        }

        /**
         * 设置展开时图标旋转的角度
         *
         * @param iconExpandedAngle 展开时图标旋转的角度
         * @return this
         */
        public CollapsiblePanelHeaderBuilder setIconExpandedAngle(String iconExpandedAngle) {
            collapsiblePanelHeader.setIconExpandedAngle(iconExpandedAngle);
            return this;
        }

        /**
         * 设置展开时图标旋转的角度
         *
         * @param angle 展开时图标旋转的角度
         * @return this
         */
        public CollapsiblePanelHeaderBuilder setIconExpandedAngle(Angle angle) {
            collapsiblePanelHeader.setIconExpandedAngle(angle.getValue());
            return this;
        }

        public CollapsiblePanelHeader build() {
            return collapsiblePanelHeader;
        }
    }
}
