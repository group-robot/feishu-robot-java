package io.github.group.robot.feishu.core.model.card.components.ele;

import io.github.group.robot.feishu.core.model.Builder;
import io.github.group.robot.feishu.core.model.IMessage;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

/**
 * 卡片 > 可内嵌交互元素 > url
 *
 * @author <a href="mailto:huangbing0730@gmail">hb0730</a>
 * @date 2021/12/16
 */
@Getter
@Setter
public class UrlEl implements IMessage {
    /**
     * create {@link  UrlEl}
     */
    public UrlEl() {
    }

    /**
     * create {@link  UrlEl}
     *
     * @param url        默认的链接地址
     * @param androidUrl Android 端的链接地址
     * @param iosUrl     iOS 端的链接地址
     * @param pcUrl      PC 端的链接地址
     */
    public UrlEl(String url, String androidUrl, String iosUrl, String pcUrl) {
        this.url = url;
        this.androidUrl = androidUrl;
        this.iosUrl = iosUrl;
        this.pcUrl = pcUrl;
    }

    /**
     * 默认的链接地址
     */
    private String url;
    /**
     * Android 端的链接地址
     */
    private String androidUrl;
    /**
     * iOS 端的链接地址
     */
    private String iosUrl;
    /**
     * PC 端的链接地址
     */
    private String pcUrl;

    @Override
    public Map<String, Object> toMessage() {
        Map<String, Object> link = new HashMap<>(4);
        if (url != null) {
            link.put("url", this.url);
        }
        if (androidUrl != null) {
            link.put("android_url", this.androidUrl);
        }
        if (iosUrl != null) {
            link.put("ios_url", this.iosUrl);
        }
        if (pcUrl != null) {
            link.put("pc_url", this.pcUrl);
        }

        return link;
    }

    /**
     * 构建器
     *
     * @return .
     */
    public static UrlBuilder builder() {
        return new UrlBuilder();
    }

    /**
     * {@link UrlEl} builder
     */
    public static class UrlBuilder implements Builder<UrlEl> {
        private final UrlEl url = new UrlEl();

        private UrlBuilder() {
        }

        /**
         * 默认的链接地址
         *
         * @param url .
         * @return .
         */
        public UrlBuilder setUrl(String url) {
            this.url.setUrl(url);
            return this;
        }

        /**
         * Android 端的链接地址
         *
         * @param androidUrl .
         * @return .
         */
        public UrlBuilder setAndroidUrl(String androidUrl) {
            this.url.setAndroidUrl(androidUrl);
            return this;
        }

        /**
         * iOS 端的链接地址
         *
         * @param iosUrl .
         * @return .
         */
        public UrlBuilder setIosUrl(String iosUrl) {
            this.url.setIosUrl(iosUrl);
            return this;
        }

        /**
         * PC 端的链接地址
         *
         * @param pcUrl .
         * @return .
         */
        public UrlBuilder setPcUrl(String pcUrl) {
            this.url.setPcUrl(pcUrl);
            return this;
        }

        @Override
        public UrlEl build() {
            return this.url;
        }
    }
}
