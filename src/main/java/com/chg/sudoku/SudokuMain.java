/*
 * Created on 30-Dec-2007
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package chg.ocio.sudoku;

import chg.ocio.sudoku.gui.*;

/**
 * @author herca07
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class SudokuMain {

	public static void main(String[] args) {
		System.out.println("Sudoku CHG v2.1 Sep23");
		if (args.length>0)
		{
			System.out.println(args[0]);
			if (args[0].equalsIgnoreCase("debug"))
				debug=true;
		}
		
		SudokuBaseEquations mainSudoku=new SudokuBaseEquations();
		mainSudoku.initSudokuEquations();
		//mainSudoku.initGame();
		//mainSudoku.initGameFromFile("test1.txt");
		//mainSudoku.initGameFromFile("test2.txt");
		//mainSudoku.initGameFromFile("test3.txt");
		//mainSudoku.initGameFromFile("test4.txt");
		//mainSudoku.initGameFromFile("test5.txt");
		//mainSudoku.initGameFromFile("test6.txt");
		//very hard sudoku
		//mainSudoku.initGameFromFile("test7.txt");
		//sudoku with 2 solutions, very easy
		mainSudoku.initGameFromFile("test8.txt");


		
		if (SudokuMain.debug)
		{
			System.out.println("totalUnknown: "+mainSudoku.totalUnknown);
			System.out.println("pending equations: "+mainSudoku.listEquations.size());
		}
		
		mainSudoku.showGame();
		try {
			
			boolean ok=mainSudoku.solve();
			
			if (SudokuMain.debug)
			{
				System.out.println("totalUnknown: "+mainSudoku.totalUnknown);
				System.out.println("pending equations: "+mainSudoku.listEquations.size());
				System.out.println("Solved: "+ ok );
			}
			
			System.out.println("Evaluated");
			mainSudoku.showGame();
			if (ok) System.out.println("Solved!"); else 
			{
				System.out.println("Not solved!");
				mainSudoku.solveN(1);
			}
		}
		catch (Exception e)
		{
			System.out.println("Exception " + e.getMessage());
			e.printStackTrace();
			if (SudokuMain.debug)
			{
				System.out.println("totalUnknown: "+mainSudoku.totalUnknown);
				System.out.println("pending equations: "+mainSudoku.listEquations.size());
				System.out.println("Not Solved");
				System.out.println("Exception " + e.getMessage());
				System.out.println("Equation Exception means Sudoku has no solution");
			}			
		}
			
		//commented 26Dec19 CHG
		//SudokuGUI s=new SudokuGUI();
		//s.show();
		//end CHG
		
		
		//BasicSwingComponents s2=new BasicSwingComponents();
		//s2.show();
	}
	
	public static boolean debug=false;
}
