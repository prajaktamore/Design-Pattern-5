package reflection.utilClasses;

import java.util.LinkedHashSet;
import java.util.Set;

import reflection.interfaces.ICompareTwoClasses;
import reflection.serDeser.DeSerializeTypes;
import reflection.util.MyAllTypesFirst;
import reflection.util.MyAllTypesSecond;

/**
 * @author Prajakta More
 * Compares the arraylists to find uniqueInstance
 */
public class CompareTwoClasses implements ICompareTwoClasses {
	public static StringBuilder strbuild = new StringBuilder();
	/**
	 * CompareTwoClasses constructor
	 */
	public CompareTwoClasses() {
		if(Debug.getDEBUG_VALUE() == 4){
			CompareTwoClasses.strbuild.append("\n Constructor is called :: "+ this.getClass().getName());}
	}
	
	Set<MyAllTypesFirst> myAllTypesFirsts = new LinkedHashSet<MyAllTypesFirst>();
	Set<MyAllTypesSecond> myAllTypesSeconds = new LinkedHashSet<MyAllTypesSecond>();

	/* (non-Javadoc)
	 * @see reflection.interfaces.ICompareTwoClasses#compare()
	 */
	@Override
	public void compare() {
		System.out.println("Compared is call");
		
		
		if (null != DeSerializeTypes.getMyAllTypesFirsts() && DeSerializeTypes.getMyAllTypesFirsts().size() !=0) {
			myAllTypesFirsts.add(DeSerializeTypes.getMyAllTypesFirsts().get(0));
			for (MyAllTypesFirst myFirst : DeSerializeTypes
					.getMyAllTypesFirsts()) {
				boolean flag = false;
				for (MyAllTypesFirst myFirstEmpty : myAllTypesFirsts) {
					if (myFirstEmpty.equals(myFirst)) {
						flag = true;
					}

				}
				if (!flag) {
					myAllTypesFirsts.add(myFirst);
				}
			}
		}
		if (null != DeSerializeTypes.getMyAllTypesSeconds() && DeSerializeTypes.getMyAllTypesSeconds().size() != 0) {
			myAllTypesSeconds.add(DeSerializeTypes.getMyAllTypesSeconds().get(0));
			for (MyAllTypesSecond mySecond : DeSerializeTypes
					.getMyAllTypesSeconds()) {
				boolean flag = false;
				for (MyAllTypesSecond mySecondEmpty : myAllTypesSeconds) {
					if (mySecondEmpty.equals(mySecond)) {
						flag = true;
					}
				}
				if (!flag) {
					myAllTypesSeconds.add(mySecond);
				}

			}
		}
		this.strbuild.append("\n Unique MyAllTypesFirst="+ String.valueOf(myAllTypesFirsts.size()));
		this.strbuild.append("\n Unique MyAllTypesSecond="+String.valueOf(myAllTypesSeconds.size()));
	}
	@Override
	  public String toString() {
	    return strbuild.toString();
	  }
}
