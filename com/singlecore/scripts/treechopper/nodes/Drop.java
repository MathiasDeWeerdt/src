package com.singlecore.scripts.treechopper.nodes;

import org.osbot.rs07.script.Script;

import com.singlecore.api.Timer;
import com.singlecore.core.AbstractNode;
import com.singlecore.scripts.treechopper.data.Constants;

public class Drop extends AbstractNode {

	Timer time = new Timer(450);

	public Drop(Script script) {
		super(script);
	}

	@Override
	public boolean activate() throws InterruptedException {
		return script.getInventory().isFull() && Constants.powerChop;
	}

	@Override
	public void execute() throws InterruptedException {
		script.getInventory().dropAll(1519);
	}

	@Override
	public String status() {
		return "Dropping node";
	}

}
