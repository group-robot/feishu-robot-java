package com.hb0730.feishu.robot.core.model.interactive;

import com.hb0730.feishu.robot.core.util.JacksonUtils;
import org.junit.Test;

public class CardLinkTest {

    @Test
    public void buildLink() {
        CardLink message = CardLink.build().url("test").iosUrl("test").pcUrl("test").androidUrl("test");
        String json = JacksonUtils.X.format(message.toMessage());
        System.out.println(json);
    }
}
