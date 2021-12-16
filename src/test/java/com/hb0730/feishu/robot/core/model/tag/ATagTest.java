package com.hb0730.feishu.robot.core.model.tag;

import com.hb0730.feishu.robot.core.util.JacksonUtils;
import org.junit.Test;

public class ATagTest {

    @Test
    public void aTag() {
        ATag tag = ATag.builder().text("text").href("https://baidu.com").build();
        String json = JacksonUtils.X.format(tag.toMessage());
        System.out.println(json);
    }
}
