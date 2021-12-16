package com.hb0730.feishu.robot.core.model;

import com.hb0730.feishu.robot.core.Response;
import com.hb0730.feishu.robot.core.RobotSend;
import com.hb0730.feishu.robot.core.model.post.PostLang;
import com.hb0730.feishu.robot.core.model.post.PostTags;
import com.hb0730.feishu.robot.core.model.post.PostUnit;
import com.hb0730.feishu.robot.core.model.tag.ATag;
import com.hb0730.feishu.robot.core.model.tag.AtTag;
import com.hb0730.feishu.robot.core.model.tag.TextTag;
import org.junit.Test;

import java.util.Map;

public class PostMessageTest {

    @Test
    public void toMessage() {
        PostMessage message = PostMessage.build().lang(
            PostLang.builder()
                .lang("zh_cn")
                .unit(
                    PostUnit.build()
                        .title("项目更新通知")
                        .addTags(
                            PostTags.build().addTags(
                                TextTag.builder().text("项目有更新: ").build(),
                                ATag.builder().text("请查看").href("http://www.example.com/").build(),
                                AtTag.builder().atAll(true).build()
                            )
                        )
                )
                .build()
        );
        String webhok = System.getenv("webhok");
        String secret = System.getenv("secret");
        RobotSend send = new RobotSend(webhok);
        send.setSecret(secret);
        Response response = send.send(message);
        System.out.println(response.getMsg());
    }
}
