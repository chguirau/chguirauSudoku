/*
 * Created on 30-Dec-2007
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.chg.sudoku;

/**
 * @author herca07
 *
 * TODO To change the template for this generated type comment go to Window -
 * Preferences - Java - Code Style - Code Templates
 */
public class SudokuMain {

    public static void main(String[] args) {
        System.out.println("Sudoku CHG v1.2 Jan24");
        if (args.length > 0) {
            System.out.println(args[0]);
            if (args[0].equalsIgnoreCase("debug")) {
                debug = true;
                System.out.println("debug true");                
            }
            else debug=false;
        }

        SudokuBaseEquations mainSudoku = new SudokuBaseEquations();
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
        //if (mainSudoku.initGameFromFile("test15.txt"))
        if (mainSudoku.initGameFromSudoku())
        {

            if (SudokuMain.debug) {
                System.out.println("totalUnknown: " + mainSudoku.totalUnknown);
                System.out.println("pending equations: " + mainSudoku.listEquations.size());
            }

            mainSudoku.showGame();
            try {

                boolean ok = mainSudoku.solve();

                if (SudokuMain.debug) {
                    System.out.println("totalUnknown: " + mainSudoku.totalUnknown);
                    System.out.println("pending equations: " + mainSudoku.listEquations.size());
                    System.out.println("Solved: " + ok);
                }

                System.out.println("Initial Evaluation");
                mainSudoku.showGame();
                if (ok) {
                    System.out.println("Solved!");
                } else {
                    System.out.println("Not solved!");
                    mainSudoku.solveN(1);
                }
            } catch (Exception e) {
                System.out.println("Exception " + e.getMessage());
                e.printStackTrace();
                if (SudokuMain.debug) {
                    System.out.println("totalUnknown: " + mainSudoku.totalUnknown);
                    System.out.println("pending equations: " + mainSudoku.listEquations.size());
                    System.out.println("Not Solved");
                    System.out.println("Exception " + e.getMessage());
                    System.out.println("Equation Exception means Sudoku has no solution");
                }
            }
        }

        //commented 26Dec19 CHG
        //SudokuGUI s=new SudokuGUI();
        //s.show();
        //end CHG
        //BasicSwingComponents s2=new BasicSwingComponents();
        //s2.show();
    }

    public static boolean debug = false;
}
