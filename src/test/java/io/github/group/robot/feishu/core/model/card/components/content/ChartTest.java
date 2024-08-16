package io.github.group.robot.feishu.core.model.card.components.content;

import com.hb0730.jsons.SimpleJsonProxy;
import io.github.group.robot.feishu.core.FeishuRobotClient;
import io.github.group.robot.feishu.core.FeishuRobotResponse;
import io.github.group.robot.feishu.core.model.CardV2Message;
import io.github.group.robot.feishu.core.model.card.CardBody;
import io.github.group.robot.feishu.core.model.card.CardHeader;
import io.github.group.robot.feishu.core.model.card.components.CardTitle;
import io.github.group.robot.feishu.core.util.MapBuilder;
import org.junit.Test;

import java.util.List;
import java.util.Map;

public class ChartTest {

    /**
     * 图表 - 折线图
     */
    @Test
    public void test1() {
        String mockData = "[{\"time\":\"2:00\",\"value\":8},{\"time\":\"4:00\",\"value\":9},{\"time\":\"6:00\"," +
                "\"value\":11},{\"time\":\"8:00\",\"value\":14},{\"time\":\"10:00\",\"value\":16},{\"time\":\"12:00\",\"value\":17},{\"time\":\"14:00\",\"value\":17},{\"time\":\"16:00\",\"value\":16},{\"time\":\"18:00\",\"value\":15}]";

        CardHeader cardHeader = CardHeader.of(CardTitle.builder()
                .setTemplate("purple")
                .setTitle(Title.of("折线图"))
                .build());


        Map<String, Object> chartSpec = MapBuilder.of()
                .put("type", "line")
                .put("data",
                        MapBuilder.of().put("values", SimpleJsonProxy.json.fromJson(mockData, List.class)).build())
                .put("xField", "time")
                .put("yField", "value")
                .build();

        CardBody cardBody = CardBody.of()
                .add(Chart.builder()
                        .setChartSpec(chartSpec)
                        .build());

        CardV2Message message = CardV2Message.builder()
                .setBody(cardBody)
                .setHeader(cardHeader)
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
     * 图表 - 面积图
     */
    @Test
    public void test2() {
        String mockData = "[{\"time\":\"2:00\",\"value\":8},{\"time\":\"4:00\",\"value\":9},{\"time\":\"6:00\",\"value\":11},{\"time\":\"8:00\",\"value\":14},{\"time\":\"10:00\",\"value\":16},{\"time\":\"12:00\",\"value\":17},{\"time\":\"14:00\",\"value\":17},{\"time\":\"16:00\",\"value\":16},{\"time\":\"18:00\",\"value\":15}]";

        CardHeader cardHeader = CardHeader.of(CardTitle.builder()
                .setTemplate("purple")
                .setTitle(Title.of("面积图"))
                .build());


        Map<String, Object> chartSpec = MapBuilder.of()
                .put("type", "area")
                .put("title", MapBuilder.of("text", "面积图").build())
                .put("data",
                        MapBuilder.of().put("values", SimpleJsonProxy.json.fromJson(mockData, List.class)).build())
                .put("xField", "time")
                .put("yField", "value")
                .build();

        CardBody cardBody = CardBody.of()
                .add(Chart.builder()
                        .setChartSpec(chartSpec)
                        .build());

        CardV2Message message = CardV2Message.builder()
                .setBody(cardBody)
                .setHeader(cardHeader)
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
