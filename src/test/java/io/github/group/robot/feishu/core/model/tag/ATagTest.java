package io.github.group.robot.feishu.core.model.tag;

import com.hb0730.jsons.SimpleJsonProxy;
import io.github.group.robot.feishu.core.model.post.tag.ATag;
import org.junit.Test;

public class ATagTest {

    @Test
    public void aTag() {
        ATag tag = ATag.builder().text("text").href("https://baidu.com").build();
        String json = SimpleJsonProxy.json.toJson(tag.toMessage());
        System.out.println(json);
    }
}
