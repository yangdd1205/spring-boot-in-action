package com.slowe;

import java.util.concurrent.Future;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.slowe.task.ASyncTask;
import com.slowe.task.ASyncTaskCallback;
import com.slowe.task.SyncTask;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

	@Autowired
	private SyncTask syncTask;

	@Test
	public void SyncTaskTest() throws Exception {
		syncTask.doTaskOne();
		syncTask.doTaskTwo();
		syncTask.doTaskThree();
	}

	@Autowired
	private ASyncTask asyncTask;

	@Test
	public void ASyncTaskTest() throws Exception {
		asyncTask.doTaskOne();
		asyncTask.doTaskTwo();
		asyncTask.doTaskThree();
	}

	@Autowired
	private ASyncTaskCallback aSyncTaskCallback;

	@Test
	public void ASyncTaskTestCall() throws Exception {
		Future<Long> task1 = aSyncTaskCallback.doTaskOne();
		Future<Long> task2 = aSyncTaskCallback.doTaskTwo();
		Future<Long> task3 = aSyncTaskCallback.doTaskThree();

		Long ms1 = task1.get();
		Long ms2 = task2.get();
		Long ms3 = task3.get();

		System.out.println("总共耗时：" + (ms1 + ms2 + ms3));
	}

}
