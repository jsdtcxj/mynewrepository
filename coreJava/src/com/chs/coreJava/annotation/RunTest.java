package com.chs.coreJava.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Objects;

public class RunTest {

	public static void main(String[] args) {
		System.out.println("Testing ...");
		
		int passed = 0, failed = 0, count = 0, ignore = 0;
		Class<TestExample> obj = TestExample.class;
		if(obj.isAnnotationPresent(TesterInfo.class)) {
			Annotation annotation = obj.getAnnotation(TesterInfo.class);
			TesterInfo testerInfo = (TesterInfo)annotation;
			
			System.out.printf("%nPriority :%s", testerInfo.priority());
			System.out.printf("%nCreatedBy :%s", testerInfo.createdBy());
			System.out.printf("%nTags :");
			
			int tagLength = testerInfo.tags().length;
			for (String tag : testerInfo.tags()) {
				if (tagLength > 1) {
					System.out.print(tag + ", ");
				} else {
					System.out.print(tag);
				}
				tagLength--;
			}
			
			System.out.printf("%nLastModified :%s%n%n", testerInfo.lastModified());
		}
		
		for(Method method : obj.getDeclaredMethods()) {
			if(method.isAnnotationPresent(Test.class)) {
				Test test = method.getAnnotation(Test.class);
				if(test.enabled()) {
					try {
						method.invoke(obj.newInstance());
						passed++;
						System.out.printf("%s - Test '%s' - passed %n", ++count, method.getName());
					} catch (Exception e) {
						failed++;
						System.out.printf("%s - Test '%s' - failed: %s %n", ++count, method.getName(), e.getCause());
						e.printStackTrace();
					}
				} else {
					System.out.printf("%s - Test '%s' - ignored%n", ++count, method.getName());
					ignore++;
				}
			} 
		}
		System.out.printf("%nResult : Total : %d, Passed: %d, Failed %d, Ignore %d%n", count, passed, failed, ignore);
	}

}
