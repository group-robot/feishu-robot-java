package io.github.group.robot.feishu.core.model.interactive.components.module;

import io.github.group.robot.feishu.core.constants.ImgMode;
import io.github.group.robot.feishu.core.model.Builder;
import io.github.group.robot.feishu.core.model.interactive.components.Text;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

/**
 * 卡片 > 图片模块
 *
 * @author <a href="mailto:huangbing0730@gmail">hb0730</a>
 * @date 2021/12/16
 */
@Getter
@Setter
public class ImgModule extends AbstractModule {
    private final String tag = "img";
    /**
     * 图片资源
     */
    private String imgKey;
    /**
     * hover图片时弹出的Tips文案
     */
    private Text alt;
    /**
     * 图片标题
     */
    private Text title;
    /**
     * 自定义图片的最大展示宽度。
     */
    private Integer customWidth;
    /**
     * 是否展示为紧凑型的图片。
     */
    private Boolean compactWidth;
    /**
     * 图片显示模式。"crop_center"（默认值）
     */
    private ImgMode mode;
    /**
     * 点击后是否放大图片
     */
    private Boolean preview;

    @Override
    public String tag() {
        return tag;
    }

    @Override
    public Map<String, Object> toMessage() {
        Map<String, Object> message = new HashMap<>(4);
        message.put("tag", tag());
        message.put("img_key", this.imgKey);
        message.put("alt", this.alt.toMessage());
        if (null != this.title) {
            message.put("title", this.title.toMessage());
        }
        if (null != this.customWidth) {
            message.put("custom_width", this.customWidth);
        }
        if (null != this.compactWidth) {
            message.put("compact_width", this.compactWidth);
        }
        message.put("mod", this.mode == null ? ImgMode.CROP_CENTER : this.mode);
        if (null != this.preview) {
            message.put("preview", this.preview);
        }
        return message;
    }

    /**
     * 构造器
     *
     * @return .
     */
    public static ImgModuleBuilder builder() {
        return new ImgModuleBuilder();
    }

    /**
     * {@link ImgModule} 构造器
     */
    public static class ImgModuleBuilder implements Builder<ImgModule> {
        private final ImgModule imgModule;

        private ImgModuleBuilder() {
            this.imgModule = new ImgModule();
        }

        /**
         * create a new {@link ImgModuleBuilder} instance.
         *
         * @return .
         */
        public static ImgModuleBuilder builder() {
            return new ImgModuleBuilder();
        }

        /**
         * 图片资源
         *
         * @param imgKey .
         * @return .
         */
        public ImgModuleBuilder imgKey(String imgKey) {
            this.imgModule.setImgKey(imgKey);
            return this;
        }

        /**
         * hover图片时弹出的Tips文案
         *
         * @param alt .
         * @return .
         */
        public ImgModuleBuilder alt(Text alt) {
            this.imgModule.setAlt(alt);
            return this;
        }

        /**
         * 图片标题
         *
         * @param title .
         * @return .
         */
        public ImgModuleBuilder title(Text title) {
            this.imgModule.setTitle(title);
            return this;
        }

        /**
         * 自定义图片的最大展示宽度。
         *
         * @param customWidth .
         * @return .
         */
        public ImgModuleBuilder customWidth(Integer customWidth) {
            this.imgModule.setCustomWidth(customWidth);
            return this;
        }

        /**
         * 是否展示为紧凑型的图片。
         *
         * @param compactWidth .
         * @return .
         */
        public ImgModuleBuilder compactWidth(Boolean compactWidth) {
            this.imgModule.setCompactWidth(compactWidth);
            return this;
        }

        /**
         * 图片显示模式。"crop_center"（默认值）
         *
         * @param mode .
         * @return .
         */
        public ImgModuleBuilder mode(ImgMode mode) {
            this.imgModule.setMode(mode);
            return this;
        }

        /**
         * 点击后是否放大图片
         *
         * @param preview .
         * @return .
         */
        public ImgModuleBuilder preview(Boolean preview) {
            this.imgModule.setPreview(preview);
            return this;
        }

        @Override
        public ImgModule build() {
            return this.imgModule;
        }
    }
}
