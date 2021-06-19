package com.example.RedisPractice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootApplication
@EnableCaching
public class RedisPracticeApplication {

	@Bean
	JedisConnectionFactory jedisConnectionFactory(){
		JedisConnectionFactory jd =new JedisConnectionFactory();
		jd.setHostName("localhost");
		jd.setPort(6379);
		return jd;

	}

	@Bean
	RedisTemplate<String, Item> redisTemplate(){
		RedisTemplate<String,Item> redisTemplate = new RedisTemplate<String, Item>();
		redisTemplate.setConnectionFactory(jedisConnectionFactory());
		return redisTemplate;
	}
	public static void main(String[] args) {
		SpringApplication.run(RedisPracticeApplication.class, args);
	}
}