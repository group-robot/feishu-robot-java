package io.github.group.robot.feishu.core.model;

import io.github.group.robot.feishu.core.FeishuRobotClient;
import io.github.group.robot.feishu.core.FeishuRobotResponse;
import org.junit.Assert;
import org.junit.Test;

public class TextMessageTest {

    @Test
    public void sendMessage() {
        TextMessage message = TextMessage
                .builder()
                .content("test")
                .atAll(false)
                .build();
        String webhok = System.getenv("webhok");
        String secret = System.getenv("secret");
        FeishuRobotClient send = new FeishuRobotClient();
        send.setSecret(secret);
        send.setWebhook(webhok);
        FeishuRobotResponse feiShuRobotResponse = send.sendMessage(message);
        Assert.assertTrue(feiShuRobotResponse.getMsg(), feiShuRobotResponse.isSuccess());
        // at all t
        message = TextMessage
                .builder()
                .content("test")
                .build();
        webhok = System.getenv("webhok");
        secret = System.getenv("secret");
        send = new FeishuRobotClient();
        send.setSecret(secret);
        send.setWebhook(webhok);
        feiShuRobotResponse = send.sendMessage(message);
        Assert.assertTrue(feiShuRobotResponse.getMsg(), feiShuRobotResponse.isSuccess());
    }

    @Test
    public void sendAtAllMessage() {
        TextMessage message = TextMessage
                .builder()
                .content("test")
                .atAll(true)
                .build();
        String webhok = System.getenv("webhok");
        String secret = System.getenv("secret");
        FeishuRobotClient send = new FeishuRobotClient();
        send.setSecret(secret);
        send.setWebhook(webhok);
        FeishuRobotResponse feiShuRobotResponse = send.sendMessage(message);
        Assert.assertTrue(feiShuRobotResponse.getMsg(), feiShuRobotResponse.isSuccess());
    }
}
