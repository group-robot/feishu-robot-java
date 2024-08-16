package io.github.group.robot.feishu.core.model.card.components.interactive;

import io.github.group.robot.feishu.core.model.Builder;
import io.github.group.robot.feishu.core.model.card.components.CardTag;
import io.github.group.robot.feishu.core.model.card.components.ele.ConfirmEl;
import io.github.group.robot.feishu.core.model.card.components.interactive.ele.ButtonOverflowOption;
import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 卡片组件 - 交互 - 折叠按钮组
 *
 * @author <a href="mailto:huangbing0730@gmail">hb0730</a>
 * @date 2024/8/7
 */
@Getter
@Setter
public class ButtonOverflow implements CardTag {
    private final String tag = "overflow";
    /**
     * 按钮的宽度
     * <ul>
     * <li>default：默认宽度</li>
     * <li>fill：卡片最大支持宽度</li>
     * <li>[100,∞)px：自定义宽度。如 120px。超出卡片宽度时将按最大支持宽度展示</li>
     * </ul>
     */
    private String width;
    /**
     * 折叠按钮组当中的选项按钮。
     */
    private List<ButtonOverflowOption> options;
    /**
     * 组件整体的回调数据。该字段值仅支持 key-value 形式的 JSON 结构，且 key 为 String 类型。
     */
    private Map<String, Object> value;
    /**
     * 二次确认弹窗配置。
     */
    private ConfirmEl confirm;

    @Override
    public Map<String, Object> toMessage() {
        Map<String, Object> message = new java.util.HashMap<>(4);
        message.put("tag", tag);
        if (width != null) {
            message.put("width", width);
        }
        if (options != null) {
            List<Map<String, Object>> options = new java.util.ArrayList<>(this.options.size());
            for (ButtonOverflowOption buttonOverflowOption : this.options) {
                options.add(buttonOverflowOption.toMessage());
            }
            message.put("options", options);
        }
        if (value != null) {
            message.put("value", value);
        }
        if (confirm != null) {
            message.put("confirm", confirm.toMessage());
        }
        return message;
    }

    /**
     * 构造器
     *
     * @return .
     */
    public static ButtonBuilderOverflow builder() {
        return new ButtonBuilderOverflow();
    }

    /**
     * 构造器
     */
    public static class ButtonBuilderOverflow implements Builder<ButtonOverflow> {
        private final ButtonOverflow buttonOverflow = new ButtonOverflow();

        private ButtonBuilderOverflow() {
        }

        /**
         * 按钮的宽度
         * <ul>
         * <li>default：默认宽度</li>
         * <li>fill：卡片最大支持宽度</li>
         * <li>[100,∞)px：自定义宽度。如 120px。超出卡片宽度时将按最大支持宽度展示</li>
         * </ul>
         *
         * @param width 按钮的宽度
         * @return .
         */
        public ButtonBuilderOverflow setWidth(String width) {
            buttonOverflow.setWidth(width);
            return this;
        }

        /**
         * 折叠按钮组当中的选项按钮。
         *
         * @param option 折叠按钮组当中的选项按钮。
         * @return .
         */
        public ButtonBuilderOverflow setOption(List<ButtonOverflowOption> option) {
            buttonOverflow.setOptions(option);
            return this;
        }

        /**
         * 折叠按钮组当中的选项按钮。
         *
         * @param option 折叠按钮组当中的选项按钮。
         * @return .
         */
        public ButtonBuilderOverflow setOption(ButtonOverflowOption... option) {
            buttonOverflow.setOptions(Arrays.asList(option));
            return this;
        }

        /**
         * 折叠按钮组当中的选项按钮。
         *
         * @param option 折叠按钮组当中的选项按钮。
         * @return .
         */
        public ButtonBuilderOverflow setOption(ButtonOverflowOption.OverflowButtonOptionBuilder... option) {
            List<ButtonOverflowOption> options = new java.util.ArrayList<>(option.length);
            for (ButtonOverflowOption.OverflowButtonOptionBuilder overflowButtonOptionBuilder : option) {
                options.add(overflowButtonOptionBuilder.build());
            }
            buttonOverflow.setOptions(options);
            return this;
        }

        /**
         * 折叠按钮组当中的选项按钮。
         *
         * @param option 折叠按钮组当中的选项按钮。
         * @return .
         */
        public ButtonBuilderOverflow addOption(List<ButtonOverflowOption> option) {
            if (buttonOverflow.getOptions() == null) {
                buttonOverflow.setOptions(new java.util.ArrayList<>());
            }
            buttonOverflow.getOptions().addAll(option);

            return this;
        }

        /**
         * 折叠按钮组当中的选项按钮。
         *
         * @param option 折叠按钮组当中的选项按钮。
         * @return .
         */
        public ButtonBuilderOverflow addOption(ButtonOverflowOption... option) {
            if (buttonOverflow.getOptions() == null) {
                buttonOverflow.setOptions(new java.util.ArrayList<>());
            }
            buttonOverflow.getOptions().addAll(Arrays.asList(option));

            return this;
        }

        /**
         * 折叠按钮组当中的选项按钮。
         *
         * @param option 折叠按钮组当中的选项按钮。
         * @return .
         */
        public ButtonBuilderOverflow addOption(ButtonOverflowOption.OverflowButtonOptionBuilder... option) {
            List<ButtonOverflowOption> options = new java.util.ArrayList<>(option.length);
            for (ButtonOverflowOption.OverflowButtonOptionBuilder overflowButtonOptionBuilder : option) {
                options.add(overflowButtonOptionBuilder.build());
            }
            if (buttonOverflow.getOptions() == null) {
                buttonOverflow.setOptions(new java.util.ArrayList<>());
            }
            buttonOverflow.getOptions().addAll(options);
            return this;
        }

        /**
         * 组件整体的回调数据。该字段值仅支持 key-value 形式的 JSON 结构，且 key 为 String 类型。
         *
         * @param value 组件整体的回调数据。该字段值仅支持 key-value 形式的 JSON 结构，且 key 为 String 类型。
         * @return .
         */
        public ButtonBuilderOverflow setValue(Map<String, Object> value) {
            buttonOverflow.setValue(value);
            return this;
        }

        /**
         * 组件整体的回调数据。该字段值仅支持 key-value 形式的 JSON 结构，且 key 为 String 类型。
         *
         * @param key   key
         * @param value value
         * @return .
         */
        public ButtonBuilderOverflow setValue(String key, Object value) {
            Map<String, Object> valueMap = new HashMap<>();
            valueMap.put(key, value);
            buttonOverflow.setValue(valueMap);
            return this;
        }

        /**
         * 组件整体的回调数据。该字段值仅支持 key-value 形式的 JSON 结构，且 key 为 String 类型。
         *
         * @param value 组件整体的回调数据。该字段值仅支持 key-value 形式的 JSON 结构，且 key 为 String 类型。
         * @return .
         */
        public ButtonBuilderOverflow putValue(Map<String, Object> value) {
            if (buttonOverflow.getValue() == null) {
                buttonOverflow.setValue(new java.util.HashMap<>());
            }
            buttonOverflow.getValue().putAll(value);
            return this;
        }

        /**
         * 组件整体的回调数据。该字段值仅支持 key-value 形式的 JSON 结构，且 key 为 String 类型。
         *
         * @param key   key
         * @param value value
         * @return .
         */
        public ButtonBuilderOverflow putValue(String key, Object value) {
            if (buttonOverflow.getValue() == null) {
                buttonOverflow.setValue(new java.util.HashMap<>());
            }
            buttonOverflow.getValue().put(key, value);
            return this;
        }


        /**
         * 二次确认弹窗配置。
         *
         * @param confirm 二次确认弹窗配置。
         * @return .
         */
        public ButtonBuilderOverflow setConfirm(ConfirmEl confirm) {
            buttonOverflow.setConfirm(confirm);
            return this;
        }

        @Override
        public ButtonOverflow build() {
            return buttonOverflow;
        }
    }

}
