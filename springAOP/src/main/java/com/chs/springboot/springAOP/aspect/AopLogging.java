package com.chs.springboot.springAOP.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AopLogging {

	@Pointcut("this(com.chs.springboot.springAOP.service.CustomerService)")
	public void pointcut() {
		System.out.println("pointcut() ...");
	}
	
	@Pointcut("args(String)") 
	public void methodwithArgs() {
		
	}
	
	@Before("args(String)") 
	public void invoke(JoinPoint joinPoint) {
		System.out.println(joinPoint.getSignature() + " methodwithArgs(String)");
	}
	
	
	@Around("pointcut()")
	public Object invoke(ProceedingJoinPoint invocation) throws Throwable {
		System.out.println("JDK proxy/CGLIB start ...");
		Object o = invocation.proceed();
		System.out.println("JDK proxy/CGLIB end ...");
		return o;
	}
	
	@After("execution(* com.chs.springboot.springAOP.service.CustomerService.getCustomer(String))")
	public void afterInvoke(JoinPoint joinPoint) {
		System.out.println(joinPoint.getSignature() + " after getCustomer(String)");
	}
}
