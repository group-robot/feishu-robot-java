package io.github.group.robot.feishu.core.model.card.components;

import io.github.group.robot.feishu.core.model.Builder;
import io.github.group.robot.feishu.core.model.IMessage;
import io.github.group.robot.feishu.core.model.card.components.content.SubTitle;
import io.github.group.robot.feishu.core.model.card.components.content.Title;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 卡片-展示-标题
 *
 * @author <a href="mailto:huangbing0730@gmail">hb0730</a>
 * @date 2024/7/26
 */
@Getter
@Setter
public class CardTitle implements IMessage {
    /**
     * 标题
     */
    private Title title;
    /**
     * 副标题
     */
    private SubTitle subTitle;
    /**
     * 文本标签列表
     */
    private List<TextTagList> textTagList;
    /**
     * 国际化文本标签列表
     */
    private Map<String, List<TextTagList>> i18nTextTagList;
    /**
     * 配置标题主题颜色
     */
    private String template;
    /**
     * 通过上传图片，自定义标题的前缀图标。
     */
    private Icon icon;
    /**
     * 添加图标库中已有的图标。
     */
    private UdIcon udIcon;

    @Override
    public Map<String, Object> toMessage() {
        Map<String, Object> map = new HashMap<>(1);
        map.put("title", title.toMessage());
        if (null != subTitle) {
            map.put("subtitle", subTitle.toMessage());
        }
        if (null != textTagList) {
            List<Map<String, Object>> list = new ArrayList<>(textTagList.size());
            textTagList.stream().map(TextTagList::toMessage).forEach(list::add);
            map.put("text_tag_list", list);
        }
        if (null != i18nTextTagList) {
            Map<String, List<Map<String, Object>>> i18n = new HashMap<>(i18nTextTagList.size());
            i18nTextTagList.forEach((k, v) -> {
                List<Map<String, Object>> list = new ArrayList<>(v.size());
                v.stream().map(TextTagList::toMessage).forEach(list::add);
                i18n.put(k, list);
            });
            map.put("i18n_text_tag_list", i18n);
        }

        if (null != template) {
            map.put("template", template);
        }

        if (null != icon) {
            map.put("icon", icon.toMessage());
        }

        if (null != udIcon) {
            map.put("ud_icon", udIcon.toMessage());
        }
        return map;
    }

    public static CardTitleBuilder builder() {
        return new CardTitleBuilder();
    }

    public static class CardTitleBuilder implements Builder<CardTitle> {
        private final CardTitle cardTitle = new CardTitle();

        /**
         * 设置标题
         *
         * @param title 标题
         * @return this
         */
        public CardTitleBuilder setTitle(Title title) {
            cardTitle.setTitle(title);
            return this;
        }

        /**
         * 设置副标题信息
         *
         * @param subTitle 副标题信息
         * @return this
         */
        public CardTitleBuilder setSubTitle(SubTitle subTitle) {
            cardTitle.setSubTitle(subTitle);
            return this;
        }

        /**
         * 设置文本标签列表
         *
         * @param textTagList 文本标签列表
         * @return this
         */
        public CardTitleBuilder setTextTagList(List<TextTagList> textTagList) {
            cardTitle.setTextTagList(textTagList);
            return this;
        }

        /**
         * 添加文本标签列表
         *
         * @param textTagList 文本标签列表
         * @return this
         */
        public CardTitleBuilder addTextTagList(TextTagList textTagList) {
            if (cardTitle.getTextTagList() == null) {
                cardTitle.setTextTagList(new ArrayList<>());
            }
            cardTitle.getTextTagList().add(textTagList);
            return this;
        }

        /**
         * 添加文本标签列表
         *
         * @param textTagList 文本标签列表
         * @return this
         */
        public CardTitleBuilder addTextTagList(TextTagList... textTagList) {
            if (cardTitle.getTextTagList() == null) {
                cardTitle.setTextTagList(new ArrayList<>());
            }
            for (TextTagList t : textTagList) {
                cardTitle.getTextTagList().add(t);
            }
            return this;
        }

        /**
         * 添加文本标签列表
         *
         * @param textTagList 文本标签列表
         * @return this
         */
        public CardTitleBuilder addTextTagList(List<TextTagList> textTagList) {
            if (cardTitle.getTextTagList() == null) {
                cardTitle.setTextTagList(new ArrayList<>());
            }
            cardTitle.getTextTagList().addAll(textTagList);
            return this;
        }

        /**
         * 设置国际化文本标签列表
         *
         * @param i18nTextTagList i18n文本标签列表
         * @return this
         */
        public CardTitleBuilder setI18nTextTagList(Map<String, List<TextTagList>> i18nTextTagList) {
            cardTitle.setI18nTextTagList(i18nTextTagList);
            return this;
        }

        /**
         * 设置国际化文本标签列表
         *
         * @param key             key
         * @param i18nTextTagList i18n文本标签列表
         * @return this
         */
        public CardTitleBuilder setI18nTextTagList(String key, List<TextTagList> i18nTextTagList) {
            if (cardTitle.getI18nTextTagList() == null) {
                cardTitle.setI18nTextTagList(new HashMap<>());
            }
            cardTitle.getI18nTextTagList().put(key, i18nTextTagList);
            return this;
        }

        /**
         * 设置国际化文本标签列表
         *
         * @param key             key
         * @param i18nTextTagList i18n文本标签列表
         * @return this
         */
        public CardTitleBuilder setI18nTextTagList(String key, TextTagList... i18nTextTagList) {
            if (cardTitle.getI18nTextTagList() == null) {
                cardTitle.setI18nTextTagList(new HashMap<>());
            }
            cardTitle.getI18nTextTagList().put(key, Arrays.asList(i18nTextTagList));
            return this;
        }

        /**
         * 设置国际化文本标签列表
         *
         * @param key             key
         * @param i18nTextTagList i18n文本标签列表
         * @return this
         */
        public CardTitleBuilder setI18nTextTagList(String key, TextTagList i18nTextTagList) {
            if (cardTitle.getI18nTextTagList() == null) {
                cardTitle.setI18nTextTagList(new HashMap<>());
            }
            ArrayList<TextTagList> list = new ArrayList<>();
            list.add(i18nTextTagList);
            cardTitle.getI18nTextTagList().put(key, list);
            return this;
        }

        /**
         * 添加国际化文本标签列表
         *
         * @param key             key
         * @param i18nTextTagList i18n文本标签列表
         * @return this
         */
        public CardTitleBuilder addI18nTextTagList(String key, List<TextTagList> i18nTextTagList) {
            if (cardTitle.getI18nTextTagList() == null) {
                cardTitle.setI18nTextTagList(new HashMap<>());
            }
            List<TextTagList> textTagLists = cardTitle.getI18nTextTagList().computeIfAbsent(key, k -> new ArrayList<>());
            textTagLists.addAll(i18nTextTagList);
            return this;
        }

        /**
         * 添加国际化文本标签列表
         *
         * @param key             key
         * @param i18nTextTagList i18n文本标签列表
         * @return this
         */
        public CardTitleBuilder addI18nTextTagList(String key, TextTagList... i18nTextTagList) {
            if (cardTitle.getI18nTextTagList() == null) {
                cardTitle.setI18nTextTagList(new HashMap<>());
            }
            List<TextTagList> textTagLists = cardTitle.getI18nTextTagList().computeIfAbsent(key, k -> new ArrayList<>());
            textTagLists.addAll(Arrays.asList(i18nTextTagList));
            return this;
        }

        /**
         * 添加国际化文本标签列表
         *
         * @param key             key
         * @param i18nTextTagList i18n文本标签列表
         * @return this
         */
        public CardTitleBuilder addI18nTextTagList(String key, TextTagList i18nTextTagList) {
            if (cardTitle.getI18nTextTagList() == null) {
                cardTitle.setI18nTextTagList(new HashMap<>());
            }
            List<TextTagList> textTagLists = cardTitle.getI18nTextTagList().computeIfAbsent(key, k -> new ArrayList<>());
            textTagLists.add(i18nTextTagList);
            return this;
        }

        /**
         * 设置主题色
         *
         * @param template 主题色
         * @return this
         */
        public CardTitleBuilder setTemplate(String template) {
            cardTitle.setTemplate(template);
            return this;
        }

        /**
         * 设置通过上传图片，自定义标题的前缀图标。
         *
         * @param icon 图标
         * @return this
         */
        public CardTitleBuilder setIcon(Icon icon) {
            cardTitle.setIcon(icon);
            return this;
        }

        public CardTitleBuilder setUdIcon(UdIcon udIcon) {
            cardTitle.setUdIcon(udIcon);
            return this;
        }


        @Override
        public CardTitle build() {
            return cardTitle;
        }
    }


    /**
     * 通过上传图片，自定义标题的前缀图标。
     */
    @Getter
    public static class Icon implements IMessage {
        private String imgKey;

        public Icon() {
        }

        public Icon(String imgKey) {
            this.imgKey = imgKey;
        }

        /**
         * 设置图片key
         *
         * @param imgKey 图片key
         * @return this
         */
        public Icon setImgKey(String imgKey) {
            this.imgKey = imgKey;
            return this;
        }

        @Override
        public Map<String, Object> toMessage() {
            Map<String, Object> map = new HashMap<>(1);
            map.put("img_key", imgKey);
            return map;
        }
    }

    @Getter
    public static class UdIcon implements IMessage {
        /**
         * 图标库中图标的 token
         */
        private String token;
        /**
         * 图标的颜色
         */
        private String color;

        /**
         * 设置图标库中图标的 token
         *
         * @param token 图标库中图标的 token
         * @return this
         */
        public UdIcon setToken(String token) {
            this.token = token;
            return this;
        }

        /**
         * 设置图标的颜色
         *
         * @param color 图标的颜色
         * @return this
         */
        public UdIcon setColor(String color) {
            this.color = color;
            return this;
        }


        @Override
        public Map<String, Object> toMessage() {
            Map<String, Object> map = new HashMap<>(2);
            if (token != null) {
                map.put("token", token);
            }
            if (color != null) {
                Map<String, Object> colorMap = new HashMap<>(1);
                colorMap.put("color", color);
                map.put("style", colorMap);
            }
            return map;
        }

        /**
         * 创建一个 UdIcon 对象
         *
         * @param token 图标库中图标的 token
         * @param color 图标的颜色
         * @return UdIcon 对象
         */
        public static UdIcon of(String token, String color) {
            return new UdIcon().setToken(token).setColor(color);
        }

        /**
         * 创建一个 UdIcon 对象
         *
         * @param token 图标库中图标的 token
         * @return UdIcon 对象
         */
        public static UdIcon of(String token) {
            return new UdIcon().setToken(token);
        }

        /**
         * 创建一个 UdIcon 对象
         *
         * @return UdIcon 对象
         */
        public static UdIcon of() {
            return new UdIcon();
        }
    }


}
