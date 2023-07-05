package io.github.group.robot.feishu.core.model.interactive.components.module;

import io.github.group.robot.feishu.core.model.Builder;

import java.util.HashMap;
import java.util.Map;

/**
 * 卡片 > 分割线模块
 *
 * @author <a href="mailto:huangbing0730@gmail">hb0730</a>
 * @date 2021/12/16
 */
public class HrModule extends AbstractModule {
    private final String tag = "hr";

    public HrModule() {
        super();
    }

    @Override
    public String tag() {
        return tag;
    }

    @Override
    public Map<String, Object> toMessage() {
        Map<String, Object> message = new HashMap<>(1);
        message.put("tag", tag());
        return message;
    }

    /**
     * create {@link HrModule}
     *
     * @return .
     */
    public static HrModule build() {
        return new HrModule();
    }

    /**
     * {@link HrModule} 构造器
     *
     * @return .
     */
    public static HrModuleBuilder builder() {
        return new HrModuleBuilder();
    }

    /**
     * {@link HrModule} 构造器
     */
    public static class HrModuleBuilder implements Builder<HrModule> {
        private final HrModule hrModule;

        private HrModuleBuilder() {
            this.hrModule = new HrModule();
        }

        public static HrModuleBuilder builder() {
            return new HrModuleBuilder();
        }

        public HrModule build() {
            return this.hrModule;
        }
    }
}
