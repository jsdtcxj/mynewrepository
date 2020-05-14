package com.chs.springboot.springAOP.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TestAspect {
	
	@Pointcut("this(com.chs.springboot.springAOP.service.ProductServiceImpl)")
	public void test() {
		System.out.println("This is a Pointcut.");
	}
	
	@Before("test()")
	public void beforeDelete() {
		System.out.println("Before Delete Product ...");
	}
}
