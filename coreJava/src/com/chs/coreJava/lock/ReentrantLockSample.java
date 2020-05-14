package com.chs.coreJava.lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockSample {
	
	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(2);
		ReentrantLock lock = new ReentrantLock();
		
		executor.submit(()->{
			lock.lock();
			try {
				System.out.println(Thread .currentThread()+ ": Accquired the lock ..");
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				lock.unlock();
				System.out.println(Thread .currentThread()+ ": release the lock ...");
			}
		});
		
		executor.submit(()->{
			System.out.println(Thread .currentThread()+ ": Try to get Lock ...");
			lock.lock();
			try {
				System.out.println(Thread .currentThread()+ ": Get Lock ...");
			} finally {
				lock.unlock();
			}
		});
		
		executor.shutdown();
	}
}
