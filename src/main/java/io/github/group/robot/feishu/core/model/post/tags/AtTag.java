package io.github.group.robot.feishu.core.model.post.tags;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

/**
 * at 标签
 *
 * @author <a href="mailto:huangbing0730@gmail">hb0730</a>
 * @date 2024/8/16
 */
@Getter
@Setter
public class AtTag implements PostTag {
    private final String tag = "at";
    /**
     * 用户 ID
     */
    private String userId;
    /**
     * 用户名
     */
    private String username;
    /**
     * 是否 at 所有人
     */
    private Boolean atAll;

    /**
     * @param userId 用户 ID
     */
    public AtTag(String userId) {
        this.userId = userId;
    }

    /**
     * @param userId   用户 ID
     * @param username 用户名
     */
    public AtTag(String userId, String username) {
        this.userId = userId;
        this.username = username;
    }

    public AtTag() {
    }

    /**
     * 设置用户 ID
     *
     * @param userId 用户 ID
     * @return {@link AtTag}
     */
    public AtTag setUserId(String userId) {
        this.userId = userId;
        return this;
    }

    /**
     * 设置用户名
     *
     * @param username 用户名
     * @return {@link AtTag}
     */
    public AtTag setUsername(String username) {
        this.username = username;
        return this;
    }

    /**
     * at 所有人
     *
     * @param atAll 是否 at 所有人
     * @return {@link AtTag}
     */
    public AtTag setAtAll(Boolean atAll) {
        this.atAll = atAll;
        return this;
    }

    /**
     * at 所有人
     *
     * @return {@link AtTag}
     */
    public AtTag atAll() {
        this.atAll = true;
        return this;
    }

    @Override
    public String getTag() {
        return tag;
    }

    @Override
    public Map<String, Object> toMessage() {
        Map<String, Object> message = new HashMap<>(3);
        message.put("tag", tag);
        if (null != atAll && atAll) {
            message.put("user_id", "all");
            message.put("user_name", "所有人");
        } else {
            message.put("user_id", userId);
            if (null != username) {
                message.put("user_name", username);
            }
        }
        return message;
    }

    /**
     * 创建 at 标签
     *
     * @param userId 用户 ID
     * @return {@link AtTag}
     */
    public static AtTag of(String userId) {
        return new AtTag(userId);
    }

    /**
     * 创建 at 标签
     *
     * @param userId   用户 ID
     * @param username 用户名
     * @return {@link AtTag}
     */
    public static AtTag of(String userId, String username) {
        return new AtTag(userId, username);
    }

    /**
     * 创建 at 标签
     *
     * @return {@link AtTag}
     */
    public static AtTag of() {
        return new AtTag();
    }

}
