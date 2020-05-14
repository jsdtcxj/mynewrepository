package com.chs.coreJava.lock;

import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumerImpl {
	
	private Lock lock = new ReentrantLock();
	private Condition fullCond = lock.newCondition();
	private Condition emptyCond = lock.newCondition();
	
	private LinkedList<Integer> queue = new LinkedList<>();
	private Random rd = new Random();
	private final static int CAPACITY = 2;
	
	public void put() {
		lock.lock();
		try {
			while(queue.size() == CAPACITY) {
				System.out.println("["+Thread.currentThread().getName()+"] wait for new space ...");
				fullCond.await();
			}
			
			int num = rd.nextInt(100);
			queue.push(num);
			System.out.println("["+Thread.currentThread().getName()+"] produced " + num);
			
			emptyCond.signalAll();
			System.out.println("["+Thread.currentThread().getName()+"] single All consumers ");
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
	
	public void get() {
		lock.lock();
		try {
			while(queue.isEmpty()) {
				System.out.println("["+Thread.currentThread().getName()+"] wait for new product ...");
				emptyCond.await();
			}
			
			System.out.println("["+Thread.currentThread().getName()+"] consumed " + queue.poll());
			fullCond.signal();
			System.out.println("["+Thread.currentThread().getName()+"] single all producers");
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
}
