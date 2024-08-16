package io.github.group.robot.feishu.core.model.card.components.content;

import io.github.group.robot.feishu.core.model.card.components.CardTag;
import lombok.Getter;

import java.util.Collections;
import java.util.Map;

/**
 * 卡片组件 - 展示 - 分割线
 *
 * @author <a href="mailto:huangbing0730@gmail">hb0730</a>
 * @date 2024/8/2
 */
@Getter
public class Hr implements CardTag {
    private final String tag = "hr";

    @Override
    public Map<String, Object> toMessage() {
        return Collections.singletonMap("tag", tag);
    }

    /**
     * 构建者
     *
     * @return this
     */
    public static Hr of() {
        return new Hr();
    }
}
