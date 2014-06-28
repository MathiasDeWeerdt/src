package com.singlecore.scripts.treechopper.nodes;

import org.osbot.rs07.api.model.RS2Object;
import org.osbot.rs07.script.MethodProvider;
import org.osbot.rs07.script.Script;

import com.singlecore.api.Timer;
import com.singlecore.core.AbstractNode;
import com.singlecore.scripts.treechopper.data.Constants;

public class Chop extends AbstractNode {

	Timer time = new Timer(MethodProvider.random(1800, 2600));

	public Chop(Script script) {
		super(script);
	}

	@Override
	public boolean activate() throws InterruptedException {
		return !script.getInventory().isFull()
				&& script.getInventory().contains(Constants.AXE)
				|| script.getEquipment().contains(Constants.AXE);
	}

	@Override
	public void execute() throws InterruptedException {
		if (!script.myPlayer().isAnimating()) {
			RS2Object tree = script.getObjects().closest(Constants.TREE_AREA,
					Constants.TREES);
			if (tree != null) {
				if (tree.interact("Chop Down")) {
					time.reset();
					while (time.isRunning() && !script.myPlayer().isAnimating()
							|| script.myPlayer().isMoving()) {
						MethodProvider.sleep(100);
					}
				}

			}
		}
	}

	@Override
	public String status() {
		return "Chopping node";
	}

}
