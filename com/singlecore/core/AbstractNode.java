package com.singlecore.core;

import org.osbot.rs07.script.Script;

public abstract class AbstractNode {

	public Script script;

	public AbstractNode(Script script) {
		this.script = script;
	}

	public abstract boolean activate() throws InterruptedException;

	public abstract void execute() throws InterruptedException;
	
	public abstract String status();

}
