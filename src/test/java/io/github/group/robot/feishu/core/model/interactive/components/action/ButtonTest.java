package io.github.group.robot.feishu.core.model.interactive.components.action;

import com.hb0730.jsons.SimpleJsonProxy;
import io.github.group.robot.feishu.core.constants.TextTag;
import io.github.group.robot.feishu.core.model.interactive.components.Text;
import org.junit.Test;

public class ButtonTest {

    @Test
    public void toMessage() {
        Button message = Button.build()
            .text(Text.builder().tag(TextTag.LARK_MD).content("default style").build())
            .addValue("key", "value");
        String json = SimpleJsonProxy.json.toJson(message.toMessage());
        System.out.println(json);
    }
}
