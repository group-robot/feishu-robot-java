package io.github.group.robot.feishu.core.model.card.components.containers;

import io.github.group.robot.feishu.core.model.Builder;
import io.github.group.robot.feishu.core.model.card.components.CardTag;
import io.github.group.robot.feishu.core.model.card.components.ele.ConfirmEl;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 卡片组件 - 容器 - 表单容器
 *
 * @author <a href="mailto:huangbing0730@gmail">hb0730</a>
 * @date 2024/7/29
 */
@Getter
@Setter
public class FormContainer implements CardTag {
    private final String tag = "form";
    /**
     * 表单容器的唯一标识
     */
    private String name;
    /**
     * 表单容器的子节点
     */
    private List<CardTag> elements;
    /**
     * 表单提交时的二次确认弹窗配置
     */
    private ConfirmEl confirm;

    @Override
    public Map<String, Object> toMessage() {
        Map<String, Object> map = new HashMap<>();
        map.put("tag", tag);
        map.put("name", name);
        if (elements != null && !elements.isEmpty()) {
            List<Map<String, Object>> elements = new java.util.ArrayList<>();
            this.elements.forEach(e -> elements.add(e.toMessage()));
            map.put("elements", elements);
        }
        if (null != confirm) {
            map.put("confirm", confirm.toMessage());
        }
        return map;
    }

    /**
     * 创建表单容器
     *
     * @return .
     */
    public static FormContainerBuilder builder() {
        return new FormContainerBuilder();
    }

    /**
     * 表单容器构建器
     */
    public static class FormContainerBuilder implements Builder<FormContainer> {
        private final FormContainer formContainer = new FormContainer();

        private FormContainerBuilder() {
        }

        /**
         * 表单容器的唯一标识
         *
         * @param name .
         * @return .
         */
        public FormContainerBuilder setName(String name) {
            formContainer.setName(name);
            return this;
        }

        /**
         * 表单容器的子节点
         *
         * @param elements .
         * @return .
         */
        public FormContainerBuilder setElements(List<CardTag> elements) {
            formContainer.setElements(elements);
            return this;
        }

        /**
         * 表单容器的子节点
         *
         * @param elements .
         * @return .
         */
        public FormContainerBuilder setElements(CardTag... elements) {
            List<CardTag> list = new ArrayList<>(elements.length);
            list.addAll(Arrays.asList(elements));
            formContainer.setElements(list);
            return this;
        }

        /**
         * 表单容器的子节点
         *
         * @param element .
         * @return .
         */
        public FormContainerBuilder addElement(CardTag element) {
            if (null == this.formContainer.getElements()) {
                this.formContainer.setElements(new ArrayList<>());
            }
            this.formContainer.getElements().add(element);
            return this;
        }

        /**
         * 表单容器的子节点
         *
         * @param elements .
         * @return .
         */
        public FormContainerBuilder addElement(CardTag... elements) {
            if (null == this.formContainer.getElements()) {
                this.formContainer.setElements(new ArrayList<>());
            }
            for (CardTag element : elements) {
                this.formContainer.getElements().add(element);
            }
            return this;
        }

        /**
         * 表单提交时的二次确认弹窗配置
         *
         * @param confirm .
         * @return .
         */
        public FormContainerBuilder setConfirm(ConfirmEl confirm) {
            formContainer.setConfirm(confirm);
            return this;
        }

        @Override
        public FormContainer build() {
            return this.formContainer;
        }
    }


}
