package com.hb0730.feishu.robot.core.model.interactive.components.action;

import com.hb0730.feishu.robot.core.constants.DatePickerTag;
import com.hb0730.feishu.robot.core.model.interactive.components.Text;
import com.hb0730.feishu.robot.core.model.interactive.components.action.ele.Confirm;
import com.hb0730.feishu.robot.core.util.JacksonUtils;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

/**
 * 交互式组件<br>
 * datePicker
 *
 * @author bing_huang
 * @date 2021/12/16
 */
@Getter
@Setter
public class DatePicker extends ActionComponent {
    /**
     * create DatePicker
     *
     * @return {@link  DatePicker}
     */
    public static DatePicker build() {
        return new DatePicker();
    }

    public DatePicker() {
        this(new HashMap<>());
    }

    public DatePicker(Map<String, Object> value) {
        this.value = value;
    }

    /**
     * 元素标签
     */
    private DatePickerTag tag;

    /**
     * set DatePricker tag
     *
     * @param tag tag
     * @return this
     */
    public DatePicker tag(DatePickerTag tag) {
        this.tag = tag;
        return this;
    }

    /**
     * 日期模式的初始值
     */
    private String initialDate;

    /**
     * set DatePricker initialDate
     *
     * @param initialDate initialDate
     * @return this
     */
    public DatePicker initialDate(String initialDate) {
        this.initialDate = initialDate;
        return this;
    }

    /**
     * 时间模式的初始值
     */
    private String initialTime;

    /**
     * set DatePricker initialTime
     *
     * @param initialTime initialTime
     * @return this
     */
    public DatePicker initialTime(String initialTime) {
        this.initialTime = initialTime;
        return this;
    }

    /**
     * 日期时间模式的初始值
     */
    private String initialDateTime;

    /**
     * set DatePicker initialDateTime
     *
     * @param initialDateTime initialDateTime
     * @return this
     */
    public DatePicker initialDateTime(String initialDateTime) {
        this.initialDateTime = initialDateTime;
        return this;
    }

    /**
     * 无初始值时必填
     */
    private Text placeholder;

    /**
     * set DatePricker  placeholder
     *
     * @param placeholder placeholder
     * @return this
     */
    public DatePicker placeholder(Text placeholder) {
        this.placeholder = placeholder;
        return this;
    }

    /**
     * 用户选定后返回业务方的数据
     */
    private Map<String, Object> value;

    /**
     * set DatePicker value
     *
     * @param value value
     * @return this
     */
    public DatePicker value(Map<String, Object> value) {
        this.value = value;
        return this;
    }

    /**
     * add DatePicker value
     *
     * @param key   key
     * @param value value
     * @return this
     */
    public DatePicker addValue(String key, Object value) {
        this.value.put(key, value);
        return this;
    }

    /**
     * 二次确认的弹框
     */
    private Confirm confirm;

    /**
     * set DatePicker confirm
     *
     * @param confirm confirm
     * @return this
     */
    public DatePicker confirm(Confirm confirm) {
        this.confirm = confirm;
        return this;
    }

    @Override
    public String tag() {
        return tag.getValue();
    }

    @Override
    public Map<String, Object> toMessage() {
        Map<String, Object> message = new HashMap<>(2);
        message.put("tag", this.tag.getValue());
        message.put("initial_date", this.initialDate);
        message.put("initial_time", this.initialTime);
        message.put("initial_datetime", this.initialDateTime);
        if (null != this.placeholder) {
            message.put("placeholder", this.placeholder.toMessage());
        }
        if (null != this.value) {
            message.put("value", JacksonUtils.X.format(this.value));
        }
        if (null != confirm) {
            message.put("confirm", this.confirm.toMessage());
        }
        return message;
    }
}
