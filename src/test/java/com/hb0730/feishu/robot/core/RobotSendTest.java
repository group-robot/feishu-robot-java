package com.hb0730.feishu.robot.core;

import com.hb0730.feishu.robot.core.model.TextMessage;
import org.junit.Test;

public class RobotSendTest {

    @Test
    public void send() {
        TextMessage text = TextMessage.builder().content("test").atAll(false).build();
        String webhok = System.getenv("webhok");
        String secret = System.getenv("secret");
        RobotSend send = new RobotSend(webhok);
        send.setSecret(secret);
        Response response = send.send(text);
        System.out.println(response.getMsg());
    }
}
