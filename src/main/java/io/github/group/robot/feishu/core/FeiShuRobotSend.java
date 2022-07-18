package io.github.group.robot.feishu.core;

/**
 * 实现
 *
 * @author bing_huang
 * @date 2021/12/16
 */
public class FeiShuRobotSend extends AbstractFeiShuRobotSend {
    public FeiShuRobotSend(String webhok) {
       this(webhok,null);
    }

    public FeiShuRobotSend(String webhok, String secret) {
        super(webhok, secret);
    }
}
