/*
 * Created on 30-Dec-2007
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.chg.sudoku;

import com.chg.booleanEquation.*;

/**
 * @author herca07
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class SudokuElement implements EquationElement {
	public SudokuBaseEquations sudoku;
	public int position1; //position in first dimension in game array, 0..8, column 1 to 9
	public int position2; //position in second dimension in game array, 0..8, row 1 to 9
	public int digit; //position in third dimension in game array, 0..9, digit 0 to 9
	
	SudokuElement(SudokuBaseEquations aSudoku, int i, int j, int k)
	{
		sudoku=aSudoku;
		position1=i;
		position2=j;
		digit=k;
	}
	
	public int getBooleanExtended() {
		return sudoku.game[position1][position2][digit].getValue();
	}
	//returns the BooleanExtended element int value in the sudoku Game!
	
	public void setBooleanExtended(int val) {
		int temp=sudoku.game[position1][position2][digit].getValue();
		if (temp!=val)
		{
			if (temp==BooleanExtended.UNKNOWN)
			{
				sudoku.totalUnknown--;
				if (SudokuMain.debug)
				{
					System.out.println("setBooleanExtended check totalUnknown");
					System.out.println("temp "+temp);
					System.out.println("val "+val);
					System.out.println("totalUnknown "+sudoku.totalUnknown);
				}
			}
			else throw new RuntimeException("invalid state change, from True/False");
		}
		sudoku.game[position1][position2][digit].setValue(val);
	}
	
	public String evaluatedMessage()
	{
		String s=null;
		int b=getBooleanExtended();
		if (b== BooleanExtended.UNKNOWN)
			s="Unknown";
		else if (b==BooleanExtended.TRUE)
			s="True";
		else if (b==BooleanExtended.FALSE)
			s="False";

		if (SudokuMain.debug)
		{
			//System.out.print("Evaluated " + s);
			//System.out.println("  Elem "+position1+ " "+ position2 + " = "+digit);
		}
		
		return s;
	}
	}