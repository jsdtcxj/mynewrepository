package com.chs.coreJava.innerClazz;

public class StaticInnerClazz {
	
	private static String message = "Hello World!";
	private int count = 0;
	
	static class Inner{
		public static void printMessage() {
			System.out.println(message);
//			System.out.println(count);
		}
	}

	public static void main(String[] args) {
		StaticInnerClazz.Inner inner = new StaticInnerClazz.Inner();
//		inner.printMessage();
		StaticInnerClazz.Inner.printMessage();
		
		StaticInnerClazz.Inner inner2 = new StaticInnerClazz.Inner();
		System.out.println(inner);
		System.out.println(inner2);
	}

}
