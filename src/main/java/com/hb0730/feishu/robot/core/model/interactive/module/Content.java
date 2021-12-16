package com.hb0730.feishu.robot.core.model.interactive.module;

import com.hb0730.feishu.robot.core.exception.RobotException;
import com.hb0730.feishu.robot.core.model.IMessage;
import com.hb0730.feishu.robot.core.model.interactive.components.Field;
import com.hb0730.feishu.robot.core.model.interactive.components.Image;
import com.hb0730.feishu.robot.core.model.interactive.components.Text;
import com.hb0730.feishu.robot.core.model.interactive.components.action.ActionComponent;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 内容模块
 *
 * @author bing_huang
 * @date 2021/12/16
 */
@Getter
@Setter
public class Content extends AbstractModule {
    /**
     * create {@link  Content}
     *
     * @return {@link  Content}
     */
    public static Content build() {
        return new Content();
    }

    public Content() {
        this(new ArrayList<>());
    }

    public Content(List<Field> fields) {
        this.fields = fields;
    }

    /**
     * 单个文本展示
     */
    private Text text;

    /**
     * set Content text
     *
     * @param text text
     * @return this
     */
    public Content text(Text text) {
        this.text = text;
        return this;
    }

    /**
     * 多个文本展示
     */
    private List<Field> fields;

    /**
     * set Content fields
     *
     * @param fields fields
     * @return this
     */
    public Content fields(List<Field> fields) {
        this.fields = fields;
        return this;
    }

    /**
     * add Content fields
     *
     * @param fields fields
     * @return this
     */
    public Content addField(Field... fields) {
        this.fields.addAll(Arrays.asList(fields));
        return this;
    }

    /**
     * add Content fields
     *
     * @param field field
     * @return this
     */
    public Content addField(Field field) {
        this.fields.add(field);
        return this;
    }

    /**
     * 附加的元素展示在文本内容右侧
     */
    private IMessage extra;

    /**
     * set Content extra
     *
     * @param extra extra
     * @return this
     */
    public Content extra(IMessage extra) {
        this.extra = extra;
        return this;
    }

    @Override
    public String tag() {
        return "div";
    }

    @Override
    public Map<String, Object> toMessage() {
        Map<String, Object> message = new HashMap<>(2);
        message.put("tag", tag());
        if (null != this.text) {
            message.put("text", this.text.toMessage());
        }
        if (!this.fields.isEmpty()) {
            List<Map<String, Object>> fields = new ArrayList<>(this.fields.size());
            for (Field field : this.fields) {
                fields.add(field.toMessage());
            }
            message.put("fields", fields);
        }
        if (null != this.extra) {
            if (this.extra instanceof Image || this.extra instanceof ActionComponent) {
                message.put("extra", this.extra.toMessage());
            } else {
                throw new RobotException("可附加的元素包括image、button、selectMenu、overflow、datePicker");
            }
        }
        return message;
    }
}
