package io.github.group.robot.feishu.core.model.card.components.content;

import io.github.group.robot.feishu.core.FeishuRobotClient;
import io.github.group.robot.feishu.core.FeishuRobotResponse;
import io.github.group.robot.feishu.core.constants.ButtonSize;
import io.github.group.robot.feishu.core.constants.ButtonType;
import io.github.group.robot.feishu.core.constants.FlexMode;
import io.github.group.robot.feishu.core.constants.HorizontalSpacing;
import io.github.group.robot.feishu.core.constants.TextAlign;
import io.github.group.robot.feishu.core.constants.TextSize;
import io.github.group.robot.feishu.core.model.CardV2Message;
import io.github.group.robot.feishu.core.model.card.CardBody;
import io.github.group.robot.feishu.core.model.card.components.containers.ColumnSet;
import io.github.group.robot.feishu.core.model.card.components.containers.ele.Column;
import io.github.group.robot.feishu.core.model.card.components.ele.ContentI18n;
import io.github.group.robot.feishu.core.model.card.components.ele.TextEl;
import io.github.group.robot.feishu.core.model.card.components.interactive.Button;
import org.junit.Test;

public class HrTest {

    /**
     * 分割线
     */
    @Test
    public void test() {
        ColumnSet columnSet = ColumnSet.builder()
                .setFlexMode(FlexMode.NONE)
                .setHorizontalSpacing(HorizontalSpacing.DEFAULT)
                .setBackgroundStyle("default")
                .addColumn(
                        Column.builder()
                                .setWidth("weighted")
                                .setWeight(1)
                                .addElement(Text.builder()
                                        .setText(TextEl.builder()
                                                .setContent(ContentI18n.of("普通文本示例"))
                                                .setTextSize(TextSize.Normal)
                                                .setTextAlign(TextAlign.LEFT)
                                                .setTextColor("default")
                                                .build())
                                        .build())
                                .build()
                )
                .build();

        CardBody cardBody = CardBody.of()
                .add(columnSet)
                .add(Hr.of())
                .add(Button.builder()
                        .setText("查看更多")
                        .setType(ButtonType.PRIMARY)
                        .setWidth("default")
                        .setSize(ButtonSize.MEDIUM)
                        .build());

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
