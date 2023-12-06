/*
 * Created on 30-Dec-2007
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.chg.booleanEquation;

import java.util.ArrayList;

/**
 * @author herca07
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public abstract class BooleanExtendedEquation {
	// e.g. with AND: elem1 AND elem2 AND ... AND elemn = True
	public static final int ORTYPE=0;
	public static final int ANDTYPE=1;
	public static final int XORTYPE=2;
	public static final int NAND=3;
	public static final int NOR=4;
	
	public boolean equalsTo; //equation equals True or False
	public int type; //AND, OR, XOR, NAND, NOR
	
	public ArrayList equationElements=new ArrayList();
	// elements in the equation
	boolean solved=false;
	// equation is solved if we know for each elem if it is true or false (it is not unknown)
	
	public abstract void initAddElement(EquationElement s);
	public abstract boolean evaluate() throws EquationException;
	//evaluate the equation bases only in the boolean value of each elem
	//to solve the equation it may be necessary another method (in another class) using information in n equations
	
	public abstract int getNumElements();
}
