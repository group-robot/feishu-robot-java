package io.github.group.robot.feishu.core.model.card.components.content;

import io.github.group.robot.feishu.core.constants.CombinationMode;
import io.github.group.robot.feishu.core.model.Builder;
import io.github.group.robot.feishu.core.model.card.components.CardTag;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 卡片组件 - 展示 - 多图混排
 *
 * @author <a href="mailto:huangbing0730@gmail">hb0730</a>
 * @date 2024/8/2
 */
@Getter
@Setter
public class MultiImageLayout implements CardTag {
    private final String tag = "img_combination";

    /**
     * 多图混排的方式
     */
    private CombinationMode mode;
    /**
     * 多图混排图片的圆角半径，单位是像素（px）,取值遵循以下格式：
     * <p>
     * [0,∞]px <br>
     * [0,100]% <br>
     */
    private String cornerRadius;

    /**
     * 图片资源的 Key
     */
    private List<String> imgKeys;

    @Override
    public Map<String, Object> toMessage() {
        Map<String, Object> message = new HashMap<>(2);
        message.put("tag", tag);
        message.put("combination_mode", this.mode.getValue());
        if (cornerRadius != null) {
            message.put("corner_radius", cornerRadius);
        }
        if (imgKeys != null) {
            List<Map<String, Object>> imgKeys = new java.util.ArrayList<>(this.imgKeys.size());
            for (String imgKey : this.imgKeys) {
                Map<String, Object> imgKeyMap = new HashMap<>(1);
                imgKeyMap.put("img_key", imgKey);
                imgKeys.add(imgKeyMap);
            }
            message.put("img_list", imgKeys);
        }
        return message;
    }

    /**
     * 多图混排的构建器
     *
     * @return 构建器
     */
    public static MultiImageLayoutBuilder builder() {
        return new MultiImageLayoutBuilder();
    }

    /**
     * 多图混排的构建器
     */
    public static class MultiImageLayoutBuilder implements Builder<MultiImageLayout> {
        private final MultiImageLayout multiImageLayout;

        private MultiImageLayoutBuilder() {
            multiImageLayout = new MultiImageLayout();
        }

        /**
         * 设置多图混排的方式
         *
         * @param mode 多图混排的方式
         * @return .
         */
        public MultiImageLayoutBuilder setMode(CombinationMode mode) {
            multiImageLayout.setMode(mode);
            return this;
        }

        /**
         * 设置多图混排图片的圆角半径
         *
         * @param cornerRadius 圆角半径
         * @return .
         */
        public MultiImageLayoutBuilder setCornerRadius(String cornerRadius) {
            multiImageLayout.setCornerRadius(cornerRadius);
            return this;
        }

        /**
         * 设置图片资源的 Key
         *
         * @param imgKeys 图片资源的 Key
         * @return .
         */
        public MultiImageLayoutBuilder setImgKeys(List<String> imgKeys) {
            multiImageLayout.setImgKeys(imgKeys);
            return this;
        }

        @Override
        public MultiImageLayout build() {
            return multiImageLayout;
        }
    }
}
