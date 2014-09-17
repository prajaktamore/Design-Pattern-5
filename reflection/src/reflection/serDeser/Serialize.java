package reflection.serDeser;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;

import reflection.interfaces.ISerialize;
import reflection.util.MyAllTypesFirst;
import reflection.util.MyAllTypesSecond;
import reflection.utilClasses.CompareTwoClasses;
import reflection.utilClasses.Debug;
import reflection.utilClasses.FileReaderClass;

/**
 * @author Prajakta More
 * Serialize class that Serialize data and generate
 *         MyAllTypesCopy.txt
 */
public class Serialize implements ISerialize, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Serialize COnstructor
	 */
	public Serialize() {
		if (Debug.getDEBUG_VALUE() == 4) {
			CompareTwoClasses.strbuild.append("\n Constructor is called :: "
					+ this.getClass().getName());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see reflection.interfaces.ISerialize#serializeObject()
	 */
	@Override
	public void serializeObject() throws IOException {
		try {
			FileWriter file = new FileWriter(
					FileReaderClass.getOutputFileName());
			PrintWriter pw = new PrintWriter(file);
			try {
				FileReaderClass.setFileReader(new FileReader(FileReaderClass
						.getInputFileName()));
			} catch (FileNotFoundException e) {
				System.err.println("Exception Occured :: " + e.getMessage());
				System.exit(0);
			}
			FileReaderClass.setBr(new BufferedReader(FileReaderClass
					.getFileReader()));
			String fileData = null;
			if(Debug.getDEBUG_VALUE() == 2){
				CompareTwoClasses.strbuild
				.append("\n"+this.getClass().getName()+"\n Serialize to the Results data structure");}
			for (Object iterable_element : SerializeTypes.getMyAllTypesFinal()) {
				while ((fileData = FileReaderClass.getBr().readLine()) != null) {

					if (fileData.contains("<DPSerialization>")) {
						pw.println(fileData);
					}
					if (iterable_element instanceof MyAllTypesSecond) {
						MyAllTypesSecond second = (MyAllTypesSecond) iterable_element;
						if (null != second) {
							if (fileData.contains("<complexType xsi:type=\"")) {
								pw.println(fileData.replaceAll("\".*?\"", "\""
										+ second.getClass().getCanonicalName()
										+ "\""));
							}
							if (fileData.contains("xsd:string")) {
								pw.println(fileData.replaceAll(">.*?<", ">"
										+ second.getMyStringS() + "<"));
							} else if (fileData.contains("xsd:int")) {
								pw.println(fileData.replaceAll(">.*?<", ">"
										+ String.valueOf(second.getMyIntS())
										+ "<"));
							} else if (fileData.contains("xsd:float")) {
								pw.println(fileData.replaceAll(">.*?<", ">"
										+ String.valueOf(second.getMyFloatS())
										+ "<"));
							} else if (fileData.contains("xsd:short")) {
								pw.println(fileData.replaceAll(">.*?<", ">"
										+ String.valueOf(second.getMyShortS())
										+ "<"));
							} else if (fileData.contains("xsd:char")) {
								pw.println(fileData.replaceAll(">.*?<", ">"
										+ String.valueOf(second.getMyCharS())
										+ "<"));
							}
						}
					}else if (iterable_element instanceof MyAllTypesFirst) {
						MyAllTypesFirst first = (MyAllTypesFirst) iterable_element;
						if (null != first) {
							if (fileData.contains("<complexType xsi:type=")) {
								pw.println(fileData.replaceAll("\".*?\"", "\""
										+ iterable_element.getClass()
												.getCanonicalName() + "\""));
							}
							if (fileData.contains("xsd:string")) {
								pw.println(fileData.replaceAll(">.*?<", ">"
										+ first.getMyString() + "<"));
							} else if (fileData.contains("xsd:int")) {
								pw.println(fileData.replaceAll(">.*?<", ">"
										+ String.valueOf(first.getMyInt())
										+ "<"));
							} else if (fileData.contains("xsd:double")) {
								pw.println(fileData.replaceAll(">.*?<", ">"
										+ String.valueOf(first.getMyDouble())
										+ "<"));
							} else if (fileData.contains("xsd:long")) {
								pw.println(fileData.replaceAll(">.*?<", ">"
										+ String.valueOf(first.getMyLong())
										+ "<"));
							} else if (fileData.contains("xsd:char")) {
								pw.println(fileData.replaceAll(">.*?<", ">"
										+ String.valueOf(first.getMyChar())
										+ "<"));
							}
						}
					}
					if (fileData.contains("</complexType>")) {
						pw.println(fileData);
					}
					if (fileData.contains("</DPSerialization>")) {
						pw.println(fileData);
						break;
					}
				}
			}

			pw.close();
			file.close();

		} catch (IOException i) {
			System.err.println("Exception Occured :: " + i.getMessage());
			System.exit(0);
		} catch (Exception e) {
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
