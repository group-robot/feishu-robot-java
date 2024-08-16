package io.github.group.robot.feishu.core.constants;

import lombok.Getter;

/**
 * 内嵌在表单容器中的按钮的交互类型
 *
 * @author <a href="mailto:huangbing0730@gmail">hb0730</a>
 * @date 2024/8/8
 */
@Getter
public enum ActionType {
    /**
     * 当前按钮仅支持链接跳转
     */
    LINK("link"),
    /**
     * 当前按钮仅支持回传交互
     */
    REQUEST("request"),
    /**
     * 当前按钮同时支持链接跳转和回传交互
     */
    MULTI("multi"),
    /**
     * 将当前按钮与提交事件绑定。用户点击后，将触发表单容器的提交事件，异步提交所有已填写的表单项内容
     */
    FORM_SUBMIT("form_submit"),
    /**
     * 将当前按钮与取消提交事件绑定。用户点击后，将触发表单容器的取消提交事件，重置所有表单组件的输入值为初始值
     */
    FORM_RESET("form_reset"),
    ;
    private final String value;

    ActionType(String value) {
        this.value = value;
    }
}
