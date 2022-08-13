package io.github.group.robot.feishu.core;

import com.hb0730.jsons.SimpleJsonProxy;
import lombok.Data;

import java.io.Serializable;
import java.util.Map;

/**
 * response
 *
 * @author <a href="mailto:huangbing0730@gmail">hb0730</a>
 * @date 2022/8/13
 */
@Data
public class FeishuRobotResponse implements Serializable {
    private Integer code;
    private String msg;

    /**
     * is success ,code==0
     *
     * @return success
     */
    public boolean isSuccess() {
        return code == 0;
    }

    public static FeishuRobotResponse toObj(String json) {
        Map map = SimpleJsonProxy.json.fromJson(json, Map.class);
        FeishuRobotResponse feiShuRobotResponse = new FeishuRobotResponse();
        if (null == map.get("StatusCode")) {
            feiShuRobotResponse.setCode(Integer.valueOf(map.get("code").toString()));
            feiShuRobotResponse.setMsg(map.get("msg").toString());
        } else {
            feiShuRobotResponse.setCode(Integer.valueOf(map.get("StatusCode").toString()));
            feiShuRobotResponse.setMsg(map.get("StatusMessage").toString());
        }
        return feiShuRobotResponse;
    }
}
