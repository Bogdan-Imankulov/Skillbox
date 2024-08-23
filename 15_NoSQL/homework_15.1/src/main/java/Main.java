import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String setName = "TaskList";
        Jedis jedis = new Jedis();
        jedis.sadd(setName, "Buy some milk",
                "Fill a car", "feed a cat");
        System.out.println(jedis.smembers(setName));
        jedis.srem(setName, "Buy some milk");
        System.out.println(jedis.smembers(setName));
        jedis.srem(setName, "Fill a car");
        System.out.println(jedis.smembers(setName));
        jedis.srem(setName, "feed a cat");
        System.out.println(jedis.smembers(setName));

        //======================================Task 2==========================================

        String hashName = "Ivanov I.I.";
        jedis.hset(hashName.getBytes(), "Web-Development".getBytes(), "1".getBytes());
        jedis.hset(hashName.getBytes(), "Data Science".getBytes(), "4".getBytes());
        System.out.println(jedis.hgetAll(hashName));
        jedis.hincrBy(hashName.getBytes(), "Data Science".getBytes(), 1);
        System.out.println(jedis.hgetAll(hashName));
    }
}
