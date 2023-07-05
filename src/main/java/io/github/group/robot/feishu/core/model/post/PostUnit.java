package io.github.group.robot.feishu.core.model.post;

import io.github.group.robot.feishu.core.model.IMessage;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 富文本每组内容
 * <code>
 * {"title:"","content":[]}
 * </code>
 *
 * @author <a href="mailto:huangbing0730@gmail">hb0730</a>
 * @date 2021/12/16
 */
@Getter
@Setter
public class PostUnit implements IMessage {
    /**
     * 创建 {@link  PostUnit}
     *
     * @return {@link  PostUnit}
     */
    public static PostUnit build() {
        return new PostUnit();
    }

    public PostUnit() {
        this(new ArrayList<>());
    }

    public PostUnit(List<PostTags> tags) {
        this.tags = tags;
    }

    /**
     * 标题
     */
    private String title;

    /**
     * set title
     *
     * @param title title
     * @return this
     */
    public PostUnit title(String title) {
        this.title = title;
        return this;
    }

    /**
     * 内容
     */
    private List<PostTags> tags;

    /**
     * 新增 tags
     *
     * @param tags tags
     * @return this
     */
    public PostUnit addTag(PostTags tags) {
        this.tags.add(tags);
        return this;
    }

    /**
     * 新增 tags
     *
     * @param tags tags
     * @return this
     */
    public PostUnit addTags(PostTags... tags) {
        this.tags.addAll(Arrays.asList(tags));
        return this;
    }

    @Override
    public Map<String, Object> toMessage() {
        List<List<Map<String, Object>>> content = new ArrayList<>(this.tags.size());
        for (PostTags tag : tags) {
            content.add(tag.toMessage());
        }
        Map<String, Object> unitMap = new HashMap<>(2);
        unitMap.put("title", this.title);
        unitMap.put("content", content);
        return unitMap;
    }
}
