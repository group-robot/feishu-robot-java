package io.github.group.robot.feishu.core.model.interactive.components.action.ele;

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
public class Url implements IMessage {
    /**
     * create {@link  Url}
     */
    public Url() {
    }

    /**
     * create {@link  Url}
     *
     * @param url        默认的链接地址
     * @param androidUrl Android 端的链接地址
     * @param iosUrl     iOS 端的链接地址
     * @param pcUrl      PC 端的链接地址
     */
    public Url(String url, String androidUrl, String iosUrl, String pcUrl) {
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
        link.put("url", this.url);
        link.put("android_url", this.androidUrl);
        link.put("ios_url", this.iosUrl);
        link.put("pc_url", this.pcUrl);
        return link;
    }

    /**
     * 构建器
     *
     * @return .
     */
    public static UrlBuilder builder() {
        return UrlBuilder.builder();
    }

    /**
     * {@link Url} builder
     */
    public static class UrlBuilder implements Builder<Url> {
        private Url url;

        public UrlBuilder() {
            this.url = new Url();
        }

        /**
         * create {@link UrlBuilder}
         *
         * @return .
         */
        public static UrlBuilder builder() {
            return new UrlBuilder();
        }

        /**
         * 默认的链接地址
         *
         * @param url .
         * @return .
         */
        public UrlBuilder url(String url) {
            this.url.setUrl(url);
            return this;
        }

        /**
         * Android 端的链接地址
         *
         * @param androidUrl .
         * @return .
         */
        public UrlBuilder androidUrl(String androidUrl) {
            this.url.setAndroidUrl(androidUrl);
            return this;
        }

        /**
         * iOS 端的链接地址
         *
         * @param iosUrl .
         * @return .
         */
        public UrlBuilder iosUrl(String iosUrl) {
            this.url.setIosUrl(iosUrl);
            return this;
        }

        /**
         * PC 端的链接地址
         *
         * @param pcUrl .
         * @return .
         */
        public UrlBuilder pcUrl(String pcUrl) {
            this.url.setPcUrl(pcUrl);
            return this;
        }

        @Override
        public Url build() {
            return this.url;
        }
    }
}
