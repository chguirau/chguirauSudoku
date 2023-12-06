/*
 * Created on 30-Dec-2007
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.chg.booleanEquation;

/**
 * @author herca07
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class BooleanExtended {
	public static final int FALSE=0;
	public static final int TRUE=1;
	public static final int UNKNOWN=2;
	private int value=UNKNOWN;
	
	public BooleanExtended() {}	
	
	public BooleanExtended (int initValue){
		value=initValue;
			}
	public int getValue()
	{
		return value;
	}
	
	public void setValue(int i)
	{
		value=i;
	}
}
