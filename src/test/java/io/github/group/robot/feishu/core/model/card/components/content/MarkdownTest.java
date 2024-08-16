package io.github.group.robot.feishu.core.model.card.components.content;

import io.github.group.robot.feishu.core.FeishuRobotClient;
import io.github.group.robot.feishu.core.FeishuRobotResponse;
import io.github.group.robot.feishu.core.model.CardV2Message;
import io.github.group.robot.feishu.core.model.card.CardBody;
import io.github.group.robot.feishu.core.model.card.CardHeader;
import io.github.group.robot.feishu.core.model.card.components.CardTitle;
import org.junit.Test;

public class MarkdownTest {

    /**
     * 测试
     */
    @Test
    public void test() {

        CardBody cardBody = CardBody.of()
                .add(Markdown.builder()
//                        .setHref(UrlEl.builder()
//                                .setUrl("xxx1")
//                                .setPcUrl("xxx2")
//                                .setIosUrl("xxx3")
//                                .setAndroidUrl("xxx4")
//                                .build())
                        .setContent("普通文本\n标准emoji😁😢🌞💼🏆❌✅\n*斜体*\n**粗体**\n~~删除线~~\n[文字链接](www.example.com)\n<link " +
                                "icon='chat_outlined' url='https://open.feishu.cn' pc_url='' ios_url='' " +
                                "android_url=''>差异化跳转</link>\n<at id=all></at>")
                        .build())
                .add(Hr.of())
                .add(Markdown.builder()
                        .setContent("上面是一行分割线\n![hover_text](img_v2_16d4ea4f-6cd5-48fa-97fd-25c8d4e79b0g)\n上面是一个图片标签")
                        .build());

        CardHeader cardHeader = CardHeader.of(
                CardTitle.builder()
                        .setTemplate("blue")
                        .setTitle(Title.of("这是卡片标题栏"))
                        .build());

        CardV2Message message = CardV2Message.builder()
                .setBody(cardBody)
                .setHeader(cardHeader)
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
