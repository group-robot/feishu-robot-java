package io.github.group.robot.feishu.core.model;

import io.github.group.robot.feishu.core.Response;
import io.github.group.robot.feishu.core.RobotSend;
import io.github.group.robot.feishu.core.model.post.PostLang;
import io.github.group.robot.feishu.core.model.post.PostTags;
import io.github.group.robot.feishu.core.model.post.PostUnit;
import io.github.group.robot.feishu.core.model.post.tag.ATag;
import io.github.group.robot.feishu.core.model.post.tag.AtTag;
import io.github.group.robot.feishu.core.model.post.tag.TextTag;
import org.junit.Test;

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
