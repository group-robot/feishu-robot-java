package com.hb0730.feishu.robot.core.model.interactive.components.action.ele;

import com.hb0730.feishu.robot.core.util.JacksonUtils;
import org.junit.Test;

import static org.junit.Assert.*;

public class UrlTest {

    @Test
    public void toMessage() {
        Url message = Url.builder().url("test").iosUrl("test").pcUrl("tesst").androidUrl("test").build();
        String json = JacksonUtils.X.format(message.toMessage());
        System.out.println(json);
    }
}
