package io.github.group.robot.feishu.core.model.card.components.behaviors;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

/**
 * 回调
 *
 * @author <a href="mailto:huangbing0730@gmail">hb0730</a>
 * @date 2024/8/8
 */
@Getter
@Setter
public class Callback implements BehaviorType {
    private final String type = "callback";
    /**
     * 交互数据
     */
    private Map<String, Object> value;

    /**
     * 设置交互数据
     *
     * @param value 交互数据
     * @return .
     */
    public Callback setValue(Map<String, Object> value) {
        this.value = value;
        return this;
    }

    /**
     * 设置交互数据
     *
     * @param key   key
     * @param value value
     * @return .
     */
    public Callback putValue(String key, Object value) {
        if (null == this.value) {
            this.value = new HashMap<>(2);
        }
        this.value.put(key, value);
        return this;
    }

    /**
     * 设置交互数据
     *
     * @param value 交互数据
     * @return .
     */
    public Callback putValue(Map<String, Object> value) {
        if (null == this.value) {
            this.value = new HashMap<>(2);
        }
        this.value.putAll(value);
        return this;
    }

    @Override
    public Map<String, Object> toMessage() {
        Map<String, Object> message = new HashMap<>(2);
        message.put("type", type);
        if (null != value) {
            message.put("value", value);
        }
        return message;
    }

    /**
     * 创建 {@link Callback}
     *
     * @return .
     */
    public static Callback of() {
        return new Callback();
    }

    /**
     * 创建 {@link Callback}
     *
     * @param value 交互数据
     * @return .
     */
    public static Callback of(Map<String, Object> value) {
        return new Callback().setValue(value);
    }

    /**
     * 创建 {@link Callback}
     *
     * @param key   key
     * @param value value
     * @return .
     */
    public static Callback of(String key, Object value) {
        return new Callback().putValue(key, value);
    }

}
