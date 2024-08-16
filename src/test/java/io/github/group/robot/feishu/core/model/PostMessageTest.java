package io.github.group.robot.feishu.core.model;

import io.github.group.robot.feishu.core.FeishuRobotClient;
import io.github.group.robot.feishu.core.FeishuRobotResponse;
import io.github.group.robot.feishu.core.model.post.Paragraph;
import io.github.group.robot.feishu.core.model.post.tags.ATag;
import io.github.group.robot.feishu.core.model.post.tags.AtTag;
import io.github.group.robot.feishu.core.model.post.tags.TextTag;
import org.junit.Test;

public class PostMessageTest {

    @Test
    public void toMessage() {
        PostMessage message = PostMessage.of()
                .addContent(Paragraph
                        .of()
                        .setTitle("项目更新通知")
                        .newLine()
                        .addContent(TextTag.of("项目有更新: "))
                        .addContent(ATag.of("请查看", "http://www.example.com/"))
                        .addContent(AtTag.of().atAll()));

        String webhook = System.getenv("webhook");
        String secret = System.getenv("secret");
        FeishuRobotClient send = new FeishuRobotClient();
        send.setSecret(secret);
        send.setWebhook(webhook);
        FeishuRobotResponse feiShuRobotResponse = send.sendMessage(message);
        System.out.println(feiShuRobotResponse.getMsg());
    }

    @Test
    public void issues4Test() {
        PostMessage message = PostMessage.of()
                .addContent(Paragraph.of("订单支付成功")
                        .addContent(TextTag.of("商品为: "))
                        .addContent(TextTag.of("支付金额为: "))
                        .addContent(TextTag.of("取餐码为: "))
                        .addContent(ATag.of("请查看", "http://www.example.com/"))
                        .addContent(AtTag.of().atAll())
                        .newLine()
                        .addContent(TextTag.of("请及时处理")));

        String webhook = System.getenv("webhook");
        String secret = System.getenv("secret");
        FeishuRobotClient send = new FeishuRobotClient();
        send.setSecret(secret);
        send.setWebhook(webhook);
        FeishuRobotResponse feiShuRobotResponse = send.sendMessage(message);
        System.out.println(feiShuRobotResponse.getMsg());
    }
}
