package org.yadi.refJ.test;

import org.yadi.refJ.exceptions.*;

/**
 * Give functionalities to help on comparing instances of list of Objects<br/>
 * between them or list of Objects with Java types
 * 
 * @author Yassine Diouri
 * 
 */
public class ClassTestsUtils {

	/**
	 * Verify that the Object is an instance of Boolean
	 * 
	 * @param o
	 * @return
	 */
	public static Boolean isBoolean(Object o){
		return o instanceof java.lang.Boolean;
	}
	
	/**
	 * Verify that the Object given is a Number
	 * 
	 * @param o
	 * @return
	 */
	public static Boolean isNumber(Object o) {
		return o instanceof java.lang.Number;
	}
	
	/**
	 * Verify that the Object given is a String
	 * 
	 * @param o
	 * @return
	 */
	public static Boolean isString(Object o) {
		return o instanceof java.lang.String;
	}
	
	/**
	 * Verify that the Object given is a Collection
	 * 
	 * @param o
	 * @return
	 */
	public static Boolean isCollection(Object o) {
		return o instanceof java.util.Collection;
	}
	
	/**
	 * Verify that the Object given is a Map
	 * 
	 * @param o
	 * @return
	 */
	public static Boolean isMap(Object o) {
		return o instanceof java.util.Map;
	}

	/**
	 * Verify that the Object given is an array (<i>Object[] or primitive[]</i>)
	 * 
	 * @param o
	 * @return
	 * @throws NullPointerException
	 */
	public static Boolean isArray(Object o) throws NullPointerException{
		if(NullTestsUtils.isNull(o))
			throw new NullPointerException("The Object given must be not null");
		
		return o.getClass().isArray();
	}
	
	/**
	 * Test that the 2 Objects are instance of the same Class
	 * 
	 * @return 
	 * @throws EmptyException
	 * @throws NullObjectsInTheArrayException 
	 */
	public static Boolean areInstanceOfTheSameClass(Object o1, Object o2) throws EmptyException, NullObjectsInTheArrayException {
		if(!NullTestsUtils.areNotNull(o1, o2))
			throw new NullObjectsInTheArrayException("The specified array Contains null Objects");

		return o1.getClass().equals(o2.getClass());
	}

	/**
	 * Test that the 2 Objects did not have the same class
	 * 
	 * @return 
	 * @throws EmptyException
	 * @throws NullObjectsInTheArrayException 
	 */
	public static Boolean areNotInstanceOfTheSameClass(Object o1, Object o2) throws EmptyException, NullObjectsInTheArrayException {
		if(!NullTestsUtils.areNotNull(o1, o2))
			throw new NullObjectsInTheArrayException("The specified array Contains null Objects");

		return !o1.getClass().equals(o2.getClass());
	}

	/**
	 * Test that all elements are instance of the same Class
	 * 
	 * @param objects
	 * @return true if all elements are instance of the same class,<br/> else if just one is different from others return false
	 * @throws EmptyException
	 * @throws NotTheSameInstanceException 
	 * @throws NullObjectsInTheArrayException 
	 * @throws NotEmptiableObjectException 
	 */
	public static Boolean areInstanceOfTheSameClass(Object... objects) throws EmptyException, NullObjectsInTheArrayException{
		try{
			if(EmptyTestsUtils.isEmpty(objects))
				throw new EmptyException("The list must have at least one element : size = " + objects.length);
			if(!NullTestsUtils.areNotNull(objects))
				throw new NullObjectsInTheArrayException("The specified array Contains null Objects");
			
			Class<?> clazz = objects[0].getClass();
			for(int i = 1; i < objects.length; i++){
				if(DifferentTestsUtils.areDifferent(clazz, objects[i].getClass()))
					return false;
			}
			return true;
		} catch(NotEmptiableObjectException | NotTheSameInstanceException unused) {}
		return null;
	}
	
	/**
	 * Test if the Object given is belongs the list of classes given
	 * 
	 * @param o
	 * @param classes
	 * @return
	 * @throws EmptyException
	 * @throws NullPointerException
	 */
	public static Boolean isInstanceOfOneFromListOfClasses(Object o, Class<?>... classes) throws EmptyException, NullPointerException{
		try{
			if(NullTestsUtils.isNull(o))
				throw new NullPointerException("The Object given must be not null");
			if(EmptyTestsUtils.isEmpty(classes))
				throw new EmptyException("The list must have at least one element : size = " + classes.length);
			if(NullTestsUtils.areNotNull((Object[]) classes))
				throw new NullPointerException("There is a null gievn on the list of classes");
			
			for(int i = 0; i < classes.length; i++){
				if(o.getClass().equals(classes[i]))
					return true;
			}
			return false;
		} catch(NotEmptiableObjectException unused) {}
		return false;
	}
	
	/**
	 * Test if the Objects given are belongs the list of classes given
	 * 
	 * @param objects
	 * @param classes
	 * @return
	 * @throws EmptyException
	 * @throws NullPointerException
	 */
	public static Boolean areInstanceOfOneFromListOfClasses(Object[] objects, Class<?>... classes) throws EmptyException, NullPointerException{
		for(int i = 0; i < objects.length; i++){
			if(!isInstanceOfOneFromListOfClasses(objects[i], classes))
				return false;
		}
		return true;
	}
}
