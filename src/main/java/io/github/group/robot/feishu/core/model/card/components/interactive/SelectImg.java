package io.github.group.robot.feishu.core.model.card.components.interactive;

import io.github.group.robot.feishu.core.constants.ImgLayout;
import io.github.group.robot.feishu.core.constants.ImgLoadingStyle;
import io.github.group.robot.feishu.core.constants.TextTag;
import io.github.group.robot.feishu.core.model.Builder;
import io.github.group.robot.feishu.core.model.card.components.CardTag;
import io.github.group.robot.feishu.core.model.card.components.ele.ContentI18n;
import io.github.group.robot.feishu.core.model.card.components.interactive.ele.ImgOption;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 卡片组件 - 交互 - 多图选择
 *
 * @author <a href="mailto:huangbing0730@gmail">hb0730</a>
 * @date 2024/8/8
 */
@Getter
@Setter
public class SelectImg implements CardTag {
    private final String tag = "select_img";

    /**
     * 图片加载等状态时的组件风格样式
     */
    private ImgLoadingStyle style;
    /**
     * 图片是否多选
     */
    private Boolean multiSelect;
    /**
     * 图片的布局方式
     */
    private ImgLayout layout;
    /**
     * 该多图选择组件的唯一标识
     */
    private String name;
    /**
     * 图片的内容是否必选
     */
    private Boolean required;
    /**
     * 点击图片选项后是否弹窗放大图片
     */
    private Boolean canPreview;
    /**
     * 选项中图片的宽高比,默认：16:9
     * <ul>
     *  <li>1:1</li>
     *  <li>4:3</li>
     *  <li>16:9</li>
     * </ul>
     */
    private String aspectRatio;
    /**
     * 是否禁用整个选择组件
     */
    private Boolean disabled;
    /**
     * 禁用整个组件后，用户将光标悬浮在整个组件上时展示的禁用提示文案
     */
    private ContentI18n disabledTips;
    /**
     * 你可在交互事件中自定义回传参数，支持回传字符串，或 "key":"value" 构成的对象结构体。
     */
    private Object value;
    /**
     * 图片选项
     */
    private List<ImgOption> options;

    @Override
    public Map<String, Object> toMessage() {
        Map<String, Object> message = new HashMap<>(12);
        message.put("tag", tag);
        if (style != null) {
            message.put("style", style.getValue());
        }
        if (multiSelect != null) {
            message.put("multi_select", multiSelect);
        }
        if (layout != null) {
            message.put("layout", layout.getValue());
        }
        if (name != null) {
            message.put("name", name);
        }
        if (required != null) {
            message.put("required", required);
        }
        if (canPreview != null) {
            message.put("can_preview", canPreview);
        }
        if (aspectRatio != null) {
            message.put("aspect_ratio", aspectRatio);
        }
        if (disabled != null) {
            message.put("disabled", disabled);
        }
        if (disabledTips != null) {
            Map<String, Object> tips = disabledTips.toMessage();
            tips.put("tag", TextTag.PLAIN_TEXT.getValue());
            message.put("disabled_tips", tips);
        }
        if (value != null) {
            message.put("value", value);
        }
        if (options != null) {
            List<Map<String, Object>> optionList = new ArrayList<>(options.size());
            for (ImgOption option : options) {
                optionList.add(option.toMessage());
            }
            message.put("options", optionList);
        }
        return message;
    }

    public static SelectImgBuilder builder() {
        return new SelectImgBuilder();
    }

    /**
     * 构造器
     */
    public static class SelectImgBuilder implements Builder<SelectImg> {
        private final SelectImg selectImg = new SelectImg();

        private SelectImgBuilder() {
        }

        /**
         * 图片加载等状态时的组件风格样式
         *
         * @param style 图片加载等状态时的组件风格样式
         * @return this
         */
        public SelectImgBuilder setStyle(ImgLoadingStyle style) {
            selectImg.setStyle(style);
            return this;
        }

        /**
         * 图片是否多选
         *
         * @param multiSelect 图片是否多选
         * @return this
         */
        public SelectImgBuilder setMultiSelect(Boolean multiSelect) {
            selectImg.setMultiSelect(multiSelect);
            return this;
        }

        /**
         * 图片的布局方式
         *
         * @param layout 图片的布局方式
         * @return this
         */
        public SelectImgBuilder setLayout(ImgLayout layout) {
            selectImg.setLayout(layout);
            return this;
        }

        /**
         * 该多图选择组件的唯一标识
         *
         * @param name 该多图选择组件的唯一标识
         * @return this
         */
        public SelectImgBuilder setName(String name) {
            selectImg.setName(name);
            return this;
        }

        /**
         * 图片的内容是否必选
         *
         * @param required 图片的内容是否必选
         * @return this
         */
        public SelectImgBuilder setRequired(Boolean required) {
            selectImg.setRequired(required);
            return this;
        }

        /**
         * 点击图片选项后是否弹窗放大图片
         *
         * @param canPreview 点击图片选项后是否弹窗放大图片
         * @return this
         */
        public SelectImgBuilder setCanPreview(Boolean canPreview) {
            selectImg.setCanPreview(canPreview);
            return this;
        }

        /**
         * 选项中图片的宽高比,默认：16:9
         * <ul>
         *  <li>1:1</li>
         *  <li>4:3</li>
         *  <li>16:9</li>
         * </ul>
         *
         * @param aspectRatio 选项中图片的宽高比
         * @return this
         */
        public SelectImgBuilder setAspectRatio(String aspectRatio) {
            selectImg.setAspectRatio(aspectRatio);
            return this;
        }

        /**
         * 是否禁用整个选择组件
         *
         * @param disabled 是否禁用整个选择组件
         * @return this
         */
        public SelectImgBuilder setDisabled(Boolean disabled) {
            selectImg.setDisabled(disabled);
            return this;
        }

        /**
         * 禁用整个组件后，用户将光标悬浮在整个组件上时展示的禁用提示文案
         *
         * @param disabledTips 禁用整个组件后，用户将光标悬浮在整个组件上时展示的禁用提示文案
         * @return this
         */
        public SelectImgBuilder setDisabledTips(ContentI18n disabledTips) {
            selectImg.setDisabledTips(disabledTips);
            return this;
        }

        /**
         * 你可在交互事件中自定义回传参数，支持回传字符串，或 "key":"value" 构成的对象结构体。
         *
         * @param value 你可在交互事件中自定义回传参数
         * @return this
         */
        public SelectImgBuilder setValue(Object value) {
            selectImg.setValue(value);
            return this;
        }

        /**
         * 图片选项
         *
         * @param options 图片选项
         * @return this
         */
        public SelectImgBuilder setOptions(List<ImgOption> options) {
            selectImg.setOptions(options);
            return this;
        }

        /**
         * 图片选项
         *
         * @param options 图片选项
         * @return this
         */
        public SelectImgBuilder setOptions(ImgOption... options) {
            selectImg.setOptions(Arrays.asList(options));
            return this;
        }

        /**
         * 图片选项
         *
         * @param options 图片选项
         * @return this
         */
        public SelectImgBuilder setOptions(ImgOption.ImgOptionBuilder... options) {
            List<ImgOption> optionList = new ArrayList<>(options.length);
            for (ImgOption.ImgOptionBuilder option : options) {
                optionList.add(option.build());
            }
            selectImg.setOptions(optionList);
            return this;
        }

        /**
         * 图片选项
         *
         * @param options 图片选项
         * @return this
         */
        public SelectImgBuilder addOption(ImgOption.ImgOptionBuilder... options) {
            if (selectImg.getOptions() == null) {
                selectImg.setOptions(new ArrayList<>());
            }
            for (ImgOption.ImgOptionBuilder option : options) {
                selectImg.getOptions().add(option.build());
            }
            return this;
        }

        /**
         * 图片选项
         *
         * @param options 图片选项
         * @return this
         */
        public SelectImgBuilder addOption(ImgOption... options) {
            if (selectImg.getOptions() == null) {
                selectImg.setOptions(new ArrayList<>());
            }
            selectImg.getOptions().addAll(Arrays.asList(options));
            return this;
        }

        /**
         * 图片选项
         *
         * @param options 图片选项
         * @return this
         */
        public SelectImgBuilder addOption(List<ImgOption> options) {
            if (selectImg.getOptions() == null) {
                selectImg.setOptions(new ArrayList<>());
            }
            selectImg.getOptions().addAll(options);
            return this;
        }

        @Override
        public SelectImg build() {
            return selectImg;
        }
    }
}
