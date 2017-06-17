package com.slowe;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.CacheManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.slowe.domain.User;
import com.slowe.domain.UserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {
	@Autowired
	private UserRepository userRepository;
	@Before
	public void before() {
		userRepository.save(new User("AAA", 10));
		userRepository.save(new User("BB", 1));
	}
	@Autowired
	private CacheManager cacheManager;

	
	@Test
	public void test() throws Exception {
		User u1 = userRepository.findByName("AAA");
		System.out.println("第一次查询：" + u1.getAge());
		User u2 = userRepository.findByName("AAA");
		System.out.println("第二次查询：" + u2.getAge());
		
		User u3 = userRepository.findByName("BB");
		System.out.println("第一次查询：" + u3.getAge());
		User u4 = userRepository.findByName("BB");
		System.out.println("第二次查询：" + u4.getAge());
		
	}
}
