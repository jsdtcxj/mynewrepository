package com.chs.coreJava.designPatterns;

public class StandardComputerBuilder extends ComputerBuilder {

	@Override
	public void addMotherBoard(Computer computer) {
		computer.setMotherBoard("motherBoard_standard");
	}

	@Override
	public void addProcessor(Computer computer) {
		computer.setProcessor("processor_standard");
	}

	@Override
	public void addMonitor(Computer computer) {
		computer.setMonitor("monitor_standard");
	}

}
