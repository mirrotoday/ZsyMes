/*
 *   编写日期：2022/6/10 14:26
 *   作者：张赵
 *   说明：
 */

package com.siyu.zsymes.config.redis;

/**
 * 基础配置
 */
public class BaseConfig {

    /**
     * 日志存储路径
     */
    public final static String logPath = "c:\\log";

    /**
     * 异常信息存储路径
     */
    public final static String excpPath = "c:\\excp";

    /**
     * redis主机地址
     */
    public final static String redisHost = "127.0.0.1";

    /**
     * redis端口
     */
    public final static int redisPort = 6379;

    /**
     * redis密码
     */
    public final static String redisPassword = "";

    /**
     * redis超时时长
     */
    public final static int redisTimeout = 60;
}
