package io.github.group.robot.feishu.core.model.post;

import io.github.group.robot.feishu.core.model.IMessage;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

/**
 * post lang
 *
 * @author bing_huang
 * @date 2021/12/16
 */
@Setter
@Getter
@Builder
public class PostLang implements IMessage {
    /**
     * lang
     */
    private String lang;
    /**
     * unit
     */
    private PostUnit unit;

    @Override
    public Map<String, Object> toMessage() {
        Map<String, Object> map = new HashMap<>(1);
        map.put(this.lang == null ? "zh_cn" : this.lang, unit.toMessage());
        return map;
    }
}
