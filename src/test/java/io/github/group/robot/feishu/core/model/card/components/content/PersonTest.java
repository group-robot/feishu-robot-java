package io.github.group.robot.feishu.core.model.card.components.content;

import io.github.group.robot.feishu.core.FeishuRobotClient;
import io.github.group.robot.feishu.core.FeishuRobotResponse;
import io.github.group.robot.feishu.core.constants.AvatarSize;
import io.github.group.robot.feishu.core.constants.PersonStyle;
import io.github.group.robot.feishu.core.model.CardV2Message;
import io.github.group.robot.feishu.core.model.card.CardBody;
import io.github.group.robot.feishu.core.model.card.CardHeader;
import io.github.group.robot.feishu.core.model.card.components.CardTitle;
import org.junit.Test;

public class PersonTest {

    /**
     * 人员
     */
    @Test
    public void test() {
        CardBody cardBody = CardBody.of()
                .add(Markdown.builder().setContent("**extra_small 尺寸，默认样式**").build())
                .add(Person.builder()
                        .setSize(AvatarSize.SMALL)
                        .setUserId("ou_48d0958ee4b2ab3eaf0b5f6c968abcef")
                        .setShowAvatar(true)
                        .setShowName(true)
                        .setStyle(PersonStyle.NORMAL)
                        .build())
                .add(Markdown.builder().setContent("**small 尺寸，胶囊样式**").build())
                .add(Person.builder()
                        .setSize(AvatarSize.SMALL)
                        .setUserId("ou_48d0958ee4b2ab3eaf0b5f6c968abcef")
                        .setShowAvatar(true)
                        .setShowName(true)
                        .setStyle(PersonStyle.CAPSULE)
                        .build())
                .add(Markdown.builder().setContent("**medium 尺寸，胶囊样式**").build())
                .add(Person.builder()
                        .setSize(AvatarSize.MEDIUM)
                        .setUserId("ou_48d0958ee4b2ab3eaf0b5f6c968abcef")
                        .setShowAvatar(true)
                        .setShowName(true)
                        .setStyle(PersonStyle.CAPSULE)
                        .build())
                .add(Markdown.builder().setContent("**large 尺寸，默认样式**").build())
                .add(Person.builder()
                        .setSize(AvatarSize.LARGE)
                        .setUserId("ou_48d0958ee4b2ab3eaf0b5f6c968abcef")
                        .setShowAvatar(true)
                        .setShowName(true)
                        .setStyle(PersonStyle.NORMAL)
                        .build());


        CardHeader cardHeader = CardHeader.of(CardTitle.builder()
                .setTemplate("blue")
                .setTitle(Title.of("人员示例"))
                .build());

        CardV2Message message = CardV2Message.builder()
                .setHeader(cardHeader)
                .setBody(cardBody)
                .build();

        String webhok = System.getenv("webhook");
        String secret = System.getenv("secret");
        FeishuRobotClient send = new FeishuRobotClient();
        send.setSecret(secret);
        send.setWebhook(webhok);
        FeishuRobotResponse feiShuRobotResponse = send.sendMessage(message);
        System.out.println(feiShuRobotResponse.getMsg());
    }
}
