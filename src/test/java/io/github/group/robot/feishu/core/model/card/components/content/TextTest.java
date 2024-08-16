package io.github.group.robot.feishu.core.model.card.components.content;

import io.github.group.robot.feishu.core.FeishuRobotClient;
import io.github.group.robot.feishu.core.FeishuRobotResponse;
import io.github.group.robot.feishu.core.constants.IconTag;
import io.github.group.robot.feishu.core.constants.TextAlign;
import io.github.group.robot.feishu.core.constants.TextSize;
import io.github.group.robot.feishu.core.constants.TextTag;
import io.github.group.robot.feishu.core.model.CardV2Message;
import io.github.group.robot.feishu.core.model.card.CardBody;
import io.github.group.robot.feishu.core.model.card.components.ele.ContentI18n;
import io.github.group.robot.feishu.core.model.card.components.ele.IconEl;
import io.github.group.robot.feishu.core.model.card.components.ele.TextEl;
import org.junit.Test;

public class TextTest {

    /**
     * plain_text示例
     */
    @Test
    public void test1() {
        Text text = Text.builder()
                .setText(
                        TextEl.builder()
                                .setContent(ContentI18n.of("这是一段普通文本示例。"))
                                .setTextSize(TextSize.Normal)
                                .setTextAlign(TextAlign.CENTER)
                                .setTextColor("default")
                                .build()
                ).setIcon(
                        IconEl.builder()
                                .setTag(IconTag.STANDARD_ICON)
                                .setToken("app-default_filled")
                                .setColor("blue")
                                .build()
                ).build();

        CardBody cardBody = CardBody.of().add(text);

        CardV2Message message = CardV2Message.builder()
                .setBody(cardBody)
                .build();

        String webhok = System.getenv("webhook");
        String secret = System.getenv("secret");
        FeishuRobotClient send = new FeishuRobotClient();
        send.setSecret(secret);
        send.setWebhook(webhok);
        FeishuRobotResponse feiShuRobotResponse = send.sendMessage(message);
        System.out.println(feiShuRobotResponse.getMsg());
    }

    /**
     * lark_md示例
     */
    @Test
    public void test2() {

        CardBody cardBody = CardBody.of()
                .add(Text.builder()
                        .setText(TextEl.builder()
                                .setContent(ContentI18n.of(TextTag.LARK_MD, "text-lark_md"))
                                .setLines(1)
                                .build())
                        .build())
                .add(Text.builder()
                        .setText(TextEl.builder()
                                .setContent(ContentI18n.of(TextTag.LARK_MD, "<a>https://open.feishu.cn</a>"))
                                .build())
                        .build())
                .add(Text.builder()
                        .setText(TextEl.builder()
                                .setContent(ContentI18n.of(TextTag.LARK_MD, "ready\nnew line"))
                                .build())
                        .build())
                .add(Text.builder()
                        .setText(TextEl.builder()
                                .setContent(ContentI18n.of(TextTag.LARK_MD, "*Italic*"))
                                .build())
                        .build())
                .add(Text.builder()
                        .setText(TextEl.builder()
                                .setContent(ContentI18n.of(TextTag.LARK_MD, "**Bold**"))
                                .build())
                        .build())
                .add(Text.builder()
                        .setText(TextEl.builder()
                                .setContent(ContentI18n.of(TextTag.LARK_MD, "~~delete line~~"))
                                .build())
                        .build())
                .add(Text.builder()
                        .setText(TextEl.builder()
                                .setContent(ContentI18n.of(TextTag.LARK_MD, "<at id=all></at>"))
                                .build())
                        .build());

        CardV2Message message = CardV2Message.builder()
                .setBody(cardBody)
                .build();
        String webhok = System.getenv("webhook");
        String secret = System.getenv("secret");
        FeishuRobotClient send = new FeishuRobotClient();
        send.setSecret(secret);
        send.setWebhook(webhok);
        FeishuRobotResponse feiShuRobotResponse = send.sendMessage(message);
        System.out.println(feiShuRobotResponse.getMsg());

    }
}
