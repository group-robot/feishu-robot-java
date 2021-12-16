package com.hb0730.feishu.robot.core.model;

import com.hb0730.feishu.robot.core.Response;
import com.hb0730.feishu.robot.core.RobotSend;
import com.hb0730.feishu.robot.core.constants.TextTag;
import com.hb0730.feishu.robot.core.model.interactive.CardConfig;
import com.hb0730.feishu.robot.core.model.interactive.CardHeader;
import com.hb0730.feishu.robot.core.model.interactive.CardTitle;
import com.hb0730.feishu.robot.core.model.interactive.components.Field;
import com.hb0730.feishu.robot.core.model.interactive.components.Image;
import com.hb0730.feishu.robot.core.model.interactive.components.Text;
import com.hb0730.feishu.robot.core.model.interactive.module.Content;
import com.hb0730.feishu.robot.core.model.interactive.module.Hr;
import com.hb0730.feishu.robot.core.model.interactive.module.Note;
import org.junit.Test;

public class InteractiveMessageTest {

    @Test
    public void toMessage() {
        InteractiveMessage message = InteractiveMessage.build();
        message.config(CardConfig.builder().wideScreenMode(true).build());
        message.setHeader(CardHeader.builder().title(CardTitle.build().content("\uD83D\uDC08 英国短毛猫")).template("indigo").build());
        message.addElements(
            Content.build()
                .text(Text.builder().tag(TextTag.LARK_MD).content("英国短毛猫，体形圆胖，四肢短粗发达，毛短而密，头大脸圆，对人友善。 " +
                    "\n其历史可追溯至古罗马时期的家猫，由于拥有悠久的育种历史，称得上是猫家族中的典范。").build())
                .extra(Image.builder().imgKey("img_70558e3a-2eef-4e8f-9a07-a701c165431g").alt(
                    Text.builder().tag(TextTag.PLAIN_TEXT).content("图片").build()).build()),
            Content.build()
                .addField(
                    Field.builder().isShort(true).text(Text.builder().tag(TextTag.LARK_MD).content("**中文学名：**\n英国短毛猫").build()).build(),
                    Field.builder().isShort(true).text(Text.builder().tag(TextTag.LARK_MD).content("**拉丁学名：**\nFelinae").build()).build(),
                    Field.builder().isShort(false).text(Text.builder().tag(TextTag.LARK_MD).content(" ").build()).build(),
                    Field.builder().isShort(true).text(Text.builder().tag(TextTag.LARK_MD).content("**体形：**\n圆胖").build()).build(),
                    Field.builder().isShort(true).text(Text.builder().tag(TextTag.LARK_MD).content("**被毛：**\n短而浓密、俗称地毯毛").build()).build()
                ),
            Hr.builder().build(),
            Content.build()
                .text(Text.builder().tag(TextTag.LARK_MD).content("**1 形态特征**\n\n 🔵 外形：身体厚实，胸部饱满宽阔，腿部粗壮，爪子浑圆，尾巴的根部粗壮，尾尖钝圆。\n\n🔵 毛色：共有十五种品种被承认，其中最著名的是蓝色系的英国短毛猫。 ").build())
                .extra(Image.builder().imgKey("img_70558e3a-2eef-4e8f-9a07-a701c165431g").alt(Text.builder().tag(TextTag.PLAIN_TEXT).content("图片").build()).build()),
            Note.build().addElement(
                Image.builder().imgKey("img_e61db329-2469-4da7-8f13-2d2f284c3b1g").alt(Text.builder().tag(TextTag.PLAIN_TEXT).content("图片").build()).build(),
                Text.builder().tag(TextTag.PLAIN_TEXT).content("以上资料来自百度百科").build()
            )
        );
        String webhok = System.getenv("webhok");
        String secret = System.getenv("secret");
        RobotSend send = new RobotSend(webhok);
        send.setSecret(secret);
        Response response = send.send(message);
        System.out.println(response.getMsg());
    }

    @Test
    public void toMessage2() {
        String json = "{\"config\":{\"enable_forward\":true,\"wide_screen_mode\":true}," +
            "\"elements\":[{\"extra\":{\"alt\":{\"content\":\"图片\",\"tag\":\"plain_text\"},\"compact_width\":false,\"img_key\":\"img_1cad0e51-26f6-492a-8280-a47057b09a0g\",\"mode\":\"crop_center\",\"preview\":true,\"tag\":\"img\"},\"fields\":null,\"tag\":\"div\",\"text\":{\"content\":\"英国短毛猫，体形圆胖，四肢短粗发达，毛短而密，头大脸圆，对人友善。 \\n其历史可追溯至古罗马时期的家猫，由于拥有悠久的育种历史，称得上是猫家族中的典范。\",\"tag\":\"lark_md\"}},{\"fields\":[{\"is_short\":true,\"text\":{\"content\":\"**中文学名：**\\n英国短毛猫\",\"tag\":\"lark_md\"}},{\"is_short\":true,\"text\":{\"content\":\"**拉丁学名：**\\nFelinae\",\"tag\":\"lark_md\"}},{\"is_short\":false,\"text\":{\"content\":\"\",\"tag\":\"lark_md\"}},{\"is_short\":true,\"text\":{\"content\":\"**体形：**\\n圆胖\",\"tag\":\"lark_md\"}},{\"is_short\":true,\"text\":{\"content\":\"**被毛：**\\n短而浓密、俗称地毯毛\",\"tag\":\"lark_md\"}}],\"tag\":\"div\"},{\"tag\":\"hr\"},{\"extra\":{\"alt\":{\"content\":\"图片\",\"tag\":\"plain_text\"},\"compact_width\":false,\"img_key\":\"img_70558e3a-2eef-4e8f-9a07-a701c165431g\",\"mode\":\"crop_center\",\"preview\":true,\"tag\":\"img\"},\"fields\":null,\"tag\":\"div\",\"text\":{\"content\":\"**1 形态特征**\\n\\n \uD83D\uDD35 外形：身体厚实，胸部饱满宽阔，腿部粗壮，爪子浑圆，尾巴的根部粗壮，尾尖钝圆。\\n\\n\uD83D\uDD35 毛色：共有十五种品种被承认，其中最著名的是蓝色系的英国短毛猫。 \",\"tag\":\"lark_md\"}},{\"elements\":[{\"alt\":{\"content\":\"图片\",\"tag\":\"plain_text\"},\"compact_width\":false,\"img_key\":\"img_7ea74629-9191-4176-998c-2e603c9c5e8g\",\"mode\":\"crop_center\",\"preview\":true,\"tag\":\"img\"},{\"content\":\"以上资料来自百度百科\",\"tag\":\"plain_text\"}],\"tag\":\"note\"}],\"header\":{\"template\":\"indigo\",\"title\":{\"content\":\"\uD83D\uDC08 英国短毛猫\",\"tag\":\"plain_text\"}}}";
        InteractiveMessage message = InteractiveMessage.build().cardJsonStr(json);
        String webhok = System.getenv("webhok");
        String secret = System.getenv("secret");
        RobotSend send = new RobotSend(webhok);
        send.setSecret(secret);
        Response response = send.send(message);
        System.out.println(response.getMsg());
    }
}
