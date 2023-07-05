package io.github.group.robot.feishu.core.model.post;

import io.github.group.robot.feishu.core.model.Builder;
import io.github.group.robot.feishu.core.model.IMessage;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

/**
 * 富文本 lang
 * <code>
 * "zh_cn":{}
 * "en_us":{}
 * </code>
 *
 * @author <a href="mailto:huangbing0730@gmail">hb0730</a>
 * @date 2021/12/16
 */
@Setter
@Getter
public class PostLang implements IMessage {
    public PostLang() {
        super();
    }

    public PostLang(String lang, PostUnit unit) {
        this.lang = lang;
        this.unit = unit;
    }

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

    /**
     * 构造器
     *
     * @return .
     */
    public static PostLangBuilder builder() {
        return PostLangBuilder.builder();
    }

    /**
     * {@link  PostLang} 构造器
     */
    public static class PostLangBuilder implements Builder<PostLang> {
        private final PostLang postLang;

        private PostLangBuilder() {
            this.postLang = new PostLang();
        }

        /**
         * create {@link  PostLangBuilder}
         *
         * @return .
         */
        public static PostLangBuilder builder() {
            return new PostLangBuilder();
        }

        /**
         * 语言,默认 zh_cn
         *
         * @param lang .
         * @return .
         */
        public PostLangBuilder lang(String lang) {
            this.postLang.setLang(lang);
            return this;
        }

        /**
         * {@link  PostUnit} 内容单元
         *
         * @param unit .
         * @return .
         */
        public PostLangBuilder unit(PostUnit unit) {
            this.postLang.setUnit(unit);
            return this;
        }

        @Override
        public PostLang build() {
            return this.postLang;
        }
    }
}
