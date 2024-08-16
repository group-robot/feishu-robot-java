package io.github.group.robot.feishu.core.model.card;

import io.github.group.robot.feishu.core.model.card.components.ele.UrlEl;
import org.junit.Test;

import java.util.Map;

public class CardLinkTest {

    @Test
    public void toMessage() {
        Map<String, Object> message = CardLink.of(
                UrlEl.builder()
                        .setUrl("https://www.baidu.com")
                        .setAndroidUrl("https://developer.android.com/")
                        .setIosUrl("https://developer.apple.com/")
                        .setPcUrl("https://www.windows.com")
                        .build()
        ).toMessage();
        System.out.println(message);
    }
}
