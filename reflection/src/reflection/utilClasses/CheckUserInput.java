package reflection.utilClasses;

import reflection.interfaces.ICheckUserInput;

/**
 * @author Prajakta More
 * Checks the input validity
 */
public class CheckUserInput implements ICheckUserInput {
	
	/**
	 * CheckUserInput COnstructor
	 */
	public CheckUserInput() {
		if(Debug.getDEBUG_VALUE() == 4){
		CompareTwoClasses.strbuild.append("\n Constructor is called :: "+ this.getClass().getName());}
	}

	/* (non-Javadoc)
	 * @see reflection.interfaces.ICheckUserInput#checkUserInput(java.lang.String, java.lang.String, int)
	 */
	@Override
	public void checkUserInput(String inputFile, String outputFile, int input)
			throws CatchWrongInputException {
		try {
			if (null == inputFile && inputFile.trim().equals(" ")
					&& inputFile.length() == 0) {
				throw new CatchWrongInputException("Input String is not valid");
			}
			if (null == outputFile && outputFile.trim().equals(" ")
					&& outputFile.length() == 0) {
				throw new CatchWrongInputException("Input String is not valid");
			}
			if (input < 0 || input > 4) {
				throw new CatchWrongInputException(
						"MM and NN should be between 1 to 5");
			}

		} catch (CatchWrongInputException e) {
			System.err.println("Exception Occured :: " + e.getMessage());
			System.exit(0);

		} finally {
		}
	}
	@Override
	public String toString() {
	    StringBuilder result = new StringBuilder();
	    String NEW_LINE = System.getProperty("line.separator");

	    result.append(""+ NEW_LINE);
	    
	    return result.toString();
	  }

}
