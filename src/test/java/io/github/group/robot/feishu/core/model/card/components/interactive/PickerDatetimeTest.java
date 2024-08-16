package io.github.group.robot.feishu.core.model.card.components.interactive;

import io.github.group.robot.feishu.core.FeishuRobotClient;
import io.github.group.robot.feishu.core.FeishuRobotResponse;
import io.github.group.robot.feishu.core.model.CardV2Message;
import io.github.group.robot.feishu.core.model.card.CardBody;
import io.github.group.robot.feishu.core.model.card.CardHeader;
import io.github.group.robot.feishu.core.model.card.components.CardTitle;
import io.github.group.robot.feishu.core.model.card.components.content.Title;
import org.junit.Test;

public class PickerDatetimeTest {

    /**
     * picker datetime 示例
     */
    @Test
    public void test() {
        CardBody cardBody = CardBody.of()
                .add(PickerDatetime.builder()
                        .setPlaceholder("请选择")
                        .setWidth("default")
                        .setInitialDatetime("2024-08-08 12:00")
                        .build())
                .add(PickerDatetime.builder()
                        .setPlaceholder("请选择")
                        .setWidth("default")
                        .build());

        CardHeader cardHeader = CardHeader.of(CardTitle.builder()
                .setTemplate("blue")
                .setTitle(Title.of("日期时间选择器"))
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
