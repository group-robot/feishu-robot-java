package com.hb0730.feishu.robot.core.model;

import com.hb0730.feishu.robot.core.constants.MessageType;
import com.hb0730.feishu.robot.core.model.post.PostLang;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 富文本
 *
 * @author bing_huang
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

    private List<PostLang> lang;

    public PostMessage lang(PostLang lang) {
        this.lang.add(lang);
        return this;
    }

    public PostMessage lang(PostLang... lang) {
        this.lang.addAll(Arrays.asList(lang));
        return this;
    }

    @Override
    protected void init() {
        this.msgType = MessageType.POST;
    }

    @Override
    public Map<String, Object> toMessage() {
        Map<String, Object> lang = new HashMap<>(this.lang.size());
        for (PostLang postLang : this.lang) {
            lang.putAll(postLang.toMessage());
        }
        Map<String, Object> post = new HashMap<>(1);
        post.put("post", lang);
        Map<String, Object> message = new HashMap<>(2);
        message.put("msg_type", this.msgType.getValue());
        message.put("content", post);
        return message;
    }
}
