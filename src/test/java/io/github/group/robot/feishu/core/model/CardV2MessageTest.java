package io.github.group.robot.feishu.core.model;

import io.github.group.robot.feishu.core.FeishuRobotClient;
import io.github.group.robot.feishu.core.FeishuRobotResponse;
import io.github.group.robot.feishu.core.constants.ButtonType;
import io.github.group.robot.feishu.core.constants.TextTag;
import io.github.group.robot.feishu.core.model.card.CardBody;
import io.github.group.robot.feishu.core.model.card.CardHeader;
import io.github.group.robot.feishu.core.model.card.components.CardTitle;
import io.github.group.robot.feishu.core.model.card.components.content.Text;
import io.github.group.robot.feishu.core.model.card.components.content.Title;
import io.github.group.robot.feishu.core.model.card.components.ele.ContentI18n;
import io.github.group.robot.feishu.core.model.card.components.ele.TextEl;
import io.github.group.robot.feishu.core.model.card.components.interactive.Button;
import org.junit.Test;

public class CardV2MessageTest {

    @Test
    public void toMessage() {
        CardHeader cardHeader = CardHeader.of(
                CardTitle
                        .builder()
                        .setTitle(Title.of("今日旅游推荐"))
                        .build()
        );
        CardBody cardBody = CardBody
                .of()
                .add(Text.builder().setText(TextEl.builder()
                        .setContent(ContentI18n.of(TextTag.LARK_MD, "**西湖**，位于浙江省杭州市西湖区龙井路1号，杭州市区西部，景区总面积49平方千米，汇水面积为21" +
                                ".22平方千米，湖面面积为6.38平方千米。"))
                        .build()).build())
                .add(Button.builder()
                        .setText("更多景点介绍 :玫瑰:")
                        .setType(ButtonType.DEFAULT)
                        .build());


        CardV2Message cardV2Message = CardV2Message
                .builder()
                .setHeader(cardHeader)
                .setBody(cardBody)
                .build();

        String webhok = System.getenv("webhook");
        String secret = System.getenv("secret");
        FeishuRobotClient send = new FeishuRobotClient();
        send.setSecret(secret);
        send.setWebhook(webhok);
        FeishuRobotResponse feiShuRobotResponse = send.sendMessage(cardV2Message);
        System.out.println(feiShuRobotResponse.getMsg());
    }
}
