package com.hb0730.feishu.robot.core;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

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
}
