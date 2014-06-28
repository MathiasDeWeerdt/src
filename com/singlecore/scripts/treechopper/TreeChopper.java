package com.singlecore.scripts.treechopper;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.util.ArrayList;

import org.osbot.rs07.api.ui.Message;
import org.osbot.rs07.api.ui.Skill;
import org.osbot.rs07.listener.MessageListener;
import org.osbot.rs07.script.Script;
import org.osbot.rs07.script.ScriptManifest;

import com.singlecore.api.Time;
import com.singlecore.core.AbstractNode;
import com.singlecore.scripts.treechopper.data.Constants;
import com.singlecore.scripts.treechopper.nodes.Bank;
import com.singlecore.scripts.treechopper.nodes.Chop;

@ScriptManifest(author = "Single Core", info = "Chops tree's and banks them", logo = "", name = "TreeChopper", version = 0.01)
public class TreeChopper extends Script implements MessageListener {

	private ArrayList<AbstractNode> nodes = new ArrayList<AbstractNode>();
	private Time time = new Time();
	
	public void onStart() {
		nodes.add(new Bank(this));
		nodes.add(new Chop(this));
		Constants.startXp = this.getSkills().getExperience(Skill.WOODCUTTING);
	}

	@Override
	public int onLoop() throws InterruptedException {
		for (AbstractNode node : nodes) {
			if (node.activate()) {
				Constants.status = node.status();
				node.execute();
			}
		}
		return 100;
	}
	
	public void onMessage(Message msg) {
		final String m = msg.getMessage();
		if (m.contains("You get some")) {
			Constants.logsChopped++;
		}
	}

	public void onPaint(Graphics2D g) {
		int gainedxp = this.getSkills().getExperience(Skill.WOODCUTTING) - Constants.startXp;
		g.setColor(color1);
		g.fillRoundRect(287, 233, 220, 97, 8, 8);
		g.setColor(color2);
		g.setStroke(stroke1);
		g.drawRoundRect(287, 233, 220, 97, 8, 8);
		g.setFont(font1);
		g.drawString("Runtime: " + time.display(), 300, 255);
		g.drawString("Logs(hr): " + Constants.logsChopped + "(" + time.calculatePerHour(Constants.logsChopped) + ")", 300, 275);
		g.drawString("Exp(hr): " + gainedxp + "(" + time.calculatePerHour(gainedxp) + ")", 300, 295);
		g.drawString("Status: " + Constants.status, 300, 315);
	}
	
	private final Color color1 = new Color(140, 200, 20, 140);
	private final Color color2 = new Color(0, 0, 0);
	private final BasicStroke stroke1 = new BasicStroke(1);
	private final Font font1 = new Font("Arial", 0, 14);
}
