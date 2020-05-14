package com.chs.coreJava.thread;

public class MultipleThreadSample {
	
	public static Object obj = new Object();

	public static void main(String[] args) {
		Runnable waiter = ()->{
			String name = Thread.currentThread().getName();
			System.out.println("["+name+"]Wait on current thread ... " + System.currentTimeMillis());
			synchronized(obj) {
				try {
					Thread.sleep(1000L);
					System.out.println("["+name+"]Waiting on current thread ... " + System.currentTimeMillis());
					obj.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println("[" + name + "]Complete the activity!");
		};
		
		Thread notifier = new Thread(()->{
			String name = Thread.currentThread().getName();
			try {
				Thread.sleep(3000L);
				synchronized(obj) {
					System.out.println("["+name+"]Notify the waiter ...");
					obj.notifyAll();
//					obj.notify();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		
		Thread t1 = new Thread(waiter);
		Thread t2 = new Thread(waiter);
		t1.start();
		t2.start();
		
		notifier.start();
	}

}
