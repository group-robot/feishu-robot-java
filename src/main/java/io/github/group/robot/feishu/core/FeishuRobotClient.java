package io.github.group.robot.feishu.core;

import com.hb0730.https.SimpleHttp;
import com.hb0730.https.support.SimpleHttpResponse;
import com.hb0730.https.utils.StringUtils;
import com.hb0730.jsons.SimpleJsonProxy;
import io.github.group.robot.feishu.core.exception.RobotException;
import io.github.group.robot.feishu.core.model.IMessage;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Map;

/**
 * feishu robot client
 *
 * @author <a href="mailto:huangbing0730@gmail">hb0730</a>
 * @date 2022/8/13
 */
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
public class FeishuRobotClient {
    @Getter
    @Setter
    private String webhook;
    @Getter
    @Setter
    private String secret;

    /**
     * send message
     *
     * @param message message
     * @return response
     */
    public FeishuRobotResponse sendMessage(IMessage message) {
        return sendMessage(this.webhook, message);
    }

    /**
     * send message
     *
     * @param json message json
     * @return result
     */
    public FeishuRobotResponse sendMessage(String json) {
        return sendMessage(this.webhook, json);
    }

    /**
     * send message
     *
     * @param url     url
     * @param message message
     * @return result
     */
    public FeishuRobotResponse sendMessage(String url, IMessage message) {
        if (null == message) {
            throw new RobotException("message missing");
        }
        Map<String, Object> map = message.toMessage();
        return send(url, map);
    }

    /**
     * send message
     *
     * @param url  url
     * @param json message json
     * @return result
     */
    @SuppressWarnings({"unchecked"})
    public FeishuRobotResponse sendMessage(String url, String json) {
        if (StringUtils.isBlank(json)) {
            throw new RobotException("message missing");
        }
        Map<String, Object> message = SimpleJsonProxy.json.fromJson(json, Map.class);
        return send(url, message);
    }

    protected FeishuRobotResponse send(String url, Map<String, Object> message) {

        if (null != this.secret && !"".equals(this.secret)) {
            long timestamp = System.currentTimeMillis();
            message.put("timestamp", timestamp / 1000);
            message.put("sign", genSign(timestamp));
        }
        String content = SimpleJsonProxy.json.toJson(message);
        if (log.isDebugEnabled()) {
            log.info(content);
        }
        SimpleHttpResponse response = SimpleHttp.HTTP.post(url, content);
        if (log.isDebugEnabled()) {
            log.info("response status:{},body:{},", response.isSuccess(), response.getBodyStr());
        }
        if (response.isSuccess()) {
            return FeishuRobotResponse.toObj(response.getBodyStr());
        }
        return null;
    }

    /**
     * 签名
     *
     * @param timestamp 时间戳，毫秒
     * @return 已签名
     */
    protected String genSign(final Long timestamp) {
        Long newTimestamp = timestamp / 1000;
        //把timestamp+"\n"+密钥当做签名字符串
        String stringToSign = newTimestamp + "\n" + secret;
        //使用HmacSHA256算法计算签名
        try {
            Mac mac = Mac.getInstance("HmacSHA256");
            mac.init(new SecretKeySpec(stringToSign.getBytes(StandardCharsets.UTF_8), "HmacSHA256"));
            byte[] signData = mac.doFinal(new byte[]{});
            return Base64.getEncoder().encodeToString(signData);
        } catch (NoSuchAlgorithmException e) {
            throw new RobotException(e);
        } catch (InvalidKeyException e) {
            e.printStackTrace();
            throw new RobotException(e);
        }

    }
}
