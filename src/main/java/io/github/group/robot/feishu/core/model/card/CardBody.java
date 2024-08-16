package io.github.group.robot.feishu.core.model.card;

import io.github.group.robot.feishu.core.model.IMessage;
import io.github.group.robot.feishu.core.model.card.components.CardTag;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * 卡片正文 body
 *
 * @author <a href="mailto:huangbing0730@gmail">hb0730</a>
 * @date 2024/8/8
 */
@Getter
@Setter
public class CardBody implements IMessage {
    /**
     * 卡片正文
     */
    private List<CardTag> elements;

    public CardBody() {
    }

    public CardBody(List<CardTag> elements) {
        this.elements = elements;
    }

    public CardBody(CardTag... elements) {
        this.elements = new ArrayList<>(elements.length);
        Collections.addAll(this.elements, elements);
    }

    /**
     * 添加元素
     *
     * @param elements 元素
     * @return this
     */
    public CardBody add(List<CardTag> elements) {
        if (null == this.elements) {
            this.elements = new ArrayList<>();
        }
        this.elements.addAll(elements);
        return this;
    }

    /**
     * 添加元素
     *
     * @param elements 元素
     * @return this
     */
    public CardBody add(CardTag... elements) {
        if (null == this.elements) {
            this.elements = new ArrayList<>();
        }
        Collections.addAll(this.elements, elements);
        return this;
    }

    /**
     * 设置元素
     *
     * @param elements 元素
     * @return this
     */
    public CardBody setElements(List<CardTag> elements) {
        this.elements = elements;
        return this;
    }

    /**
     * 设置元素
     *
     * @param elements 元素
     * @return this
     */
    public CardBody setElements(CardTag... elements) {
        this.elements = new ArrayList<>(elements.length);
        Collections.addAll(this.elements, elements);
        return this;
    }

    @Override
    public Map<String, Object> toMessage() {
        List<Map<String, Object>> list = new ArrayList<>(elements.size());
        for (IMessage element : elements) {
            list.add(element.toMessage());
        }
        return Collections.singletonMap("elements", list);
    }

    /**
     * 构建者
     *
     * @param elements 元素
     * @return this
     */
    public static CardBody of(List<CardTag> elements) {
        return new CardBody(elements);
    }

    /**
     * 构建者
     *
     * @param elements 元素
     * @return this
     */
    public static CardBody of(CardTag... elements) {
        return new CardBody(elements);
    }

    /**
     * 构建者
     *
     * @return this
     */
    public static CardBody of() {
        return new CardBody();
    }
}
