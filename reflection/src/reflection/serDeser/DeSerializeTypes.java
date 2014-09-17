package reflection.serDeser;

import java.util.ArrayList;

import reflection.util.MyAllTypesFirst;
import reflection.util.MyAllTypesSecond;
/**
 * @author Prajakta More
 * DeSerialize types that provides input to DeSerialize class that uses reflection to generate classes and calls respective methodfrom the parsed data 
 */

public class DeSerializeTypes {
	static ArrayList<MyAllTypesFirst> myAllTypesFirsts = new ArrayList<MyAllTypesFirst>();
	static ArrayList<MyAllTypesSecond> myAllTypesSeconds = new ArrayList<MyAllTypesSecond>();

	/**
	 * @return the myAllTypesFirsts
	 */
	public static ArrayList<MyAllTypesFirst> getMyAllTypesFirsts() {
		return myAllTypesFirsts;
	}

	/**
	 * @param myAllTypesFirsts
	 *            the myAllTypesFirsts to set
	 */
	public static void setMyAllTypesFirsts(
			ArrayList<MyAllTypesFirst> myAllTypesFirsts) {
		DeSerializeTypes.myAllTypesFirsts = myAllTypesFirsts;
	}

	/**
	 * @return the myAllTypesSeconds
	 */
	public static ArrayList<MyAllTypesSecond> getMyAllTypesSeconds() {
		return myAllTypesSeconds;
	}

	/**
	 * @param myAllTypesSeconds
	 *            the myAllTypesSeconds to set
	 */
	public static void setMyAllTypesSeconds(
			ArrayList<MyAllTypesSecond> myAllTypesSeconds) {
		DeSerializeTypes.myAllTypesSeconds = myAllTypesSeconds;
	}
	@Override
	public String toString() {
	    StringBuilder result = new StringBuilder();
	    String NEW_LINE = System.getProperty("line.separator");

	    result.append(""+ NEW_LINE);
	    
	    return result.toString();
	  }

}
