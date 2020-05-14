package com.chs.coreJava.repeatable.annotation;

@Hint("hint1")
@Hint("hint2")
/**
 * 老式写法
 * @Hints({@Hint("hint1"),
 * 		   @Hint("hint2")})
 */
public class Test {

	public static void main(String[] args) {
		Hints hints = Test.class.getAnnotation(Hints.class);
		System.out.println("Annotation is Hints");
		for(Hint h : hints.value()) {
			System.out.println(h.value());
		}

		Hint[] hints2 = Test.class.getAnnotationsByType(Hint.class);
		System.out.println("Annotation type is Hint");
		for (Hint h : hints2) {
			System.out.println(h.value());
		}

	}

}
