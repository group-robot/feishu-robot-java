package com.hb0730.feishu.robot.core.model.interactive.components;

import com.hb0730.feishu.robot.core.model.Tag;
import com.hb0730.feishu.robot.core.constants.ActionLayout;
import com.hb0730.feishu.robot.core.model.IMessage;
import com.hb0730.feishu.robot.core.model.interactive.components.action.ActionComponent;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 交互模块
 *
 * @author bing_huang
 * @date 2021/12/16
 */
@Getter
@Setter
public class Action implements IMessage, Tag {
    private final String tag = "action";

    /**
     * create {@link  Action}
     *
     * @return {@link  Action}
     */
    public static Action build() {
        return new Action();
    }

    public Action() {
        this(new ArrayList<>());
    }

    public Action(List<ActionComponent> actions) {
        this.actions = actions;
    }

    /**
     * 放置交互元素
     */
    private List<ActionComponent> actions;

    /**
     * set Action actions
     *
     * @param actions actions
     * @return this
     */
    public Action actions(List<ActionComponent> actions) {
        this.actions = actions;
        return this;
    }

    /**
     * add Action actions
     *
     * @param action action
     * @return this
     */
    public Action addAction(ActionComponent action) {
        this.actions.add(action);
        return this;
    }

    /**
     * add Action actions
     *
     * @param actions actions
     * @return this
     */
    public Action addAction(ActionComponent... actions) {
        this.actions.addAll(Arrays.asList(actions));
        return this;
    }

    /**
     * 交互元素布局
     */
    private ActionLayout layout;

    /**
     * set Action layout
     *
     * @param layout layout
     * @return this
     */
    public Action layout(ActionLayout layout) {
        this.layout = layout;
        return this;
    }

    @Override
    public Map<String, Object> toMessage() {
        Map<String, Object> message = new HashMap<>(2);
        message.put("tag", this.tag);
        List<Map<String, Object>> actions = new ArrayList<>(this.actions.size());
        for (ActionComponent action : this.actions) {
            actions.add(action.toMessage());
        }
        message.put("actions", actions);
        if (null != layout) {
            message.put("layout", this.layout.getValue());
        }

        return message;
    }

    @Override
    public String tag() {
        return this.tag;
    }
}
