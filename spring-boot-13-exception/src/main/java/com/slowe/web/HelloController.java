package com.slowe.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.slowe.exception.MyException;

@Controller
public class HelloController {

	@RequestMapping("/hello")
	public String hello() throws Exception {
		throw new Exception("发生错误");
	}

	/**
	 * 针对MyException返回json,所以该方法的@ResponseBody根据实际返回写
	 * 
	 * @return
	 * @throws MyException
	 */
	@ResponseBody
	@RequestMapping("/json")
	public String json() throws MyException {
		throw new MyException("发生错误，返回json");
	}
}
