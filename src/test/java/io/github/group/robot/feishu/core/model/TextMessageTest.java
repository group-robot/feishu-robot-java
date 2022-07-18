package io.github.group.robot.feishu.core.model;

import io.github.group.robot.feishu.core.FeiShuRobotResponse;
import io.github.group.robot.feishu.core.FeiShuRobotSend;
import org.junit.Test;

public class TextMessageTest {

    @Test
    public void sendMessage() {
        TextMessage text = TextMessage.builder().content("test").atAll(false).build();
        String webhok = System.getenv("webhok");
        String secret = System.getenv("secret");
        FeiShuRobotSend send = new FeiShuRobotSend(webhok);
        send.setSecret(secret);
        FeiShuRobotResponse feiShuRobotResponse = send.send(text);
        System.out.println(feiShuRobotResponse.getMsg());
    }

    @Test
    public void sendAtAllMessage() {
        TextMessage text = TextMessage.builder().content("test").atAll(true).build();
        String webhok = System.getenv("webhok");
        String secret = System.getenv("secret");
        FeiShuRobotSend send = new FeiShuRobotSend(webhok);
        send.setSecret(secret);
        FeiShuRobotResponse feiShuRobotResponse = send.send(text);
        System.out.println(feiShuRobotResponse.getMsg());
    }
}
