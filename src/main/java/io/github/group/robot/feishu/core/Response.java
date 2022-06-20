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
public class Response implements Serializable {
    private Integer code;
    private String msg;

    public static Response toObj(String json) {
        Map map = SimpleJsonProxy.json.fromJson(json, Map.class);
        Response response = new Response();
        if (null == map.get("StatusCode")) {
            response.setCode(Integer.valueOf(map.get("code").toString()));
            response.setMsg(map.get("msg").toString());
            return response;
        } else {
            response.setCode(Integer.valueOf(map.get("StatusCode").toString()));
            response.setMsg(map.get("StatusMessage").toString());
            return response;
        }
    }
}
