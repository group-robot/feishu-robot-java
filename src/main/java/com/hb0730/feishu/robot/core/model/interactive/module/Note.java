package com.hb0730.feishu.robot.core.model.interactive.module;

import com.hb0730.feishu.robot.core.exception.RobotException;
import com.hb0730.feishu.robot.core.model.IMessage;
import com.hb0730.feishu.robot.core.model.interactive.components.Image;
import com.hb0730.feishu.robot.core.model.interactive.components.Text;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 备注模块
 *
 * @author bing_huang
 * @date 2021/12/16
 */
public class Note extends AbstractModule {
    private final String tag = "note";

    /**
     * create {@link  Note}
     *
     * @return {@link  Note}
     */
    public static Note build() {
        return new Note();
    }

    public Note() {
        this(new ArrayList<>());
    }

    public Note(List<IMessage> elements) {
        this.elements = elements;
    }

    /**
     * 备注信息
     */
    private List<IMessage> elements;

    /**
     * set Note elements
     *
     * @param elements elements
     * @return this
     */
    public Note elements(List<IMessage> elements) {
        this.elements = elements;
        return this;
    }

    /**
     * add Note elements
     *
     * @param elements elements
     * @return this
     */
    public Note addElement(IMessage... elements) {
        this.elements.addAll(Arrays.asList(elements));
        return this;
    }

    /**
     * add Note elements
     *
     * @param element element
     * @return this
     */
    public Note addElement(IMessage element) {
        this.elements.add(element);
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
        List<Map<String, Object>> elements = new ArrayList<>(this.elements.size());
        for (IMessage element : this.elements) {
            if (element instanceof Text || element instanceof Image) {
                elements.add(element.toMessage());
            } else {
                throw new RobotException("text对象或image元素");
            }
        }
        message.put("elements", elements);
        return message;
    }
}
