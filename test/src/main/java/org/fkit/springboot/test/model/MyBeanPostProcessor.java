package org.fkit.springboot.test.model;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyBeanPostProcessor implements BeanPostProcessor{

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("BeanPostProcessor: load before " + beanName);
		if(beanName.equals("student")) {
			((Student)bean).setName("Updated by BeanPostProcessor");
		}
		return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("BeanPostProcessor: load after " + beanName);
		return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
	}

}
