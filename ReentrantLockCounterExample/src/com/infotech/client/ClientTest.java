package com.infotech.client;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import com.infotech.model.Counter;

public class ClientTest {

	public static void main(String[] args) {
		ExecutorService executorService = null;
		try {
			executorService = Executors.newFixedThreadPool(2);

			final Counter counter = new Counter();
			Runnable task1 = new Runnable() {

				public void run() {
					for (int i = 1; i <= 1000; i++) {
						counter.increment();
					}
				}
			};

			Runnable task2 = new Runnable() {

				public void run() {
					for (int i = 1; i <= 2000; i++) {
						counter.increment();
					}
				}
			};
			executorService.submit(task1);
			executorService.submit(task2);
			
			executorService.awaitTermination(3, TimeUnit.SECONDS);
			System.out.println(counter.getCount());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (executorService != null)
				executorService.shutdown();
		}
	}

}
