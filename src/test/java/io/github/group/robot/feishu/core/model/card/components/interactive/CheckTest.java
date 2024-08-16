package io.github.group.robot.feishu.core.model.card.components.interactive;

import io.github.group.robot.feishu.core.FeishuRobotClient;
import io.github.group.robot.feishu.core.FeishuRobotResponse;
import io.github.group.robot.feishu.core.constants.ButtonSize;
import io.github.group.robot.feishu.core.constants.ButtonType;
import io.github.group.robot.feishu.core.constants.FlexMode;
import io.github.group.robot.feishu.core.constants.IconTag;
import io.github.group.robot.feishu.core.constants.TextTag;
import io.github.group.robot.feishu.core.model.CardV2Message;
import io.github.group.robot.feishu.core.model.card.CardBody;
import io.github.group.robot.feishu.core.model.card.CardHeader;
import io.github.group.robot.feishu.core.model.card.components.CardTitle;
import io.github.group.robot.feishu.core.model.card.components.behaviors.Callback;
import io.github.group.robot.feishu.core.model.card.components.containers.ColumnSet;
import io.github.group.robot.feishu.core.model.card.components.containers.ele.Column;
import io.github.group.robot.feishu.core.model.card.components.content.Title;
import io.github.group.robot.feishu.core.model.card.components.ele.ConfirmEl;
import io.github.group.robot.feishu.core.model.card.components.ele.ContentI18n;
import io.github.group.robot.feishu.core.model.card.components.ele.IconEl;
import io.github.group.robot.feishu.core.model.card.components.ele.TextEl;
import io.github.group.robot.feishu.core.model.card.components.interactive.ele.CheckButtonArea;
import io.github.group.robot.feishu.core.model.card.components.interactive.ele.CheckedStyle;
import io.github.group.robot.feishu.core.util.MapBuilder;
import org.junit.Test;

import java.util.Arrays;

public class CheckTest {


    /**
     * 卡片组件 - 交互 - 勾选器
     */
    @Test
    public void test() {
        ColumnSet columnSet = ColumnSet.builder()
                .setFlexMode(FlexMode.NONE)
                .setBackgroundStyle("default")
                .addColumn(Column.builder()
                        .setWidth("weighted")
                        .setWeight(1)
                        .setVerticalSpacing("1px")
                        .addElement(Check.builder()
                                .setName("check-1")
                                .setChecked(false)
                                .setText(TextEl.builder()
                                        .setContent(ContentI18n.of(TextTag.LARK_MD, "完成新品上市计划报告 \uD83D\uDCAC[战略研讨会](https://open.feishu.cn)"))
                                        .build())
                                .setOverallCheckable(false)
                                .setButtonArea(CheckButtonArea.of()
                                        .setPcDisplayRule("always")
                                        .addButton(Button.builder()
                                                .setType(ButtonType.TEXT)
                                                .setSize(ButtonSize.LARGE)
                                                .setText("")
                                                .setIcon(IconEl.builder()
                                                        .setTag(IconTag.STANDARD_ICON)
                                                        .setToken("forward-com_outlined")
                                                        .setColor("grey-500")
                                                        .build())
                                                .setDisabled(false)
                                                .setBehaviors(Arrays.asList(Callback.of("key", "btn1")))
                                                .build())
                                        .addButton(Button.builder()
                                                .setType(ButtonType.TEXT)
                                                .setSize(ButtonSize.LARGE)
                                                .setText("")
                                                .setIcon(IconEl.builder()
                                                        .setTag(IconTag.STANDARD_ICON)
                                                        .setToken("forward-com_outlined")
                                                        .setColor("grey-500")
                                                        .build())
                                                .setDisabled(false)
                                                .setBehaviors(Arrays.asList(
                                                        MapBuilder.of()
                                                                .put("type", "open_url")
                                                                .put("default_url", "https://www.baidu.com")
                                                                .put("pc_url", "https://www.windows.com")
                                                                .put("android_url", "https://developer.android.com/")
                                                                .put("ios_url", "lark://msgcard/unsupported_action")
                                                                .build()
                                                ))
                                                .build()))
                                .setCheckedStyle(CheckedStyle.of(true, 0.5f))
                                .setPadding("2px 2px 2px 2px")
                                .setBehaviors(Arrays.asList(Callback.of("key", "todo1")))
                                .build())
                        .addElement(Check.builder()
                                .setName("check-2")
                                .setChecked(false)
                                .setText(TextEl.builder()
                                        .setContent(ContentI18n.of(TextTag.LARK_MD, "把材料提前给\uD83D\uDCAC[业务数据共享群](https://open.feishu.cn)审阅"))
                                        .build())
                                .setOverallCheckable(true)
                                .setButtonArea(CheckButtonArea.of()
                                        .setPcDisplayRule("on_hover")
                                        .addButton(Button.builder()
                                                .setType(ButtonType.TEXT)
                                                .setSize(ButtonSize.LARGE)
                                                .setText("")
                                                .setIcon(IconEl.builder()
                                                        .setTag(IconTag.STANDARD_ICON)
                                                        .setToken("forward-com_outlined")
                                                        .setColor("grey-500")
                                                        .build())
                                                .setDisabled(false)
                                                .setBehaviors(Arrays.asList(Callback.of("key", "btn2")))
                                                .build())
                                        .addButton(Button.builder()
                                                .setType(ButtonType.TEXT)
                                                .setSize(ButtonSize.LARGE)
                                                .setText("")
                                                .setIcon(IconEl.builder()
                                                        .setTag(IconTag.STANDARD_ICON)
                                                        .setToken("forward-com_outlined")
                                                        .setColor("grey-500")
                                                        .build())
                                                .setDisabled(false)
                                                .setBehaviors(Arrays.asList(
                                                        MapBuilder.of()
                                                                .put("type", "open_url")
                                                                .put("default_url", "https://www.baidu.com")
                                                                .put("pc_url", "https://www.windows.com")
                                                                .put("android_url", "https://developer.android.com/")
                                                                .put("ios_url", "lark://msgcard/unsupported_action")
                                                                .build()
                                                ))
                                                .build()))
                                .setCheckedStyle(CheckedStyle.of(true, 0.5f))
                                .setPadding("2px 2px 2px 2px")
                                .setConfirm(ConfirmEl.of()
                                        .setTitle("弹窗标题")
                                        .setContent("确认提交吗"))
                                .setBehaviors(Arrays.asList(Callback.of("key", "todo2")))
                                .build())
                        .build())
                .build();

        CardHeader cardHeader = CardHeader.of(CardTitle.builder()
                .setTemplate("blue")
                .setTitle(Title.of("勾选器"))
                .build());

        CardBody cardBody = CardBody.of().add(columnSet);

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
