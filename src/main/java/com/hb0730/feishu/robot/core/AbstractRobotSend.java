package com.hb0730.feishu.robot.core;

import com.hb0730.feishu.robot.core.exception.RobotException;
import com.hb0730.feishu.robot.core.model.BaseMessage;
import com.hb0730.feishu.robot.core.util.JacksonUtils;
import com.hb0730.https.HttpHeader;
import com.hb0730.https.HttpSync;
import com.hb0730.https.Https;
import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Map;

/**
 * 抽象,webhok必填
 *
 * @author bing_huang
 * @date 2021/12/16
 */
@Setter
@Getter
public abstract class AbstractRobotSend implements IRobotSend {
    private final static Logger LOGGER = LoggerFactory.getLogger(AbstractRobotSend.class);
    /**
     * webhok
     */
    private final String webhok;
    private String secret;
    /**
     * request
     */
    private final HttpSync request;

    public AbstractRobotSend(String webhok) {
        if (webhok == null || webhok.length() == 0) {
            throw new RobotException("webhok missing");
        }
        this.webhok = webhok;
        this.request = Https.SYNC.getHttp();
        HttpHeader header = HttpHeader.builder();
        header.add("Content-Type", "application/json");
        this.request.setHeader(header);
    }

    @Override
    public Response send(BaseMessage message) {
        Map<String, Object> map = message.toMessage();
        long timestamp = System.currentTimeMillis();
        map.put("timestamp", timestamp / 1000);
        map.put("sign", genSign(timestamp));
        String content = JacksonUtils.X.format(map);
        if (LOGGER.isDebugEnabled()) {
            LOGGER.info(content);
        }
        String post = this.request.post(this.webhok, content);
        return JacksonUtils.X.parse(post, Response.class);
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
