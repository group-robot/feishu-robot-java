package io.github.group.robot.feishu.core.model.card.components.containers;

import io.github.group.robot.feishu.core.FeishuRobotClient;
import io.github.group.robot.feishu.core.FeishuRobotResponse;
import io.github.group.robot.feishu.core.constants.FlexMode;
import io.github.group.robot.feishu.core.constants.HorizontalSpacing;
import io.github.group.robot.feishu.core.constants.TextAlign;
import io.github.group.robot.feishu.core.constants.VerticalAlign;
import io.github.group.robot.feishu.core.model.CardV2Message;
import io.github.group.robot.feishu.core.model.card.CardBody;
import io.github.group.robot.feishu.core.model.card.CardHeader;
import io.github.group.robot.feishu.core.model.card.components.CardTitle;
import io.github.group.robot.feishu.core.model.card.components.containers.ele.Column;
import io.github.group.robot.feishu.core.model.card.components.content.Hr;
import io.github.group.robot.feishu.core.model.card.components.content.Img;
import io.github.group.robot.feishu.core.model.card.components.content.Markdown;
import io.github.group.robot.feishu.core.model.card.components.content.Title;
import io.github.group.robot.feishu.core.model.card.components.ele.ContentI18n;
import io.github.group.robot.feishu.core.model.card.components.ele.ImageEl;
import io.github.group.robot.feishu.core.model.card.components.ele.UrlEl;
import org.junit.Test;

public class ColumnSetTest {


    /**
     * 差旅卡片
     */
    @Test
    public void test1() {
        CardHeader cardHeader = CardHeader.of(
                CardTitle.builder()
                        .setTitle(Title.of("\uD83C\uDFE8 酒店申请已通过，请选择房型"))
                        .setTemplate("green")
                        .build());
        CardBody cardBody = CardBody.of(
                Markdown.builder().setContent("入住酒店：杭州xxxx酒店\n<font color='grey'>\uD83D\uDCCD 浙江省杭州市西湖区</font>").build(),
                Hr.of(),
                ColumnSet.builder()
                        .setFlexMode(FlexMode.NONE)
                        .setBackgroundStyle("default")
                        .setHorizontalSpacing(HorizontalSpacing.DEFAULT)
                        .setAction(
                                UrlEl.builder()
                                        .setUrl("https://open.feishu.cn")
                                        .setAndroidUrl("https://developer.android.com/")
                                        .setIosUrl("https://developer.apple.com/")
                                        .setPcUrl("https://www.windows.com")
                                        .build())
                        .addColumn(
                                Column.builder()
                                        .setWidth("weighted")
                                        .setWeight("1")
                                        .setVerticalAlign(VerticalAlign.CENTER)
                                        .addElement(
                                                Img.builder()
                                                        .setImg(ImageEl
                                                                .of("img_v2_120b03c8-27e3-456f-89c0-90ede1aa59ag")
                                                                .setAlt(ContentI18n.of().setContent("")))
                                                        .build()
                                        )
                                        .build(),
                                Column.builder()
                                        .setWidth("weighted")
                                        .setWeight("3")
                                        .addElement(
                                                Markdown.builder()
                                                        .setContent("**高级双床房**\n<font color='grey'>双早|40-47㎡|有窗户|双床</font>\n<font color='red'>¥699</font> 起")
                                                        .setTextAlign(TextAlign.LEFT)
                                                        .build()
                                        ).build()
                        )
                        .build(),
                Hr.of(),
                ColumnSet.builder()
                        .setFlexMode(FlexMode.NONE)
                        .setBackgroundStyle("default")
                        .setHorizontalSpacing(HorizontalSpacing.DEFAULT)
                        .setAction(
                                UrlEl.builder()
                                        .setUrl("https://open.feishu.cn")
                                        .setAndroidUrl("https://developer.android.com/")
                                        .setIosUrl("https://developer.apple.com/")
                                        .setPcUrl("https://www.windows.com")
                                        .build()
                        )
                        .addColumn(
                                Column.builder()
                                        .setWidth("weighted")
                                        .setWeight("1")
                                        .setVerticalAlign(VerticalAlign.CENTER)
                                        .addElement(
                                                Img.builder()
                                                        .setImg(ImageEl
                                                                .of("img_v2_120b03c8-27e3-456f-89c0-90ede1aa59ag")
                                                                .setAlt(ContentI18n.of().setContent("")))
                                                        .build()
                                        )
                                        .build(),
                                Column.builder()
                                        .setWidth("weighted")
                                        .setWeight("3")
                                        .addElement(
                                                Markdown.builder()
                                                        .setContent("**精品大床房**\n<font color='grey'>双早|40-47㎡|有窗户|大床</font>\n<font color='red'>¥666</font> 起")
                                                        .setTextAlign(TextAlign.LEFT)
                                                        .build()
                                        )
                                        .build()
                        )
                        .build()
        );

        CardV2Message message = CardV2Message.builder()
                .setBody(cardBody)
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
