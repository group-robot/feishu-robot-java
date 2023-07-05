package io.github.group.robot.feishu.core.model.post.tag;

import io.github.group.robot.feishu.core.model.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

/**
 * 富文本 a标签
 *
 * @author <a href="mailto:huangbing0730@gmail">hb0730</a>
 * @date 2021/12/16
 */
@Setter
@Getter
public class ATag extends PostTag {
    public ATag() {
        super();
    }

    public ATag(String text, String href) {
        super();
        this.text = text;
        this.href = href;
    }

    /**
     * 文本内容
     */
    private String text;
    /**
     * 默认的链接地址
     */
    private String href;

    @Override
    public String tag() {
        return "a";
    }

    @Override
    public Map<String, Object> toMessage() {
        Map<String, Object> aMap = new HashMap<>(3);
        aMap.put("tag", tag());
        aMap.put("text", this.text);
        aMap.put("href", this.href);
        return aMap;
    }

    /**
     * 构建器
     *
     * @return .
     */
    public static ATagBuilder builder() {
        return ATagBuilder.builder();
    }

    /**
     * {@link AtTag} 构建器
     */
    public static class ATagBuilder implements Builder<ATag> {
        private final ATag aTag;

        private ATagBuilder() {
            this.aTag = new ATag();
        }

        /**
         * create {@link  ATagBuilder}
         *
         * @return this
         */
        public static ATagBuilder builder() {
            return new ATagBuilder();
        }

        /**
         * 设置文本内容
         *
         * @param text .
         * @return .
         */
        public ATagBuilder text(String text) {
            this.aTag.setText(text);
            return this;
        }

        /**
         * 设置默认的链接地址
         *
         * @param href .
         * @return .
         */
        public ATagBuilder href(String href) {
            this.aTag.setHref(href);
            return this;
        }

        @Override
        public ATag build() {
            return this.aTag;
        }
    }
}
