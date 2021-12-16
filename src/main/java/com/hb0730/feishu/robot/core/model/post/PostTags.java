package com.hb0730.feishu.robot.core.model.post;

import com.hb0730.feishu.robot.core.model.tag.BaseTag;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Post tags集合
 *
 * @author bing_huang
 * @date 2021/12/16
 */
@Getter
@Setter
public class PostTags {
    /**
     * tag集合
     */
    private List<BaseTag> tags;

    /**
     * 构建 {@link  PostTags}
     *
     * @return {@link  PostTags}
     */
    public static PostTags build() {
        return new PostTags();
    }

    public PostTags() {
        this(new ArrayList<>());
    }

    public PostTags(List<BaseTag> tags) {
        this.tags = tags;
    }

    public PostTags addTags(BaseTag... postTags) {
        this.tags.addAll(Arrays.asList(postTags));
        return this;
    }

    public PostTags addTag(BaseTag postTag) {
        this.tags.add(postTag);
        return this;
    }

    /**
     * 将 tag转换成map
     *
     * @return map集合
     */
    public List<Map<String, Object>> toMessage() {
        List<Map<String, Object>> messageMap = new ArrayList<>(this.tags.size());
        for (BaseTag tag : this.tags) {
            messageMap.add(tag.toMessage());
        }
        return messageMap;
    }
}
