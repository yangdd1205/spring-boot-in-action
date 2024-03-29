package com.slowe;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.slowe.entity.p.User;
import com.slowe.entity.s.Message;
import com.slowe.service.p.UserRepository;
import com.slowe.service.s.MessageRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBoot09ApplicationTests {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private MessageRepository messageRepository;

	/**
	 *  并没有进行测试
	 */
	@Test
	public void test() throws Exception {
		userRepository.save(new User("aaa", 10));
		userRepository.save(new User("bbb", 20));
		userRepository.save(new User("ccc", 30));
		userRepository.save(new User("ddd", 40));
		userRepository.save(new User("eee", 50));
		Assert.assertEquals(5, userRepository.findAll().size());
		messageRepository.save(new Message("o1", "aaaaaaaaaa"));
		messageRepository.save(new Message("o2", "bbbbbbbbbb"));
		messageRepository.save(new Message("o3", "cccccccccc"));
		Assert.assertEquals(3, messageRepository.findAll().size());
	}
}
