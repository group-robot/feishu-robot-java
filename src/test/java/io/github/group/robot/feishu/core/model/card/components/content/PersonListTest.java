package io.github.group.robot.feishu.core.model.card.components.content;

import io.github.group.robot.feishu.core.FeishuRobotClient;
import io.github.group.robot.feishu.core.FeishuRobotResponse;
import io.github.group.robot.feishu.core.constants.AvatarSize;
import io.github.group.robot.feishu.core.constants.IconTag;
import io.github.group.robot.feishu.core.model.CardV2Message;
import io.github.group.robot.feishu.core.model.card.CardBody;
import io.github.group.robot.feishu.core.model.card.CardHeader;
import io.github.group.robot.feishu.core.model.card.components.CardTitle;
import io.github.group.robot.feishu.core.model.card.components.ele.IconEl;
import org.junit.Test;

public class PersonListTest {

    /**
     * 人员列表示例
     */
    @Test
    public void test() {
        CardHeader cardHeader = CardHeader.of(CardTitle.builder()
                .setTemplate("blue")
                .setTitle(Title.of("人员列表示例"))
                .build());

        CardBody cardBody = CardBody.of()
                .add(Markdown.builder().setContent("仅名字：").build())
                .add(PersonList.builder()
                        .setUserIds(
                                "ou_48d0958ee4b2ab3eaf0b5f6c968abcef",
                                "ou_48d0958ee4b2ab3eaf0b5f6c968abcef",
                                "ou_48d0958ee4b2ab3eaf0b5f6c968abcef")
                        .build())
                .add(Markdown.builder().setContent("名字+头像：").build())
                .add(PersonList.builder()
                        .setShowName(true)
                        .setShowAvatar(true)
                        .setLines(2)
                        .setSize(AvatarSize.SMALL)
                        .setUserIds(
                                "ou_48d0958ee4b2ab3eaf0b5f6c968abcef",
                                "ou_48d0958ee4b2ab3eaf0b5f6c968abcef",
                                "ou_48d0958ee4b2ab3eaf0b5f6c968abcef")
                        .build())
                .add(Markdown.builder().setContent("名字+头像+icon：").build())
                .add(PersonList.builder()
                        .setShowName(true)
                        .setShowAvatar(true)
                        .setLines(2)
                        .setSize(AvatarSize.SMALL)
                        .setUserIds(
                                "ou_48d0958ee4b2ab3eaf0b5f6c968abcef",
                                "ou_48d0958ee4b2ab3eaf0b5f6c968abcef",
                                "ou_48d0958ee4b2ab3eaf0b5f6c968abcef")
                        .setIcon(IconEl.builder()
                                .setTag(IconTag.STANDARD_ICON)
                                .setToken("group_outlined")
                                .setColor("blue")
                                .build())
                        .build())
                .add(Markdown.builder().setContent("名字葫芦串：").build())
                .add(PersonList.builder()
                        .setShowName(false)
                        .setShowAvatar(true)
                        .setSize(AvatarSize.SMALL)
                        .setUserIds(
                                "ou_48d0958ee4b2ab3eaf0b5f6c968abcef",
                                "ou_48d0958ee4b2ab3eaf0b5f6c968abcef",
                                "ou_48d0958ee4b2ab3eaf0b5f6c968abcef")
                        .build());


        CardV2Message message = CardV2Message.builder()
                .setHeader(cardHeader)
                .setBody(cardBody)
                .build();

        String webhook = System.getenv("webhook");
        String secret = System.getenv("secret");
        FeishuRobotClient send = new FeishuRobotClient();
        send.setSecret(secret);
        send.setWebhook(webhook);
        FeishuRobotResponse feiShuRobotResponse = send.sendMessage(message);
        System.out.println(feiShuRobotResponse.getMsg());
    }
}
