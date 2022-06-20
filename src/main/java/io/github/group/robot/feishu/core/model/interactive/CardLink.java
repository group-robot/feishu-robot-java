package io.github.group.robot.feishu.core.model.interactive;

import io.github.group.robot.feishu.core.model.interactive.components.action.ele.Url;
import lombok.Getter;
import lombok.Setter;

/**
 * 指定卡片整体的点击跳转链接
 *
 * @author bing_huang
 * @date 2021/12/16
 */
@Getter
@Setter
public class CardLink extends Url {

    public static CardLink build() {
        return new CardLink();
    }

    public CardLink() {
        super();
    }

    /**
     * set 默认的链接地址
     *
     * @param url url
     * @return this
     */
    public CardLink url(String url) {
        setUrl(url);
        return this;
    }

    /**
     * set Android 端的链接地址
     *
     * @param androidUrl url
     * @return this
     */
    public CardLink androidUrl(String androidUrl) {
        setAndroidUrl(androidUrl);
        return this;
    }

    /**
     * set iOS 端的链接地址
     *
     * @param iosUrl url
     * @return this
     */
    public CardLink iosUrl(String iosUrl) {
        setIosUrl(iosUrl);
        return this;
    }

    /**
     * set PC 端的链接地址
     *
     * @param pcUrl url
     * @return this
     */
    public CardLink pcUrl(String pcUrl) {
        setPcUrl(pcUrl);
        return this;
    }
}
