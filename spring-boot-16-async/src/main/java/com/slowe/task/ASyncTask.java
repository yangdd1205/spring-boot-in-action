package com.slowe.task;

import java.util.Random;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class ASyncTask {
	public static Random random = new Random();

	// 注： @Async所修饰的函数不要定义为static类型，这样异步调用不会生效
	@Async
	public void doTaskOne() throws Exception {
		System.out.println("异步：开始做任务一");
		long start = System.currentTimeMillis();
		Thread.sleep(random.nextInt(10000));
		long end = System.currentTimeMillis();
		System.out.println("异步：完成任务一，耗时：" + (end - start) + "毫秒");
	}

	@Async
	public void doTaskTwo() throws Exception {
		System.out.println("异步：开始做任务二");
		long start = System.currentTimeMillis();
		Thread.sleep(random.nextInt(10000));
		long end = System.currentTimeMillis();
		System.out.println("异步：完成任务二，耗时：" + (end - start) + "毫秒");
	}

	@Async
	public void doTaskThree() throws Exception {
		System.out.println("异步：开始做任务三");
		long start = System.currentTimeMillis();
		Thread.sleep(random.nextInt(10000));
		long end = System.currentTimeMillis();
		System.out.println("异步：完成任务三，耗时：" + (end - start) + "毫秒");
	}
}
