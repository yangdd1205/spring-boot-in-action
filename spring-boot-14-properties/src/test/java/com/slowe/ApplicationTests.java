package com.slowe;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

	@Autowired
	private BlogProperties blogProperties;
	
	@Test
	public void contextLoads() {
		Assert.assertEquals("程序猿DD",blogProperties.getName());
		Assert.assertEquals("Spring Boot教程",blogProperties.getTitle());
		Assert.assertEquals("程序猿DD正在努力写《Spring Boot教程》",blogProperties.getDesc());
		
		System.out.println("随机数测试输出：");
		System.out.println("随机字符串 : " + blogProperties.getValue());
		System.out.println("随机int : " + blogProperties.getNumber());
		System.out.println("随机long : " + blogProperties.getBignumber());
		System.out.println("随机10以下 : " + blogProperties.getTest1());
		System.out.println("随机10-20 : " + blogProperties.getTest2());

	}

}
