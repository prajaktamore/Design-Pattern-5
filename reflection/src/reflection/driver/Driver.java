package reflection.driver;

import java.io.IOException;

import reflection.interfaces.ICheckUserInput;
import reflection.interfaces.ICompareTwoClasses;
import reflection.interfaces.IParse;
import reflection.interfaces.ISerialize;
import reflection.serDeser.Serialize;
import reflection.utilClasses.CatchWrongInputException;
import reflection.utilClasses.CheckUserInput;
import reflection.utilClasses.CompareTwoClasses;
import reflection.utilClasses.Debug;
import reflection.utilClasses.FileReaderClass;
import reflection.utilClasses.Parse;


/**
 * @author Prajakta  More
 * Driver class that calls in steps Parse, Serialize, compare only if Debug value is 0,deserialize
 */
public class Driver {
	/**
	 * Constructor of Driver
	 */
	public Driver() {
		if(Debug.getDEBUG_VALUE() == 4){
		CompareTwoClasses.strbuild.append("\n Constructor is called :: "+ this.getClass().getName());}
	}

	public static void main(String[] args) throws IOException {
		try {
			FileReaderClass fileReaderClass = new FileReaderClass();
			ICheckUserInput checkUserInput = new CheckUserInput();
			 fileReaderClass.setInputFileName(args[0]);
			fileReaderClass.setOutputFileName(args[1]);
			Debug.setDEBUG_VALUE(Integer.parseInt(args[2]),"");
			checkUserInput.checkUserInput(fileReaderClass.getInputFileName(),
					fileReaderClass.getOutputFileName(), 2);
			IParse parse = new Parse();
			parse.readFile();

			if(Debug.getDEBUG_VALUE() == 0){
				ICompareTwoClasses compareTwoClasses = new CompareTwoClasses();
				compareTwoClasses.compare();
			}
			
			ISerialize serialize = new Serialize();
			serialize.serializeObject();
		} catch (CatchWrongInputException e) {
			System.err.println("Exception Occured :: " + e.getMessage());
			e.printStackTrace();
			System.exit(0);
		} finally {
			CompareTwoClasses c = new CompareTwoClasses();
			System.out.println(c.toString());
		}
	}
}
