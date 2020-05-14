package com.chs.springboot.springAOP.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

//@Component
@Aspect
public class LoggingAspect {
	
	@Before("execution(* com.chs.springboot.springAOP.service.CustomerService.addCustomer(..))")
	public void addCustomerBefore(JoinPoint joinPoint) {
		System.out.println("addCustomerBefore() is running ...");
	}
	
	@After("execution(* com.chs.springboot.springAOP.service.CustomerService.addCustomer(..))")
	public void addCustomerAfter(JoinPoint joinPoint) {
		System.out.println("addCustomerAfter() is running ...");
	}
	
	@AfterReturning(pointcut="execution(* *.getCustomer(String))",
			returning = "username")
	public void getCustomerReturnning(JoinPoint joinPoint, Object username) {
		System.out.println("getCustomerReturnning() is running ...");
		System.out.println("Returnning ... [" + username + "]");
	}
	
	@Around("execution(* com.chs.springboot.springAOP.service.CustomerService.addCustomer(..))")
	public void addCustomerAround(ProceedingJoinPoint joinPoint) {
		System.out.println("[Around before]addCustomer() is running ...");
		try {
			joinPoint.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		System.out.println("[Around after]addCustomer() is running ...");
	}
}
