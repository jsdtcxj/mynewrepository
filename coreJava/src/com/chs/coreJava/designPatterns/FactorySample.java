package com.chs.coreJava.designPatterns;

public class FactorySample {
	
	public Shape getShape(String type) {
		Shape shape = null;
		if(type != null) {
			if("Circle".equals(type)) {
				shape = new Circle();
			} else if("Square".equals(type)) {
				shape = new Square();
			}
		}
		return shape;
	}

	public static void main(String[] args) {
		FactorySample factory = new FactorySample();
		Shape shape = factory.getShape("Circle");
		shape.draw();
		
		shape = factory.getShape("Square");
		shape.draw();
	}

}
