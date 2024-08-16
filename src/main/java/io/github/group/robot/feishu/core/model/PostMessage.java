package io.github.group.robot.feishu.core.model;

import io.github.group.robot.feishu.core.constants.MessageType;
import io.github.group.robot.feishu.core.model.post.Paragraph;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 富文本 <a href="https://open.feishu.cn/document/client-docs/bot-v3/add-custom-bot#f62e72d5">发送富文本消息</a>
 *
 * @author <a href="mailto:huangbing0730@gmail">hb0730</a>
 * @date 2021/12/16
 */
@Setter
@Getter
public class PostMessage extends BaseMessage {
    /**
     * 富文本内容
     */
    private List<Paragraph> content;

    /**
     * 富文本内容，json格式,高于其他属性
     * <pre>
     * "post": {
     *   "zh_cn": {}
     * }
     * </pre>
     */
    private String jsonContent;

    public PostMessage() {
        super();
    }

    /**
     * @param content 富文本内容
     */
    public PostMessage(List<Paragraph> content) {
        super();
        this.content = content;
    }

    /**
     * @param jsonContent 富文本内容，json格式
     */
    public PostMessage(String jsonContent) {
        super();
        this.jsonContent = jsonContent;
    }

    /**
     * @param zhParagraph 富文本内容,默认为zh_cn
     */
    public PostMessage(Paragraph zhParagraph) {
        super();
        this.content = new ArrayList<>();
        this.content.add(zhParagraph);
    }

    /**
     * 设置富文本内容，json格式
     *
     * @param jsonContent 富文本内容，json格式
     * @return {@link PostMessage}
     */
    public PostMessage setJsonContent(String jsonContent) {
        this.jsonContent = jsonContent;
        return this;
    }

    /**
     * 设置富文本内容
     *
     * @param content 富文本内容
     * @return {@link PostMessage}
     */
    public PostMessage setContent(List<Paragraph> content) {
        this.content = content;
        return this;
    }

    /**
     * 添加富文本消息的内容
     *
     * @param paragraph 富文本消息的内容
     * @return {@link PostMessage}
     */
    public PostMessage addContent(Paragraph paragraph) {
        if (null == this.content) {
            this.content = new ArrayList<>();
        }
        this.content.add(paragraph);
        return this;
    }

    /**
     * 添加富文本消息的内容
     *
     * @param paragraphs 富文本消息的内容
     * @return {@link PostMessage}
     */
    public PostMessage addContent(List<Paragraph> paragraphs) {
        if (null == this.content) {
            this.content = new ArrayList<>();
        }
        this.content.addAll(paragraphs);
        return this;
    }

    /**
     * 添加富文本消息的内容
     *
     * @param paragraphs 富文本消息的内容
     * @return {@link PostMessage}
     */
    public PostMessage addContent(Paragraph... paragraphs) {
        if (null == this.content) {
            this.content = new ArrayList<>();
        }
        this.content.addAll(Arrays.asList(paragraphs));
        return this;
    }


    @Override
    protected void init() {
        this.msgType = MessageType.POST;
    }

    @Override
    public Map<String, Object> toMessage() {
        Map<String, Object> message = new HashMap<>(2);
        message.put("msg_type", msgType.getValue());
        if (null != jsonContent) {
            message.put("content", this.jsonContent);
        } else {
            Map<String, Object> postContent = new HashMap<>();
            if (null != this.content) {
                for (Paragraph paragraph : this.content) {
                    postContent.putAll(paragraph.toMessage());
                }
            }
            Map<String, Object> post = new HashMap<>();
            post.put("post", postContent);

            message.put("content", post);
        }
        return message;
    }


    /**
     * 创建富文本消息
     *
     * @return {@link PostMessage}
     */
    public static PostMessage of() {
        return new PostMessage();
    }

    /**
     * 创建富文本消息
     *
     * @param content 富文本内容
     * @return {@link PostMessage}
     */
    public static PostMessage of(List<Paragraph> content) {
        return new PostMessage(content);
    }

    /**
     * 创建富文本消息
     *
     * @param jsonContent 富文本内容，json格式
     * @return {@link PostMessage}
     */
    public static PostMessage of(String jsonContent) {
        return new PostMessage(jsonContent);
    }

    /**
     * 创建富文本消息
     *
     * @param zhParagraph 富文本内容,默认为zh_cn
     * @return {@link PostMessage}
     */
    public static PostMessage of(Paragraph zhParagraph) {
        return new PostMessage(zhParagraph);
    }
}
