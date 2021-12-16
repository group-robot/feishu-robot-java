package com.hb0730.feishu.robot.core.model.post;

import com.hb0730.feishu.robot.core.model.tag.ATag;
import com.hb0730.feishu.robot.core.model.tag.AtTag;
import com.hb0730.feishu.robot.core.model.tag.ImgTag;
import com.hb0730.feishu.robot.core.model.tag.TextTag;
import com.hb0730.feishu.robot.core.util.JacksonUtils;
import org.junit.Test;

import java.util.Map;

public class PostUnitTest {

    @Test
    public void unit() {
        PostUnit unit = PostUnit.build();
        Map<String, Object> message = unit.title("我是标题").addTags(
            PostTags.build().addTags(
                TextTag.builder().text("第一行:").build(),
                ATag.builder().href("http://www.feishu.cn").text("超链接").build(),
                AtTag.builder().atAll(true).build()
            ),
            PostTags.build().addTag(
                ImgTag.builder().imageKey("img_7ea74629-9191-4176-998c-2e603c9c5e8g").build()
            ),
            PostTags.build().addTags(
                TextTag.builder().text("第二行:").build(),
                TextTag.builder().text("文本测试").build()
            ),
            PostTags.build().addTag(
                ImgTag.builder().imageKey("img_7ea74629-9191-4176-998c-2e603c9c5e8g").build()
            )
        ).toMessage();
        String json = JacksonUtils.X.format(message);
        System.out.println(json);
    }
}
