package com.singlecore.scripts.treechopper.nodes;

import org.osbot.rs07.api.model.Item;
import org.osbot.rs07.script.MethodProvider;
import org.osbot.rs07.script.Script;

import com.singlecore.api.Timer;
import com.singlecore.core.AbstractNode;
import com.singlecore.scripts.treechopper.data.Constants;

public class Bank extends AbstractNode {

	Timer time = new Timer(MethodProvider.random(1200, 1600));

	public Bank(Script script) {
		super(script);
	}

	@Override
	public boolean activate() throws InterruptedException {
		return !Constants.powerChop && script.getInventory().isFull()
				|| !script.getInventory().contains(Constants.selectedAxe)
				&& !script.getEquipment().contains(Constants.selectedAxe);
	}

	@Override
	public void execute() throws InterruptedException {
		if (!script.getBank().isOpen()) {
			script.getBank().open();
			time.reset();
			while (!script.getBank().isOpen() && time.isRunning()) {
				MethodProvider.sleep(100);
			}
		}
		
		depositAllExcept(Constants.selectedAxe);

		if (!script.getInventory().contains(Constants.selectedAxe) && !script.getEquipment().contains(Constants.selectedAxe)) {
			
			if(!script.getBank().contains(Constants.selectedAxe)) {
				script.log("No axe in your bank!");
				script.stop();
			}
			
			script.getBank().withdraw(Constants.selectedAxe, 1);
			time.reset();
			while (!script.getInventory().contains(Constants.selectedAxe)
					&& time.isRunning()) {
				MethodProvider.sleep(100);
			}
		}
	}

	@Override
	public String status() {
		return "Banking node";
	}

	public void depositAllExcept(int id) {
		if (script.getBank().isOpen()) {
			Item[] items = script.getInventory().getItems();

			for (Item item : items) {
				if (item != null) {
					if (item.getId() != id) {
						script.getBank().deposit(item.getId(), 28);
					}
				}
			}

		}

	}

}
