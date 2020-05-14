package com.chs.coreJava.methodConstructorRef;

@FunctionalInterface
public interface Converter<F, T> {

	T convert(F from);
}
