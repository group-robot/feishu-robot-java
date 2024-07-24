package io.github.group.robot.feishu.core.model.post.tag;

import io.github.group.robot.feishu.core.model.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

/**
 * 文本标签
 *
 * @author <a href="mailto:huangbing0730@gmail">hb0730</a>
 * @date 2021/12/16
 */
@Setter
@Getter
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

    /**
     * 构建器
     *
     * @return .
     */
    public static TextTagBuilder builder() {
        return TextTagBuilder.builder();
    }

    /**
     * {@link  TextTag} 构建器
     */
    public static class TextTagBuilder implements Builder<TextTag> {
        private final TextTag textTag;

        private TextTagBuilder() {
            this.textTag = new TextTag();
        }

        /**
         * create {@link  TextTagBuilder}
         *
         * @return .
         */
        public static TextTagBuilder builder() {
            return new TextTagBuilder();
        }

        /**
         * 文本内容
         *
         * @param text .
         * @return .
         */
        public TextTagBuilder text(String text) {
            this.textTag.setText(text);
            return this;
        }

        /**
         * 换行
         * @return .
         */
        public TextTagBuilder enter() {
            this.textTag.setText(this.textTag.getText() + "\n");
            return this;
        }

        /**
         * 表示是不是 unescape 解码，默认为 false ，不用可以不填
         *
         * @param unEscape .
         * @return .
         */
        public TextTagBuilder unEscape(Boolean unEscape) {
            this.textTag.setUnEscape(unEscape);
            return this;
        }


        @Override
        public TextTag build() {
            return this.textTag;
        }
    }
}
