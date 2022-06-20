package io.github.group.robot.feishu.core.model.interactive.components.action;

import io.github.group.robot.feishu.core.model.interactive.components.action.ele.Confirm;
import io.github.group.robot.feishu.core.model.interactive.components.action.ele.Option;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 交互式组件<br>
 * overflow 提供折叠的按钮型菜单
 *
 * @author bing_huang
 * @date 2021/12/16
 */
@Getter
@Setter
public class Overflow extends ActionComponent {
    private final String tag = "overflow";

    /**
     * create Overflow
     *
     * @return {@link  Overflow}
     */
    private static Overflow build() {
        return new Overflow();
    }

    public Overflow() {
        this(new ArrayList<>(), new HashMap<>());
    }

    public Overflow(List<Option> options, Map<String, Object> value) {
        this.options = options;
        this.value = value;
    }

    /**
     * 待选选项
     */
    private List<Option> options;

    /**
     * set Overflow options
     *
     * @param options options
     * @return this
     */
    public Overflow options(List<Option> options) {
        this.options = options;
        return this;
    }

    /**
     * add Overflow options
     *
     * @param option option
     * @return this
     */
    public Overflow addOption(Option option) {
        this.options.add(option);
        return this;
    }

    /**
     * 用户选定后返回业务方的数据
     */
    private Map<String, Object> value;

    /**
     * set Overflow value
     *
     * @param value value
     * @return this
     */
    public Overflow value(Map<String, Object> value) {
        this.value = value;
        return this;
    }

    /**
     * add Overflow value
     *
     * @param key   key
     * @param value value
     * @return this
     */
    public Overflow addValue(String key, String value) {
        this.value.put(key, value);
        return this;
    }

    /**
     * 二次确认的弹框
     */
    private Confirm confirm;

    /**
     * set Overflow confirm
     *
     * @param confirm confirm
     * @return this
     */
    public Overflow confirm(Confirm confirm) {
        this.confirm = confirm;
        return this;
    }

    @Override
    public Map<String, Object> toMessage() {
        Map<String, Object> message = new HashMap<>(2);
        message.put("tag", this.tag);
        List<Map<String, Object>> options = new ArrayList<>(this.options.size());
        for (Option option : this.options) {
            options.add(option.toMessage());
        }
        message.put("options", options);
        if (!this.value.isEmpty()) {
            message.put("value", this.value);
        }
        if (null != this.confirm) {
            message.put("confirm", this.confirm.toMessage());
        }
        return message;
    }

    @Override
    public String tag() {
        return tag;
    }
}
