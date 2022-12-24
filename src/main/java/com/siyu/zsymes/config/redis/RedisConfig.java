/*
 *   编写日期：2022/6/9 14:35
 *   作者：张赵
 *   说明：
 */

package com.siyu.zsymes.config.redis;

import lombok.Data;

@Data
public class RedisConfig {
    /**
     * redis服务器地址
     */
    private String host;
    /**
     * 端口
     */
    private int port;
    /**
     * 密码
     */
    private String password;
    /**
     * 连接超时时间，秒
     */
    private int timeout;
}
