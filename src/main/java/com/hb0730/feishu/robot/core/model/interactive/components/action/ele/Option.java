package com.hb0730.feishu.robot.core.model.interactive.components.action.ele;

import com.hb0730.feishu.robot.core.model.IMessage;
import com.hb0730.feishu.robot.core.model.interactive.components.Text;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

/**
 * 可内嵌交互元素<br>
 * url
 *
 * @author bing_huang
 * @date 2021/12/16
 */
@Getter
@Setter
@Builder
public class Option implements IMessage {
    /**
     * 选项显示内容，非待选人员时必填
     */
    private Text text;
    /**
     * 选项选中后返回业务方的数据
     */
    private String value;
    /**
     * *仅支持overflow，跳转指定链接，和multi_url字段互斥
     */
    private String url;
    /**
     * *仅支持overflow，跳转对应链接，和url字段互斥
     */
    private Url multiUrl;

    @Override
    public Map<String, Object> toMessage() {
        Map<String, Object> message = new HashMap<>(1);
        if (null != this.text) {
            message.put("text", this.text.toMessage());
        }
        message.put("value", this.value);
        message.put("url", this.url);
        if (null != this.multiUrl) {
            message.put("multi_url", this.multiUrl.toMessage());

        }
        return message;
    }
}
