package io.github.group.robot.feishu.core.model.card.components.content;

import io.github.group.robot.feishu.core.constants.AvatarSize;
import io.github.group.robot.feishu.core.constants.PersonStyle;
import io.github.group.robot.feishu.core.model.Builder;
import io.github.group.robot.feishu.core.model.card.components.CardTag;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

/**
 * 卡片组件 - 展示 - 人员
 *
 * @author <a href="mailto:huangbing0730@gmail">hb0730</a>
 * @date 2024/8/2
 */
@Getter
@Setter
public class Person implements CardTag {
    private final String tag = "person";
    /**
     * 头像大小
     */
    private AvatarSize size;
    /**
     * 用户id
     */
    private String userId;
    /**
     * 是否展示人员的头像
     */
    private Boolean showAvatar;
    /**
     * 是否展示人员的名称
     */
    private Boolean showName;
    /**
     * 人员组件的展示样式
     */
    private PersonStyle style;

    public Person() {
    }

    public Person(AvatarSize size, String userId) {
        this.size = size;
        this.userId = userId;
    }

    public Person(String userId) {
        this.userId = userId;
    }

    @Override
    public Map<String, Object> toMessage() {
        Map<String, Object> message = new HashMap<>();
        message.put("tag", tag);
        message.put("user_id", userId);
        if (size != null) {
            message.put("size", size.getValue());
        }
        if (showAvatar != null) {
            message.put("show_avatar", showAvatar);
        }
        if (showName != null) {
            message.put("show_name", showName);
        }
        if (style != null) {
            message.put("style", style.getValue());
        }
        return message;
    }

    public static PersonBuilder builder() {
        return new PersonBuilder();
    }


    /**
     * 构建者
     */
    public static class PersonBuilder implements Builder<Person> {
        private final Person person = new Person();

        private PersonBuilder() {
        }

        /**
         * 头像大小
         *
         * @param size {@link AvatarSize}
         * @return UserProfileBuilder
         */
        public PersonBuilder setSize(AvatarSize size) {
            person.setSize(size);
            return this;
        }

        /**
         * 用户id
         *
         * @param userId 用户id
         * @return UserProfileBuilder
         */
        public PersonBuilder setUserId(String userId) {
            person.setUserId(userId);
            return this;
        }

        /**
         * 是否展示人员的头像
         *
         * @param showAvatar 是否展示人员的头像
         * @return UserProfileBuilder
         */
        public PersonBuilder setShowAvatar(Boolean showAvatar) {
            person.setShowAvatar(showAvatar);
            return this;
        }

        /**
         * 是否展示人员的名称
         *
         * @param showName 是否展示人员的名称
         * @return UserProfileBuilder
         */
        public PersonBuilder setShowName(Boolean showName) {
            person.setShowName(showName);
            return this;
        }

        /**
         * 人员组件的展示样式
         *
         * @param style {@link PersonStyle}
         * @return UserProfileBuilder
         */
        public PersonBuilder setStyle(PersonStyle style) {
            person.setStyle(style);
            return this;
        }

        @Override
        public Person build() {
            return person;
        }
    }
}
