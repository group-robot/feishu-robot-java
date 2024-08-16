package io.github.group.robot.feishu.core.model.card;

import io.github.group.robot.feishu.core.model.card.components.ele.UrlEl;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

/**
 * 指定卡片整体的点击跳转链接
 *
 * @author <a href="mailto:huangbing0730@gmail">hb0730</a>
 * @date 2021/12/16
 */
@Getter
@Setter
public class CardLink extends UrlEl {
    /**
     * create {@link  CardLink}
     */
    public CardLink() {
    }

    /**
     * create {@link  CardLink}
     *
     * @param urlEl url
     */
    public CardLink(UrlEl urlEl) {
        super(urlEl.getUrl(),
                urlEl.getAndroidUrl(),
                urlEl.getIosUrl(),
                urlEl.getPcUrl());
    }

    @Override
    public Map<String, Object> toMessage() {
        return super.toMessage();
    }

    /**
     * 构建者
     *
     * @param urlEl url
     * @return this
     */
    public static CardLink of(UrlEl urlEl) {
        return new CardLink(urlEl);
    }

    /**
     * 构建者
     *
     * @param url url
     * @return this
     */
    public static CardLink of(String url) {
        return new CardLink(new UrlEl(url, null, null, null));
    }

    /**
     * 构建者
     *
     * @param url        默认的链接地址
     * @param androidUrl Android 端的链接地址
     * @param iosUrl     iOS 端的链接地址
     * @param pcUrl      PC 端的链接地址
     * @return this
     */
    public static CardLink of(String url, String androidUrl, String iosUrl, String pcUrl) {
        return new CardLink(new UrlEl(url, androidUrl, iosUrl, pcUrl));
    }

    /**
     * 构建者
     *
     * @return this
     */
    public static CardLink of() {
        return new CardLink();
    }
}
