/*
 * Created by JFormDesigner on Mon Jun 30 17:27:10 CEST 2014
 */

package com.singlecore.scripts.treechopper.gui;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.*;

import org.osbot.rs07.script.Script;
import org.osbot.rs07.utility.Area;

import com.singlecore.api.PriceChecker;
import com.singlecore.scripts.treechopper.data.Constants;

/**
 * @author Mathias De Weerdt
 */
public class UI extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Script script;
	
	public UI(Script script) {
		this.script = script;
		initComponents();
	}

	private void button1ActionPerformed(ActionEvent e) throws Exception {
		if (checkBox1.isSelected()) {
			Constants.powerChop = true;
			Constants.treeName = textField1.getText();
			Constants.selectedTree = textField1.getText();
			
			Constants.TREE_AREA_SELECTED = new Area(
					(script.myPosition().getX() - 10),
					(script.myPosition().getY() + 10),
					(script.myPosition().getX() + 10),
					(script.myPosition().getY() - 10)
			);
			
		} else {
			if(comboBox2.getSelectedItem().toString().equals("Bronze")) {
				Constants.selectedAxe = Constants.BRONZE_AXE;
			} else if(comboBox2.getSelectedItem().toString().equals("Iron")) {
				Constants.selectedAxe = Constants.IRON_AXE;
			} else if(comboBox2.getSelectedItem().toString().equals("Steel")) {
				Constants.selectedAxe = Constants.STEEL_AXE;
			} else if(comboBox2.getSelectedItem().toString().equals("Black")) {
				Constants.selectedAxe = Constants.BLACK_AXE;
			} else if(comboBox2.getSelectedItem().toString().equals("Mithril")) {
				Constants.selectedAxe = Constants.MITHRIL_AXE;
			} else if(comboBox2.getSelectedItem().toString().equals("Adamant")) {
				Constants.selectedAxe = Constants.ADAMANT_AXE;
			} else if(comboBox2.getSelectedItem().toString().equals("Rune")) {
				Constants.selectedAxe = Constants.RUNE_AXE;
			}
			
			if(comboBox1.getSelectedItem().toString().equals("Varrock-East | Logs")) {
				Constants.BANK_AREA_SELECTED = Constants.BANK_AREA_VEAST;
				Constants.TREE_AREA_SELECTED = Constants.TREE_AREA_VEAST;
				Constants.selectedTree = Constants.TREE;
				Constants.SELECTED_PRICE = PriceChecker.LOGS.getPrice();
			} else if(comboBox1.getSelectedItem().toString().equals("Varrock-East | Oaks")) {
				Constants.BANK_AREA_SELECTED = Constants.BANK_AREA_VEAST;
				Constants.TREE_AREA_SELECTED = Constants.TREE_AREA_VEAST;
				Constants.selectedTree = Constants.OAK;
				Constants.SELECTED_PRICE = PriceChecker.OAK_LOGS.getPrice();
			}  else if(comboBox1.getSelectedItem().toString().equals("Varrock-West | Logs")) {
				Constants.BANK_AREA_SELECTED = Constants.BANK_AREA_VWEST;
				Constants.TREE_AREA_SELECTED = Constants.TREE_AREA_VWEST;
				Constants.selectedTree = Constants.TREE;
				Constants.SELECTED_PRICE = PriceChecker.LOGS.getPrice();
			} else if(comboBox1.getSelectedItem().toString().equals("Varrock-West | Oaks")) {
				Constants.BANK_AREA_SELECTED = Constants.BANK_AREA_VWEST;
				Constants.TREE_AREA_SELECTED = Constants.TREE_AREA_VWEST;
				Constants.selectedTree = Constants.OAK;
				Constants.SELECTED_PRICE = PriceChecker.OAK_LOGS.getPrice();
			} else if(comboBox1.getSelectedItem().toString().equals("Seers | Yews")) {
				Constants.BANK_AREA_SELECTED = Constants.BANK_AREA_SEERS;
				Constants.TREE_AREA_SELECTED = Constants.TREE_AREA_SEERS_YEW;
				Constants.selectedTree = Constants.YEW;
				Constants.SELECTED_PRICE = PriceChecker.YEW_LOGS.getPrice();
			} else if(comboBox1.getSelectedItem().toString().equals("Seers | Willows")) {
				Constants.BANK_AREA_SELECTED = Constants.BANK_AREA_SEERS;
				Constants.TREE_AREA_SELECTED = Constants.TREE_AREA_SEERS_MAPLE;
				Constants.selectedTree = Constants.WILLOW;
				Constants.SELECTED_PRICE = PriceChecker.WILLOW_LOGS.getPrice();
			} else if(comboBox1.getSelectedItem().toString().equals("Seers | Maples")) {
				Constants.BANK_AREA_SELECTED = Constants.BANK_AREA_SEERS;
				Constants.TREE_AREA_SELECTED = Constants.TREE_AREA_SEERS_MAPLE;
				Constants.selectedTree = Constants.MAPLE;
				Constants.SELECTED_PRICE = PriceChecker.MAPLE_LOGS.getPrice();
			} else if(comboBox1.getSelectedItem().toString().equals("Seers | Magics")) {
				Constants.BANK_AREA_SELECTED = Constants.BANK_AREA_SEERS;
				Constants.TREE_AREA_SELECTED = Constants.TREE_AREA_SEERS_MAGIC_1;
				Constants.selectedTree = Constants.MAGIC;
				Constants.SELECTED_PRICE = PriceChecker.MAGIC_LOGS.getPrice();
			} else if(comboBox1.getSelectedItem().toString().equals("Draynor | Willows")) {
				Constants.BANK_AREA_SELECTED = Constants.BANK_AREA_DRAYNOR;
				Constants.TREE_AREA_SELECTED = Constants.TREE_AREA_DRAYNOR;
				Constants.selectedTree = Constants.WILLOW;
				Constants.SELECTED_PRICE = PriceChecker.WILLOW_LOGS.getPrice();
			} else if(comboBox1.getSelectedItem().toString().equals("Edgeville | Yews")) {
				Constants.BANK_AREA_SELECTED = Constants.BANK_AREA_EDGEVILLE;
				Constants.TREE_AREA_SELECTED = Constants.TREE_AREA_EDGEVILLE;
				Constants.selectedTree = Constants.YEW;
				Constants.SELECTED_PRICE = PriceChecker.YEW_LOGS.getPrice();
			}
		}
		
		this.setVisible(false);
		this.dispose();
	}

	private void checkBox1StateChanged(ChangeEvent e) {
		if (checkBox1.isSelected()) {
			comboBox1.setEnabled(false);
			comboBox2.setEnabled(false);
		} else {
			comboBox1.setEnabled(true);
			comboBox2.setEnabled(true);
		}
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Evaluation license - Mathias De Weerdt
		label1 = new JLabel();
		comboBox1 = new JComboBox<>();
		label2 = new JLabel();
		comboBox2 = new JComboBox<>();
		checkBox1 = new JCheckBox();
		button1 = new JButton();
		textField1 = new JTextField();

		//======== this ========
		setTitle("AIO TreeChopper - By Single Core");
		Container contentPane = getContentPane();

		//---- label1 ----
		label1.setText("Options: ");

		//---- comboBox1 ----
		comboBox1.setModel(new DefaultComboBoxModel<>(new String[] {
			"Varrock-East | Logs",
			"Varrock-East | Oaks",
			"Varrock-West | Logs",
			"Varrock-West | Oaks",
			"Seers | Yews",
			"Seers | Willows",
			"Seers | Maples",
			"Seers | Magics",
			"Draynor | Willows",
			"Edgeville | Yews"
		}));

		//---- label2 ----
		label2.setText("Axe: ");

		//---- comboBox2 ----
		comboBox2.setModel(new DefaultComboBoxModel<>(new String[] {
			"Bronze",
			"Iron",
			"Steel",
			"Black",
			"Mithril",
			"Adamant",
			"Rune",
			"Dragon"
		}));

		//---- checkBox1 ----
		checkBox1.setText("Powerchop");
		checkBox1.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				checkBox1StateChanged(e);
			}
		});

		//---- button1 ----
		button1.setText("Start");
		button1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					button1ActionPerformed(e);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});

		//---- textField1 ----
		textField1.setText("TreeName");
		
		
		//----- Defaults -----
		comboBox2.setSelectedIndex(6);

		GroupLayout contentPaneLayout = new GroupLayout(contentPane);
		contentPane.setLayout(contentPaneLayout);
		contentPaneLayout.setHorizontalGroup(
			contentPaneLayout.createParallelGroup()
				.addGroup(contentPaneLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
						.addGroup(contentPaneLayout.createSequentialGroup()
							.addComponent(checkBox1)
							.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
							.addComponent(textField1, GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE))
						.addGroup(contentPaneLayout.createSequentialGroup()
							.addGroup(contentPaneLayout.createParallelGroup()
								.addComponent(label1)
								.addComponent(label2))
							.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
							.addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
								.addComponent(comboBox1, GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
								.addComponent(comboBox2, GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE))))
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
					.addComponent(button1)
					.addContainerGap())
		);
		contentPaneLayout.setVerticalGroup(
			contentPaneLayout.createParallelGroup()
				.addGroup(contentPaneLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(label1)
						.addComponent(comboBox1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(label2)
						.addComponent(comboBox2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
					.addContainerGap(95, Short.MAX_VALUE)
					.addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(button1)
						.addComponent(checkBox1)
						.addComponent(textField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		pack();
		setLocationRelativeTo(getOwner());
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	// Generated using JFormDesigner Evaluation license - Mathias De Weerdt
	private JLabel label1;
	private JComboBox<String> comboBox1;
	private JLabel label2;
	private JComboBox<String> comboBox2;
	private JCheckBox checkBox1;
	private JButton button1;
	private JTextField textField1;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
