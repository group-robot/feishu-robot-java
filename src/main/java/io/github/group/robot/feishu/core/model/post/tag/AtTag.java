package io.github.group.robot.feishu.core.model.post.tag;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

/**
 * at标签
 *
 * @author bing_huang
 * @date 2021/12/16
 */
@Getter
@Setter
@Builder
public class AtTag extends PostTag {
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
        if (this.atAll) {
            atMap.put("user_name", "所有人");
            atMap.put("user_id", "all");
        } else {
            atMap.put("user_id", this.userId);
            atMap.put("user_name", this.userName);
        }
        return atMap;
    }
}
