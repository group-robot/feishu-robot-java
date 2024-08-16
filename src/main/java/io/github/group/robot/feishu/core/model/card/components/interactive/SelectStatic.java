package io.github.group.robot.feishu.core.model.card.components.interactive;

import io.github.group.robot.feishu.core.constants.SelectType;
import io.github.group.robot.feishu.core.constants.TextTag;
import io.github.group.robot.feishu.core.model.Builder;
import io.github.group.robot.feishu.core.model.card.components.CardTag;
import io.github.group.robot.feishu.core.model.card.components.ele.ConfirmEl;
import io.github.group.robot.feishu.core.model.card.components.interactive.ele.SelectOption;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 卡片组件 - 交互 - 下拉选择-单选
 *
 * @author <a href="mailto:huangbing0730@gmail">hb0730</a>
 * @date 2024/8/7
 */
@Getter
@Setter
public class SelectStatic implements CardTag {
    private final String tag = "select_static";
    /**
     * 组件边框样式
     */
    private SelectType type;
    /**
     * 单选组件的唯一标识
     */
    private String name;
    /**
     * 单选组件的内容是否必选
     */
    private Boolean required;
    /**
     * 是否禁用该单选组件
     */
    private Boolean disabled;
    /**
     * 下拉选择组件的初始选项的内容
     */
    private String initialOption;
    /**
     * 下拉选择组件内的占位文本。
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
     * 下拉选择组件的选项
     */
    private List<SelectOption> options;
    /**
     * 二次确认弹窗配置
     */
    private ConfirmEl confirm;

    @Override
    public Map<String, Object> toMessage() {
        Map<String, Object> message = new java.util.HashMap<>(10);
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
        if (initialOption != null) {
            message.put("initial_option", initialOption);
        }

        if (placeholder != null) {
            Map<String, Object> map = new java.util.HashMap<>(2);
            map.put("content", placeholder);
            map.put("tag", TextTag.PLAIN_TEXT.getValue());
            message.put("placeholder", map);
        }
        if (width != null) {
            message.put("width", width);
        }
        if (options != null) {
            List<Map<String, Object>> list = new java.util.ArrayList<>(options.size());
            for (SelectOption option : options) {
                list.add(option.toMessage());
            }
            message.put("options", list);
        }
        if (confirm != null) {
            message.put("confirm", confirm.toMessage());
        }
        return message;
    }

    public static SelectStaticBuilder builder() {
        return new SelectStaticBuilder();
    }

    /**
     * 构建器
     */
    public static class SelectStaticBuilder implements Builder<SelectStatic> {
        private final SelectStatic selectStatic = new SelectStatic();

        private SelectStaticBuilder() {

        }

        /**
         * 组件边框样式
         *
         * @param type 选择器边框样式
         * @return {@link SelectStaticBuilder}
         */
        public SelectStaticBuilder setType(SelectType type) {
            selectStatic.setType(type);
            return this;
        }


        /**
         * 单选组件的唯一标识
         *
         * @param name 单选组件的唯一标识
         * @return {@link SelectStaticBuilder}
         */
        public SelectStaticBuilder setName(String name) {
            selectStatic.setName(name);
            return this;
        }

        /**
         * 单选组件的内容是否必选
         *
         * @param required 单选组件的内容是否必选
         * @return {@link SelectStaticBuilder}
         */
        public SelectStaticBuilder setRequired(Boolean required) {
            selectStatic.setRequired(required);
            return this;
        }

        /**
         * 是否禁用该单选组件
         *
         * @param disabled 是否禁用该单选组件
         * @return {@link SelectStaticBuilder}
         */
        public SelectStaticBuilder setDisabled(Boolean disabled) {
            selectStatic.setDisabled(disabled);
            return this;
        }

        /**
         * 下拉选择组件的初始选项的内容
         *
         * @param initialOption 下拉选择组件的初始选项的内容
         * @return {@link SelectStaticBuilder}
         */
        public SelectStaticBuilder setInitialOption(String initialOption) {
            selectStatic.setInitialOption(initialOption);
            return this;
        }

        /**
         * 下拉选择组件内的占位文本。
         *
         * @param placeholder 下拉选择组件内的占位文本。
         * @return {@link SelectStaticBuilder}
         */
        public SelectStaticBuilder setPlaceholder(String placeholder) {
            selectStatic.setPlaceholder(placeholder);
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
         * @return {@link SelectStaticBuilder}
         */
        public SelectStaticBuilder setWidth(String width) {
            selectStatic.setWidth(width);
            return this;
        }

        /**
         * 下拉选择组件的选项
         *
         * @param options 下拉选择组件的选项
         * @return {@link SelectStaticBuilder}
         */
        public SelectStaticBuilder setOptions(List<SelectOption> options) {
            selectStatic.setOptions(options);
            return this;
        }

        /**
         * 下拉选择组件的选项
         *
         * @param options 下拉选择组件的选项
         * @return {@link SelectStaticBuilder}
         */
        public SelectStaticBuilder setOptions(SelectOption... options) {
            selectStatic.setOptions(java.util.Arrays.asList(options));
            return this;
        }

        /**
         * 下拉选择组件的选项
         *
         * @param options 下拉选择组件的选项
         * @return {@link SelectStaticBuilder}
         */
        public SelectStaticBuilder addOption(List<SelectOption> options) {
            if (selectStatic.getOptions() == null) {
                selectStatic.setOptions(new ArrayList<>());
            }
            selectStatic.getOptions().addAll(options);
            return this;
        }

        /**
         * 下拉选择组件的选项
         *
         * @param options 下拉选择组件的选项
         * @return {@link SelectStaticBuilder}
         */
        public SelectStaticBuilder addOption(SelectOption... options) {
            if (selectStatic.getOptions() == null) {
                selectStatic.setOptions(new ArrayList<>());
            }
            selectStatic.getOptions().addAll(java.util.Arrays.asList(options));
            return this;
        }

        /**
         * 二次确认弹窗配置
         *
         * @param confirm 二次确认弹窗配置
         * @return {@link SelectStaticBuilder}
         */
        public SelectStaticBuilder setConfirm(ConfirmEl confirm) {
            selectStatic.setConfirm(confirm);
            return this;
        }

        @Override
        public SelectStatic build() {
            return selectStatic;
        }
    }
}
