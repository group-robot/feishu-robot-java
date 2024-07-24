package io.github.group.robot.feishu.core.model;

import io.github.group.robot.feishu.core.FeishuRobotClient;
import io.github.group.robot.feishu.core.FeishuRobotResponse;
import io.github.group.robot.feishu.core.model.post.PostLang;
import io.github.group.robot.feishu.core.model.post.PostTags;
import io.github.group.robot.feishu.core.model.post.PostUnit;
import io.github.group.robot.feishu.core.model.post.tag.ATag;
import io.github.group.robot.feishu.core.model.post.tag.AtTag;
import io.github.group.robot.feishu.core.model.post.tag.TextTag;
import org.junit.Test;

public class PostMessageTest {

    @Test
    public void toMessage() {
        PostMessage message = PostMessage.build().lang(
                PostLang.builder()
                        .lang("zh_cn")
                        .unit(
                                PostUnit.build()
                                        .title("项目更新通知")
                                        .addTags(
                                                PostTags.build().addTags(
                                                        TextTag.builder().text("项目有更新: ").build(),
                                                        ATag.builder().text("请查看").href("http://www.example.com/").build(),
                                                        AtTag.builder().atAll(true).build()
                                                )
                                        )
                        )
                        .build()
        );
        String webhok = System.getenv("webhok");
        String secret = System.getenv("secret");
        FeishuRobotClient send = new FeishuRobotClient();
        send.setSecret(secret);
        send.setWebhook(webhok);
        FeishuRobotResponse feiShuRobotResponse = send.sendMessage(message);
        System.out.println(feiShuRobotResponse.getMsg());
    }

    @Test
    public void issues4Test() {
        PostMessage message = PostMessage.build().lang(
                PostLang.builder()
                        .lang("zh_cn")
                        .unit(
                                PostUnit.build()
                                        .title("订单支付成功")
                                        .addTags(
                                                PostTags.build().addTags(
                                                        TextTag.builder().text("商品为: ").build(),
                                                        TextTag.builder().text("支付金额为: ").build(),
                                                        TextTag.builder().text("取餐码为: ").build(),
                                                        ATag.builder().text("请查看").href("http://www.example.com/").build(),
                                                        AtTag.builder().atAll(true).build()
                                                )
                                        )
                        )
                        .build()
        );
        String webhok = System.getenv("webhook");
        String secret = System.getenv("secret");
        FeishuRobotClient send = new FeishuRobotClient();
        send.setSecret(secret);
        send.setWebhook(webhok);
        FeishuRobotResponse feiShuRobotResponse = send.sendMessage(message);
        System.out.println(feiShuRobotResponse.getMsg());
    }

    @Test
    public void pr8Test() {
        PostMessage message = PostMessage.build().lang(
                PostLang.builder()
                        .lang("zh_cn")
                        .unit(
                                PostUnit.build()
                                        .title("订单支付成功")
                                        .addTags(
                                                PostTags.build().addTags(
                                                        TextTag.builder().text("商品为: ").enter().build(),
                                                        TextTag.builder().text("支付金额为: ").enter().build(),
                                                        TextTag.builder().text("取餐码为: ").enter().build(),
                                                        ATag.builder().text("请查看").href("http://www.example.com/").build(),
                                                        AtTag.builder().atAll(true).build()
                                                )
                                        )
                        )
                        .build()
        );
        String webhok = System.getenv("webhook");
        String secret = System.getenv("secret");
        FeishuRobotClient send = new FeishuRobotClient();
        send.setSecret(secret);
        send.setWebhook(webhok);
        FeishuRobotResponse feiShuRobotResponse = send.sendMessage(message);
        System.out.println(feiShuRobotResponse.getMsg());
    }
}
