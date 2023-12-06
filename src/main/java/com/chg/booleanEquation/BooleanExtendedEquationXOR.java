/*
 * Created on 30-Dec-2007
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package chg.ocio.booleanEquation;

import java.util.Iterator;


/**
 * @author herca07
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class BooleanExtendedEquationXOR extends BooleanExtendedEquation {
	/**
	 * 
	 */
	public BooleanExtendedEquationXOR() {
		type=XORTYPE;
		equalsTo=true;
	}
	
	public void initAddElement(EquationElement s)
	{
		equationElements.add(s);
	}
	
	public boolean evaluate() throws EquationException
	{
		//ideally equation should be solved considering:
		// equalsTo and XORTYPE in the base evaluate method
		// but it is very complex
		// this is the evaluate method considering equals is True
		
		// if equation is not solved
		// equationElements keeps N elements in an OR equation like:
		// a1 OR a2 OR ... OR aN = true
		// if a1 is null it means it is false and has been erased
		// num elements keeps the number of elements not null
		// this method :
		// searches for equationElements different to UNKNOWN
		// 1) if they are true, rest of elements will be false, and equation is solved
		// 2) if they are false, they are erased
		// then, if numElements is 1, then the element is not unknown as the equation is ai = true
		// then it is solved
		
		if (solved) return solved;
		EquationElement s;
		int booleanValue;
		Iterator i=equationElements.iterator();
		while (i.hasNext())
		{
			s=(EquationElement)i.next();
			if (s==null) throw new RuntimeException("s is null");
			booleanValue=s.getBooleanExtended();
			if (booleanValue==BooleanExtended.TRUE)
			{
				if (solved) throw new EquationException("2 elements are true!");
				solved=true;
				i.remove();
			}
			else if (booleanValue==BooleanExtended.FALSE)
			{
				i.remove();
			}
			else if (booleanValue==BooleanExtended.UNKNOWN)
			{
				if (solved)
				{
					s.setBooleanExtended(BooleanExtended.FALSE);
					i.remove();
				}
			}
			s.evaluatedMessage();
		}
		if (solved)
		// traverse the list again to set to False the elements that were in the list before the element that has been detected as True
		{
			i=equationElements.iterator();
			while (i.hasNext())
			{
				s=(EquationElement)i.next();
				if (s==null) throw new RuntimeException("s is null");
				
				booleanValue=s.getBooleanExtended();
				
				//if we get here, there was an element true, the rest that were false were removed and only unknown elems remain
				if (booleanValue==BooleanExtended.TRUE) throw new RuntimeException("algorithm is wrong?");
				else if (booleanValue==BooleanExtended.FALSE) throw new RuntimeException("algorithm is wrong?");

				if (booleanValue==BooleanExtended.UNKNOWN)
				{
					s.setBooleanExtended(BooleanExtended.FALSE);
					i.remove();
					s.evaluatedMessage();
				}
			}
		}
		else
		{
			if (equationElements.size()<1) throw new EquationException("at least 1 elem must be true");
			//we removed all elems and no true elem was found
				
			if (equationElements.size()==1)
			{
				//solved, the remaining element is True!
				solved=true;
				s=(EquationElement)equationElements.get(0);
				if (s==null) throw new RuntimeException("s is null");
				s.setBooleanExtended(BooleanExtended.TRUE);
				s.evaluatedMessage();
				//equationElements.remove(0);
			}	
		}
		return solved;
	}
	
	public int getNumElements()
	{
		return equationElements.size();
	}
	
	
}
