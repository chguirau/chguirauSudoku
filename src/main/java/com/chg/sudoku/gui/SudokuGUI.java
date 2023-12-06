/*
 * Created on 03-Jan-2008
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.chg.sudoku.gui;

import javax.swing.JWindow;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
/**
 * @author herca07
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class SudokuGUI extends JWindow {

	private javax.swing.JPanel jContentPane = null;
	private javax.swing.JPanel jContentPane2 = null;
	private javax.swing.JPanel jContentPane3 = null;

	
	private JButton[][] jButton = new JButton[9][9];
	private JButton jButtonEnd = null;
	
	/**
	 * This is the default constructor
	 */
	public SudokuGUI() {
		super();
		initialize();
	}
	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(450,500);
		this.setContentPane(getJContentPane2());
	}
	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private javax.swing.JPanel getJContentPane2() {
		if(jContentPane2 == null) {
			java.awt.GridLayout layGridLayout = new java.awt.GridLayout();
			layGridLayout.setRows(10);
			layGridLayout.setColumns(9);
			jContentPane2 = new javax.swing.JPanel();
			jContentPane2.setLayout(layGridLayout);
			
			//Object constrain=null;
			for (int i=1; i<=9; i++)
			{
				for (int j=1; j<=9; j++)
				{
					//jContentPane.add(getJButton(i-1,j-1), constrain);
					jContentPane2.add(getJButton(i-1,j-1));
				}
			}
			
			jContentPane2.add(getJButtonEnd());

		}
		return jContentPane2;
	}

/*	private javax.swing.JPanel getJContentPane3() {
		if(jContentPane3 == null) {
			java.awt.GridLayout layGridLayout = new java.awt.GridLayout();
			layGridLayout.setRows(1);
			layGridLayout.setColumns(1);
			jContentPane3 = new javax.swing.JPanel();
			jContentPane3.setLayout(layGridLayout);
			
			jContentPane3.add(getJButtonEnd());
		}
		return jContentPane3;
	}
	
	private javax.swing.JPanel getJContentPane() {
		if(jContentPane == null) {
			java.awt.BorderLayout layBorderLayout = new java.awt.BorderLayout();
			jContentPane = new javax.swing.JPanel();
			jContentPane.setLayout(layBorderLayout);
			
			jContentPane.add(getJContentPane2(),
					java.awt.BorderLayout.NORTH);
			jContentPane.add(getJContentPane3(),
					java.awt.BorderLayout.SOUTH);

		}
		return jContentPane;
	}
*/
	
	/**
	 * This method initializes jButton	
	 * 	
	 * @return javax.swing.JButton	
	 */    
	private JButton getJButton(int i, int j) {
		if (jButton[i][j] == null) {
			jButton[i][j] = new JButton();
			//jButton[i][j].setBounds(i*7,j*7,7,7);
			//jButton[i][j].setText((new Integer(j+1).toString()));
			jButton[i][j].setText(" ");
		}
		return jButton[i][j];
	}
	
	/**
	 * This method initializes jButton	
	 * 	
	 * @return javax.swing.JButton	
	 */    
	private JButton getJButtonEnd() {
		if (jButtonEnd == null) {
			jButtonEnd = new JButton();
			jButtonEnd.setText("Ok");
		}
		return jButtonEnd;
	}

}
