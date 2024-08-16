package io.github.group.robot.feishu.core.util;

import io.github.group.robot.feishu.core.model.Builder;

import java.util.HashMap;
import java.util.Map;

/**
 * map 构建器
 *
 * @author <a href="mailto:huangbing0730@gmail">hb0730</a>
 * @date 2024/8/12
 */
public class MapBuilder implements Builder<Map<String, Object>> {
    private final Map<String, Object> message = new HashMap<>();

    /**
     * 创建一个MapBuilder
     *
     * @return MapBuilder
     */
    public static MapBuilder of() {
        return new MapBuilder();
    }

    /**
     * 创建一个MapBuilder
     *
     * @param key   key
     * @param value value
     * @return MapBuilder
     */
    public static MapBuilder of(String key, Object value) {
        return new MapBuilder().put(key, value);
    }

    /**
     * 创建一个MapBuilder
     *
     * @param map map
     * @return MapBuilder
     */
    public static MapBuilder of(Map<String, Object> map) {
        return new MapBuilder().putAll(map);
    }

    public MapBuilder put(String key, Object value) {
        message.put(key, value);
        return this;
    }

    public MapBuilder putAll(Map<String, Object> map) {
        message.putAll(map);
        return this;
    }

    public MapBuilder putIfAbsent(String key, Object value) {
        message.putIfAbsent(key, value);
        return this;
    }

    public MapBuilder remove(String key) {
        message.remove(key);
        return this;
    }

    public MapBuilder clear() {
        message.clear();
        return this;
    }

    public MapBuilder putIfNotNull(String key, Object value) {
        if (value != null) {
            message.put(key, value);
        }
        return this;
    }

    @Override
    public Map<String, Object> build() {
        return message;
    }
}
