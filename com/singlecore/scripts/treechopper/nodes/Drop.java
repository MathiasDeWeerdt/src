package com.singlecore.scripts.treechopper.nodes;

import org.osbot.rs07.api.filter.Filter;
import org.osbot.rs07.api.model.Item;
import org.osbot.rs07.script.MethodProvider;
import org.osbot.rs07.script.Script;

import com.singlecore.api.Timer;
import com.singlecore.core.AbstractNode;
import com.singlecore.scripts.treechopper.data.Constants;

public class Drop extends AbstractNode {

	Timer time = new Timer(1000);

	public Drop(Script script) {
		super(script);
	}

	@Override
	public boolean activate() throws InterruptedException {
		return script.getInventory().isFull() && Constants.powerChop;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void execute() throws InterruptedException {
		for(int i = 0; i < 27; i++) {
			int j = script.getInventory().getEmptySlots();
			script.getInventory().dropForFilter(new Filter<Item>() {
	
				@Override
				public boolean match(Item item) {
					return item != null && !item.getName().contains("axe");
				}
	
			});
			time.reset();
			while(time.isRunning() && script.getInventory().getEmptySlots() == j) {
				MethodProvider.sleep(50);
			}
		}
	}

	@Override
	public String status() {
		return "Dropping node";
	}

}
