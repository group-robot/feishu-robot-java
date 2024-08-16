package io.github.group.robot.feishu.core.model.card.components.content;

import io.github.group.robot.feishu.core.FeishuRobotClient;
import io.github.group.robot.feishu.core.FeishuRobotResponse;
import io.github.group.robot.feishu.core.constants.CombinationMode;
import io.github.group.robot.feishu.core.model.CardV2Message;
import io.github.group.robot.feishu.core.model.card.CardBody;
import org.junit.Test;

import java.util.Arrays;

public class MultiImageLayoutTest {

    /**
     * 双图混排效果示例
     */
    @Test
    public void test1() {
        MultiImageLayout imageLayout = MultiImageLayout.builder()
                .setMode(CombinationMode.DOUBLE)
                .setImgKeys(Arrays.asList("img_v2_16d4ea4f-6cd5-48fa-97fd-25c8d4e79b0g", "img_v2_16d4ea4f-6cd5-48fa-97fd-25c8d4e79b0g"))
                .build();

        CardBody cardBody = CardBody.of(imageLayout);

        CardV2Message message = CardV2Message.builder()
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

    /**
     * 三图混排效果示例
     */
    @Test
    public void test2() {
        MultiImageLayout imageLayout = MultiImageLayout.builder()
                .setMode(CombinationMode.TRIPLE)
                .setImgKeys(Arrays.asList("img_v2_16d4ea4f-6cd5-48fa-97fd-25c8d4e79b0g", "img_v2_16d4ea4f-6cd5-48fa-97fd-25c8d4e79b0g", "img_v2_16d4ea4f-6cd5-48fa-97fd-25c8d4e79b0g"))
                .build();

        CardBody cardBody = CardBody.of(imageLayout);

        CardV2Message message = CardV2Message.builder()
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

    /**
     * 等分双列效果示例
     */
    @Test
    public void test3() {
        MultiImageLayout imageLayout = MultiImageLayout.builder()
                .setMode(CombinationMode.BISECT)
                .setImgKeys(Arrays.asList(
                        "img_v2_16d4ea4f-6cd5-48fa-97fd-25c8d4e79b0g",
                        "img_v2_16d4ea4f-6cd5-48fa-97fd-25c8d4e79b0g",
                        "img_v2_16d4ea4f-6cd5-48fa-97fd-25c8d4e79b0g",
                        "img_v2_16d4ea4f-6cd5-48fa-97fd-25c8d4e79b0g",
                        "img_v2_16d4ea4f-6cd5-48fa-97fd-25c8d4e79b0g",
                        "img_v2_16d4ea4f-6cd5-48fa-97fd-25c8d4e79b0g"
                ))
                .build();

        CardBody cardBody = CardBody.of(imageLayout);

        CardV2Message message = CardV2Message.builder()
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

    /**
     * 等分三列效果示例
     */
    @Test
    public void test4() {
        MultiImageLayout imageLayout = MultiImageLayout.builder()
                .setMode(CombinationMode.TRISECT)
                .setImgKeys(Arrays.asList(
                        "img_v2_16d4ea4f-6cd5-48fa-97fd-25c8d4e79b0g",
                        "img_v2_16d4ea4f-6cd5-48fa-97fd-25c8d4e79b0g",
                        "img_v2_16d4ea4f-6cd5-48fa-97fd-25c8d4e79b0g"
                ))
                .build();

        CardBody cardBody = CardBody.of(imageLayout);

        CardV2Message message = CardV2Message.builder()
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
