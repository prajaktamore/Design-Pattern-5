package reflection.serDeser;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;

import reflection.interfaces.IDeSerialize;
import reflection.util.MyAllTypesFirst;
import reflection.util.MyAllTypesSecond;
import reflection.utilClasses.CompareTwoClasses;
import reflection.utilClasses.Debug;
/**
 * @author Prajakta 
 * DeSerialize class that uses reflection to generate classes and calls respective methodfrom the parsed data 
 */
public class DeSerialize implements IDeSerialize {
	static ArrayList<MyAllTypesFirst> myAllTypesFirsts1 = new ArrayList<MyAllTypesFirst>();
	static ArrayList<MyAllTypesSecond> myAllTypesSecond1 = new ArrayList<MyAllTypesSecond>();
	static Integer finalValue = 0;

	/**
	 * DeSerialize Constructor
	 */
	public DeSerialize() {
		if(Debug.getDEBUG_VALUE() == 4){
		CompareTwoClasses.strbuild.append("\n Constructor is called :: "+ this.getClass().getName());}
	}
	
	/* (non-Javadoc)
	 * @see reflection.interfaces.IDeSerialize#deSerializeMethod(java.util.HashMap)
	 */
	@Override
	public void deSerializeMethod(HashMap<Integer, String> hashMap) {
		
		Class myObjectClass = null;
		try {
			if(null != hashMap.get(0)){
			myObjectClass = Class.forName(hashMap.get(0));}
			Object object = myObjectClass.newInstance();
			if (object instanceof MyAllTypesFirst) {
				@SuppressWarnings("unchecked")
				Method method1 = myObjectClass.getDeclaredMethod("setMyString",
						String.class);
				@SuppressWarnings("unchecked")
				Method method2 = myObjectClass.getDeclaredMethod("setMyInt",
						int.class);
				@SuppressWarnings("unchecked")
				Method method3 = myObjectClass.getDeclaredMethod("setMyDouble",
						double.class);
				@SuppressWarnings("unchecked")
				Method method4 = myObjectClass.getDeclaredMethod("setMyLong",
						long.class);
				@SuppressWarnings("unchecked")
				Method method5 = myObjectClass.getDeclaredMethod("setMyChar",
						char.class);
			if(null != hashMap.get(1)){
				method1.invoke(object, hashMap.get(1));}
				if(null != hashMap.get(2)){
				method2.invoke(object, Integer.parseInt(hashMap.get(2)));}
				if(null != hashMap.get(3)){
				method3.invoke(object, Double.parseDouble(hashMap.get(3)));}
				if(null != hashMap.get(4)){
				method4.invoke(object, Long.parseLong(hashMap.get(4)));}
				if(null != hashMap.get(5)){
				method5.invoke(object, hashMap.get(5).charAt(0));}
				MyAllTypesFirst myAllTypesFirst = new MyAllTypesFirst();
				if(null != myObjectClass){
					Method m10 = object.getClass().getMethod("getMyString", new Class[] {});
					Object ret =  m10.invoke(object, new Object[] {});
					myAllTypesFirst.setMyString((String) ret);
					
					Method m11 = object.getClass().getMethod("getMyInt", new Class[] {});
					Object ret1 =  m11.invoke(object, new Object[] {});
					myAllTypesFirst.setMyInt((Integer) ret1);
					
					Method m12 = object.getClass().getMethod("getMyLong", new Class[] {});
					Object ret2 =  m12.invoke(object, new Object[] {});
					myAllTypesFirst.setMyLong((Long)ret2);
					
					Method m13 = object.getClass().getMethod("getMyChar", new Class[] {});
					Object ret3 =  m13.invoke(object, new Object[] {});
					myAllTypesFirst.setMyChar((Character)ret3);
					
					Method m14 = object.getClass().getMethod("getMyDouble", new Class[] {});
					Object ret4 =  m14.invoke(object, new Object[] {});
					myAllTypesFirst.setMyDouble((Double)ret4);				
					}
				myAllTypesFirsts1.add(myAllTypesFirst);
				SerializeTypes.myAllTypesFinal.add(myAllTypesFirst);

			} else if (object instanceof MyAllTypesSecond) {
				MyAllTypesSecond mSecond = new MyAllTypesSecond();
				@SuppressWarnings("unchecked")
				Method method1 = myObjectClass.getDeclaredMethod(
						"setMyStringS", String.class);
				@SuppressWarnings("unchecked")
				Method method2 = myObjectClass.getDeclaredMethod("setMyIntS",
						int.class);
				@SuppressWarnings("unchecked")
				Method method3 = myObjectClass.getDeclaredMethod("setMyFloatS",
						float.class);
				@SuppressWarnings("unchecked")
				Method method4 = myObjectClass.getDeclaredMethod("setMyShortS",
						short.class);
				@SuppressWarnings("unchecked")
				Method method5 = myObjectClass.getDeclaredMethod("setMyCharS",
						char.class);
				if(null != hashMap.get(1)){
				method1.invoke(object, hashMap.get(1));}
				if(null != hashMap.get(2)){
				method2.invoke(object, Integer.parseInt(hashMap.get(2)));}
				if(null != hashMap.get(3)){
				method3.invoke(object, Float.parseFloat(hashMap.get(3)));}
				if(null != hashMap.get(4)){
				method4.invoke(object, Short.parseShort(hashMap.get(4)));}
				if(null != hashMap.get(5)){
				method5.invoke(object, hashMap.get(5).charAt(0));}
				MyAllTypesSecond myAllTypesSecond = new MyAllTypesSecond();
				if(null != myObjectClass){
					
					Method m10 = object.getClass().getMethod("getMyStringS", new Class[] {});
					Object ret =  m10.invoke(object, new Object[] {});
					myAllTypesSecond.setMyStringS((String) ret);
					
					Method m11 = object.getClass().getMethod("getMyIntS", new Class[] {});
					Object ret1 =  m11.invoke(object, new Object[] {});
					myAllTypesSecond.setMyIntS((Integer) ret1);
					
					Method m12 = object.getClass().getMethod("getMyShortS", new Class[] {});
					Object ret2 =  m12.invoke(object, new Object[] {});
					myAllTypesSecond.setMyShortS((Short)ret2);
					
					Method m13 = object.getClass().getMethod("getMyCharS", new Class[] {});
					Object ret3 =  m13.invoke(object, new Object[] {});
					myAllTypesSecond.setMyCharS((Character)ret3);
					
					Method m14 = object.getClass().getMethod("getMyFloatS", new Class[] {});
					Object ret4 =  m14.invoke(object, new Object[] {});
					myAllTypesSecond.setMyFloatS((Float)ret4);
				}
				
				myAllTypesSecond1.add(myAllTypesSecond);
				SerializeTypes.myAllTypesFinal.add(myAllTypesSecond);
			}
		} catch (ClassNotFoundException e) {
			System.err.println("Exception Occured :: " + e.getMessage());
			System.exit(0);
		} catch (NoSuchMethodException nsme) {
			System.err.println("Exception Occured :: " + nsme.getMessage());
			System.exit(0);
		} catch (IllegalAccessException iae) {
			System.err.println("Exception Occured :: " + iae.getMessage());
			System.exit(0);
		} catch (InstantiationException ie) {
			System.err.println("Exception Occured :: " + ie.getMessage());
			System.exit(0);
		} catch (InvocationTargetException ite) {
			System.err.println("Exception Occured :: " + ite.getMessage());
			System.exit(0);
		}finally {
			
		}
	}

	/**
	 * @return the myAllTypesFirsts1
	 */
	public static ArrayList<MyAllTypesFirst> getMyAllTypesFirsts1() {
		return myAllTypesFirsts1;
	}

	/**
	 * @param myAllTypesFirsts1
	 *            the myAllTypesFirsts1 to set
	 */
	public static void setMyAllTypesFirsts1(
			ArrayList<MyAllTypesFirst> myAllTypesFirsts1) {
		DeSerialize.myAllTypesFirsts1 = myAllTypesFirsts1;
	}

	/**
	 * @return the myAllTypesSecond1
	 */
	public static ArrayList<MyAllTypesSecond> getMyAllTypesSecond1() {
		return myAllTypesSecond1;
	}

	/**
	 * @param myAllTypesSecond1
	 *            the myAllTypesSecond1 to set
	 */
	public static void setMyAllTypesSecond1(
			ArrayList<MyAllTypesSecond> myAllTypesSecond1) {
		DeSerialize.myAllTypesSecond1 = myAllTypesSecond1;
	}
	@Override
	public String toString() {
	    StringBuilder result = new StringBuilder();
	    String NEW_LINE = System.getProperty("line.separator");

	    result.append(""+ NEW_LINE);
	    
	    return result.toString();
	  }
}
