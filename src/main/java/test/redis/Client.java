package test.redis;

import java.util.Iterator;
import java.util.Set;

import redis.clients.jedis.Jedis;

public class Client {
	public static void main(String[] args) {
		// 连接本地的 Redis 服务
		Jedis jedis = new Jedis("192.168.18.177");
		jedis.auth("redis123");
		System.out.println("连接成功");
		jedis.set("mykey", "hello redis!");
		System.out.println("set ok");
		// 获取数据并输出
		Set<String> keys = jedis.keys("*");
		Iterator<String> it = keys.iterator();
		while (it.hasNext()) {
			String key = it.next();
			System.out.println(key + "：" + jedis.get(key));
		}

	}
}