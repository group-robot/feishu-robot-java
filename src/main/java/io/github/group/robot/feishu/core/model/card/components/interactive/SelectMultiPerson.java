package io.github.group.robot.feishu.core.model.card.components.interactive;

import io.github.group.robot.feishu.core.constants.SelectType;
import io.github.group.robot.feishu.core.constants.TextTag;
import io.github.group.robot.feishu.core.model.Builder;
import io.github.group.robot.feishu.core.model.card.components.CardTag;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * 卡片组件 - 交互 - 人员选择-多选
 *
 * @author <a href="mailto:huangbing0730@gmail">hb0730</a>
 * @date 2024/8/7
 */
@Getter
@Setter
public class SelectMultiPerson implements CardTag {
    private final String tag = "multi_select_person";
    /**
     * 组件边框样式
     */
    private SelectType type;
    /**
     * 表单容器中组件的唯一标识
     */
    private String name;
    /**
     * 多选组件的内容是否必选
     */
    private Boolean required;
    /**
     * 是否禁用该多选组件
     */
    private Boolean disabled;
    /**
     * 用户未选择选项时，下拉选择组件内的占位文本。
     */
    private String placeholder;
    /**
     * 下拉选择组件的宽度
     * <ul>
     * <li>default：默认宽度</li>
     * <li>fill：卡片最大支持宽度</li>
     * <li>[100,∞)px：自定义宽度。超出卡片宽度时将按最大支持宽度展示</li>
     * </ul>
     */
    private String width;
    /**
     * 多选组件默认选中的选项
     */
    private List<String> selectedValues;
    /**
     * 下拉选择组件的选项
     */
    private List<String> options;

    @Override
    public Map<String, Object> toMessage() {
        Map<String, Object> message = new java.util.HashMap<>(9);
        message.put("tag", tag);
        if (type != null) {
            message.put("type", type.getValue());
        }
        if (name != null) {
            message.put("name", name);
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
        if (selectedValues != null) {
            message.put("selected_values", selectedValues);
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

    public static SelectMultiPersonBuilder builder() {
        return new SelectMultiPersonBuilder();
    }

    /**
     * 构造器
     */
    public static class SelectMultiPersonBuilder implements Builder<SelectMultiPerson> {
        private final SelectMultiPerson selectMultiPerson = new SelectMultiPerson();

        private SelectMultiPersonBuilder() {
        }

        /**
         * 组件边框样式
         *
         * @param type 组件边框样式
         * @return this
         */
        public SelectMultiPersonBuilder setType(SelectType type) {
            selectMultiPerson.setType(type);
            return this;
        }

        /**
         * 表单容器中组件的唯一标识
         *
         * @param name 表单容器中组件的唯一标识
         * @return this
         */
        public SelectMultiPersonBuilder setName(String name) {
            selectMultiPerson.setName(name);
            return this;
        }

        /**
         * 多选组件的内容是否必选
         *
         * @param required 多选组件的内容是否必选
         * @return this
         */
        public SelectMultiPersonBuilder setRequired(Boolean required) {
            selectMultiPerson.setRequired(required);
            return this;
        }

        /**
         * 是否禁用该多选组件
         *
         * @param disabled 是否禁用该多选组件
         * @return this
         */
        public SelectMultiPersonBuilder setDisabled(Boolean disabled) {
            selectMultiPerson.setDisabled(disabled);
            return this;
        }

        /**
         * 用户未选择选项时，下拉选择组件内的占位文本。
         *
         * @param placeholder 用户未选择选项时，下拉选择组件内的占位文本。
         * @return this
         */
        public SelectMultiPersonBuilder setPlaceholder(String placeholder) {
            selectMultiPerson.setPlaceholder(placeholder);
            return this;
        }

        /**
         * 下拉选择组件的宽度
         * <ul>
         * <li>default：默认宽度</li>
         * <li>fill：卡片最大支持宽度</li>
         * <li>[100,∞)px：自定义宽度。超出卡片宽度时将按最大支持宽度展示</li>
         * </ul>
         *
         * @param width 下拉选择组件的宽度
         * @return this
         */
        public SelectMultiPersonBuilder setWidth(String width) {
            selectMultiPerson.setWidth(width);
            return this;
        }

        /**
         * 多选组件默认选中的选项
         *
         * @param selectedValues 多选组件默认选中的选项
         * @return this
         */
        public SelectMultiPersonBuilder setSelectedValues(List<String> selectedValues) {
            selectMultiPerson.setSelectedValues(selectedValues);
            return this;
        }

        /**
         * 多选组件默认选中的选项
         *
         * @param selectedValues 多选组件默认选中的选项
         * @return this
         */
        public SelectMultiPersonBuilder setSelectedValues(String... selectedValues) {
            selectMultiPerson.setSelectedValues(Arrays.asList(selectedValues));
            return this;
        }

        /**
         * 多选组件默认选中的选项
         *
         * @param selectedValues 多选组件默认选中的选项
         * @return this
         */
        public SelectMultiPersonBuilder addSelectedValues(List<String> selectedValues) {
            if (selectMultiPerson.getSelectedValues() == null) {
                selectMultiPerson.setSelectedValues(new ArrayList<>());
            }
            selectMultiPerson.getSelectedValues().addAll(selectedValues);

            return this;
        }

        /**
         * 多选组件默认选中的选项
         *
         * @param selectedValues 多选组件默认选中的选项
         * @return this
         */
        public SelectMultiPersonBuilder addSelectedValues(String... selectedValues) {
            if (selectMultiPerson.getSelectedValues() == null) {
                selectMultiPerson.setSelectedValues(new ArrayList<>());
            }
            selectMultiPerson.getSelectedValues().addAll(Arrays.asList(selectedValues));

            return this;
        }

        /**
         * 下拉选择组件的选项
         *
         * @param options 下拉选择组件的选项
         * @return this
         */
        public SelectMultiPersonBuilder setOptions(List<String> options) {
            selectMultiPerson.setOptions(options);
            return this;
        }

        /**
         * 下拉选择组件的选项
         *
         * @param options 下拉选择组件的选项
         * @return this
         */
        public SelectMultiPersonBuilder setOptions(String... options) {
            selectMultiPerson.setOptions(Arrays.asList(options));
            return this;
        }

        /**
         * 下拉选择组件的选项
         *
         * @param options 下拉选择组件的选项
         * @return this
         */
        public SelectMultiPersonBuilder addOption(List<String> options) {
            if (selectMultiPerson.getOptions() == null) {
                selectMultiPerson.setOptions(new ArrayList<>());
            }
            selectMultiPerson.getOptions().addAll(options);
            return this;
        }

        /**
         * 下拉选择组件的选项
         *
         * @param options 下拉选择组件的选项
         * @return this
         */
        public SelectMultiPersonBuilder addOption(String... options) {
            if (selectMultiPerson.getOptions() == null) {
                selectMultiPerson.setOptions(new ArrayList<>());
            }
            selectMultiPerson.getOptions().addAll(Arrays.asList(options));
            return this;
        }

        @Override
        public SelectMultiPerson build() {
            return selectMultiPerson;
        }
    }
}
