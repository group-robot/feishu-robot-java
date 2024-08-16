package io.github.group.robot.feishu.core.model.card.components.interactive;

import io.github.group.robot.feishu.core.FeishuRobotClient;
import io.github.group.robot.feishu.core.FeishuRobotResponse;
import io.github.group.robot.feishu.core.constants.ButtonType;
import io.github.group.robot.feishu.core.constants.FlexMode;
import io.github.group.robot.feishu.core.constants.VerticalAlign;
import io.github.group.robot.feishu.core.model.CardV2Message;
import io.github.group.robot.feishu.core.model.card.CardBody;
import io.github.group.robot.feishu.core.model.card.CardHeader;
import io.github.group.robot.feishu.core.model.card.components.CardTitle;
import io.github.group.robot.feishu.core.model.card.components.containers.ColumnSet;
import io.github.group.robot.feishu.core.model.card.components.containers.ele.Column;
import io.github.group.robot.feishu.core.model.card.components.content.Title;
import io.github.group.robot.feishu.core.util.MapBuilder;
import org.junit.Test;

import java.util.Arrays;

public class ButtonTest {


    /**
     * button 示例
     */
    @Test
    public void test() {
        ColumnSet columnSet1 = ColumnSet.builder()
                .setFlexMode(FlexMode.FLOW)
                .setBackgroundStyle("default")
                .addColumn(Column.builder()
                        .setWidth("auto")
                        .setWeight(1)
                        .setVerticalAlign(VerticalAlign.TOP)
                        .addElement(Button.builder()
                                .setText("镭射按钮")
                                .setBehaviors(Arrays.asList(
                                        MapBuilder.of()
                                                .put("type", "open_url")
                                                .put("default_url", "https://open.feishu.cn/document")
                                                .put("android_url", "https://developer.android.com/")
                                                .put("ios_url", "lark://msgcard/unsupported_action")
                                                .put("pc_url", "https://www.windows.com")
                                                .build()))
                                .setType(ButtonType.LASER)
                                .setHoverTips("hover提示")
                                .setValue(MapBuilder.of().put("key", "value").build())
                                .build())
                        .build())
                .addColumn(Column.builder()
                        .setWidth("auto")
                        .setWeight(1)
                        .setVerticalAlign(VerticalAlign.TOP)
                        .addElement(Button.builder()
                                .setType(ButtonType.LASER)
                                .setText("镭射禁用按钮")
                                .setDisabled(true)
                                .setDisabledTips("禁用 hover 提示")
                                .setBehaviors(Arrays.asList(
                                        MapBuilder.of()
                                                .put("type", "open_url")
                                                .put("default_url", "https://open.feishu.cn/document")
                                                .put("android_url", "https://developer.android.com/")
                                                .put("ios_url", "lark://msgcard/unsupported_action")
                                                .put("pc_url", "https://www.windows.com")
                                                .build()))
                                .build())
                        .build())
                .build();

        ColumnSet columnSet2 = ColumnSet.builder()
                .setFlexMode(FlexMode.FLOW)
                .setBackgroundStyle("default")
                .addColumn(Column.builder()
                        .setWidth("auto")
                        .setWeight(1)
                        .setVerticalAlign(VerticalAlign.TOP)
                        .addElement(Button.builder()
                                .setText("primary")
                                .setUrl("https://open.feishu.cn/document")
                                .setType(ButtonType.PRIMARY)
                                .setHoverTips("我是 primary button")
                                .setValue("key", "value")
                                .build())
                        .build())
                .addColumn(Column.builder()
                        .setWidth("auto")
                        .setWeight(1)
                        .setVerticalAlign(VerticalAlign.TOP)
                        .addElement(Button.builder()
                                .setType(ButtonType.DEFAULT)
                                .setText("default")
                                .setType(ButtonType.DEFAULT)
                                .setHoverTips("我是 default 按钮")
                                .setBehaviors(Arrays.asList(
                                        MapBuilder.of()
                                                .put("type", "open_url")
                                                .put("default_url", "https://open.feishu.cn/document")
                                                .put("android_url", "https://developer.android.com/")
                                                .put("ios_url", "lark://msgcard/unsupported_action")
                                                .put("pc_url", "https://www.windows.com")
                                                .build()))
                                .build())
                        .build())
                .addColumn(Column.builder()
                        .setWidth("auto")
                        .setWeight(1)
                        .setVerticalAlign(VerticalAlign.TOP)
                        .addElement(Button.builder()
                                .setType(ButtonType.DANGER)
                                .setText("我是 danger 按钮")
                                .setHoverTips("我是 danger 按钮")
                                .setBehaviors(Arrays.asList(
                                        MapBuilder.of()
                                                .put("type", "open_url")
                                                .put("default_url", "https://open.feishu.cn/document")
                                                .put("android_url", "https://developer.android.com/")
                                                .put("ios_url", "lark://msgcard/unsupported_action")
                                                .put("pc_url", "https://www.windows.com")
                                                .build()))
                                .build())
                        .build())
                .addColumn(Column.builder()
                        .setWidth("auto")
                        .setWeight(1)
                        .setVerticalAlign(VerticalAlign.TOP)
                        .addElement(Button.builder()
                                .setType(ButtonType.DANGER)
                                .setText("我是 disabled 按钮")
                                .setDisabled(true)
                                .setDisabledTips("我是 disabled 按钮，我被禁用了")
                                .setBehaviors(Arrays.asList(
                                        MapBuilder.of()
                                                .put("type", "open_url")
                                                .put("default_url", "https://open.feishu.cn/document")
                                                .put("android_url", "https://developer.android.com/")
                                                .put("ios_url", "lark://msgcard/unsupported_action")
                                                .put("pc_url", "https://www.windows.com")
                                                .build()))
                                .build())
                        .build())
                .build();


        CardHeader cardHeader = CardHeader.of(CardTitle.builder()
                .setTemplate("blue")
                .setTitle(Title.of("Buttons"))
                .build());

        CardBody cardBody = CardBody.of()
                .add(columnSet1)
                .add(columnSet2);

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
