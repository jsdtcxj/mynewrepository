package com.chs.coreJava.thread;

public class IdThread extends Thread {
	
	private ThreadLocal<Integer> ids = null;
	
	public IdThread(ThreadLocal<Integer> ids) {
		this.ids = ids;
	}

	@Override
	public void run() {
		ids.set(ThreadLocalExample.atomic.getAndIncrement());
		System.out.println("[IdThread1" +this.toString() + "] id: " + ids.get());
		try {
			sleep(1000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("[IdThread1" +this.toString() + "] id: " + ids.get());
	}

}
