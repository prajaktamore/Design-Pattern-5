package reflection.interfaces;

import reflection.utilClasses.CatchWrongInputException;

/**
 * @author Prajakta More
 * Interface that checks the input validity
 */
public interface ICheckUserInput {
	/**
	 * @param inputFile
	 * @param outputFile
	 * @param input
	 * @throws CatchWrongInputException
	 */
	public void checkUserInput(String inputFile, String outputFile, int input)
			throws CatchWrongInputException;

}
