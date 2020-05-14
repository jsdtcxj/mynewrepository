package org.fkit.hellotest;

public class MyResource implements AutoCloseable{

	@Override
	public void close() throws Exception {
		System.out.println("Closing resource");
	}

	public void print1() {
		System.out.println("start to print ...");
	}
}
