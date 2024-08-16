package io.github.group.robot.feishu.core.model.card.components.content;

import io.github.group.robot.feishu.core.constants.ChartColorTheme;
import io.github.group.robot.feishu.core.model.Builder;
import io.github.group.robot.feishu.core.model.card.components.CardTag;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

/**
 * 卡片组件 - 展示 - 图表
 *
 * @author <a href="mailto:huangbing0730@gmail">hb0730</a>
 * @date 2024/8/2
 */
@Getter
@Setter
public class Chart implements CardTag {
    private final String tag = "chart";
    /**
     * 图表的宽高比。支持以下比例：
     * <ul>
     *  <li>1:1</li>
     *  <li>2:1</li>
     *  <li>4:3</li>
     *  <li>16:9</li>
     *  </ul>
     */
    private String aspectRatio;
    /**
     * 图表的主题样式。
     */
    private ChartColorTheme colorTheme;
    /**
     * 基于 VChart 的图表定义
     *
     * @see <a href="https://www.visactor.io/vchart/option/barChart">VChart</a>
     */
    private Map<String, Object> chartSpec;

    /**
     * 图表是否可在独立窗口查看。
     * <pre>
     * true:
     *  PC 端：图表可在独立飞书窗口查看
     *  移动端：图表可在点击后全屏查看
     * false:
     *  PC 端：图表不支持在独立飞书窗口查看
     *  移动端：图表不支持在点击后全屏查看
     * </pre>
     */
    private Boolean preview = true;
    /**
     * 图表组件的高度。
     * <p>
     * auto：默认值，高度将根据宽高比自动计算。<br>
     * [1,999]px：自定义固定图表高度，此时宽高比属性 aspect_ratio 失效。
     */
    private String height = "auto";

    @Override
    public Map<String, Object> toMessage() {
        Map<String, Object> message = new java.util.HashMap<>(6);
        message.put("tag", tag);
        if (aspectRatio != null) {
            message.put("aspect_ratio", aspectRatio);
        }
        if (colorTheme != null) {
            message.put("color_theme", colorTheme.getValue());
        }
        message.put("chart_spec", chartSpec);
        if (preview != null) {
            message.put("preview", preview);
        }
        if (height != null) {
            message.put("height", height);
        }
        return message;
    }

    public static ChartBuilder builder() {
        return new ChartBuilder();
    }

    /**
     * 构造器
     */
    public static class ChartBuilder implements Builder<Chart> {
        private final Chart chart = new Chart();

        private ChartBuilder() {
        }

        /**
         * 图表的宽高比。支持以下比例：
         * <ul>
         *  <li>1:1</li>
         *  <li>2:1</li>
         *  <li>4:3</li>
         *  <li>16:9</li>
         *  </ul>
         */
        public ChartBuilder setAspectRatio(String aspectRatio) {
            chart.setAspectRatio(aspectRatio);
            return this;
        }

        /**
         * 图表的主题样式。
         */
        public ChartBuilder setColorTheme(ChartColorTheme colorTheme) {
            chart.setColorTheme(colorTheme);
            return this;
        }

        /**
         * 基于 VChart 的图表定义
         *
         * @see <a href="https://www.visactor.io/vchart/option/barChart">VChart</a>
         */
        public ChartBuilder setChartSpec(Map<String, Object> chartSpec) {
            chart.setChartSpec(chartSpec);
            return this;
        }

        /**
         * 图表是否可在独立窗口查看。
         * <pre>
         * true:
         *  PC 端：图表可在独立飞书窗口查看
         *  移动端：图表可在点击后全屏查看
         * false:
         *  PC 端：图表不支持在独立飞书窗口查看
         *  移动端：图表不支持在点击后全屏查看
         * </pre>
         */
        public ChartBuilder setPreview(Boolean preview) {
            chart.setPreview(preview);
            return this;
        }

        /**
         * 图表组件的高度。
         * <p>
         * auto：默认值，高度将根据宽高比自动计算。<br>
         * [1,999]px：自定义固定图表高度，此时宽高比属性 aspect_ratio 失效。
         */
        public ChartBuilder setHeight(String height) {
            chart.setHeight(height);
            return this;
        }

        @Override
        public Chart build() {
            return chart;
        }
    }
}
