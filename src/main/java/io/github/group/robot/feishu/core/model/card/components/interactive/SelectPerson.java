package io.github.group.robot.feishu.core.model.card.components.interactive;

import io.github.group.robot.feishu.core.constants.SelectType;
import io.github.group.robot.feishu.core.constants.TextTag;
import io.github.group.robot.feishu.core.model.Builder;
import io.github.group.robot.feishu.core.model.card.components.CardTag;
import io.github.group.robot.feishu.core.model.card.components.ele.ConfirmEl;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 卡片组件 - 交互 - 人员选择-单选
 *
 * @author <a href="mailto:huangbing0730@gmail">hb0730</a>
 * @date 2024/8/7
 */
@Getter
@Setter
public class SelectPerson implements CardTag {
    private final String tag = "select_person";
    /**
     * 组件边框样式
     */
    private SelectType type;
    /**
     * 单选组件的内容是否必选
     */
    private Boolean required;
    /**
     * 是否禁用该单选组件
     */
    private Boolean disabled;
    /**
     * 人员选择组件内的占位文本
     */
    private String placeholder;
    /**
     * 单选组件的宽度
     * <ul>
     * <li>default：默认宽度</li>
     * <li>fill：卡片最大支持宽度</li>
     * <li>[100,∞)px：自定义宽度。超出卡片宽度时将按最大支持宽度展示</li>
     * </ul>
     */
    private String width;
    /**
     * 选项值配置。按选项数组的顺序展示选项内容.
     */
    private List<String> options;
    /**
     * 二次确认弹窗配置
     */
    private ConfirmEl confirm;

    @Override
    public Map<String, Object> toMessage() {
        Map<String, Object> message = new java.util.HashMap<>(7);
        message.put("tag", tag);
        if (type != null) {
            message.put("type", type.getValue());
        }
        if (required != null) {
            message.put("required", required);
        }
        if (disabled != null) {
            message.put("disabled", disabled);
        }
        if (placeholder != null) {
            Map<String, Object> placeholderMap = new java.util.HashMap<>(2);
            placeholderMap.put("content", placeholder);
            placeholderMap.put("tag", TextTag.PLAIN_TEXT.getValue());
            message.put("placeholder", placeholderMap);
        }
        if (width != null) {
            message.put("width", width);
        }
        if (options != null) {
            List<Map<String, Object>> options = new java.util.ArrayList<>(this.options.size());
            for (String option : this.options) {
                Map<String, Object> optionMap = new java.util.HashMap<>(2);
                optionMap.put("value", option);
                options.add(optionMap);
            }
            message.put("options", options);
        }
        return message;
    }

    public static SelectPersonBuilder builder() {
        return new SelectPersonBuilder();
    }

    /**
     * 构造器
     */
    public static class SelectPersonBuilder implements Builder<SelectPerson> {
        private final SelectPerson selectPerson = new SelectPerson();

        private SelectPersonBuilder() {
        }

        /**
         * 组件边框样式
         *
         * @param type 组件边框样式
         * @return .
         */
        public SelectPersonBuilder setType(SelectType type) {
            selectPerson.setType(type);
            return this;
        }

        /**
         * 单选组件的内容是否必选
         *
         * @param required 单选组件的内容是否必选
         * @return .
         */
        public SelectPersonBuilder setRequired(Boolean required) {
            selectPerson.setRequired(required);
            return this;
        }

        /**
         * 是否禁用该单选组件
         *
         * @param disabled 是否禁用该单选组件
         * @return .
         */
        public SelectPersonBuilder setDisabled(Boolean disabled) {
            selectPerson.setDisabled(disabled);
            return this;
        }

        /**
         * 人员选择组件内的占位文本
         *
         * @param placeholder 人员选择组件内的占位文本
         * @return .
         */
        public SelectPersonBuilder setPlaceholder(String placeholder) {
            selectPerson.setPlaceholder(placeholder);
            return this;
        }

        /**
         * 单选组件的宽度
         * <ul>
         * <li>default：默认宽度</li>
         * <li>fill：卡片最大支持宽度</li>
         * <li>[100,∞)px：自定义宽度。超出卡片宽度时将按最大支持宽度展示</li>
         * </ul>
         *
         * @param width 单选组件的宽度
         * @return .
         */
        public SelectPersonBuilder setWidth(String width) {
            selectPerson.setWidth(width);
            return this;
        }

        /**
         * 选项值配置。按选项数组的顺序展示选项内容.
         *
         * @param options 选项值配置
         * @return .
         */
        public SelectPersonBuilder setOptions(List<String> options) {
            selectPerson.setOptions(options);
            return this;
        }

        /**
         * 选项值配置。按选项数组的顺序展示选项内容.
         *
         * @param options 选项值配置
         * @return .
         */
        public SelectPersonBuilder setOptions(String... options) {
            selectPerson.setOptions(java.util.Arrays.asList(options));
            return this;
        }

        /**
         * 选项值配置。按选项数组的顺序展示选项内容.
         *
         * @param options 选项值配置
         * @return .
         */
        public SelectPersonBuilder addOption(List<String> options) {
            if (selectPerson.getOptions() == null) {
                selectPerson.setOptions(new ArrayList<>());
            }
            selectPerson.getOptions().addAll(options);
            return this;
        }

        /**
         * 选项值配置。按选项数组的顺序展示选项内容.
         *
         * @param options 选项值配置
         * @return .
         */
        public SelectPersonBuilder addOption(String... options) {
            if (selectPerson.getOptions() == null) {
                selectPerson.setOptions(new ArrayList<>());
            }
            selectPerson.getOptions().addAll(java.util.Arrays.asList(options));
            return this;
        }

        /**
         * 二次确认弹窗配置
         *
         * @param confirm 二次确认弹窗配置
         * @return .
         */
        public SelectPersonBuilder setConfirm(ConfirmEl confirm) {
            selectPerson.setConfirm(confirm);
            return this;
        }

        @Override
        public SelectPerson build() {
            return selectPerson;
        }
    }
}
