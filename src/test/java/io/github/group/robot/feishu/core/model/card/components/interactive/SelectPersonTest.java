package io.github.group.robot.feishu.core.model.card.components.interactive;

import io.github.group.robot.feishu.core.FeishuRobotClient;
import io.github.group.robot.feishu.core.FeishuRobotResponse;
import io.github.group.robot.feishu.core.constants.SelectType;
import io.github.group.robot.feishu.core.model.CardV2Message;
import io.github.group.robot.feishu.core.model.card.CardBody;
import io.github.group.robot.feishu.core.model.card.CardHeader;
import io.github.group.robot.feishu.core.model.card.components.CardTitle;
import io.github.group.robot.feishu.core.model.card.components.content.Title;
import org.junit.Test;

import java.util.Arrays;

public class SelectPersonTest {

    /**
     * 人员选择-单选 示例
     */
    @Test
    public void test() {
        CardBody cardBody = CardBody.of()
                .add(SelectPerson.builder()
                        .setPlaceholder("请选择")
                        .addOption(Arrays.asList("ou_449b53ad6aee526f7ed311b216aabcef", "ou_449b53ad6aee526f7ed311b216aabcef"))
                        .setWidth("default")
                        .setType(SelectType.DEFAULT)
                        .build());

        CardHeader cardHeader = CardHeader.of(CardTitle.builder()
                .setTemplate("blue")
                .setTitle(Title.of("人员选择-单选"))
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
