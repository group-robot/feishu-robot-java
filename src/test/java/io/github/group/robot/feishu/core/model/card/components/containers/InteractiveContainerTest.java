package io.github.group.robot.feishu.core.model.card.components.containers;

import io.github.group.robot.feishu.core.FeishuRobotClient;
import io.github.group.robot.feishu.core.FeishuRobotResponse;
import io.github.group.robot.feishu.core.constants.FlexMode;
import io.github.group.robot.feishu.core.constants.IconTag;
import io.github.group.robot.feishu.core.constants.ScaleType;
import io.github.group.robot.feishu.core.constants.TextSize;
import io.github.group.robot.feishu.core.model.CardV2Message;
import io.github.group.robot.feishu.core.model.card.CardBody;
import io.github.group.robot.feishu.core.model.card.CardConfig;
import io.github.group.robot.feishu.core.model.card.CardHeader;
import io.github.group.robot.feishu.core.model.card.components.CardTitle;
import io.github.group.robot.feishu.core.model.card.components.behaviors.Callback;
import io.github.group.robot.feishu.core.model.card.components.containers.ele.Column;
import io.github.group.robot.feishu.core.model.card.components.content.Img;
import io.github.group.robot.feishu.core.model.card.components.content.Markdown;
import io.github.group.robot.feishu.core.model.card.components.content.Title;
import io.github.group.robot.feishu.core.model.card.components.ele.IconEl;
import io.github.group.robot.feishu.core.model.card.components.ele.ImageEl;
import org.junit.Test;

import java.util.Arrays;

public class InteractiveContainerTest {

    /**
     * 示例
     */
    @Test
    public void test1() {
        CardBody cardBody = CardBody.of()
                .add(
                        Markdown.builder().setContent("在「内容创作」话题下，我可以帮助你进行产品方案、营销文案、工作报告等内容的创作。").build(),
                        ColumnSet.builder()
                                .setFlexMode(FlexMode.NONE)
                                .setBackgroundStyle("default")
                                .addColumn(
                                        Column.builder()
                                                .setWidth("weighted")
                                                .setWeight("1")
                                                .setVerticalSpacing("8px")
                                                .addElement(
                                                        Markdown.builder()
                                                                .setContent("<font color='grey'>你可以对我说：</font>")
                                                                .setTextSize(TextSize.Notation).build(),
                                                        InteractiveContainer.builder()
                                                                .setWidth("fill")
                                                                .setHeight("auto")
                                                                .setBackgroundStyle("default")
                                                                .setHasBorder(true)
                                                                .setBorderColor("grey")
                                                                .setCornerRadius("8px")
                                                                .setPadding("4px 12px 4px 12px")
                                                                .setBehaviors(
                                                                        Arrays.asList(Callback.of("key", "value"))
                                                                )
                                                                .addElements(
                                                                        Markdown.builder()
                                                                                .setContent("帮我生成一篇产品方案的框架")
                                                                                .setIcon(
                                                                                        IconEl.builder()
                                                                                                .setColor("orange")
                                                                                                .setTag(IconTag.STANDARD_ICON)
                                                                                                .setToken("frame-selection_outlined")
                                                                                                .build()
                                                                                )
                                                                                .build()
                                                                )
                                                                .build(),
                                                        InteractiveContainer.builder()
                                                                .setWidth("fill")
                                                                .setHeight("auto")
                                                                .setBackgroundStyle("default")
                                                                .setHasBorder(true)
                                                                .setBorderColor("grey")
                                                                .setCornerRadius("8px")
                                                                .setPadding("4px 12px 4px 12px")
                                                                .setBehaviors(
                                                                        Arrays.asList(Callback.of("key", "value"))
                                                                )
                                                                .setDisabled(false)
                                                                .addElements(
                                                                        Markdown.builder()
                                                                                .setContent("帮我生成一篇营销文案的框架")
                                                                                .setIcon(
                                                                                        IconEl.builder()
                                                                                                .setColor("orange")
                                                                                                .setTag(IconTag.STANDARD_ICON)
                                                                                                .setToken("file-link-docx_outlined")
                                                                                                .build()
                                                                                )
                                                                                .build()
                                                                )
                                                                .build(),
                                                        InteractiveContainer.builder()
                                                                .setWidth("fill")
                                                                .setHeight("auto")
                                                                .setBackgroundStyle("default")
                                                                .setHasBorder(true)
                                                                .setBorderColor("grey")
                                                                .setCornerRadius("8px")
                                                                .setPadding("4px 12px 4px 12px")
                                                                .setBehaviors(
                                                                        Arrays.asList(Callback.of("key", "value"))
                                                                )
                                                                .setDisabled(false)
                                                                .addElements(
                                                                        Markdown.builder()
                                                                                .setContent("帮我写一篇周报")
                                                                                .setIcon(
                                                                                        IconEl.builder()
                                                                                                .setColor("orange")
                                                                                                .setTag(IconTag.STANDARD_ICON)
                                                                                                .setToken("pa-calibration-report_outlined")
                                                                                                .build()
                                                                                )
                                                                                .build()
                                                                )
                                                                .build()
                                                )
                                                .build()
                                )
                                .build(),
                        ColumnSet.builder()
                                .setFlexMode(FlexMode.NONE)
                                .setBackgroundStyle("default")
                                .addColumn(
                                        Column.builder()
                                                .setWidth("weighted")
                                                .setWeight("1")
                                                .setVerticalSpacing("8px")
                                                .addElement(
                                                        Markdown.builder()
                                                                .setContent("<font color='grey'>或者继续之前的话题</font>")
                                                                .setTextSize(TextSize.Notation)
                                                                .build(),
                                                        InteractiveContainer.builder()
                                                                .setWidth("fill")
                                                                .setHeight("auto")
                                                                .setBackgroundStyle("default")
                                                                .setHasBorder(true)
                                                                .setBorderColor("grey")
                                                                .setCornerRadius("8px")
                                                                .setPadding("4px 12px 4px 12px")
                                                                .setBehaviors(Arrays.asList(Callback.of("key", "value")))
                                                                .setDisabled(false)
                                                                .addElements(
                                                                        ColumnSet.builder()
                                                                                .setFlexMode(FlexMode.NONE)
                                                                                .setBackgroundStyle("default")
                                                                                .addColumn(
                                                                                        Column.builder()
                                                                                                .setWidth("weighted")
                                                                                                .setWeight("1")
                                                                                                .addElement(
                                                                                                        Markdown.builder()
                                                                                                                .setContent("内容创作:创作暑假营销活动文案")
                                                                                                                .setIcon(
                                                                                                                        IconEl.builder()
                                                                                                                                .setTag(IconTag.STANDARD_ICON)
                                                                                                                                .setToken("chat-history_outlined")
                                                                                                                                .build()
                                                                                                                )
                                                                                                                .build()
                                                                                                )
                                                                                                .build(),
                                                                                        Column.builder()
                                                                                                .setWidth("auto")
                                                                                                .setWeight("1")
                                                                                                .addElement(
                                                                                                        Markdown.builder()
                                                                                                                .setContent("<font color='grey'>昨天</font>")
                                                                                                                .setTextSize(TextSize.Notation)
                                                                                                                .build()
                                                                                                )
                                                                                                .build()
                                                                                )
                                                                                .build()
                                                                )
                                                                .build(),
                                                        InteractiveContainer.builder()
                                                                .setWidth("fill")
                                                                .setHeight("auto")
                                                                .setBackgroundStyle("default")
                                                                .setHasBorder(true)
                                                                .setBorderColor("grey")
                                                                .setCornerRadius("8px")
                                                                .setPadding("4px 12px 4px 12px")
                                                                .setBehaviors(Arrays.asList(Callback.of("key", "value")))
                                                                .setDisabled(false)
                                                                .addElements(
                                                                        ColumnSet.builder()
                                                                                .setFlexMode(FlexMode.NONE)
                                                                                .setBackgroundStyle("default")
                                                                                .addColumn(
                                                                                        Column.builder()
                                                                                                .setWidth("weighted")
                                                                                                .setWeight(1)
                                                                                                .addElement(
                                                                                                        Markdown.builder()
                                                                                                                .setContent("内容创作:生成了季度工作报告")
                                                                                                                .setIcon(
                                                                                                                        IconEl.builder().setTag(IconTag.STANDARD_ICON).setToken("chat-history_outlined").build()
                                                                                                                )
                                                                                                                .build()
                                                                                                )
                                                                                                .build(),
                                                                                        Column.builder()
                                                                                                .setWidth("auto")
                                                                                                .setWeight(1)
                                                                                                .addElement(
                                                                                                        Markdown.builder()
                                                                                                                .setContent("<font color='grey'>上周</font>")
                                                                                                                .setTextSize(TextSize.Notation)
                                                                                                                .build()
                                                                                                )
                                                                                                .build()
                                                                                )
                                                                                .build()
                                                                )
                                                                .build(),
                                                        InteractiveContainer.builder()
                                                                .setWidth("fill")
                                                                .setHeight("auto")
                                                                .setBackgroundStyle("default")
                                                                .setHasBorder(true)
                                                                .setBorderColor("grey")
                                                                .setCornerRadius("8px")
                                                                .setPadding("4px 12px 4px 12px")
                                                                .setBehaviors(Arrays.asList(Callback.of("key", "value")))
                                                                .setDisabled(false)
                                                                .addElements(
                                                                        Markdown.builder()
                                                                                .setContent("更多历史话题")
                                                                                .setIcon(
                                                                                        IconEl.builder()
                                                                                                .setTag(IconTag.STANDARD_ICON)
                                                                                                .setToken("chat-history_outlined")
                                                                                                .build()
                                                                                )
                                                                                .build()
                                                                )
                                                                .build()
                                                )
                                                .build()
                                )
                                .build(),
                        ColumnSet.builder()
                                .setFlexMode(FlexMode.NONE)
                                .setBackgroundStyle("default")
                                .addColumn(
                                        Column.builder()
                                                .setWidth("weighted")
                                                .setWeight(1)
                                                .setVerticalSpacing("8px")
                                                .addElement(
//                                                        Note.of(
//                                                                TextEl.builder()
//                                                                        .setTag(TextTag.PLAIN_TEXT)
//                                                                        .setContent("本话题中已选择以下插件")
//                                                                        .build()
//                                                        ),
                                                        InteractiveContainer.builder()
                                                                .setWidth("auto")
                                                                .setHeight("auto")
                                                                .setBackgroundStyle("grey")
                                                                .setHasBorder(false)
                                                                .setBorderColor("grey")
                                                                .setCornerRadius("40px")
                                                                .setPadding("2px 8px 2px 4px")
                                                                .setBehaviors(Arrays.asList(Callback.of("key", "value")))
                                                                .setDisabled(false)
                                                                .addElements(
                                                                        ColumnSet.builder()
                                                                                .setFlexMode(FlexMode.NONE)
                                                                                .setBackgroundStyle("default")
                                                                                .setHorizontalSpacing("4px")
                                                                                .addColumn(

                                                                                        Column.builder()
                                                                                                .setWidth("auto")
                                                                                                .setWeight(1)
                                                                                                .setVerticalSpacing("8px")
                                                                                                .addElement(
                                                                                                        Img.builder()
                                                                                                                .setImg(ImageEl.of("img_v2_58e37110-6878-44ee-bce4-7a571c1bb70g"))
                                                                                                                .setTransparent(true)
                                                                                                                .setCaleType(ScaleType.CROP_CENTER)
                                                                                                                .setSize("18px 18px")
                                                                                                                .setPreview(false)
                                                                                                                .build()
                                                                                                )
                                                                                                .build(),
                                                                                        Column.builder()
                                                                                                .setWidth("weighted")
                                                                                                .setWeight(1)
                                                                                                .setVerticalSpacing("8px")
                                                                                                .addElement(
                                                                                                        Markdown.builder()
                                                                                                                .setContent("妙记插件")
                                                                                                                .build()
                                                                                                )
                                                                                                .build()
                                                                                )
                                                                                .build()
                                                                )
                                                                .build()
                                                )
                                                .build()
                                )
                                .build()
                );

        CardHeader cardHeader = CardHeader.of(
                CardTitle.builder()
                        .setTitle(Title.of("交互容器示例（依赖端版本 7.4+)"))
//                        .setUdIcon(
//                                CardTitle.UdIcon.of("chat-history_outlined", "blue")
//                        )
                        .build()
        );
        CardConfig cardConfig = CardConfig.builder().setWidthMode("compact").build();


        CardV2Message message = CardV2Message.builder()
                .setBody(cardBody)
                .setConfig(cardConfig)
                .setHeader(cardHeader)
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
