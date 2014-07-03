package com.singlecore.scripts.treechopper.nodes;

import org.osbot.rs07.api.filter.Filter;
import org.osbot.rs07.api.model.GroundItem;
import org.osbot.rs07.api.model.Item;
import org.osbot.rs07.script.MethodProvider;
import org.osbot.rs07.script.Script;

import com.singlecore.api.Timer;
import com.singlecore.core.AbstractNode;
import com.singlecore.scripts.treechopper.data.Constants;

public class Nest extends AbstractNode {

	Timer time = new Timer(2000);

	public Nest(Script script) {
		super(script);
	}

	@Override
	public boolean activate() throws InterruptedException {
		GroundItem nest = script.getGroundItems().closestThatContains("nest");
		return nest != null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void execute() throws InterruptedException {
		GroundItem nest = script.getGroundItems().closestThatContains(
				"Bird nest");
		
		if(script.getInventory().isFull()) {
			script.getInventory().dropForFilter(new Filter<Item>() {
				
				@Override
				public boolean match(Item item) {
					return item != null && !item.getName().contains("axe");
				}
	
			});
		}
		
		if (nest != null) {
			if (nest.interact("Take")) {
				time.reset();
				while (time.isRunning() && nest != null) {
					MethodProvider.sleep(50);
				}
				Constants.nestsFound++;
			}
		}
	}

	@Override
	public String status() {
		return "Nest node";
	}

}
