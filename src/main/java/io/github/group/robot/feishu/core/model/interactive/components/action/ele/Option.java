package io.github.group.robot.feishu.core.model.interactive.components.action.ele;

import io.github.group.robot.feishu.core.model.Builder;
import io.github.group.robot.feishu.core.model.IMessage;
import io.github.group.robot.feishu.core.model.interactive.components.Text;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

/**
 * 卡片 > 可内嵌交互元素 >  url
 *
 * @author <a href="mailto:huangbing0730@gmail">hb0730</a>
 * @date 2021/12/16
 */
@Getter
@Setter
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

    /**
     * 构建器
     *
     * @return .
     */
    public static OptionBuilder builder() {
        return OptionBuilder.builder();
    }

    /**
     * {@link  Option} 构建器
     */
    public static class OptionBuilder implements Builder<Option> {
        private final Option option;

        private OptionBuilder() {
            this.option = new Option();
        }

        /**
         * create OptionBuilder
         *
         * @return .
         */
        public static OptionBuilder builder() {
            return new OptionBuilder();
        }

        /**
         * 选项显示内容，非待选人员时必填
         *
         * @param text .
         * @return .
         */
        public OptionBuilder text(Text text) {
            this.option.setText(text);
            return this;
        }

        /**
         * 选项选中后返回业务方的数据
         *
         * @param value .
         * @return .
         */
        public OptionBuilder value(String value) {
            this.option.setValue(value);
            return this;
        }

        /**
         * 仅支持overflow，跳转指定链接，和multi_url字段互斥
         *
         * @param url .
         * @return .
         */
        public OptionBuilder url(String url) {
            this.option.setUrl(url);
            return this;
        }

        /**
         * 仅支持overflow，跳转对应链接，和url字段互斥
         *
         * @param multiUrl .
         * @return .
         */
        public OptionBuilder multiUrl(Url multiUrl) {
            this.option.setMultiUrl(multiUrl);
            return this;
        }

        @Override
        public Option build() {
            return this.option;
        }
    }

}
