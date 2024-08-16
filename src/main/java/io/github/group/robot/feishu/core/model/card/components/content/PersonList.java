package io.github.group.robot.feishu.core.model.card.components.content;

import io.github.group.robot.feishu.core.constants.AvatarSize;
import io.github.group.robot.feishu.core.model.Builder;
import io.github.group.robot.feishu.core.model.card.components.CardTag;
import io.github.group.robot.feishu.core.model.card.components.ele.IconEl;
import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 卡片组件 - 展示 - 人员列表
 *
 * @author <a href="mailto:huangbing0730@gmail">hb0730</a>
 * @date 2024/8/2
 */
@Getter
@Setter
public class PersonList implements CardTag {
    private final String tag = "person_list";
    /**
     * 最大显示行数，默认不限制最大显示行数。
     */
    private Integer lines;
    /**
     * 是否展示用户名称，默认展示用户名称。
     */
    private Boolean showName;
    /**
     * 是否展示用户头像，默认不展示用户头像。
     */
    private Boolean showAvatar;
    /**
     * 头像大小
     */
    private AvatarSize size;
    /**
     * 用户id列表
     */
    private List<String> userIds;
    /**
     * 添加图标作为文本前缀图标。支持自定义或使用图标库中的图标。
     */
    private IconEl icon;

    @Override
    public Map<String, Object> toMessage() {
        Map<String, Object> message = new java.util.HashMap<>(7);
        message.put("tag", tag);
        if (lines != null) {
            message.put("lines", lines);
        }
        if (showName != null) {
            message.put("show_name", showName);
        }
        if (showAvatar != null) {
            message.put("show_avatar", showAvatar);
        }
        if (size != null) {
            message.put("size", size.getValue());
        }
        if (userIds != null) {
            List<Map<String, String>> persons =
                    this.userIds.stream().map(e -> Collections.singletonMap("id", e)).collect(Collectors.toList());
            message.put("persons", persons);
        }
        if (icon != null) {
            message.put("icon", icon.toMessage());
        }
        return message;
    }

    public static PersionListBuilder builder() {
        return new PersionListBuilder();
    }

    /**
     * 构建者
     */
    public static class PersionListBuilder implements Builder<PersonList> {
        private final PersonList personList = new PersonList();

        private PersionListBuilder() {
        }

        /**
         * 最大显示行数，默认不限制最大显示行数。
         *
         * @param lines 最大显示行数
         * @return UserListBuilder
         */
        public PersionListBuilder setLines(Integer lines) {
            personList.setLines(lines);
            return this;
        }

        /**
         * 是否展示用户名称，默认展示用户名称。
         *
         * @param showName 是否展示用户名称
         * @return UserListBuilder
         */
        public PersionListBuilder setShowName(Boolean showName) {
            personList.setShowName(showName);
            return this;
        }

        /**
         * 是否展示用户头像，默认不展示用户头像。
         *
         * @param showAvatar 是否展示用户头像
         * @return UserListBuilder
         */
        public PersionListBuilder setShowAvatar(Boolean showAvatar) {
            personList.setShowAvatar(showAvatar);
            return this;
        }

        /**
         * 头像大小
         *
         * @param size {@link AvatarSize}
         * @return UserListBuilder
         */
        public PersionListBuilder setSize(AvatarSize size) {
            personList.setSize(size);
            return this;
        }

        /**
         * 用户id列表
         *
         * @param userIds 用户id列表
         * @return UserListBuilder
         */
        public PersionListBuilder setUserIds(List<String> userIds) {
            personList.setUserIds(userIds);
            return this;
        }

        /**
         * 用户id列表
         *
         * @param userIds 用户id列表
         * @return UserListBuilder
         */
        public PersionListBuilder setUserIds(String... userIds) {
            personList.setUserIds(Arrays.asList(userIds));
            return this;
        }

        /**
         * 添加用户id
         *
         * @param userId 用户id
         * @return UserListBuilder
         */
        public PersionListBuilder addUserId(String userId) {
            if (personList.getUserIds() == null) {
                personList.setUserIds(Collections.singletonList(userId));
            } else {
                personList.getUserIds().add(userId);
            }
            return this;
        }

        /**
         * 添加用户id
         *
         * @param userIds 用户id列表
         * @return UserListBuilder
         */
        public PersionListBuilder addUserId(String... userIds) {
            if (personList.getUserIds() == null) {
                personList.setUserIds(Arrays.asList(userIds));
            } else {
                personList.getUserIds().addAll(Arrays.asList(userIds));
            }
            return this;
        }

        /**
         * 添加用户id
         *
         * @param userIds 用户id列表
         * @return UserListBuilder
         */
        public PersionListBuilder addUserId(List<String> userIds) {
            if (personList.getUserIds() == null) {
                personList.setUserIds(userIds);
            } else {
                personList.getUserIds().addAll(userIds);
            }
            return this;
        }


        /**
         * 添加图标作为文本前缀图标。支持自定义或使用图标库中的图标。
         *
         * @param icon {@link IconEl}
         * @return UserListBuilder
         */
        public PersionListBuilder setIcon(IconEl icon) {
            personList.setIcon(icon);
            return this;
        }

        @Override
        public PersonList build() {
            return personList;
        }
    }
}
