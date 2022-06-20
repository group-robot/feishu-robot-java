package io.github.group.robot.feishu.core.model.interactive.components.action.ele;

import com.hb0730.jsons.SimpleJsonProxy;
import org.junit.Test;

public class UrlTest {

    @Test
    public void toMessage() {
        Url message = Url.builder().url("test").iosUrl("test").pcUrl("tesst").androidUrl("test").build();
        String json = SimpleJsonProxy.json.toJson(message.toMessage());
        System.out.println(json);
    }
}
