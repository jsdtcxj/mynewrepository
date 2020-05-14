package com.chs.coreJava.lock;

public class LockConditionSample {

	public static void main(String[] args) {
		ProducerConsumerImpl pc = new ProducerConsumerImpl();
		Runnable producer = () -> {
			pc.put();
		};

		Runnable consumer = () -> {
			pc.get();
		};
		
		try {
			for(int i = 0; i < 3; i++) {
				Thread t = new Thread(producer);
				t.start();
				Thread.currentThread().sleep(1000);
			}
			
			for(int i = 0; i < 4; i++) {
				Thread t = new Thread(consumer);
				t.start();
				Thread.currentThread().sleep(1000);
			}
			
			new Thread(producer).start();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
