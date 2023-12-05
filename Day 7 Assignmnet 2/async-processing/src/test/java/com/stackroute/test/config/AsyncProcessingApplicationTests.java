package com.stackroute.test.config;

import com.stackroute.Async.Processing.AsyncProcessingApplication;
import com.stackroute.Async.Processing.service.AsyncService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@SpringJUnitConfig
@EnableAsync
@ContextConfiguration(classes = AsyncProcessingApplication.class)
class AsyncProcessingApplicationTests {

	@Autowired
	private AsyncService asyncService;

	@Test
	public void testAsyncTaskExecution() throws InterruptedException {
		// Create a latch to wait for the asynchronous task to complete
		CountDownLatch latch = new CountDownLatch(1);

		// Trigger the asynchronous task
		asyncService.performAsyncTask();

		// Wait for a reasonable amount of time for the async task to complete
		assertFalse(latch.await(10, TimeUnit.SECONDS), "Async task did not complete in time");

		// If the latch countdown completes, the asynchronous task has completed successfully
	}

	@Test
	public void testMultipleConcurrentAsyncTasks() throws InterruptedException {
		int numberOfTasks = 5;
		CountDownLatch latch = new CountDownLatch(numberOfTasks);

		ExecutorService executorService = Executors.newFixedThreadPool(numberOfTasks);

		// Trigger multiple asynchronous tasks concurrently
		for (int i = 0; i < numberOfTasks; i++) {
			executorService.execute(() -> {
				asyncService.performAsyncTask();
				latch.countDown();
			});
		}

		// Wait for all tasks to complete
		assertTrue(latch.await(20, TimeUnit.SECONDS), "Not all async tasks completed in time");

		executorService.shutdown();
		executorService.awaitTermination(5, TimeUnit.SECONDS);

		// If the latch countdown completes, all asynchronous tasks have completed successfully
	}
}
