package io.github.group.robot.feishu.core.model.card.components.interactive;

import io.github.group.robot.feishu.core.FeishuRobotClient;
import io.github.group.robot.feishu.core.FeishuRobotResponse;
import io.github.group.robot.feishu.core.constants.IconTag;
import io.github.group.robot.feishu.core.constants.SelectType;
import io.github.group.robot.feishu.core.model.CardV2Message;
import io.github.group.robot.feishu.core.model.card.CardBody;
import io.github.group.robot.feishu.core.model.card.CardHeader;
import io.github.group.robot.feishu.core.model.card.components.CardTitle;
import io.github.group.robot.feishu.core.model.card.components.content.Title;
import io.github.group.robot.feishu.core.model.card.components.ele.IconEl;
import io.github.group.robot.feishu.core.model.card.components.interactive.ele.SelectOption;
import org.junit.Test;

public class SelectStaticTest {

    /**
     * select static 示例
     */
    @Test
    public void test() {
        CardBody cardBody = CardBody.of()
                .add(SelectStatic.builder()
                        .setPlaceholder("请选择")
                        .addOption(SelectOption.of("选项1", "1")
                                .setIcon(IconEl.builder()
                                        .setTag(IconTag.STANDARD_ICON)
                                        .setToken("signature_outlined")
                                        .build()))
                        .addOption(SelectOption.of("选项2", "2")
                                .setIcon(IconEl.builder()
                                        .setTag(IconTag.STANDARD_ICON)
                                        .setToken("signature_outlined")
                                        .build()))
                        .setType(SelectType.DEFAULT)
                        .setWidth("default")
                        .setInitialOption("选项1")
                        .build());

        CardHeader cardHeader = CardHeader.of(CardTitle.builder()
                .setTemplate("blue")
                .setTitle(Title.of("下拉选择-单选"))
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
