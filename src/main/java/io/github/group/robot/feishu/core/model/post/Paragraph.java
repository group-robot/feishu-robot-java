package io.github.group.robot.feishu.core.model.post;

import io.github.group.robot.feishu.core.model.IMessage;
import io.github.group.robot.feishu.core.model.post.tags.PostTag;
import io.github.group.robot.feishu.core.util.MapBuilder;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * 段落
 *
 * @author <a href="mailto:huangbing0730@gmail">hb0730</a>
 * @date 2024/8/16
 */
@Getter
@Setter
public class Paragraph implements IMessage {
    /**
     * 语言。默认为 zh_cn。
     */
    private String lang = "zh_cn";
    /**
     * 富文本消息的标题。
     */
    private String title;
    /**
     * 富文本消息的内容。
     */
    private List<List<PostTag>> content;

    public Paragraph() {
    }

    public Paragraph(String title) {
        this.title = title;
    }


    public Paragraph(String lang, String title) {
        this.lang = lang;
        this.title = title;
    }

    public Paragraph setTitle(String title) {
        this.title = title;
        return this;
    }

    /**
     * 新段落
     *
     * @return .
     */
    public Paragraph newLine() {
        if (null == this.content) {
            this.content = new ArrayList<>();
        } else {
            this.content.add(new ArrayList<>());
        }
        return this;
    }

    /**
     * 设置内容,最后一个
     *
     * @param content 内容
     * @return .
     */
    public Paragraph setContent(List<List<PostTag>> content) {
        this.content = content;
        return this;
    }

    /**
     * 设置内容，最后一个
     *
     * @param content 内容
     * @return .
     */
    public Paragraph setContent(PostTag... content) {
        if (null == this.content) {
            this.content = new ArrayList<>();
        }
        List<PostTag> tags = Arrays.asList(content);
        int size = this.content.size();
        if (size > 0) {
            this.content.set(size - 1, tags);
        } else {
            this.content.set(0, tags);
        }
        return this;
    }


    /**
     * 设置内容
     *
     * @param index   索引 从0开始
     * @param content 内容
     * @return .
     */
    public Paragraph setContent(int index, List<PostTag> content) {
        if (null == this.content) {
            this.content = new ArrayList<>();
        }
        this.content.set(index, content);
        return this;
    }

    /**
     * 设置内容
     *
     * @param index   索引 从0开始
     * @param content 内容
     * @return .
     */
    public Paragraph setContent(int index, PostTag... content) {
        if (null == this.content) {
            this.content = new ArrayList<>();
        }
        this.content.set(index, Arrays.asList(content));
        return this;
    }

    /**
     * 添加标签
     *
     * @param postTags 标签
     * @return .
     */
    public Paragraph addContent(PostTag... postTags) {
        List<PostTag> tags = new ArrayList<>();
        if (null != postTags) {
            tags.addAll(Arrays.asList(postTags));
        }
        if (null == this.content) {
            this.content = new ArrayList<>();
        }
        int size = this.content.size();
        if (size > 0) {
            List<PostTag> tagList = this.content.get(size - 1);
            tagList.addAll(tags);
            this.content.set(size - 1, tagList);
        } else {
            this.content.add(tags);
        }
        return this;
    }

    /**
     * 添加标签
     *
     * @param postTags 标签
     * @return .
     */
    public Paragraph addContent(List<PostTag> postTags) {
        List<PostTag> tags = new ArrayList<>();
        if (null != postTags) {
            tags.addAll(postTags);
        }
        if (null == this.content) {
            this.content = new ArrayList<>();
        }
        int size = this.content.size();
        if (size > 0) {
            List<PostTag> tagList = this.content.get(size - 1);
            tagList.addAll(tags);
            this.content.set(size - 1, tagList);
        } else {
            this.content.add(tags);
        }
        return this;
    }

    /**
     * 添加标签
     *
     * @param index    索引 从0开始
     * @param postTags 标签
     * @return .
     */
    public Paragraph addContent(int index, PostTag... postTags) {
        List<PostTag> tags = new ArrayList<>();
        if (null != postTags) {
            tags.addAll(Arrays.asList(postTags));
        }
        if (null == this.content) {
            this.content = new ArrayList<>();
        }
        this.content.add(index, tags);
        return this;
    }

    @Override
    public Map<String, Object> toMessage() {
        List<List<Map<String, Object>>> content = new ArrayList<>();
        if (null != this.content) {
            this.content.forEach(tags -> {
                List<Map<String, Object>> tagList = new ArrayList<>();
                tags.forEach(tag -> tagList.add(tag.toMessage()));
                content.add(tagList);
            });
        }
        return MapBuilder.of(
                        this.lang, MapBuilder.of()
                                .put("title", title)
                                .put("content", content)
                                .build())
                .build();
    }

    /**
     * 创建段落
     *
     * @param title 标题
     * @return {@link Paragraph}
     */
    public static Paragraph of(String title) {
        return new Paragraph(title);
    }

    /**
     * 创建段落
     *
     * @param lang  语言
     * @param title 标题
     * @return {@link Paragraph}
     */
    public static Paragraph of(String lang, String title) {
        return new Paragraph(lang, title);
    }

    /**
     * 创建段落
     *
     * @return {@link Paragraph}
     */
    public static Paragraph of() {
        return new Paragraph();
    }
}
