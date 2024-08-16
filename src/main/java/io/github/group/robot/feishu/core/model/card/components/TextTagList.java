package io.github.group.robot.feishu.core.model.card.components;

import io.github.group.robot.feishu.core.model.Builder;
import io.github.group.robot.feishu.core.model.IMessage;
import io.github.group.robot.feishu.core.model.card.components.ele.TextEl;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

/**
 * 文本标签列表
 *
 * @author <a href="mailto:huangbing0730@gmail">hb0730</a>
 * @date 2024/7/27
 */
@Getter
@Setter
public class TextTagList implements IMessage {
    private final String tag = "text_tag";
    /**
     * 标签内容
     */
    private TextEl text;
    /**
     * 标签颜色
     */
    private String color;

    public TextTagList() {
    }

    public TextTagList(TextEl text) {
        this.text = text;
    }

    public TextTagList(TextEl text, String color) {
        this.text = text;
        this.color = color;
    }

    @Override
    public Map<String, Object> toMessage() {
        Map<String, Object> map = new java.util.HashMap<>(2);
        map.put("tag", tag);
        map.put("text", text.toMessage());
        if (color != null) {
            map.put("color", color);
        }
        return map;
    }

    public static TextTagListBuilder builder() {
        return new TextTagListBuilder();
    }

    /**
     * {@link TextTagList} 构造器
     */
    public static class TextTagListBuilder implements Builder<TextTagList> {
        private final TextTagList textTagList = new TextTagList();

        private TextTagListBuilder() {
        }

        public TextTagListBuilder setText(TextEl text) {
            this.textTagList.setText(text);
            return this;
        }

        public TextTagListBuilder setColor(String color) {
            this.textTagList.setColor(color);
            return this;
        }

        public TextTagList build() {
            return this.textTagList;
        }
    }
}
