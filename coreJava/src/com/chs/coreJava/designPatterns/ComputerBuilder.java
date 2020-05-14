package com.chs.coreJava.designPatterns;

public abstract class ComputerBuilder {
	
	final public Computer buildComputer() {
		Computer computer = new Computer();
		
		addMotherBoard(computer);
		addProcessor(computer);
		addMonitor(computer);
		
		return computer;
	}
	
	public abstract void addMotherBoard(Computer computer);
	public abstract void addProcessor(Computer computer);
	public abstract void addMonitor(Computer computer);
}
