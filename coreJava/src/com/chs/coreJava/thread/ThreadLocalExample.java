package com.chs.coreJava.thread;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreadLocalExample {
	public static AtomicInteger atomic = new AtomicInteger();
	
	public static void main(String[] args) {
		ThreadLocal<Integer> ids = new ThreadLocal<Integer>();
		IdThread t1 = new IdThread(ids);
		IdThread t2 = new IdThread(ids);
		t1.start();
		t2.start();
	}
}
