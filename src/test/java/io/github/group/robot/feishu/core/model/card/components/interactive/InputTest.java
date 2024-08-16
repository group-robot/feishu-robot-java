package io.github.group.robot.feishu.core.model.card.components.interactive;

import io.github.group.robot.feishu.core.FeishuRobotClient;
import io.github.group.robot.feishu.core.FeishuRobotResponse;
import io.github.group.robot.feishu.core.constants.ActionType;
import io.github.group.robot.feishu.core.constants.ButtonType;
import io.github.group.robot.feishu.core.constants.FlexMode;
import io.github.group.robot.feishu.core.constants.InputType;
import io.github.group.robot.feishu.core.constants.VerticalAlign;
import io.github.group.robot.feishu.core.model.CardV2Message;
import io.github.group.robot.feishu.core.model.card.CardBody;
import io.github.group.robot.feishu.core.model.card.CardConfig;
import io.github.group.robot.feishu.core.model.card.CardLink;
import io.github.group.robot.feishu.core.model.card.components.containers.ColumnSet;
import io.github.group.robot.feishu.core.model.card.components.containers.FormContainer;
import io.github.group.robot.feishu.core.model.card.components.containers.ele.Column;
import io.github.group.robot.feishu.core.model.card.components.ele.FallbackEl;
import org.junit.Test;

public class InputTest {

    /**
     * 示例
     */
    @Test
    public void test() {
        FormContainer formContainer = FormContainer.builder()
                .setName("Form_lrocopxr")
                .addElement(Input.builder()
                        .setPlaceholder("请输入")
                        .setDefaultValue("")
                        .setWidth("default")
                        .setLabel("用户名：")
                        .setName("Input_31q6mtuvdx9")
                        .setFallback(FallbackEl.of().setContent("仅支持在 V6.8 及以上版本使用"))
                        .build())
                .addElement(Input.builder()
                        .setInputType(InputType.PASSWORD)
                        .setPlaceholder("请输入")
                        .setDefaultValue("")
                        .setWidth("default")
                        .setLabel("密码：")
                        .setLabelPosition("top")
                        .setName("Input_5hez3q41fck")
                        .setFallback(FallbackEl.of().setContent("仅支持在 V6.8 及以上版本使用"))
                        .build())
                .addElement(Input.builder()
                        .setInputType(InputType.MULTILINE_TEXT)
                        .setRows(4)
                        .setAutoResize(true)
                        .setPlaceholder("请输入")
                        .setDefaultValue("")
                        .setWidth("default")
                        .setLabel("收货地址：")
                        .setName("Input_u2k3lbrokvd")
                        .setFallback(FallbackEl.of().setContent("仅支持在 V6.8 及以上版本使用"))
                        .build())
                .addElement(ColumnSet.builder()
                        .setFlexMode(FlexMode.NONE)
                        .setBackgroundStyle("default")
                        .setHorizontalSpacing("default")
                        .setMargin("0px")
                        .addColumn(Column.builder()
                                .setWidth("auto")
                                .setVerticalAlign(VerticalAlign.TOP)
                                .addElement(Button.builder()
                                        .setText("提交")
                                        .setType(ButtonType.PRIMARY)
                                        .setActionType(ActionType.FORM_SUBMIT)
                                        .setName("Button_lrocopxs")
                                        .build())
                                .build())
                        .addColumn(Column.builder()
                                .setWidth("auto")
                                .setVerticalAlign(VerticalAlign.TOP)
                                .addElement(Button.builder()
                                        .setText("取消")
                                        .setType(ButtonType.DEFAULT)
                                        .setActionType(ActionType.FORM_RESET)
                                        .setName("Button_lrocopxt")
                                        .build())
                                .build())
                        .build())
                .build();


        CardV2Message message = CardV2Message.builder()
                .setCardLink(CardLink.of(""))
                .setConfig(CardConfig.builder().setWidthMode("compact").build())
                .setBody(CardBody.of(formContainer))
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
