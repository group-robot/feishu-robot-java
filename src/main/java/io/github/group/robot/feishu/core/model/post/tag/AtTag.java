package io.github.group.robot.feishu.core.model.post.tag;

import io.github.group.robot.feishu.core.model.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

/**
 * 富文本 at标签
 *
 * @author <a href="mailto:huangbing0730@gmail">hb0730</a>
 * @date 2021/12/16
 */
@Getter
@Setter
public class AtTag extends PostTag {
    public AtTag() {
        super();
    }

    /**
     * open_id
     */
    private String userId;
    /**
     * 用户姓名
     */
    private String userName;
    /**
     * 是否at全部，如果是,其他属性失效
     */
    private Boolean atAll;

    @Override
    public String tag() {
        return "at";
    }

    @Override
    public Map<String, Object> toMessage() {
        Map<String, Object> atMap = new HashMap<>(3);
        atMap.put("tag", tag());
        if (Boolean.TRUE.equals(this.atAll)) {
            atMap.put("user_name", "所有人");
            atMap.put("user_id", "all");
        } else {
            atMap.put("user_id", this.userId);
            atMap.put("user_name", this.userName);
        }
        return atMap;
    }

    /**
     * 构建器
     *
     * @return .
     */
    public static AtTagBuilder builder() {
        return AtTagBuilder.builder();
    }

    /**
     * {@link AtTag} 构建器
     */
    public static class AtTagBuilder implements Builder<AtTag> {
        private final AtTag atTag;

        private AtTagBuilder() {
            this.atTag = new AtTag();
        }

        /**
         * create {@link  AtTagBuilder}
         *
         * @return this
         */
        public static AtTagBuilder builder() {
            return new AtTagBuilder();
        }

        /**
         * 用户的 Open ID。
         *
         * @param userId .
         * @return .
         */
        public AtTagBuilder userId(String userId) {
            this.atTag.setUserId(userId);
            return this;
        }

        /**
         * 用户名称。
         *
         * @param userName .
         * @return .
         */
        public AtTagBuilder userName(String userName) {
            this.atTag.setUserName(userName);
            return this;
        }

        /**
         * 是否at全部，如果是,其他属性失效
         *
         * @param atAll .
         * @return .
         */
        public AtTagBuilder atAll(Boolean atAll) {
            this.atTag.setAtAll(atAll);
            return this;
        }

        @Override
        public AtTag build() {
            return this.atTag;
        }
    }
}
