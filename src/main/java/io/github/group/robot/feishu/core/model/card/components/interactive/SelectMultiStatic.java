package io.github.group.robot.feishu.core.model.card.components.interactive;

import io.github.group.robot.feishu.core.constants.SelectType;
import io.github.group.robot.feishu.core.constants.TextTag;
import io.github.group.robot.feishu.core.model.Builder;
import io.github.group.robot.feishu.core.model.card.components.CardTag;
import io.github.group.robot.feishu.core.model.card.components.interactive.ele.SelectOption;
import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * 卡片组件 - 交互 - 下拉选择-多选
 *
 * @author <a href="mailto:huangbing0730@gmail">hb0730</a>
 * @date 2024/8/7
 */
@Getter
@Setter
public class SelectMultiStatic implements CardTag {
    private final String tag = "multi_select_static";

    /**
     * 组件边框样式
     */
    private SelectType type;
    /**
     * 表单容器中组件的唯一标识
     */
    private String name;
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
     * 多选组件的选项是否必选
     */
    private Boolean required;
    /**
     * 是否禁用该多选组件
     */
    private Boolean disabled;
    /**
     * 多选组件默认选中的选项
     */
    private List<String> selectedValues;
    /**
     * 下拉选择组件的选项
     */
    private List<SelectOption> options;

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
        if (placeholder != null) {
            Map<String, Object> placeholderMap = new java.util.HashMap<>(2);
            placeholderMap.put("content", placeholder);
            placeholderMap.put("tag", TextTag.PLAIN_TEXT.getValue());
            message.put("placeholder", placeholderMap);
        }
        if (width != null) {
            message.put("width", width);
        }
        if (required != null) {
            message.put("required", required);
        }
        if (disabled != null) {
            message.put("disabled", disabled);
        }
        if (selectedValues != null) {
            message.put("selected_values", selectedValues);
        }
        if (options != null) {
            List<Map<String, Object>> options = new java.util.ArrayList<>(this.options.size());
            for (SelectOption option : this.options) {
                options.add(option.toMessage());
            }
            message.put("options", options);
        }
        return message;
    }

    public static SelectMultiStaticBuilder builder() {
        return new SelectMultiStaticBuilder();
    }

    /**
     * 构建器
     */
    public static class SelectMultiStaticBuilder implements Builder<SelectMultiStatic> {
        private final SelectMultiStatic selectMultiStatic = new SelectMultiStatic();

        private SelectMultiStaticBuilder() {
        }

        /**
         * 组件边框样式
         *
         * @param type 组件边框样式
         * @return .
         */
        public SelectMultiStaticBuilder setType(SelectType type) {
            selectMultiStatic.setType(type);
            return this;
        }

        /**
         * 表单容器中组件的唯一标识
         *
         * @param name 表单容器中组件的唯一标识
         * @return .
         */
        public SelectMultiStaticBuilder setName(String name) {
            selectMultiStatic.setName(name);
            return this;
        }

        /**
         * 用户未选择选项时，下拉选择组件内的占位文本。
         *
         * @param placeholder 用户未选择选项时，下拉选择组件内的占位文本。
         * @return .
         */
        public SelectMultiStaticBuilder setPlaceholder(String placeholder) {
            selectMultiStatic.setPlaceholder(placeholder);
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
         * @return .
         */
        public SelectMultiStaticBuilder setWidth(String width) {
            selectMultiStatic.setWidth(width);
            return this;
        }

        /**
         * 多选组件的选项是否必选
         *
         * @param required 多选组件的选项是否必选
         * @return .
         */
        public SelectMultiStaticBuilder setRequired(Boolean required) {
            selectMultiStatic.setRequired(required);
            return this;
        }

        /**
         * 是否禁用该多选组件
         *
         * @param disabled 是否禁用该多选组件
         * @return .
         */
        public SelectMultiStaticBuilder setDisabled(Boolean disabled) {
            selectMultiStatic.setDisabled(disabled);
            return this;
        }

        /**
         * 多选组件默认选中的选项
         *
         * @param selectedValues 多选组件默认选中的选项
         * @return .
         */
        public SelectMultiStaticBuilder setSelectedValues(List<String> selectedValues) {
            selectMultiStatic.setSelectedValues(selectedValues);
            return this;
        }

        /**
         * 多选组件默认选中的选项
         *
         * @param selectedValues 多选组件默认选中的选项
         * @return .
         */
        public SelectMultiStaticBuilder setSelectedValues(String... selectedValues) {
            selectMultiStatic.setSelectedValues(Arrays.asList(selectedValues));
            return this;
        }

        /**
         * 多选组件默认选中的选项
         *
         * @param selectedValues 多选组件默认选中的选项
         * @return .
         */
        public SelectMultiStaticBuilder addSelectedValues(List<String> selectedValues) {
            if (selectMultiStatic.getSelectedValues() == null) {
                selectMultiStatic.setSelectedValues(new java.util.ArrayList<>());
            }
            selectMultiStatic.getSelectedValues().addAll(selectedValues);
            return this;
        }

        /**
         * 多选组件默认选中的选项
         *
         * @param selectedValues 多选组件默认选中的选项
         * @return .
         */
        public SelectMultiStaticBuilder addSelectedValues(String... selectedValues) {
            if (selectMultiStatic.getSelectedValues() == null) {
                selectMultiStatic.setSelectedValues(new java.util.ArrayList<>());
            }
            selectMultiStatic.getSelectedValues().addAll(Arrays.asList(selectedValues));
            return this;
        }

        /**
         * 下拉选择组件的选项
         *
         * @param options 下拉选择组件的选项
         * @return .
         */
        public SelectMultiStaticBuilder setOptions(List<SelectOption> options) {
            selectMultiStatic.setOptions(options);
            return this;
        }

        /**
         * 下拉选择组件的选项
         *
         * @param options 下拉选择组件的选项
         * @return .
         */
        public SelectMultiStaticBuilder setOptions(SelectOption... options) {
            selectMultiStatic.setOptions(Arrays.asList(options));
            return this;
        }

        /**
         * 下拉选择组件的选项
         *
         * @param options 下拉选择组件的选项
         * @return .
         */
        public SelectMultiStaticBuilder addOption(List<SelectOption> options) {
            if (selectMultiStatic.getOptions() == null) {
                selectMultiStatic.setOptions(new java.util.ArrayList<>());
            }
            selectMultiStatic.getOptions().addAll(options);
            return this;
        }

        /**
         * 下拉选择组件的选项
         *
         * @param options 下拉选择组件的选项
         * @return .
         */
        public SelectMultiStaticBuilder addOption(SelectOption... options) {
            if (selectMultiStatic.getOptions() == null) {
                selectMultiStatic.setOptions(new java.util.ArrayList<>());
            }
            selectMultiStatic.getOptions().addAll(Arrays.asList(options));
            return this;
        }

        @Override
        public SelectMultiStatic build() {
            return selectMultiStatic;
        }
    }
}
