package com.slowe;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.slowe.entity.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

	@Autowired
	private UserRepository userRepository;

	@Before
	public void setUp() {
		userRepository.deleteAll();
	}

	@Test
	public void contextLoads() {
		//		
		//没有进行测试过
		//		
		userRepository.save(new User(1L, "DIDI", 30));
		userRepository.save(new User(2L, "MAMA", 40));
		userRepository.save(new User(1L, "KAKA", 50));
		Assert.assertEquals(3, userRepository.findAll().size());
		User u = userRepository.findOne(1L);
		userRepository.delete(u);
		Assert.assertEquals(2, userRepository.findAll().size());

		u = userRepository.findByUserName("mama");
		userRepository.delete(u);
		Assert.assertEquals(1, userRepository.findAll().size());
	}

}
