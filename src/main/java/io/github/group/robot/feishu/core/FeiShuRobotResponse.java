package io.github.group.robot.feishu.core;

import com.hb0730.jsons.SimpleJsonProxy;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Map;

/**
 * 响应
 *
 * @author bing_huang
 * @date 2021/12/16
 */
@Getter
@Setter
public class FeiShuRobotResponse implements Serializable {
    private Integer code;
    private String msg;

    public static FeiShuRobotResponse toObj(String json) {
        Map map = SimpleJsonProxy.json.fromJson(json, Map.class);
        FeiShuRobotResponse feiShuRobotResponse = new FeiShuRobotResponse();
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
