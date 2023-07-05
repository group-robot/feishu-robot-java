package io.github.group.robot.feishu.core.model;

import io.github.group.robot.feishu.core.constants.MessageType;
import io.github.group.robot.feishu.core.model.post.PostLang;
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
     * build
     *
     * @return {@link  PostMessage}
     */
    public static PostMessage build() {
        return new PostMessage();
    }

    public PostMessage() {
        this(new ArrayList<>());
    }

    public PostMessage(List<PostLang> lang) {
        this.lang = lang;
    }

    /**
     * 富文本语言配置
     */
    private List<PostLang> lang;

    /**
     * 富文本json字符串,优先级高于lang,格式:
     * <PRE>
     * "post": {
     * "zh_cn": {}
     * }
     * <PRE>
     */
    private String contentJsonStr;

    /**
     * 添加语言配置
     *
     * @param lang .
     * @return .
     */
    public PostMessage lang(PostLang lang) {
        this.lang.add(lang);
        return this;
    }

    /**
     * 添加语言配置
     *
     * @param lang .
     * @return .
     */
    public PostMessage lang(PostLang... lang) {
        this.lang.addAll(Arrays.asList(lang));
        return this;
    }

    /**
     * 设置语言配置
     *
     * @param langJson .
     * @return .
     */
    public PostMessage lang(String langJson) {
        this.contentJsonStr = langJson;
        return this;
    }

    @Override
    protected void init() {
        this.msgType = MessageType.POST;
    }

    @Override
    public Map<String, Object> toMessage() {

        Map<String, Object> message = new HashMap<>(2);
        message.put("msg_type", this.msgType.getValue());
        if (null != this.contentJsonStr) {
            message.put("content", this.contentJsonStr);
        } else {
            Map<String, Object> lang = new HashMap<>(this.lang.size());
            for (PostLang postLang : this.lang) {
                lang.putAll(postLang.toMessage());
            }
            Map<String, Object> post = new HashMap<>(1);
            post.put("post", lang);
            message.put("content", post);
        }
        return message;
    }
}
