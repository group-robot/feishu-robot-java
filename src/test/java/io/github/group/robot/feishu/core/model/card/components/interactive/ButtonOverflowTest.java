package io.github.group.robot.feishu.core.model.card.components.interactive;

import io.github.group.robot.feishu.core.FeishuRobotClient;
import io.github.group.robot.feishu.core.FeishuRobotResponse;
import io.github.group.robot.feishu.core.constants.ButtonSize;
import io.github.group.robot.feishu.core.constants.ButtonType;
import io.github.group.robot.feishu.core.model.CardV2Message;
import io.github.group.robot.feishu.core.model.card.CardBody;
import io.github.group.robot.feishu.core.model.card.CardHeader;
import io.github.group.robot.feishu.core.model.card.components.CardTitle;
import io.github.group.robot.feishu.core.model.card.components.content.Title;
import io.github.group.robot.feishu.core.model.card.components.ele.ContentI18n;
import io.github.group.robot.feishu.core.model.card.components.ele.UrlEl;
import io.github.group.robot.feishu.core.model.card.components.interactive.ele.ButtonOverflowOption;
import org.junit.Test;

public class ButtonOverflowTest {

    /**
     * button overflow 示例
     */
    @Test
    public void test() {
        CardBody cardBody = CardBody.of()
                .add(Button.builder()
                        .setText("按钮 1")
                        .setType(ButtonType.DEFAULT)
//                        .setComplexInteraction(true)
                        .setWidth("default")
                        .setSize(ButtonSize.MEDIUM)
                        .build())
                .add(Button.builder()
                        .setText("按钮 2")
                        .setType(ButtonType.DEFAULT)
//                        .setComplexInteraction(true)
                        .setWidth("default")
                        .setSize(ButtonSize.MEDIUM)
                        .build())
                .add(Button.builder()
                        .setText("按钮 3")
                        .setType(ButtonType.DEFAULT)
//                        .setComplexInteraction(true)
                        .setWidth("default")
                        .setSize(ButtonSize.MEDIUM)
                        .build())
                .add(ButtonOverflow.builder()
                        .addOption(ButtonOverflowOption.builder()
                                .setText(ContentI18n.of("按钮 4"))
                                .setMultiUrl(UrlEl.builder()
                                        .setUrl("https://open.feishu.cn/document/home/index")
                                        .setPcUrl("")
                                        .setIosUrl("")
                                        .setAndroidUrl("")
                                        .build())
                                .setValue("document")
                                .build())
                        .addOption(ButtonOverflowOption.builder()
                                .setText(ContentI18n.of("按钮 5"))
                                .setMultiUrl(UrlEl.builder()
                                        .setUrl("https://open.feishu.cn/")
                                        .setPcUrl("")
                                        .setIosUrl("")
                                        .setAndroidUrl("")
                                        .build())
                                .build())
                        .build());


        CardHeader cardHeader = CardHeader.of(CardTitle.builder()
                .setTitle(Title.of("按钮组"))
                .setTemplate("blue")
                .build());

        CardV2Message message = CardV2Message.builder()
                .setHeader(cardHeader)
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
