package io.github.group.robot.feishu.core.model.card.components.ele;

import io.github.group.robot.feishu.core.model.IMessage;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * 边框设置
 *
 * @author <a href="mailto:huangbing0730@gmail">hb0730</a>
 * @date 2024/7/30
 */
@Getter
public class BorderEl implements IMessage {
    /**
     * 边框颜色设置
     */
    private String color;
    /**
     * 圆角设置。
     */
    private String cornerRadius;

    public BorderEl() {
    }

    public BorderEl(String color, String cornerRadius) {
        this.color = color;
        this.cornerRadius = cornerRadius;
    }

    /**
     * 设置边框颜色设置
     *
     * @param color .
     * @return .
     */
    public BorderEl setColor(String color) {
        this.color = color;
        return this;
    }

    /**
     * 设置圆角设置
     *
     * @param cornerRadius .
     * @return .
     */
    public BorderEl setCornerRadius(String cornerRadius) {
        this.cornerRadius = cornerRadius;
        return this;
    }

    @Override
    public Map<String, Object> toMessage() {
        Map<String, Object> map = new HashMap<>(2);
        if (color != null) {
            map.put("color", color);
        }
        if (cornerRadius != null) {
            map.put("corner_radius", cornerRadius);
        }
        return map;
    }

    /**
     * 构建者
     */
    public static BorderEl of() {
        return new BorderEl();
    }

    /**
     * 构建者
     *
     * @param color        边框颜色设置
     * @param cornerRadius 圆角设置
     * @return .
     */
    public static BorderEl of(String color, String cornerRadius) {
        return new BorderEl(color, cornerRadius);
    }

}
