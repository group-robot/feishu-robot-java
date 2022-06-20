package io.github.group.robot.feishu.core.model.interactive;

import com.hb0730.jsons.SimpleJsonProxy;
import org.junit.Test;

public class CardLinkTest {

    @Test
    public void buildLink() {
        CardLink message = CardLink.build().url("test").iosUrl("test").pcUrl("test").androidUrl("test");
        String json = SimpleJsonProxy.json.toJson(message.toMessage());
        System.out.println(json);
    }
}
