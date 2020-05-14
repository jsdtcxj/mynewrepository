package com.chs.coreJava.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyInvocationHandler implements InvocationHandler {
	
	public static void main(String[] args) {
		MyInvocationHandler handler = new MyInvocationHandler();
		CustomerService service = (CustomerService)handler.getProxy(new CustomerServiceImpl());
		System.out.println("Customer name: " + service.getUserName());
		service.setUserName("Taylor Jimmy");
	}
	
	private Object obj;
	
	public Object getProxy(Object obj) {
		this.obj = obj;
		return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), this);
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		doBefore();
		Object result = method.invoke(obj, args);
		doAfter();
		return result;
	}

	public void doBefore() {
		System.out.println("do something before method invocation");
	}
	
	public void doAfter() {
		System.out.println("do something after method invocation");
	}
}
