package org.example;


import redis.clients.jedis.Jedis;
import java.util.Set;



public class RedisTemplateWrapper {

    private RedisConfig redisManager;


    public RedisTemplateWrapper(String host, int port) {
        if(redisManager==null){
            this.redisManager = new RedisConfig(host, port);
        }

    }

    public void set(String key, String value) {
        try (Jedis jedis = redisManager.getJedis()) {
            jedis.set(key, value);
        }
    }

    public String get(String key) {
        try (Jedis jedis = redisManager.getJedis()) {
            return jedis.get(key);
        }
    }

    public void getAllData() {
        try (Jedis jedis = redisManager.getJedis()) {
            Set<String> allKeys = jedis.keys("*");

            for (String key : allKeys) {
                System.out.println("Key: " + key + ", Value: " + jedis.get(key));
            }
        }
    }

    public String del(String key) {
        try (Jedis jedis = redisManager.getJedis()) {
            jedis.del(key);
            return "deleted successfully";
        }
    }


    public void close() {
        redisManager.close();
    }
}
