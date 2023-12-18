package org.example;

import java.util.Map;
import java.util.Set;

public class Main {
    private String redisHost;
    private int redisPort;
    private RedisTemplateWrapper redisTemplate;

    public Main(String redisHost, int redisPort) {
        this.redisHost = redisHost;
        this.redisPort = redisPort;
        this.redisTemplate = new RedisTemplateWrapper(redisHost, redisPort);
    }

    public void insert(String key, Map<String, Object> document) {
        redisTemplate.set(key, document.toString());
    }

    public void getData(String key) {


        // String key = "exampleKey";

        String retrievedValue = redisTemplate.get(key);
        System.out.println("Retrieved Value: " + retrievedValue);
    }

    public void update(String key, Map<String, Object> document) {

        redisTemplate.set(key, document.toString());
        System.out.println("Updated successfully");
    }

    public void delete(String key) {

        String str = redisTemplate.del(key);
        System.out.println(str);
    }


    public void getAllData() {
        redisTemplate.getAllData();
    }

}

