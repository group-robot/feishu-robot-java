package io.github.group.robot.feishu.core.model.card.components.interactive;

import io.github.group.robot.feishu.core.FeishuRobotClient;
import io.github.group.robot.feishu.core.FeishuRobotResponse;
import io.github.group.robot.feishu.core.constants.ActionType;
import io.github.group.robot.feishu.core.constants.ButtonType;
import io.github.group.robot.feishu.core.constants.ImgLayout;
import io.github.group.robot.feishu.core.model.CardV2Message;
import io.github.group.robot.feishu.core.model.card.CardBody;
import io.github.group.robot.feishu.core.model.card.CardHeader;
import io.github.group.robot.feishu.core.model.card.components.CardTitle;
import io.github.group.robot.feishu.core.model.card.components.containers.FormContainer;
import io.github.group.robot.feishu.core.model.card.components.content.Title;
import io.github.group.robot.feishu.core.model.card.components.ele.ContentI18n;
import io.github.group.robot.feishu.core.model.card.components.interactive.ele.ImgOption;
import org.junit.Test;

public class SelectImgTest {

    /**
     * 单选后立即提交选项内容
     */
    @Test
    public void test1() {
        CardBody cardBody = CardBody.of()
                .add(SelectImg.builder()
                        .setName("select_img-1")
                        .setLayout(ImgLayout.BISECT)
                        .setAspectRatio("16:9")
                        .setDisabled(false)
                        .setDisabledTips(ContentI18n.of("用户禁用提示文案"))
                        .addOption(ImgOption.builder()
                                .setImgKey("img_v2_9dd98485-2900-4d65-ada9-e31d1408dcfg")
                                .setValue("picture1")
                                .setDisabled(false)
                                .setDisabledTips(ContentI18n.of("用户禁用提示文案1"))
                                .setHoverTips(ContentI18n.of("第一张图"))
                                .build())
                        .addOption(ImgOption.builder()
                                .setImgKey("img_v2_9dd98485-2900-4d65-ada9-e31d1408dcfg")
                                .setValue("picture2")
                                .setDisabled(false)
                                .setDisabledTips(ContentI18n.of("用户禁用提示文案2"))
                                .setHoverTips(ContentI18n.of("第二张图"))
                                .build())
                        .addOption(ImgOption.builder()
                                .setImgKey("img_v2_9dd98485-2900-4d65-ada9-e31d1408dcfg")
                                .setValue("picture3")
                                .setDisabled(false)
                                .setDisabledTips(ContentI18n.of("用户禁用提示文案3"))
                                .setHoverTips(ContentI18n.of("第三张图"))
                                .build())
                        .addOption(ImgOption.builder()
                                .setImgKey("img_v2_9dd98485-2900-4d65-ada9-e31d1408dcfg")
                                .setValue("picture4")
                                .setDisabled(false)
                                .setDisabledTips(ContentI18n.of("用户禁用提示文案4"))
                                .setHoverTips(ContentI18n.of("第四张图"))
                                .build())
                        .addOption(ImgOption.builder()
                                .setImgKey("img_v2_9dd98485-2900-4d65-ada9-e31d1408dcfg")
                                .setValue("picture5")
                                .setDisabled(false)
                                .setDisabledTips(ContentI18n.of("用户禁用提示文案5"))
                                .setHoverTips(ContentI18n.of("第五张图"))
                                .build())
                        .addOption(ImgOption.builder()
                                .setImgKey("img_v2_9dd98485-2900-4d65-ada9-e31d1408dcfg")
                                .setValue("picture6")
                                .setDisabled(false)
                                .setDisabledTips(ContentI18n.of("用户禁用提示文案6"))
                                .setHoverTips(ContentI18n.of("第六张图"))
                                .build())
                        .build());

        CardHeader cardHeader = CardHeader.of(CardTitle.builder()
                .setTemplate("blue")
                .setTitle(Title.of("图片选择器-单选后立即提交选项内容"))
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

    /**
     * 在表单容器中异步提交多选的选项内容
     */
    @Test
    public void test2() {
        FormContainer formContainer = FormContainer.builder()
                .setName("form1")
                .addElement(SelectImg.builder()
                        .setMultiSelect(false)
                        .setName("select_img-1")
                        .setLayout(ImgLayout.BISECT)
                        .setCanPreview(false)
                        .setAspectRatio("16:9")
                        .setDisabled(false)
                        .setDisabledTips(ContentI18n.of("用户禁用提示文案"))
                        .addOption(ImgOption.builder()
                                .setImgKey("img_v2_9dd98485-2900-4d65-ada9-e31d1408dcfg")
                                .setValue("picture1")
                                .setDisabled(false)
                                .setDisabledTips(ContentI18n.of("用户禁用提示文案1"))
                                .setHoverTips(ContentI18n.of("第一张图"))
                                .build())
                        .addOption(ImgOption.builder()
                                .setImgKey("img_v2_9dd98485-2900-4d65-ada9-e31d1408dcfg")
                                .setValue("picture2")
                                .setDisabled(false)
                                .setDisabledTips(ContentI18n.of("用户禁用提示文案2"))
                                .setHoverTips(ContentI18n.of("第二张图"))
                                .build())
                        .addOption(ImgOption.builder()
                                .setImgKey("img_v2_9dd98485-2900-4d65-ada9-e31d1408dcfg")
                                .setValue("picture3")
                                .setDisabled(false)
                                .setDisabledTips(ContentI18n.of("用户禁用提示文案3"))
                                .setHoverTips(ContentI18n.of("第三张图"))
                                .build())
                        .addOption(ImgOption.builder()
                                .setImgKey("img_v2_9dd98485-2900-4d65-ada9-e31d1408dcfg")
                                .setValue("picture4")
                                .setDisabled(false)
                                .setDisabledTips(ContentI18n.of("用户禁用提示文案4"))
                                .setHoverTips(ContentI18n.of("第四张图"))
                                .build())
                        .addOption(ImgOption.builder()
                                .setImgKey("img_v2_9dd98485-2900-4d65-ada9-e31d1408dcfg")
                                .setValue("picture5")
                                .setDisabled(false)
                                .setDisabledTips(ContentI18n.of("用户禁用提示文案5"))
                                .setHoverTips(ContentI18n.of("第五张图"))
                                .build())
                        .addOption(ImgOption.builder()
                                .setImgKey("img_v2_9dd98485-2900-4d65-ada9-e31d1408dcfg")
                                .setValue("picture6")
                                .setDisabled(false)
                                .setDisabledTips(ContentI18n.of("用户禁用提示文案6"))
                                .setHoverTips(ContentI18n.of("第六张图"))
                                .build())
                        .build())
                .addElement(Button.builder()
                        .setText("提交")
                        .setType(ButtonType.PRIMARY)
                        .setName("button-submit")
                        .setActionType(ActionType.FORM_SUBMIT)
                        .build())
                .addElement(Button.builder()
                        .setText("取消")
                        .setType(ButtonType.DEFAULT)
                        .setName("button-cancel")
                        .setActionType(ActionType.FORM_RESET)
                        .build())
                .build();

        CardBody cardBody = CardBody.of().add(formContainer);

        CardHeader cardHeader = CardHeader.of(CardTitle.builder()
                .setTemplate("blue")
                .setTitle(Title.of("图片选择器-form表单提交"))
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
