package io.github.group.robot.feishu.core;

import io.github.group.robot.feishu.core.model.TextMessage;
import org.junit.Test;

public class RobotSendTest {

    @Test
    public void send() {
        TextMessage text = TextMessage.builder().content("test").atAll(false).build();
        String webhok = System.getenv("webhok");
        String secret = System.getenv("secret");
        FeishuRobotClient send = new FeishuRobotClient();
        send.setSecret(secret);
        send.setWebhook(webhok);
        FeishuRobotResponse feiShuRobotResponse = send.sendMessage(text);
        System.out.println(feiShuRobotResponse.getMsg());
    }
}
