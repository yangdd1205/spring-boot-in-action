package com.slowe;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.slowe.web.UserController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBoot05ApplicationTests {

	private MockMvc mvc;

	@Before
	public void setUp() throws Exception {
		mvc = MockMvcBuilders.standaloneSetup(new UserController()).build();
	}

	@Test
	public void contextLoads() throws Exception {
		RequestBuilder request = null;
		// 1、get查一下user列表，应该为空
		request = get("/users/");
		mvc.perform(request).andExpect(status().isOk()).andExpect(content().string(equalTo("[]")));
		// 2、post提交一个user
		request = post("/users/").contentType(MediaType.APPLICATION_JSON)
				.content("{\"age\":20,\"id\":1,\"name\":\"测试大师\"}");
		mvc.perform(request).andDo(print()).andExpect(content().string(equalTo("success")));
		// 3、get获取user列表，应该有刚才插入的数据
		request = get("/users/");
		mvc.perform(request).andExpect(status().isOk())
				.andExpect(content().string(equalTo("[{\"id\":1,\"name\":\"测试大师\",\"age\":20}]")));
		// 4、put修改id为1的user
		request = put("/users/1").contentType(MediaType.APPLICATION_JSON)
				.content("{\"age\":30,\"id\":1,\"name\":\"测试终极大师\"}");
		mvc.perform(request).andExpect(content().string(equalTo("success")));
		// 5、get一个id为1的user
		request = get("/users/1");
		mvc.perform(request).andExpect(content().string(equalTo("{\"id\":1,\"name\":\"测试终极大师\",\"age\":30}")));
		// 6、del删除id为1的user
		request = delete("/users/1");
		mvc.perform(request).andExpect(content().string(equalTo("success")));
		// 1、get查一下user列表，应该为空
		request = get("/users/");
		mvc.perform(request).andExpect(status().isOk()).andExpect(content().string(equalTo("[]")));
	}

}
