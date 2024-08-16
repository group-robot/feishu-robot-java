package io.github.group.robot.feishu.core.model.card.components.behaviors;

import io.github.group.robot.feishu.core.model.card.components.ele.UrlEl;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

/**
 * 打开链接
 *
 * @author <a href="mailto:huangbing0730@gmail">hb0730</a>
 * @date 2024/8/8
 */
@Getter
@Setter
public class OpenUrl extends UrlEl implements BehaviorType {
    private final String type = "open_url";
    /**
     * 默认链接
     */
    private String defaultUrl;

    /**
     * 设置默认链接
     *
     * @param defaultUrl .
     * @return .
     */
    public OpenUrl setDefaultUrl(String defaultUrl) {
        this.defaultUrl = defaultUrl;
        return this;
    }

    @Override
    public Map<String, Object> toMessage() {
        Map<String, Object> message = super.toMessage();
        message.put("type", type);
        if (null != defaultUrl) {
            message.put("default_url", defaultUrl);
        }
        return message;
    }

    public static OpenUrl of() {
        return new OpenUrl();
    }

    /**
     * 创建 {@link OpenUrl}
     *
     * @param defaultUrl 默认链接
     * @return .
     */
    public static OpenUrl of(String defaultUrl) {
        return new OpenUrl().setDefaultUrl(defaultUrl);
    }

}
