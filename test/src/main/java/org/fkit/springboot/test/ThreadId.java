package org.fkit.springboot.test;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreadId {
	
	public static void main(String[] args) {
		ThreadId t = new ThreadId();
		ThreadTest t1 = new ThreadTest();
		ThreadTest t2 = new ThreadTest();
		t1.start();
		t2.start();
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}

class ThreadTest extends Thread{
	private static AtomicInteger ids = new AtomicInteger();
	
	private static ThreadLocal<Integer> local = new ThreadLocal<Integer>(){

		@Override
		protected Integer initialValue() {
			return ids.getAndIncrement();
		}
		
	};

	@Override
	public void run() {
		System.out.println("["+this.getId()+"] nextId: " + local.get());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("["+this.getId()+"] nextId: " + local.get());
	}
	
}
