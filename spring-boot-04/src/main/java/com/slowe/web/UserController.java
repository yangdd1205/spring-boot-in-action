package com.slowe.web;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.slowe.entity.User;

@RestController
@RequestMapping("/users")
public class UserController {

	// 创建线程安全的Map
	// Collections.synchronizedMap(new HashMap()) 单个方法是线程安全的，但是复合操作不是线程安全的
	// ConcurrentHashMap 为并发容器，支持复合操作
	static Map<Long, User> users = new ConcurrentHashMap<Long, User>();

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<User> getUserList() {
		List<User> list = new ArrayList<>(users.values());
		return list;

	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String postUser(@ModelAttribute User user) {
		users.put(user.getId(), user);
		return "success";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public User getUser(@PathVariable Long id) {
		return users.get(id);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public String putUser(@PathVariable Long id, @ModelAttribute User user) {
		User u = users.get(id);
		u.setName(user.getName());
		u.setAge(user.getAge());
		users.put(id, u);
		return "success";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public String deleteUser(@PathVariable Long id) {
		users.remove(id);
		return "success";

	}
}
