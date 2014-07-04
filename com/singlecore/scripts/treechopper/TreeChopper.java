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
import com.singlecore.api.XpDistance;
import com.singlecore.core.AbstractNode;
import com.singlecore.scripts.treechopper.data.Constants;
import com.singlecore.scripts.treechopper.gui.UI;
import com.singlecore.scripts.treechopper.nodes.Bank;
import com.singlecore.scripts.treechopper.nodes.Chop;
import com.singlecore.scripts.treechopper.nodes.Drop;
import com.singlecore.scripts.treechopper.nodes.Ent;
import com.singlecore.scripts.treechopper.nodes.Nest;
import com.singlecore.scripts.treechopper.nodes.Walk;

@ScriptManifest(author = "Single Core", info = "Chops tree's and banks them", logo = "", name = "TreeChopper", version = 0.05)
public class TreeChopper extends Script implements MessageListener {

	private ArrayList<AbstractNode> nodes = new ArrayList<AbstractNode>();
	private Time time = new Time();
	
	public void onStart() throws InterruptedException {
		
		UI gui = new UI(this);
		gui.setVisible(true);
		while(gui.isVisible()) {
			sleep(100);
		}
		
		if(!Constants.powerChop) {
			log("Option Selected: " + Constants.TREE_AREA_SELECTED.toString());
			log("Axe Selected: " + Constants.selectedAxe);
		}
		log("Tree Selected: " + Constants.selectedTree);
		
		nodes.add(new Nest(this));
		nodes.add(new Ent(this));
		nodes.add(new Walk(this));
		nodes.add(new Bank(this));
		nodes.add(new Chop(this));
		nodes.add(new Drop(this));
		
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
	
	public void onPaint(Graphics2D g1) {
		
		int gainedxp = this.getSkills().getExperience(Skill.WOODCUTTING) - Constants.startXp;
		
		Graphics2D g = (Graphics2D) g1;

		g.setColor(color1);
		g.fillRect(9, 311, 500, 21);
		g.setColor(color2);
		g.setStroke(stroke1);
		g.drawRect(9, 311, 500, 21);

		g.setColor(new Color(0, 255, 0, 80));

		//Percentage to next level
		g.fillRect(9, 311, 500 / 100 * (100 - XpDistance.getPercentageUntilNextLevelFromCurrentLevel(this, Skill.WOODCUTTING)), 21);
		g.setColor(color2);
		g.setStroke(stroke1);
		g.drawRect(9, 311, 500, 21);

		g.setFont(font2);
		g.setFont(font1);
		g.setColor(color2);
		g.drawString("Runtime: " + time.display(), 20, 326);
		g.drawString("Exp(hr): " + gainedxp + "(" + time.calculatePerHour(gainedxp) + ")", 130, 326);
		g.drawString("TTNL: " + time.timeTillNewLevel(getSkills().experienceToLevel(Skill.WOODCUTTING), time.calculatePerHour(gainedxp)), 260, 326);
		g.drawString("Logs: " + Constants.logsChopped + "(" + time.calculatePerHour(Constants.logsChopped) + ")", 370, 326);
		g.drawString(100 - XpDistance.getPercentageUntilNextLevelFromCurrentLevel(this, Skill.WOODCUTTING) + "%", 480,326);

		g.setColor(Color.BLACK);
		g.drawString("Made by: Single Core", 392, 360);
		
		if(!Constants.powerChop) {
			g.drawString("$ Made: " + Constants.logsChopped*Constants.SELECTED_PRICE + "(" + Constants.SELECTED_PRICE + ")", 392, 380);
			g.drawString("$ Hour: " + time.calculatePerHour(Constants.logsChopped*Constants.SELECTED_PRICE), 392, 400);
		}
		
		g.drawString("Version: " + 0.05, 10, 360);
		g.drawString("Status: " + Constants.status, 10, 380);
		g.drawString("Nests: " + Constants.nestsFound, 10, 400);
	}
	
	public static final Color color1 = new Color(0, 0, 0, 150);
	public static final Color color2 = new Color(255, 255, 255);
	public static final Color color3 = new Color(255, 0, 0, 130);
	public static final Color color4 = new Color(255, 0, 0, 255);

	public static final BasicStroke stroke1 = new BasicStroke(1);
	public static final Font font1 = new Font("Arial", 0, 11);
	public static final Font font2 = new Font("Trebuchet", 0, 30);

}