package com.hb0730.feishu.robot.core.model;

import com.hb0730.feishu.robot.core.Response;
import com.hb0730.feishu.robot.core.RobotSend;
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
