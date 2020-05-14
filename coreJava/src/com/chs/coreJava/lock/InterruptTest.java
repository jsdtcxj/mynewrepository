package com.chs.coreJava.lock;

import java.util.concurrent.locks.ReentrantLock;

public class InterruptTest {

	public static void main(String[] args) {
		ReentrantLock lock = new ReentrantLock();
		Thread t1 = new Thread(()-> {
			lock.lock();
			try {
				System.out.println("["+Thread.currentThread().getName()+"] got the lock");
				Thread.currentThread().sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				lock.unlock();
				System.out.println("["+Thread.currentThread().getName()+"] released the lock");
			}
		});
		
		Thread t2 = new Thread(()-> {
//			lock.lock(); //can not be interrupted
			
			try {
				lock.lockInterruptibly();//can be interrupted
			} catch (InterruptedException e1) {
				System.out.println("["+Thread.currentThread().getName()+"] is interrupted");
				return;
			}
			
			try {
				
				System.out.println("["+Thread.currentThread().getName()+"] got the lock");
				Thread.currentThread().sleep(2000);
			} catch (InterruptedException e) {
				System.out.println("["+Thread.currentThread().getName()+"] is interrupted");
			} finally {
				lock.unlock();
				System.out.println("["+Thread.currentThread().getName()+"] released the lock");
			}
		});
		
		t1.start();
		t2.start();
		try {
			Thread.currentThread().sleep(1000);
			t2.interrupt();
			System.out.println("["+t2.getName()+"] is interrupting ...");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
