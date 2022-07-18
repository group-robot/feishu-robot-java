package io.github.group.robot.feishu.core.model;

import io.github.group.robot.feishu.core.FeiShuRobotResponse;
import io.github.group.robot.feishu.core.FeiShuRobotSend;
import org.junit.Test;

public class ImageMessageTest {

    @Test
    public void toMessage() {
        ImageMessage message = ImageMessage.builder().imageKey("img_7ea74629-9191-4176-998c-2e603c9c5e8g").build();
        String webhok = System.getenv("webhok");
        String secret = System.getenv("secret");
        FeiShuRobotSend send = new FeiShuRobotSend(webhok);
        send.setSecret(secret);
        FeiShuRobotResponse feiShuRobotResponse = send.send(message);
        System.out.println(feiShuRobotResponse.getMsg());
    }
}
