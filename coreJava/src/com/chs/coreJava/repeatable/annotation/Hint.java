package com.chs.coreJava.repeatable.annotation;

import java.lang.annotation.Repeatable;

@Repeatable(Hints.class)
public @interface Hint {
	String value();
}
