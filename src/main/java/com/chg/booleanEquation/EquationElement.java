/*
 * Created on 31-Dec-2007
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package chg.ocio.booleanEquation;

/**
 * @author herca07
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public interface EquationElement {
	public int getBooleanExtended();
	//returns the BooleanExtended element int value
	
	public void setBooleanExtended(int val);
	//sets the BooleanExtended element int value
	
	//The equations engine will get or set the value of this BooleanExtended element
	//which is referenced in n equations
	
	public String evaluatedMessage();
	// to print a message when an element has been evaluated (from UNKNOWN to true or false)
}
