package com.slowe;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.slowe.domain.User;
import com.slowe.domain.UserMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

	@Autowired
	private UserMapper userMapper;

	@Test
	public void test() throws Exception {

		userMapper.insert("AAA", 20);
		User u = userMapper.findByName("AAA");
		Assert.assertEquals(20, u.getAge().intValue());
		
		u.setAge(30);
		
		userMapper.update(u);
		
		u = userMapper.findByName("AAA");
		Assert.assertEquals(30, u.getAge().intValue());
		
		userMapper.delete(u.getId());
		
		u = userMapper.findByName("AAA");
		
		Assert.assertEquals(null, u);
	}

}
