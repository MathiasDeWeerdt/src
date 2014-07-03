package com.singlecore.scripts.treechopper.nodes;

import org.osbot.rs07.api.map.Position;
import org.osbot.rs07.api.model.NPC;
import org.osbot.rs07.script.Script;

import com.singlecore.api.Walking;
import com.singlecore.core.AbstractNode;

public class Ent extends AbstractNode {

	public Ent(Script script) {
		super(script);
	}

	@Override
	public boolean activate() throws InterruptedException {
		return isChoppingEnt();
	}

	@Override
	public void execute() throws InterruptedException {
		Walking walk = new Walking(script);
		script.log("Ent detected, walking away.");
		walk.walkTile(new Position((script.myPosition().getX() + 3), (script.myPosition().getY() - 3), 0));
	}

	@Override
	public String status() {
		return "Ent node";
	}
	
	public boolean isChoppingEnt() {
		NPC ent = script.getNpcs().closestThatContains(new String[] {"Tree", "tree", "Oak", "oak", "Willow", "willow", "Yew", "yew", "Maple", "maple", "Magic", "magic"});
		return ent != null && script.myPlayer().isInteracting(ent);
	}

}
