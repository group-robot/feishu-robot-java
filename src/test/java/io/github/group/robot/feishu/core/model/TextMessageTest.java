package io.github.group.robot.feishu.core.model;

import io.github.group.robot.feishu.core.Response;
import io.github.group.robot.feishu.core.RobotSend;
import org.junit.Test;

public class TextMessageTest {

    @Test
    public void sendMessage() {
        TextMessage text = TextMessage.builder().content("test").atAll(false).build();
        String webhok = System.getenv("webhok");
        String secret = System.getenv("secret");
        RobotSend send = new RobotSend(webhok);
        send.setSecret(secret);
        Response response = send.send(text);
        System.out.println(response.getMsg());
    }

    @Test
    public void sendAtAllMessage() {
        TextMessage text = TextMessage.builder().content("test").atAll(true).build();
        String webhok = System.getenv("webhok");
        String secret = System.getenv("secret");
        RobotSend send = new RobotSend(webhok);
        send.setSecret(secret);
        Response response = send.send(text);
        System.out.println(response.getMsg());
    }
}
