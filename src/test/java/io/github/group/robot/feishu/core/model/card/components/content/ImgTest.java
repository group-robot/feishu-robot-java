package io.github.group.robot.feishu.core.model.card.components.content;

import io.github.group.robot.feishu.core.FeishuRobotClient;
import io.github.group.robot.feishu.core.FeishuRobotResponse;
import io.github.group.robot.feishu.core.constants.ImgSize;
import io.github.group.robot.feishu.core.constants.ScaleType;
import io.github.group.robot.feishu.core.model.CardV2Message;
import io.github.group.robot.feishu.core.model.card.CardBody;
import io.github.group.robot.feishu.core.model.card.components.ele.ImageEl;
import org.junit.Test;

public class ImgTest {

    /**
     * 图片示例
     */
    @Test
    public void test() {
        Img img = Img.builder()
                .setImg(ImageEl.of("img_v2_16d4ea4f-6cd5-48fa-97fd-25c8d4e79b0g"))
                .setPreview(true)
                .setCaleType(ScaleType.CROP_TOP)
                .setSize(ImgSize.STRETCH)
                .build();


        CardBody cardBody = CardBody.of().add(img);
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
