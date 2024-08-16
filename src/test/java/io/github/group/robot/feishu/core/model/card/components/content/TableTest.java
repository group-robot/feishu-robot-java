package io.github.group.robot.feishu.core.model.card.components.content;

import io.github.group.robot.feishu.core.FeishuRobotClient;
import io.github.group.robot.feishu.core.FeishuRobotResponse;
import io.github.group.robot.feishu.core.constants.DataType;
import io.github.group.robot.feishu.core.constants.HorizontalAlign;
import io.github.group.robot.feishu.core.constants.TextAlign;
import io.github.group.robot.feishu.core.constants.TextSize;
import io.github.group.robot.feishu.core.model.CardV2Message;
import io.github.group.robot.feishu.core.model.card.CardBody;
import io.github.group.robot.feishu.core.model.card.CardHeader;
import io.github.group.robot.feishu.core.model.card.components.CardTitle;
import io.github.group.robot.feishu.core.model.card.components.content.table.Column;
import io.github.group.robot.feishu.core.model.card.components.content.table.HeaderStyle;
import io.github.group.robot.feishu.core.model.card.components.content.table.NumberFormat;
import io.github.group.robot.feishu.core.util.MapBuilder;
import org.junit.Test;

import java.util.Arrays;

public class TableTest {

    /**
     * 表格 示例
     */
    @Test
    public void test() {
        CardHeader cardHeader = CardHeader.of(
                CardTitle.builder()
                        .setTitle(Title.of("表格组件（依赖端版本 7.4+)"))
                        .setTemplate("blue")
                        .build());

        Table table = Table.builder()
                .setPageSize(5)
                .setRowHeight("low")
                .setHeaderStyle(HeaderStyle.builder()
                        .setTextAlign(TextAlign.LEFT)
                        .setTextSize(TextSize.Normal)
                        .setBackgroundStyle("none")
                        .setTextColor("grey")
                        .setBold(true)
                        .setLines(1)
                        .build())
                .addColumn(Column.builder()
                        .setName("customer_name")
                        .setDisplayName("客户名称")
                        .setDataType(DataType.TEXT)
                        .setHorizontalAlign(HorizontalAlign.Left)
                        .setWidth("auto")
                        .build())
                .addColumn(Column.builder()
                        .setName("customer_scale")
                        .setDisplayName("客户规模")
                        .setDataType(DataType.OPTIONS)
                        .setHorizontalAlign(HorizontalAlign.Left)
                        .setWidth("auto")
                        .build())
                .addColumn(Column.builder()
                        .setName("customer_arr")
                        .setDisplayName("ARR(万元)")
                        .setDataType(DataType.NUMBER)
                        .setFormat(NumberFormat.of()
                                .setSymbol("¥")
                                .setPrecision(2)
                                .setSeparator(true))
                        .setWidth("auto")
                        .build())
                .addColumn(Column.builder()
                        .setName("customer_poc")
                        .setDisplayName("跟进人")
                        .setDataType(DataType.PERSON)
                        .setHorizontalAlign(HorizontalAlign.Left)
                        .setWidth("auto")
                        .build())
                .addColumn(Column.builder()
                        .setName("customer_date")
                        .setDisplayName("签约日期")
                        .setDataType(DataType.DATE)
                        .setDateFormat("YYYY/MM/DD")
                        .setWidth("auto")
                        .build())
                .addColumn(Column.builder()
                        .setName("customer_link")
                        .setDisplayName("相关链接")
                        .setDataType(DataType.LARK_MD)
                        .setWidth("auto")
                        .build())
                .addColumn(Column.builder()
                        .setName("company_image")
                        .setDisplayName("企业图片")
                        .setDataType(DataType.MARKDOWN)
                        .build())
                .addRows(MapBuilder.of()
                        .put("customer_name", "飞书科技")
                        .put("customer_date", 1699341315000L)
                        .put("customer_scale",
                                Arrays.asList(MapBuilder.of().put("text", "S2").put("color", "blue").build()))
                        .put("customer_arr", 168)
                        .put("customer_poc", Arrays.asList("ou_14a32f1a02e64944cf19207aa43abcef", "ou_e393cf9c22e6e617a4332210d2aabcef"))
                        .put("customer_link", "[飞书科技](/document-mod/index?fullPath=/uAjLw4CM/ukTMukTMukTM/reference/im-v1/message-reaction/emojis-introduce)")
                        .put("company_image", "![image.png](img_v3_02cc_bf88cdee-6650-4b39-987c-f8e87c3227fg)").build())
                .addRows(MapBuilder.of()
                        .put("customer_name", "飞书科技_01")
                        .put("customer_date", 1606101072000L)
                        .put("customer_scale",
                                Arrays.asList(MapBuilder.of().put("text", "S1").put("color", "red").build()))
                        .put("customer_arr", 168.23)
                        .put("customer_poc", "ou_14a32f1a02e64944cf19207aa43abcef")
                        .put("customer_link", "[飞书科技_01](/document-mod/index?fullPath=/uAjLw4CM/ukTMukTMukTM/reference/im-v1/message-reaction/emojis-introduce)")
                        .put("company_image", "![image.png](img_v3_02cc_bf88cdee-6650-4b39-987c-f8e87c3227fg)")
                        .build())
                .addRows(MapBuilder.of()
                        .put("customer_name", "飞书科技_02")
                        .put("customer_date", 1606101072000L)
                        .put("customer_scale",
                                Arrays.asList(MapBuilder.of().put("text", "S3").put("color", "orange").build()))
                        .put("customer_arr", 168.23)
                        .put("customer_poc", "ou_14a32f1a02e64944cf19207aa43abcef")
                        .put("customer_link", "[飞书科技_02](/document-mod/index?fullPath=/uAjLw4CM/ukTMukTMukTM/reference/im-v1/message-reaction/emojis-introduce)")
                        .put("company_image", "![image.png](img_v3_02cc_bf88cdee-6650-4b39-987c-f8e87c3227fg)")
                        .build())
                .addRows(MapBuilder.of()
                        .put("customer_name", "飞书科技_03")
                        .put("customer_date", 1606101072000L)
                        .put("customer_scale",
                                Arrays.asList(MapBuilder.of().put("text", "S4").put("color", "blue").build()))
                        .put("customer_arr", 168.23)
                        .put("customer_poc", "ou_14a32f1a02e64944cf19207aa43abcef")
                        .put("customer_link", "[飞书科技_03](/document-mod/index?fullPath=/uAjLw4CM/ukTMukTMukTM/reference/im-v1/message-reaction/emojis-introduce)")
                        .put("company_image", "![image.png](img_v3_02cc_bf88cdee-6650-4b39-987c-f8e87c3227fg)")
                        .build())
                .build();
        ;


        CardBody cardBody = CardBody.of().add(table);

        CardV2Message message = CardV2Message.builder()
                .setHeader(cardHeader)
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
