package reflection.serDeser;

import java.io.Serializable;
import java.util.ArrayList;
/**
 * @author Prajakta More
 * SerializeTypes class that contains datatypes used in Serialize class
 */

public class SerializeTypes implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static ArrayList<Object> myAllTypesFinal = new ArrayList<Object>();

	/**
	 * @return the myAllTypesFinal
	 */
	public static ArrayList<Object> getMyAllTypesFinal() {
		return myAllTypesFinal;
	}

	/**
	 * @param myAllTypesFinal
	 *            the myAllTypesFinal to set
	 */
	public static void setMyAllTypesFinal(ArrayList<Object> myAllTypesFinal) {
		SerializeTypes.myAllTypesFinal = myAllTypesFinal;
	}
	@Override
	public String toString() {
	    StringBuilder result = new StringBuilder();
	    String NEW_LINE = System.getProperty("line.separator");

	    result.append(""+ NEW_LINE);
	    
	    return result.toString();
	  }

}
