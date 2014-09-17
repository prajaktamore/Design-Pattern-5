package reflection.utilClasses;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import reflection.interfaces.IContext;
import reflection.interfaces.IDeSerialize;
import reflection.interfaces.IParse;
import reflection.serDeser.DeSerialize;
import reflection.serDeser.DeSerializeTypes;

/**
 * @author Prajakta More 
 * Parse class that parse the file data and generated the
 *         hashmap for every object
 */

public class Parse implements IParse {

	/**
	 * Parse Constructor
	 */
	public Parse() {
		if (Debug.getDEBUG_VALUE() == 4) {
			CompareTwoClasses.strbuild.append("\n Constructor is called :: "
					+ this.getClass().getName());
		}
	}

	/**
	 * @throws IOException
	 */
	@Override
	public void readFile() throws IOException {
		if(Debug.getDEBUG_VALUE() == 3){
			CompareTwoClasses.strbuild.append("\n"+this.getClass().getName()
					+ "\n Deserialize method is called");}
		try {
			try {
				FileReaderClass.setFileReader(new FileReader(FileReaderClass
						.getInputFileName()));
			} catch (FileNotFoundException e) {
				System.err.println("Exception Occured :: " + e.getMessage());
				System.exit(0);
			}
			FileReaderClass.setBr(new BufferedReader(FileReaderClass
					.getFileReader()));

			StringBuilder buildString = new StringBuilder();
			String fileData = null;
			HashMap<Integer, String> hashMap = new HashMap<Integer, String>();
			while ((fileData = FileReaderClass.getBr().readLine()) != null) {
				IContext context = new Context(new DPSerialization());
				if (!context.executeStrategy(fileData.trim())) {
					context = new Context(new ComplexType());
					if (context.executeStrategy(fileData.trim())) {
						Matcher matcher = Pattern.compile(
								"^.*?" + "<" + "(.*)" + "xsi:type" + ".*$")
								.matcher(fileData);
						if (matcher.matches()) {
							hashMap = new HashMap<Integer, String>();
													Matcher matcher1 = Pattern.compile(
									"^.*?" + "\"" + "(.*)" + "\"" + ".*$")
									.matcher(fileData);
							if (matcher1.matches())
								hashMap.put(0, matcher1.group(1));
						}

					}
					context = new Context(new PrimitiveTypes());
					if (!context.executeStrategy(fileData.trim())) {
						Pattern tagPattern = Pattern
								.compile("<(\\S+?)(.*?)>(.*?)</\\1>");
						@SuppressWarnings("unused")
						Pattern attValueDoubleQuoteOnly = Pattern
								.compile("(\\w+)=\"(.*?)\"");
						@SuppressWarnings("unused")
						Pattern attValueAll = Pattern
								.compile("([\\w:\\-]+)(\\s*=\\s*(\"(.*?)\"|'(.*?)'|([^ ]*))|(\\s+|\\z))");
						Matcher m = tagPattern.matcher(fileData.trim());
						@SuppressWarnings("unused")
						boolean tagFound = m.find();
						@SuppressWarnings("unused")
						String tagOnly = m.group(0);
						@SuppressWarnings("unused")
						String tagname = m.group(1);
						String attributes = m.group(2);
						@SuppressWarnings("unused")
						String content = m.group(3);
						if (null != attributes) {
							if (null != m.group(3)) {
								if (attributes.contains("xsd:string")) {
									hashMap.put(1, m.group(3).trim());
								} else if (attributes.contains("xsd:int")) {
									hashMap.put(2, m.group(3).trim());
								} else if (attributes.contains("xsd:double")
										|| attributes.contains("xsd:float")) {
									hashMap.put(3, m.group(3).trim());
								} else if (attributes.contains("xsd:long")
										|| attributes.contains("xsd:short")) {
									hashMap.put(4, m.group(3).trim());
								} else if (attributes.contains("xsd:char")
										) {
									hashMap.put(5, m.group(3).trim());
								}
							}
						}
					}
					context = new Context(new CallMethod());
					if (context.executeStrategy(fileData.trim())) {
						IDeSerialize deSerialize = new DeSerialize();
						deSerialize.deSerializeMethod(hashMap);
					}
				}

			}
			if(null != DeSerialize
					.getMyAllTypesFirsts1()){
			DeSerializeTypes.setMyAllTypesFirsts(DeSerialize
					.getMyAllTypesFirsts1());}
			if(null != DeSerialize
					.getMyAllTypesSecond1()){
			DeSerializeTypes.setMyAllTypesSeconds(DeSerialize
					.getMyAllTypesSecond1());}
		} catch (Exception e) {
			System.err.println("Exception Occured :: " + e.getMessage());
			e.printStackTrace();
			System.exit(0);
		}finally {
			
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
