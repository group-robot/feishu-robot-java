package io.github.group.robot.feishu.core.model.interactive.components.module;

import io.github.group.robot.feishu.core.exception.RobotException;
import io.github.group.robot.feishu.core.model.IMessage;
import io.github.group.robot.feishu.core.model.interactive.components.Field;
import io.github.group.robot.feishu.core.model.interactive.components.Image;
import io.github.group.robot.feishu.core.model.interactive.components.Text;
import io.github.group.robot.feishu.core.model.interactive.components.action.ActionComponent;
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
public class ContentModule extends AbstractModule {
    private final String tag = "div";

    /**
     * create {@link  ContentModule}
     *
     * @return {@link  ContentModule}
     */
    public static ContentModule build() {
        return new ContentModule();
    }

    public ContentModule() {
        this(new ArrayList<>());
    }

    public ContentModule(List<Field> fields) {
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
    public ContentModule text(Text text) {
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
    public ContentModule fields(List<Field> fields) {
        this.fields = fields;
        return this;
    }

    /**
     * add Content fields
     *
     * @param fields fields
     * @return this
     */
    public ContentModule addField(Field... fields) {
        this.fields.addAll(Arrays.asList(fields));
        return this;
    }

    /**
     * add Content fields
     *
     * @param field field
     * @return this
     */
    public ContentModule addField(Field field) {
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
    public ContentModule extra(IMessage extra) {
        this.extra = extra;
        return this;
    }

    @Override
    public String tag() {
        return tag;
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
