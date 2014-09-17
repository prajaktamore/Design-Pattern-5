package reflection.utilClasses;

import reflection.interfaces.IStrategy;
/**
 * @author Prajakta More
 * One of the Implementation of Strategy pattern
 */
public class ComplexType implements IStrategy{

	/* (non-Javadoc)
	 * @see reflection.interfaces.IStrategy#check(java.lang.String)
	 */
	@Override
	public boolean check(String s) {
		if(null != s && s.contains("<complexType")){
			return true;
		}
		return false;
	}
	@Override
	public String toString() {
	    StringBuilder result = new StringBuilder();
	    String NEW_LINE = System.getProperty("line.separator");

	    result.append(""+ NEW_LINE);
	    
	    return result.toString();
	  }

}
