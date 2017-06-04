package com.slowe;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import com.slowe.entity.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBoot11ApplicationTests {

	@Autowired
	private StringRedisTemplate stringRedisTemplate;

	@Test
	public void test() {
		stringRedisTemplate.opsForValue().set("aaa", "222");
		Assert.assertEquals("222", stringRedisTemplate.opsForValue().get("aaa"));
	}

	@Autowired
	private RedisTemplate<String, User> redisTemplate;

	@Test
	public void testUserRedisTemplate() throws Exception {
		User user = new User("超人", 20);
		redisTemplate.opsForValue().set(user.getUsername(), user);
		
		user = new User("蝙蝠侠",30);
		redisTemplate.opsForValue().set(user.getUsername(), user);
		
		user = new User("蜘蛛侠",40);
		redisTemplate.opsForValue().set(user.getUsername(), user);
		
		Assert.assertEquals(20, redisTemplate.opsForValue().get("超人").getAge().longValue());
		Assert.assertEquals(30, redisTemplate.opsForValue().get("蝙蝠侠").getAge().longValue());
		Assert.assertEquals(40, redisTemplate.opsForValue().get("蜘蛛侠").getAge().longValue());
	}

}
