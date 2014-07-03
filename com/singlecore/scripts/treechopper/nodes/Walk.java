package com.singlecore.scripts.treechopper.nodes;

import org.osbot.rs07.api.map.Position;
import org.osbot.rs07.script.Script;
import org.osbot.rs07.utility.Area;

import com.singlecore.api.Walking;
import com.singlecore.core.AbstractNode;
import com.singlecore.scripts.treechopper.data.Constants;

public class Walk extends AbstractNode {

	public Walk(Script script) {
		super(script);
	}

	@Override
	public boolean activate() throws InterruptedException {
		if(!Constants.powerChop) {
			if(!script.getInventory().isFull() && !Constants.TREE_AREA_SELECTED.contains(script.myPlayer())) {
				return true;
			}
			if(script.getInventory().isFull() && !Constants.BANK_AREA_SELECTED.contains(script.myPlayer())) {
				return true;
			}
		}
		
		return false;
	}

	@Override
	public void execute() throws InterruptedException {
		Walking walk = new Walking(script);

		if(script.getInventory().contains(Constants.selectedAxe)
				|| script.getEquipment().contains(Constants.selectedAxe)) {
			if (!script.getInventory().isFull() && !Constants.TREE_AREA_SELECTED.contains(script.myPlayer())) {
				if (Constants.selectedTree.equals(Constants.MAGIC)) {
					walk.walkPath(Constants.pathToMagics);
				} else {
					script.localWalker.walk(getCenterPosition(Constants.TREE_AREA_SELECTED, 0));
				}
			}
		}

		if (script.getInventory().isFull() && !Constants.BANK_AREA_SELECTED.contains(script.myPlayer())) {
			if (Constants.selectedTree.equals(Constants.MAGIC)) {
				walk.walkPath(Constants.pathToBank);
			} else {
				script.localWalker.walk(getCenterPosition(Constants.BANK_AREA_SELECTED, 0));
			}
		}
	}
	
	public Position getCenterPosition(Area area, int height) {
		return new Position((area.getMinX() + area.getMaxX()) / 2, (area.getMinY() + area.getMaxY()) / 2, height);
	}

	@Override
	public String status() {
		return "walking node";
	}

}
