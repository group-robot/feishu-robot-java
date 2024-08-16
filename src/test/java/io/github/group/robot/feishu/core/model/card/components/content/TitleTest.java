package io.github.group.robot.feishu.core.model.card.components.content;

import io.github.group.robot.feishu.core.FeishuRobotClient;
import io.github.group.robot.feishu.core.FeishuRobotResponse;
import io.github.group.robot.feishu.core.model.CardV2Message;
import io.github.group.robot.feishu.core.model.card.CardConfig;
import io.github.group.robot.feishu.core.model.card.CardHeader;
import io.github.group.robot.feishu.core.model.card.CardLink;
import io.github.group.robot.feishu.core.model.card.components.CardTitle;
import io.github.group.robot.feishu.core.model.card.components.TextTagList;
import io.github.group.robot.feishu.core.model.card.components.ele.ContentI18n;
import io.github.group.robot.feishu.core.model.card.components.ele.TextEl;
import org.junit.Test;

public class TitleTest {

    @Test
    public void test() {
        CardConfig cardConfig = CardConfig.builder().build();
        CardLink cardLink = CardLink.of();
        CardHeader cardHeader = CardHeader.of()
                .setTitle(
                        CardTitle.builder()
                                .setTitle(Title.of("卡片主标题"))
                                .setSubTitle(SubTitle.of("卡片副标题"))
                                .addTextTagList(
                                        TextTagList.builder()
                                                .setText(TextEl.builder().setContent(ContentI18n.of("后缀标签1")).build())
                                                .setColor("turquoise")
                                                .build(),
                                        TextTagList.builder()
                                                .setText(TextEl.builder().setContent(ContentI18n.of("后缀标签2")).build())
                                                .setColor("orange")
                                                .build(),
                                        TextTagList.builder()
                                                .setText(TextEl.builder().setContent(ContentI18n.of("后缀标签3")).build())
                                                .setColor("indigo")
                                                .build()
                                )
                                .setTemplate("blue")
//                                .setUdIcon(CardTitle.UdIcon.of("larkcommunity_colorful"))
                                .build()
                );

        CardV2Message message = CardV2Message.builder()
                .setCardLink(cardLink)
                .setConfig(cardConfig)
                .setHeader(cardHeader)
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
