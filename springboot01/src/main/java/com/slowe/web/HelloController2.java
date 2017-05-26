package com.slowe.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/admin")
public class HelloController2 {

	@ResponseBody
	@RequestMapping("/hello/{name}")
	public String hello(@PathVariable String name) {
		return "hello," + name;

	}

}
