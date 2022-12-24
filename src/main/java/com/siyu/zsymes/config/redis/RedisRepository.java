/*
 *   编写日期：2022/6/9 14:34
 *   作者：张赵
 *   说明：
 */

package com.siyu.zsymes.config.redis;

import config.BaseConfig;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import redis.clients.jedis.Jedis;

import java.util.List;

public class RedisRepository {

    private RedisConfig config;

    /**
     * 默认初始化redis
     */
    public RedisRepository() {
        this.connect();
    }

    /**
     * @param config 初始化redis
     */
    public RedisRepository(RedisConfig config) {
        this.config = config;
        this.connect();
    }

    private static RedisProperties.Jedis jedis;
    private static boolean firstConnect = true;

    private static Object obj = new Object();

    private void connect() {
        if (firstConnect) {
            if (config == null) {
                //默认初始化redis连接信息
                this.config = new RedisConfig();
                this.config.setHost(BaseConfig.redisHost);
                this.config.setPort(BaseConfig.redisPort);
                this.config.setPassword(BaseConfig.redisPassword);
                this.config.setTimeout(BaseConfig.redisTimeout);
            }
            synchronized (obj) {
                jedis = new RedisProperties.Jedis(this.config.getHost(), this.config.getPort());
                firstConnect = false;
            }
        }
    }

    /**
     * @param key   关键词
     * @param value 值，默认存储1分钟
     */
    public void set(String key, String value) {
        this.set(key, value, 60);
    }

    /**
     * @param key     关键词
     * @param value   值
     * @param timeout 缓存有效时间，单位：秒
     * @return 存储redis是否成功
     */
    public boolean set(String key, String value, int timeout) {
        String str = jedis.set(key, value);
        this.expire(key, timeout);
        return str == "OK";
    }

    /**
     * @param key 关键词
     * @return 对应的值
     */
    public String get(String key) {
        return jedis.get(key);
    }

    /**
     * @param keys 关键词集合
     * @return 关键词对应的redis值集合，按key->value获取
     */
    public List<String> get(String... keys) {
        return jedis.mget(keys);
    }

    /**
     * @param key 关键词
     * @return 关键词是否存在
     */
    public boolean hasKey(String key) {
        return jedis.exists(key);
    }

    /**
     * @param key     关键词
     * @param timeout redis缓存时间，单位：秒
     */
    public boolean expire(String key, int timeout) {
        return jedis.expire(key, timeout) > 0;
    }

    /**
     * @param key 关键词
     * @return 移除关键词是否成功
     */
    public boolean remove(String key) {
        return jedis.del(key) > 0;
    }
}
