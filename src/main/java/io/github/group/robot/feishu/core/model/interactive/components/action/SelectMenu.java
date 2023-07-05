package io.github.group.robot.feishu.core.model.interactive.components.action;

import io.github.group.robot.feishu.core.constants.SelectMenuTag;
import io.github.group.robot.feishu.core.model.interactive.components.Text;
import io.github.group.robot.feishu.core.model.interactive.components.action.ele.Confirm;
import io.github.group.robot.feishu.core.model.interactive.components.action.ele.Option;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 卡片 > 交互式组件 > button
 *
 * @author <a href="mailto:huangbing0730@gmail">hb0730</a>
 * @date 2021/12/16
 */
@Getter
@Setter
public class SelectMenu extends ActionComponent {
    /**
     * create {@link  SelectMenu}
     *
     * @return {@link  SelectMenu}
     */
    public static SelectMenu build() {
        return new SelectMenu();
    }

    public SelectMenu() {
        this(new ArrayList<>(), new HashMap<>());
    }

    public SelectMenu(List<Option> options, Map<String, Object> value) {
        this.options = options;
        this.value = value;
    }

    /**
     * 元素标签
     */
    private SelectMenuTag tag;

    /**
     * set selectMenu tag
     *
     * @param tag tag
     * @return this
     */
    public SelectMenu tag(SelectMenuTag tag) {
        this.tag = tag;
        return this;
    }

    /**
     * 占位符
     */
    private Text placeholder;

    /**
     * set SelectMenu placeholder
     *
     * @param placeholder placeholder
     * @return this
     */
    public SelectMenu placeholder(Text placeholder) {
        this.placeholder = placeholder;
        return this;
    }

    /**
     * 默认选项的value字段值
     */
    private String initialOption;

    /**
     * set SelectMenu initialOption
     *
     * @param initialOption initialOption
     * @return this
     */
    public SelectMenu initialOption(String initialOption) {
        this.initialOption = initialOption;
        return this;
    }

    /**
     * 待选选项
     */
    private List<Option> options;

    /**
     * set SelectMenu options
     *
     * @param options options
     * @return this
     */
    public SelectMenu options(List<Option> options) {
        this.options = options;
        return this;
    }

    /**
     * add SelectMenu options
     *
     * @param option option
     * @return this
     */
    public SelectMenu addOption(Option option) {
        this.options.add(option);
        return this;
    }

    /**
     * 用户选定后返回业务方的数据
     */
    private Map<String, Object> value;

    /**
     * set SelectMenu value
     *
     * @param value value
     * @return this
     */
    public SelectMenu value(Map<String, Object> value) {
        this.value = value;
        return this;
    }

    /**
     * add SelectMenu value
     *
     * @param key   key
     * @param value value
     * @return this
     */
    public SelectMenu addValue(String key, Object value) {
        this.value.put(key, value);
        return this;
    }

    /**
     * 二次确认的弹框
     */
    private Confirm confirm;

    /**
     * set SelectMenu confirm
     *
     * @param confirm confirm
     * @return this
     */
    public SelectMenu confirm(Confirm confirm) {
        this.confirm = confirm;
        return this;
    }

    @Override
    public Map<String, Object> toMessage() {
        Map<String, Object> message = new HashMap<>(2);
        message.put("tag", this.tag.getValue());
        if (null != this.placeholder) {
            message.put("placeholder", this.placeholder.toMessage());
        }
        message.put("initial_option", this.initialOption);
        if (!options.isEmpty()) {
            List<Map<String, Object>> options = new ArrayList<>(this.options.size());
            for (Option option : this.options) {
                options.add(option.toMessage());
            }
            message.put("options", options);
        }
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
        return tag.getValue();
    }
}
