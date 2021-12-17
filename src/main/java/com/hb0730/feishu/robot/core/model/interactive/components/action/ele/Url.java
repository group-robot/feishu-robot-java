package com.hb0730.feishu.robot.core.model.interactive.components.action.ele;

import com.hb0730.feishu.robot.core.model.IMessage;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

/**
 * 可内嵌交互元素<br>
 * url
 *
 * @author bing_huang
 * @date 2021/12/16
 */
@Getter
@Setter
@Builder
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
}
