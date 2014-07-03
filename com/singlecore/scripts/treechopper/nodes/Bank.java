package com.singlecore.scripts.treechopper.nodes;

import org.osbot.rs07.api.filter.Filter;
import org.osbot.rs07.api.model.Item;
import org.osbot.rs07.api.model.RS2Object;
import org.osbot.rs07.script.MethodProvider;
import org.osbot.rs07.script.Script;

import com.singlecore.api.Timer;
import com.singlecore.core.AbstractNode;
import com.singlecore.scripts.treechopper.data.Constants;

public class Bank extends AbstractNode {

	Timer time = new Timer(2500);

	public Bank(Script script) {
		super(script);
	}

	@Override
	public boolean activate() throws InterruptedException {
		if(!Constants.powerChop) {
		return script.getInventory().isFull()
				|| !script.getInventory().contains(Constants.selectedAxe)
				&& !script.getEquipment().contains(Constants.selectedAxe)
				&& Constants.BANK_AREA_SELECTED.contains(script.myPlayer());
		}
		
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void execute() throws InterruptedException {
		if (!script.getBank().isOpen()) {
			RS2Object bank = script.getObjects().closestThatContains("Bank Booth");
			if(bank != null) {
				if (bank.interact("Bank")) {
					time.reset();
					while (!script.getBank().isOpen() && time.isRunning()) {
						MethodProvider.sleep(100);
					}
				}
			}
		}
		
		script.getBank().depositAll(new Filter<Item>() {

			@Override
			public boolean match(Item item) {
				return item != null && !item.getName().contains("axe");
			}
			
		});

		if (!script.getInventory().contains(Constants.selectedAxe) && !script.getEquipment().contains(Constants.selectedAxe)) {
			if (!script.getBank().contains(Constants.selectedAxe)) {
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
		
		script.getBank().close();
	}

	@Override
	public String status() {
		return "Banking node";
	}

}
