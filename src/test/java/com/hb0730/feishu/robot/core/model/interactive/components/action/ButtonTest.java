package com.hb0730.feishu.robot.core.model.interactive.components.action;

import com.hb0730.feishu.robot.core.constants.TextTag;
import com.hb0730.feishu.robot.core.model.interactive.components.Text;
import com.hb0730.feishu.robot.core.util.JacksonUtils;
import org.junit.Test;

public class ButtonTest {

    @Test
    public void toMessage() {
        Button message = Button.build()
            .text(Text.builder().tag(TextTag.LARK_MD).content("default style").build())
            .addValue("key", "value");
        String json = JacksonUtils.X.format(message.toMessage());
        System.out.println(json);
    }
}
