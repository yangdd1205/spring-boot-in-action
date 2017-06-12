package com.slowe.web;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	/**
	 * 测试WebLogAspect
	 */
	@RequestMapping("/hello/{name}")
	public String hello(@PathVariable String name) throws Exception {
		return "hello " + name;
	}

	/**
	 * 测试OrderAspect
	 * 
	 * @Order(int)的执行顺序
	 * 
	 * 查找顺序 类 > 方法 
	 * 在切入点前的操作，按order的值由小到大执行
	 * 在切入点后的操作，按order的值由大到小执行
	 * 
	 */
	@RequestMapping("/order")
	public String order() throws Exception {
		return "order";
	}

}
