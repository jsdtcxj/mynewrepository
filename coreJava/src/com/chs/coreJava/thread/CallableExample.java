package com.chs.coreJava.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class CallableExample {

	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(3);
		Callable<String> callable = ()->{
			Thread.sleep(1000L);
			return Thread.currentThread().getName();
		};
		
		List<Future<String>> list = new ArrayList<>();
		for(int i = 0; i < 5; i++) {
			list.add(executor.submit(callable));
		}
		
		for(Future<String> future : list) {
			try {
				System.out.println(future.get());
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
		}
		executor.shutdown();
		try {
			if(!executor.awaitTermination(800, TimeUnit.MILLISECONDS)) {
				executor.shutdownNow();
			}
		} catch (InterruptedException e) {
			executor.shutdownNow();
		}
		
	}

}
