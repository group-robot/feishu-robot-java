package io.github.group.robot.feishu.core.model.post.tag;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

/**
 * 文本标签
 *
 * @author bing_huang
 * @date 2021/12/16
 */
@Setter
@Getter
@Builder
public class TextTag extends PostTag {
    /**
     * 文本内容
     */
    private String text;
    /**
     * 表示是不是 unescape 解码，默认为 false ，不用可以不填
     */
    private Boolean unEscape;

    @Override
    public String tag() {
        return "text";
    }

    @Override
    public Map<String, Object> toMessage() {
        Map<String, Object> textMap = new HashMap<>(3);
        textMap.put("tag", tag());
        textMap.put("text", this.text);
        textMap.put("un_escape", this.unEscape);
        return textMap;
    }
}
