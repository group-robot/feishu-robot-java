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
    private Object data;

    /**
     * is success ,code==0
     *
     * @return success
     */
    public boolean isSuccess() {
        return code == 0;
    }

    public static FeishuRobotResponse toObj(String resultJson) {
        Map resultMap = SimpleJsonProxy.json.fromJson(resultJson, Map.class);
        FeishuRobotResponse feiShuRobotResponse = new FeishuRobotResponse();
        feiShuRobotResponse.setCode(Integer.valueOf(resultMap.get("code").toString()));
        feiShuRobotResponse.setMsg(resultMap.get("msg").toString());
        feiShuRobotResponse.setData(resultMap.get("data"));
        return feiShuRobotResponse;
    }
}
