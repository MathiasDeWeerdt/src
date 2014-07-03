package com.singlecore.api;

import org.osbot.rs07.api.map.Position;
import org.osbot.rs07.input.mouse.MiniMapTileDestination;
import org.osbot.rs07.script.MethodProvider;
import org.osbot.rs07.script.Script;

public class Walking {

	Script script;

	public Walking(Script script) {
		this.script = script;
	}

	public void walkPath(Position[] path) throws InterruptedException {
		for (Position p : path) {
			if (script.myPosition().distance(p) > 16
					|| script.myPosition().distance(p) < 3)
				continue;
			boolean success;
			do {
				success = walkTile(p);
			} while (!success);
		}
	}

	public boolean walkTile(Position p) throws InterruptedException {
		if (script.myPosition().distance(p) > 13) {
			Position pos = new Position(
					((p.getX() + script.myPosition().getX()) / 2)
							+ MethodProvider.random(-3, 3), ((p.getY() + script
							.myPosition().getY()) / 2)
							+ MethodProvider.random(-3, 3), script.myPosition()
							.getZ());
			walkTile(pos);
		}
		script.mouse.click(new MiniMapTileDestination(script.bot, p), false);
		int fail = 0;
		while (script.myPosition().distance(p) > 2 && fail < 10) {
			MethodProvider.sleep(500);
			if (!script.myPlayer().isMoving())
				fail++;
		}
		return fail != 10;
	}

}
