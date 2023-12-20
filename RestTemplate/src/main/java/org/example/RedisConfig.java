package org.example;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisConfig {

    private JedisPool jedisPool;

    public RedisConfig(String host, int port) {
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        this.jedisPool = new JedisPool(poolConfig, host, port);
    }

    public Jedis getJedis() {
        return jedisPool.getResource();
    }

    public void close() {
        jedisPool.close();
    }
}
