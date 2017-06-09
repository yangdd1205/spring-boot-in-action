package com.slowe.task;

import java.util.Random;
import java.util.concurrent.Future;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

@Component
public class ASyncTaskCallback {
	public static Random random = new Random();

	// 注： @Async所修饰的函数不要定义为static类型，这样异步调用不会生效
	@Async
	public Future<Long> doTaskOne() throws Exception {
		System.out.println("异步回调：开始做任务一");
		long start = System.currentTimeMillis();
		Thread.sleep(random.nextInt(10000));
		long end = System.currentTimeMillis();
		System.out.println("异步回调：完成任务一，耗时：" + (end - start) + "毫秒");
		return new AsyncResult<Long>((end - start));
	}

	@Async
	public Future<Long> doTaskTwo() throws Exception {
		System.out.println("异步回调：开始做任务二");
		long start = System.currentTimeMillis();
		Thread.sleep(random.nextInt(10000));
		long end = System.currentTimeMillis();
		System.out.println("异步回调：完成任务二，耗时：" + (end - start) + "毫秒");
		return new AsyncResult<Long>((end - start));
	}

	@Async
	public Future<Long> doTaskThree() throws Exception {
		System.out.println("异步回调：开始做任务三");
		long start = System.currentTimeMillis();
		Thread.sleep(random.nextInt(10000));
		long end = System.currentTimeMillis();
		System.out.println("异步回调：完成任务三，耗时：" + (end - start) + "毫秒");
		return new AsyncResult<Long>((end - start));
	}
}
