package io.github.group.robot.feishu.core.model.interactive.components;

import io.github.group.robot.feishu.core.model.Builder;
import io.github.group.robot.feishu.core.model.IMessage;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

/**
 * 卡片 >可内嵌非交互元素 > Field
 *
 * @author <a href="mailto:huangbing0730@gmail">hb0730</a>
 * @date 2021/12/16
 */
@Getter
@Setter
public class Field implements IMessage {
    /**
     * 是否并排布局
     */
    private boolean isShort;
    /**
     * 国际化文本内容
     */
    private Text text;

    @Override
    public Map<String, Object> toMessage() {
        Map<String, Object> message = new HashMap<>(2);
        message.put("is_short", this.isShort);
        message.put("text", this.text.toMessage());
        return message;
    }

    /**
     * 构造器
     *
     * @return .
     */
    public static FieldBuilder builder() {
        return new FieldBuilder();
    }

    /**
     * {@link Field} 构造器
     */
    public static class FieldBuilder implements Builder<Field> {
        private final Field field;

        private FieldBuilder() {
            this.field = new Field();
        }

        /**
         * create {@link Field}
         *
         * @return {@link Field}
         */
        public static FieldBuilder builder() {
            return new FieldBuilder();
        }

        /**
         * 是否并排布局
         *
         * @param isShort .
         * @return .
         */
        public FieldBuilder isShort(boolean isShort) {
            this.field.setShort(isShort);
            return this;
        }

        /**
         * 国际化文本内容
         *
         * @param text .
         * @return .
         */
        public FieldBuilder text(Text text) {
            this.field.setText(text);
            return this;
        }

        @Override
        public Field build() {
            return this.field;
        }
    }
}
