package com.singlecore.scripts.treechopper.nodes;

import org.osbot.rs07.script.Script;

import com.singlecore.core.AbstractNode;

public class Nest extends AbstractNode {

	public Nest(Script script) {
		super(script);
	}

	@Override
	public boolean activate() throws InterruptedException {
		return false;
	}

	@Override
	public void execute() throws InterruptedException {
		
	}

	@Override
	public String status() {
		return "Nest node";
	}

}
