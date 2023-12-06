/*
 * Created on 30-Dec-2007
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.chg.sudoku;

import com.chg.booleanEquation.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;


import java.io.File;
import java.io.IOException;

/**
 * @author herca07
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class SudokuBaseEquations {
	public BooleanExtended[][][] game=new BooleanExtended[9][9][9];
	
	public int totalUnknown=729; // 9 * 9 * 9

	public ArrayList listEquations=new ArrayList(); //Sudoku game equation lists

	public void initSudokuEquations() {
		int i;
		int j;
		int k;
		int digit;
		BooleanExtendedEquationXOR equation;
		SudokuElement s;
		
		for (i=1;i<=9;i++)
		{
			for (j=1;j<=9;j++)
			{
				for (k=1;k<=9;k++)
				{
					game[i-1][j-1][k-1]=new BooleanExtended();
				}
			}
		}
		
		
		//in each position a digit 1 .. 9
		for (i=1; i<=9; i++)
		{
			for (j=1;j<=9;j++)
			{
				equation=new BooleanExtendedEquationXOR();
				listEquations.add(equation);
				for (digit=1;digit<=9;digit++)
				{
					s=new SudokuElement(this,i-1,j-1,digit-1);
					equation.initAddElement(s);
					if (SudokuMain.debug)
					{
						System.out.println("initAddElement "+ s.evaluatedMessage()); 
					}
					
					if (equation.equationElements.size()>9) throw new SudokuException();
				}
			}
		}
		
		//in each row one and only one 1, one and only one 2, ... 
		for (digit=1; digit<=9; digit++)
		{
			for (j=1;j<=9;j++)
			{
				equation=new BooleanExtendedEquationXOR();
				listEquations.add(equation);
				for (i=1;i<=9;i++)
				{
					s=new SudokuElement(this,i-1,j-1,digit-1);
					equation.initAddElement(s);
					if (SudokuMain.debug)
					{
						System.out.println("initAddElement "+ s.evaluatedMessage()); 
					}
					
					if (equation.equationElements.size()>9) throw new SudokuException();
				}
			}
		}
		
		//in each column one and only one 1, one and only one 2, ... 
		for (digit=1; digit<=9; digit++)
		{
			for (i=1;i<=9;i++)
			{
				equation=new BooleanExtendedEquationXOR();
				listEquations.add(equation);
				for (j=1;j<=9;j++)
				{
					s=new SudokuElement(this,i-1,j-1,digit-1);
					equation.initAddElement(s);
					if (SudokuMain.debug)
					{
						System.out.println("initAddElement "+ s.evaluatedMessage()); 
					}
					
					if (equation.equationElements.size()>9) throw new SudokuException();
				}
			}
		}

		//in each quadrant one and only one 1, one and only one 2, ... 
		for (digit=1; digit<=9; digit++)
		{
			//quadrant1 (col 1 row 1)
			equation=new BooleanExtendedEquationXOR();
			listEquations.add(equation);
			for (i=1;i<=3;i++)
			{
				for (j=1;j<=3;j++)
				{
					s=new SudokuElement(this,i-1,j-1,digit-1);
					equation.initAddElement(s);
					if (SudokuMain.debug)
					{
						System.out.println("initAddElement "+ s.evaluatedMessage()); 
					}
					
					if (equation.equationElements.size()>9) throw new SudokuException();
				}
			}
			
			//quadrant2 (col 2 row 1)
			equation=new BooleanExtendedEquationXOR();
			listEquations.add(equation);
			for (i=4;i<=6;i++)
			{
				for (j=1;j<=3;j++)
				{
					s=new SudokuElement(this,i-1,j-1,digit-1);
					equation.initAddElement(s);
					if (SudokuMain.debug)
					{
						System.out.println("initAddElement "+ s.evaluatedMessage()); 
					}
					
					if (equation.equationElements.size()>9) throw new SudokuException();
				}
			}

			//quadrant3 (col 3 row 1)
			equation=new BooleanExtendedEquationXOR();
			listEquations.add(equation);
			for (i=7;i<=9;i++)
			{
				for (j=1;j<=3;j++)
				{
					s=new SudokuElement(this,i-1,j-1,digit-1);
					equation.initAddElement(s);
					if (SudokuMain.debug)
					{
						System.out.println("initAddElement "+ s.evaluatedMessage()); 
					}
					
					if (equation.equationElements.size()>9) throw new SudokuException();
				}
			}
			
			//quadrant4 (col 1 row 2)
			equation=new BooleanExtendedEquationXOR();
			listEquations.add(equation);
			for (i=1;i<=3;i++)
			{
				for (j=4;j<=6;j++)
				{
					s=new SudokuElement(this,i-1,j-1,digit-1);
					equation.initAddElement(s);
					if (SudokuMain.debug)
					{
						System.out.println("initAddElement "+ s.evaluatedMessage()); 
					}
					
					if (equation.equationElements.size()>9) throw new SudokuException();
				}
			}
			
			//quadrant5 (col 2 row 2)
			equation=new BooleanExtendedEquationXOR();
			listEquations.add(equation);
			for (i=4;i<=6;i++)
			{
				for (j=4;j<=6;j++)
				{
					s=new SudokuElement(this,i-1,j-1,digit-1);
					equation.initAddElement(s);
					if (SudokuMain.debug)
					{
						System.out.println("initAddElement "+ s.evaluatedMessage()); 
					}
					
					if (equation.equationElements.size()>9) throw new SudokuException();
				}
			}

			//quadrant6 (col 3 row 2)
			equation=new BooleanExtendedEquationXOR();
			listEquations.add(equation);
			for (i=7;i<=9;i++)
			{
				for (j=4;j<=6;j++)
				{
					s=new SudokuElement(this,i-1,j-1,digit-1);
					equation.initAddElement(s);
					if (SudokuMain.debug)
					{
						System.out.println("initAddElement "+ s.evaluatedMessage()); 
					}
					
					if (equation.equationElements.size()>9) throw new SudokuException();
				}
			}
			
			//quadrant7 (col 1 row 3)
			equation=new BooleanExtendedEquationXOR();
			listEquations.add(equation);
			for (i=1;i<=3;i++)
			{
				for (j=7;j<=9;j++)
				{
					s=new SudokuElement(this,i-1,j-1,digit-1);
					equation.initAddElement(s);
					if (SudokuMain.debug)
					{
						System.out.println("initAddElement "+ s.evaluatedMessage()); 
					}
					
					if (equation.equationElements.size()>9) throw new SudokuException();
				}
			}
			
			//quadrant8 (col 2 row 3)
			equation=new BooleanExtendedEquationXOR();
			listEquations.add(equation);
			for (i=4;i<=6;i++)
			{
				for (j=7;j<=9;j++)
				{
					s=new SudokuElement(this,i-1,j-1,digit-1);
					equation.initAddElement(s);
					if (SudokuMain.debug)
					{
						System.out.println("initAddElement "+ s.evaluatedMessage()); 
					}
					
					if (equation.equationElements.size()>9) throw new SudokuException();
				}
			}

			//quadrant9 (col 3 row 3)
			equation=new BooleanExtendedEquationXOR();
			listEquations.add(equation);
			for (i=7;i<=9;i++)
			{
				for (j=7;j<=9;j++)
				{
					s=new SudokuElement(this,i-1,j-1,digit-1);
					equation.initAddElement(s);
					if (SudokuMain.debug)
					{
						System.out.println("initAddElement "+ s.evaluatedMessage()); 
					}
					
					if (equation.equationElements.size()>9) throw new SudokuException();
				}
			}
			
			//improvement: instead 9 loops for each of the 9 quadrants, create x and y offsets 
			// 1 loop for the vertical quadrant 
			// another for the horizontal one, 
			//and do the quadrant loop with x and y offsets
		}
		
		
		
	}
		
	public void initGame()
	{
		//init the game
		// example game[2][4][2].setValue(BooleanExtended.TRUE); //column 3, row 5 is a 3
		game[1][0][5].setValue(BooleanExtended.TRUE);
		game[2][0][8].setValue(BooleanExtended.TRUE); 
		game[5][0][4].setValue(BooleanExtended.TRUE); 
		game[1][1][0].setValue(BooleanExtended.TRUE); 
		game[5][1][6].setValue(BooleanExtended.TRUE); 
		game[6][1][7].setValue(BooleanExtended.TRUE); 
		game[7][1][4].setValue(BooleanExtended.TRUE); 
		game[8][1][8].setValue(BooleanExtended.TRUE); 
		game[1][2][3].setValue(BooleanExtended.TRUE); 
		game[4][2][8].setValue(BooleanExtended.TRUE); 
		game[8][2][5].setValue(BooleanExtended.TRUE); 
		game[0][3][3].setValue(BooleanExtended.TRUE); 
		game[1][3][2].setValue(BooleanExtended.TRUE); 
		game[3][3][4].setValue(BooleanExtended.TRUE); 
		game[5][3][5].setValue(BooleanExtended.TRUE); 
		game[2][4][7].setValue(BooleanExtended.TRUE); 
		game[6][4][2].setValue(BooleanExtended.TRUE); 
		game[3][5][2].setValue(BooleanExtended.TRUE); 
		game[5][5][3].setValue(BooleanExtended.TRUE); 
		game[7][5][5].setValue(BooleanExtended.TRUE); 
		game[8][5][6].setValue(BooleanExtended.TRUE); 
		game[0][6][0].setValue(BooleanExtended.TRUE); 
		game[4][6][2].setValue(BooleanExtended.TRUE); 
		game[7][6][8].setValue(BooleanExtended.TRUE); 
		game[0][7][4].setValue(BooleanExtended.TRUE); 
		game[1][7][8].setValue(BooleanExtended.TRUE); 
		game[2][7][2].setValue(BooleanExtended.TRUE); 
		game[3][7][6].setValue(BooleanExtended.TRUE); 
		game[7][7][1].setValue(BooleanExtended.TRUE); 
		game[3][8][8].setValue(BooleanExtended.TRUE); 
		game[6][8][5].setValue(BooleanExtended.TRUE); 
		game[7][8][7].setValue(BooleanExtended.TRUE); 

		for (int i=1;i<=9;i++)
		{
			for (int j=1;j<=9;j++)
			{
				for (int digit=1; digit<=9; digit++)
				{
					if (game[i-1][j-1][digit-1].getValue()!=BooleanExtended.UNKNOWN)
						totalUnknown--;
				}
			}
		}
		
		if (SudokuMain.debug)
		{	
			System.out.println("Total unknown after init game: "+totalUnknown);
		}

	}
	
	 public void initGameFromFile(String fileName)
	{
		//format is for the same board than in initGame
		//.69..5... EOL
		//.1...7859 EOL
		// etc, the 9 lines
                if (SudokuMain.debug)
                {
                        System.out.println(fileName); 
                }
                String strfilename="/Users/carlosherrero/NetBeansProjects/chguirauSudoku/src/main/java/"+fileName;
		try 
		{ 
			Scanner sc = new Scanner(new File(strfilename)); 
			int row=0;
			int colSize=0;
			int digit;
			while (sc.hasNext() && row<9) 
			{ 
				String str = sc.nextLine(); 
				if (SudokuMain.debug)
				{
					System.out.println(str); 
				}
				colSize=str.length();
				for (int col=0; col<colSize && col<9; col++)
				{
					if (str.charAt(col) != '.') 
					{	
						switch (str.charAt(col))
						{
						case '1' : digit=0; break;
						case '2' : digit=1; break;
						case '3' : digit=2; break;
						case '4' : digit=3; break;
						case '5' : digit=4; break;
						case '6' : digit=5; break;
						case '7' : digit=6; break;
						case '8' : digit=7; break;
						case '9' : digit=8; break;
						default :
							throw new IOException("Wrong format");
						}
						if (SudokuMain.debug)
						{
							System.out.println(digit); 
						}
	
						game[col][row][digit].setValue(BooleanExtended.TRUE);
					}
					//else nothing, it stays BooleanExtended.UNKNOWN
				}
				row++;
			} 
			sc.close(); 
		} 
		catch (IOException e) { 
			if (SudokuMain.debug)
			{
				System.out.println(e.getMessage()); 
			}

		}	
		
		for (int i=1;i<=9;i++)
		{
			for (int j=1;j<=9;j++)
			{
				for (int digit=1; digit<=9; digit++)
				{
					if (game[i-1][j-1][digit-1].getValue()!=BooleanExtended.UNKNOWN)
						totalUnknown--;
				}
			}
		}
		
		if (SudokuMain.debug)
		{	
			System.out.println("Total unknown after init game: "+totalUnknown);
		}

	}
	
	public boolean solve() throws Exception
	{
		//solves the Sudoku
		Iterator i;
		BooleanExtendedEquationXOR equation;
		
		
		int previous=totalUnknown+1;
		try {
			
			while (totalUnknown<previous)
			//while we gain information, go on
			{
				previous=totalUnknown;
				i=listEquations.iterator();
				if (SudokuMain.debug)
				{
					System.out.println("equations: " + listEquations.size());
					System.out.println("totalUnknown: " + totalUnknown);
				}	

				while (i.hasNext())
				{
					equation=(BooleanExtendedEquationXOR)i.next();
					if (equation.evaluate()) i.remove();
				}
			}	
	
			return (totalUnknown==0);
		}
		catch(EquationException e)
		{
			if (SudokuMain.debug)
			{
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
			throw e;
		}
		catch(SudokuException s)
		{
			if (SudokuMain.debug)
			{
				System.out.println(s.getMessage());
				s.printStackTrace();
			}
			throw s;
		}
		
		//this is for 1 solution sudoku
		// if the sudoku has no solution an exception is thrown
		// if it is true, done
		// pending, in a separate method solveN (iteration level 1)
		// if it is false, we enter in an iterative process where we try to solve introducing a new hypothesis
		// we have a SudokuBaseEquations with a list of BooleanExtendedEquationXOR equations where all elements in them are UNKNOWN
		// new iteration, for the BooleanExtendedEquationXOR equation in the list with the lowest number of elements, we iterate in each element (SudokuElement) and
		// 1.- we create a copy of SudokuBaseEquations
		// 2.- then set the new hypothesis, element set to TRUE
		// 3.- solve
		// if false, try a new hypothesis and solveN (interation level 2, and recursively to any level)
		// this is creating a search tree, in general we will find N solutions in the tree
		// if true, solution found at this level! show iteration number (the number of element in the hypothesis list), interation level
		// if an exception is thrown, do nothing (catch Exception), this hypothesis is not correct
		
		// we finish the process with:
		// a) a list of solutions in several levels
		// b) no solutions (NOT SURE THIS CAN HAPPEN) INTERESTING TO INVESTIGATE

		// it is necessary to create a copy of SudokuBaseEquations in each iteration 
		// so that each iteration (and recursive iterations from it) modify only its copy
	}

	public boolean solveN(int iterationLevel) throws Exception
	{
		Iterator i;
		BooleanExtendedEquationXOR equation, selectedEquation;
		selectedEquation=null;
		int numElems;
		int minNumElems=9;
		i=listEquations.iterator();
		//ArrayList sudokuHypothesis=new ArrayList(); //array of SudokuBaseEquations
		SudokuBaseEquations sudokuHypothesis;
		
		//search for the equation with minimum number of elements, the best choice to solve
		while (i.hasNext())
		{
			equation=(BooleanExtendedEquationXOR)i.next();
			numElems=equation.getNumElements();
			if (numElems<minNumElems) 
			{
				minNumElems=numElems;
				selectedEquation=equation;
			}
		}
		
		Iterator j=selectedEquation.equationElements.iterator();
		boolean globalSolved=false;
		while (j.hasNext())
		{
			//duplicate sudoku
			boolean ok=false;
			sudokuHypothesis=this.copyWithHypothesis(selectedEquation, (SudokuElement)j.next());
			try
			{
				ok=sudokuHypothesis.solve();
				if (SudokuMain.debug)
				{
					System.out.println("totalUnknown: "+sudokuHypothesis.totalUnknown);
					System.out.println("pending equations: "+sudokuHypothesis.listEquations.size());
					System.out.println("Solved: "+ ok );
					System.out.println("Iteration " + iterationLevel);
				}
				
				System.out.println("Evaluated");
				sudokuHypothesis.showGame();
				if (ok) 
				{
					System.out.println("Solved!"); 
					System.out.println("Iteration " + iterationLevel);					
				} 
				else 
				{
					System.out.println("Not solved!");
					System.out.println("Iteration " + iterationLevel);					
					ok=sudokuHypothesis.solveN(iterationLevel+1);
				}
			}
			catch(EquationException e)
			{
				System.out.println("Iteration " + iterationLevel);
				System.out.println(e.getMessage());
				if (SudokuMain.debug)
				{
					e.printStackTrace();
				}
				// we do nothing
			}
			catch(SudokuException s)
			{
				System.out.println("Iteration " + iterationLevel);
				System.out.println(s.getMessage());
				if (SudokuMain.debug)
				{
					s.printStackTrace();
				}
				// we do nothing
			}
			globalSolved=ok || globalSolved;
		}
		System.out.println("Global Solved " + globalSolved);
		return globalSolved;
	}
	
	SudokuBaseEquations copyWithHypothesis(BooleanExtendedEquationXOR selectedEq, SudokuElement selectedElem)
	{
		SudokuBaseEquations newSudoku=new SudokuBaseEquations();
		//newSudoku.game copy game
		int i,j,k;
		for (i=1;i<=9;i++)
		{
			for (j=1;j<=9;j++)
			{
				for (k=1;k<=9;k++)
				{
					newSudoku.game[i-1][j-1][k-1]=new BooleanExtended(game[i-1][j-1][k-1].getValue());
				}
			}
		}

		//set totalUnknown
		newSudoku.totalUnknown=totalUnknown;

		//newSudoku.listEquations copy list equations
		Iterator it, jt;
		BooleanExtendedEquationXOR equation, tempEq;
		SudokuElement se, tempSe;
		it=listEquations.iterator();
		while (it.hasNext())
		{
			equation=(BooleanExtendedEquationXOR)it.next();
			tempEq=new BooleanExtendedEquationXOR();
			newSudoku.listEquations.add(tempEq);
			jt=equation.equationElements.iterator();
			while (jt.hasNext())
			{
				se=(SudokuElement)jt.next();
				tempSe=new SudokuElement(newSudoku, se.position1, se.position2, se.digit);
				tempEq.initAddElement(tempSe);
				if (equation == selectedEq)
				{
					if (se == selectedElem)
					{
						tempSe.setBooleanExtended(BooleanExtended.TRUE);
					}
				}
			}
		}		
		return newSudoku;
	}
	
	public void showGame()
	{
		int digit;
		boolean found=false;
		System.out.println(" |---|---|---|---|---|---|---|---|---|");
		for(int j=1;j<=9;j++)
		{
			for (int i=1;i<=9;i++)
			{
				found=false;
				for (digit=1;digit<=9 && !found ;digit++ )
				{
					found=(game[i-1][j-1][digit-1].getValue()==BooleanExtended.TRUE); 
				}
				System.out.print(" | ");
				if (found)
				{
					System.out.print(digit-1);
				}
				else
				{
					System.out.print("?");
				}	
			}
			System.out.println(" | ");
			System.out.println(" |---|---|---|---|---|---|---|---|---|");
		}
	}

}
