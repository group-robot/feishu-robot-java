package io.github.group.robot.feishu.core.model.card.components.containers;

import io.github.group.robot.feishu.core.FeishuRobotClient;
import io.github.group.robot.feishu.core.FeishuRobotResponse;
import io.github.group.robot.feishu.core.constants.Angle;
import io.github.group.robot.feishu.core.constants.IconPosition;
import io.github.group.robot.feishu.core.constants.IconTag;
import io.github.group.robot.feishu.core.constants.TextTag;
import io.github.group.robot.feishu.core.constants.VerticalAlign;
import io.github.group.robot.feishu.core.model.CardV2Message;
import io.github.group.robot.feishu.core.model.card.CardBody;
import io.github.group.robot.feishu.core.model.card.CardHeader;
import io.github.group.robot.feishu.core.model.card.components.CardTitle;
import io.github.group.robot.feishu.core.model.card.components.containers.ele.CollapsiblePanelHeader;
import io.github.group.robot.feishu.core.model.card.components.content.Markdown;
import io.github.group.robot.feishu.core.model.card.components.content.Title;
import io.github.group.robot.feishu.core.model.card.components.ele.BorderEl;
import io.github.group.robot.feishu.core.model.card.components.ele.ContentI18n;
import io.github.group.robot.feishu.core.model.card.components.ele.IconEl;
import org.junit.Test;

public class CollapsiblePanelTest {

    @Test
    public void test1() {
        CardHeader header = CardHeader.of(
                CardTitle.builder()
                        .setTitle(Title.of("折叠面板展示"))
                        .setTemplate("yellow")
                        .build());
        CardBody body = CardBody.of()
                .add(
                        Markdown.builder()
                                .setContent("下面是一个 默认折叠 的折叠面板组件")
                                .build(),
                        CollapsiblePanel.builder()
                                .setExpanded(false)
                                .setHeader(
                                        CollapsiblePanelHeader.builder()
                                                .setTitle(ContentI18n.of("面板标题文本"))
                                                .setVerticalAlign(VerticalAlign.CENTER)
                                                .setIcon(
                                                        IconEl.builder()
                                                                .setTag(IconTag.STANDARD_ICON)
                                                                .setToken("down-small-ccm_outlined")
                                                                .setSize("16px 16px")
                                                                .build()
                                                )
                                                .setIconPosition(IconPosition.RIGHT)
                                                .setIconExpandedAngle(Angle.DEG_180)
                                                .build()
                                )
                                .setBorder(BorderEl.of("grey", "5px"))
                                .setVerticalSpacing("8px")
                                .setPadding("8px 8px 8px 8px")
                                .addElement(
                                        Markdown.builder()
                                                .setContent("很长的文本很长的文本很长的文本很长的文本很长的文本很长的文本很长的文本很长的文本很长的文本很长的文本很长的文本很长的文本很长的文本很长的文本很长的文本很长的文本很长的文本很长的文本很长的文本很长的文本很长的文本很长的文本很长的文本很长的文本很长的文本很长的文本很长的文本很长的文本很长的文本")
                                                .build()
                                )
                                .build(),
                        Markdown.builder()
                                .setContent("下面是一个 标题带背景色 且 默认展开 的折叠面板组件")
                                .build(),
                        CollapsiblePanel.builder()
                                .setExpanded(true)
                                .setHeader(
                                        CollapsiblePanelHeader.builder()
                                                .setTitle(
                                                        ContentI18n.of(
                                                                TextTag.MARKDOWN,
                                                                "**<font color='white'>面板标题文本</font>**"
                                                        )
                                                )
                                                .setBackgroundColor("yellow")
                                                .setVerticalAlign(VerticalAlign.CENTER)
                                                .setIcon(
                                                        IconEl.builder()
                                                                .setTag(IconTag.STANDARD_ICON)
                                                                .setToken("down-small-ccm_outlined")
                                                                .setColor("white")
                                                                .setSize("16px 16px")
                                                                .build()
                                                )
                                                .setIconPosition(IconPosition.RIGHT)
                                                .setIconExpandedAngle(Angle.DEG_180)
                                                .build()
                                ).setBorder(
                                        BorderEl.of("grey", "5px")
                                )
                                .setVerticalSpacing("8px")
                                .setPadding("8px 8px 8px 8px")
                                .addElement(
                                        Markdown.builder()
                                                .setContent("很长的文本很长的文本很长的文本很长的文本很长的文本很长的文本")
                                                .build()
                                )
                                .build(),
                        Markdown.builder()
                                .setContent("下面是一个无边框折叠面板组件")
                                .build(),
                        CollapsiblePanel.builder()
                                .setExpanded(true)
                                .setHeader(
                                        CollapsiblePanelHeader.builder()
                                                .setTitle(ContentI18n.of(
                                                        TextTag.MARKDOWN,
                                                        "**面板标题文本**"))
                                                .setVerticalAlign(VerticalAlign.CENTER)
                                                .setPadding("8px 8px 8px 8px")
                                                .setIcon(
                                                        IconEl.builder()
                                                                .setTag(IconTag.STANDARD_ICON)
                                                                .setToken("down-small-ccm_outlined")
                                                                .setColor("")
                                                                .setSize("16px 16px")
                                                                .build()
                                                )
                                                .setIconPosition(IconPosition.FOLLOW_TEXT)
                                                .setIconExpandedAngle(Angle.DEG_180)
                                                .build())
                                .setVerticalSpacing("8px")
                                .setPadding("8px 8px 8px 8px")
                                .addElement(
                                        Markdown.builder()
                                                .setContent("很长的文本很长的文本很长的文本很长的文本很长的文本很长的文本")
                                                .build()
                                )
                                .build()
                );

        CardV2Message message = CardV2Message.builder()
                .setBody(body)
                .setHeader(header)
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
