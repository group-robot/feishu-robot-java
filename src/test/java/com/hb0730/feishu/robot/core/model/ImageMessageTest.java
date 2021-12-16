package com.hb0730.feishu.robot.core.model;

import com.hb0730.feishu.robot.core.Response;
import com.hb0730.feishu.robot.core.RobotSend;
import org.junit.Test;

import static org.junit.Assert.*;

public class ImageMessageTest {

    @Test
    public void toMessage() {
        ImageMessage message = ImageMessage.builder().imageKey("img_7ea74629-9191-4176-998c-2e603c9c5e8g").build();
        String webhok = System.getenv("webhok");
        String secret = System.getenv("secret");
        RobotSend send = new RobotSend(webhok);
        send.setSecret(secret);
        Response response = send.send(message);
        System.out.println(response.getMsg());
    }
}
