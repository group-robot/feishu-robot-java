package io.github.group.robot.feishu.core.model.card.components.containers;

import io.github.group.robot.feishu.core.FeishuRobotClient;
import io.github.group.robot.feishu.core.FeishuRobotResponse;
import io.github.group.robot.feishu.core.constants.ActionType;
import io.github.group.robot.feishu.core.constants.ButtonType;
import io.github.group.robot.feishu.core.constants.FlexMode;
import io.github.group.robot.feishu.core.constants.VerticalAlign;
import io.github.group.robot.feishu.core.model.CardV2Message;
import io.github.group.robot.feishu.core.model.card.CardBody;
import io.github.group.robot.feishu.core.model.card.components.containers.ele.Column;
import io.github.group.robot.feishu.core.model.card.components.content.Markdown;
import io.github.group.robot.feishu.core.model.card.components.ele.ConfirmEl;
import io.github.group.robot.feishu.core.model.card.components.interactive.Button;
import io.github.group.robot.feishu.core.model.card.components.interactive.Input;
import io.github.group.robot.feishu.core.model.card.components.interactive.SelectStatic;
import io.github.group.robot.feishu.core.model.card.components.interactive.ele.SelectOption;
import org.junit.Test;

public class FormContainerTest {

    /**
     * 示例
     */
    @Test
    public void test1() {
        CardBody cardBody = CardBody
                .of()
                .add(
                        FormContainer
                                .builder()
                                .setName("Form_lvxmxsxf")
                                .addElement(
                                        ColumnSet.builder()
                                                .setFlexMode(FlexMode.STRETCH)
                                                .setBackgroundStyle("default")
                                                .addColumn(
                                                        Column
                                                                .builder()
                                                                .setWidth("weighted")
                                                                .setWeight("1")
                                                                .setVerticalAlign(VerticalAlign.TOP)
                                                                .addElement(
                                                                        Markdown.builder().setContent("请选择:").build()
                                                                )
                                                                .build(),
                                                        Column.builder()
                                                                .setWidth("weighted")
                                                                .setWeight("1")
                                                                .setVerticalAlign(VerticalAlign.TOP)
                                                                .addElement(
                                                                        SelectStatic.builder()
                                                                                .setName("Select_pj6kw7cxyl")
                                                                                .setPlaceholder("这是一个选择菜单")
                                                                                .addOption(
                                                                                        SelectOption.of("选项1", "1"),
                                                                                        SelectOption.of("选项2", "2"),
                                                                                        SelectOption.of("选项3", "3"),
                                                                                        SelectOption.of("选项4", "4")
                                                                                )
                                                                                .build()
                                                                )
                                                                .build()
                                                )
                                                .build(),
                                        Input.builder()
                                                .setName("Input_fhaty9jktke")
                                                .setPlaceholder("请输入")
                                                .setMaxLength(5)
                                                .setLabel("请输入文本：")
                                                .setLabelPosition("left")
                                                .build(),
                                        Button.builder()
                                                .setActionType(ActionType.FORM_SUBMIT)
                                                .setName("Button_e4d9u982x5k")
                                                .setText("提交")
                                                .setType(ButtonType.PRIMARY)
                                                .setConfirm(
                                                        ConfirmEl.of()
                                                                .setTitle("title")
                                                                .setContent("确认提交吗")
                                                )
                                                .build()
                                )
                                .build()
                );

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
