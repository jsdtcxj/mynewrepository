package com.chs.coreJava.designPatterns;

public class Computer {
	private String motherBoard;
	private String processor;
	private String monitor;

	public String getMotherBoard() {
		return motherBoard;
	}

	public void setMotherBoard(String motherBoard) {
		this.motherBoard = motherBoard;
	}

	public String getProcessor() {
		return processor;
	}

	public void setProcessor(String processor) {
		this.processor = processor;
	}

	public String getMonitor() {
		return monitor;
	}

	public void setMonitor(String monitor) {
		this.monitor = monitor;
	}

	@Override
	public String toString() {
		return "Computer [motherBoard=" + motherBoard + ", processor=" + processor + ", monitor=" + monitor + "]";
	}
}
