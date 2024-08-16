package io.github.group.robot.feishu.core.model.card;

import io.github.group.robot.feishu.core.model.IMessage;
import io.github.group.robot.feishu.core.model.card.components.CardTitle;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

/**
 * 卡片标题
 *
 * @author <a href="mailto:huangbing0730@gmail">hb0730</a>
 * @date 2024/8/8
 */
@Getter
@Setter
public class CardHeader implements IMessage {
    /**
     * 标题
     */
    private CardTitle title;

    public CardHeader(CardTitle title) {
        this.title = title;
    }

    public CardHeader() {
    }


    /**
     * 设置标题
     *
     * @param title 标题
     * @return this
     */
    public CardHeader setTitle(CardTitle title) {
        this.title = title;
        return this;
    }

    @Override
    public Map<String, Object> toMessage() {
        return title.toMessage();
    }

    /**
     * 构建者
     *
     * @return this
     */
    public static CardHeader of(CardTitle title) {
        return new CardHeader(title);
    }

    /**
     * 构建者
     *
     * @return this
     */
    public static CardHeader of() {
        return new CardHeader();
    }
}
