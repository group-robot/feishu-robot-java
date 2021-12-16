package com.hb0730.feishu.robot.core.model;

import com.hb0730.feishu.robot.core.constants.MessageType;
import com.hb0730.feishu.robot.core.model.interactive.CardConfig;
import com.hb0730.feishu.robot.core.model.interactive.CardHeader;
import com.hb0730.feishu.robot.core.model.interactive.CardLink;
import com.hb0730.feishu.robot.core.model.interactive.module.AbstractModule;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 卡片
 *
 * @author bing_huang
 * @date 2021/12/16
 */
@Getter
@Setter
public class InteractiveMessage extends BaseMessage {
    public static InteractiveMessage build() {
        return new InteractiveMessage();
    }

    public InteractiveMessage() {
        this(new ArrayList<>(), new HashMap<>());
    }

    public InteractiveMessage(List<AbstractModule> elements, Map<String, List<AbstractModule>> i18nElements) {
        this.elements = elements;
        this.i18nElements = i18nElements;
    }

    /**
     * 用于描述卡片的功能属性。
     */
    private CardConfig config;

    /**
     * set InteractiveMessage config
     *
     * @param config config
     * @return this
     */
    public InteractiveMessage config(CardConfig config) {
        this.config = config;
        return this;
    }

    /**
     * 用于配置卡片标题内容。
     */
    private CardHeader header;

    /**
     * set InteractiveMessage header
     *
     * @param header header
     * @return this
     */
    public InteractiveMessage header(CardHeader header) {
        this.header = header;
        return this;
    }

    /**
     * 整个卡片跳转
     */
    private CardLink link;

    /**
     * set InteractiveMessage link
     *
     * @param link link
     * @return this
     */
    public InteractiveMessage link(CardLink link) {
        this.link = link;
        return this;
    }

    /**
     * 用于定义卡片正文内容
     */
    private List<AbstractModule> elements;

    /**
     * set InteractiveMessage elements
     *
     * @param elements elements
     * @return this
     */
    public InteractiveMessage elements(List<AbstractModule> elements) {
        this.elements = elements;
        return this;
    }

    /**
     * add InteractiveMessage elements
     *
     * @param elements elements
     * @return this
     */
    public InteractiveMessage addElements(AbstractModule... elements) {
        this.elements.addAll(Arrays.asList(elements));
        return this;
    }

    /**
     * add InteractiveMessage elements
     *
     * @param element element
     * @return this
     */
    public InteractiveMessage addElement(AbstractModule element) {
        this.elements.add(element);
        return this;
    }

    /**
     * 为卡片的正文部分定义多语言内容
     */
    private Map<String, List<AbstractModule>> i18nElements;

    /**
     * set InteractiveMessage i18nElements
     *
     * @param i18nElements i18 elements
     * @return this
     */
    public InteractiveMessage i18nElements(Map<String, List<AbstractModule>> i18nElements) {
        this.i18nElements = i18nElements;
        return this;
    }

    /**
     * add InteractiveMessage 18n elements
     *
     * @param key      key
     * @param elements elements
     * @return this
     */
    public InteractiveMessage addI18nElements(String key, List<AbstractModule> elements) {
        this.i18nElements.put(key, elements);
        return this;
    }

    @Override
    protected void init() {
        msgType = MessageType.INTERACTIVE;
    }

    @Override
    public Map<String, Object> toMessage() {
        Map<String, Object> configMessage = new HashMap<>(1);
        if (null != this.config) {
            Map<String, Object> message = this.config.toMessage();
            configMessage.put("config", message);
        }
        Map<String, Object> header = new HashMap<>(1);
        if (null != this.header) {
            Map<String, Object> message = this.header.toMessage();
            header.put("header", message);
        }
        Map<String, Object> linkMessage = new HashMap<>(1);
        if (null != this.link) {
            Map<String, Object> message = this.link.toMessage();
            linkMessage.put("card_link", message);
        }
        //elements
        Map<String, Object> elements = new HashMap<>(1);
        if (!this.elements.isEmpty()) {
            List<Map<String, Object>> el = new ArrayList<>(this.elements.size());
            for (AbstractModule element : this.elements) {
                el.add(element.toMessage());
            }
            elements.put("elements", el);
        }
        //i18n
        Map<String, Object> i18n = new HashMap<>(1);
        if (!this.i18nElements.isEmpty()) {
            Map<String, List<Map<String, Object>>> i18nMap = new HashMap<>(this.i18nElements.size());
            for (Map.Entry<String, List<AbstractModule>> entry : this.i18nElements.entrySet()) {
                List<AbstractModule> value = entry.getValue();
                if (null != value) {
                    List<Map<String, Object>> list = new ArrayList<>(value.size());
                    for (AbstractModule module : value) {
                        list.add(module.toMessage());
                    }
                    i18nMap.put(entry.getKey(), list);
                }
            }
            i18n.put("i18n_elements", i18nMap);
        }

        Map<String, Object> cardMessage = new HashMap<>();
        cardMessage.putAll(configMessage);
        cardMessage.putAll(header);
        cardMessage.putAll(i18n);
        cardMessage.putAll(linkMessage);
        cardMessage.putAll(elements);

        Map<String, Object> message = new HashMap<>();
        message.put("msg_type", msgType.getValue());
        message.put("card", cardMessage);
        return message;
    }
}
