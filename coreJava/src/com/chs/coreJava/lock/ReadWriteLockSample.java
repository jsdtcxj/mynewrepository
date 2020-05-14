package com.chs.coreJava.lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockSample {

	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(2);
		ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
		Runnable read = ()-> {
			lock.readLock().lock();
			try {
				System.out.println("Read data ...");
				Thread.sleep(2000L);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				System.out.println("released read lock");
				lock.readLock().unlock();
			}
		};
		
		executor.submit(()->{
			lock.writeLock().lock();
			try {
				System.out.println("Lock it for write ...");
				Thread.sleep(1000L);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				System.out.println("Unlock it ...");
				lock.writeLock().unlock();
			}
		});
		
		executor.submit(read);
		executor.submit(read);
		
		executor.shutdown();
	}

}
