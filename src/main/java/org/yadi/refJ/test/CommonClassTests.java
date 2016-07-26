package org.yadi.refJ.test;

import java.util.List;

import org.yadi.refJ.exceptions.EmptyListException;
import org.yadi.refJ.exceptions.NotTheSameInstanceException;
import org.yadi.refJ.exceptions.NullObjectsInTheArrayException;

/**
 * 
 * Give functionalities to help on comparing instances between list of Objects or Object with <br/>defined java Objects from <i>java.lang.*</i>
 * 
 * @author Yassine Diouri
 * 
 */
public class CommonClassTests {

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
	 * Test that the 2 Objects are instance of the same Class
	 * 
	 * @return 
	 * @throws EmptyListException
	 * @throws NotTheSameInstanceException 
	 * @throws NullObjectsInTheArrayException 
	 */
	public static Boolean areInstanceOfTheSameClass(Object o1, Object o2) throws NotTheSameInstanceException, EmptyListException, NullObjectsInTheArrayException {
		if(!CommonNullTests.areNotNull(o1, o2))
			throw new NullObjectsInTheArrayException("The specified array Contains null Objects");

		return o1.getClass().equals(o2.getClass());
	}

	/**
	 * Test that the 2 Objects did not have the same class
	 * 
	 * @return 
	 * @throws EmptyListException
	 * @throws NotTheSameInstanceException 
	 * @throws NullObjectsInTheArrayException 
	 */
	public static Boolean areNotInstanceOfTheSameClass(Object o1, Object o2) throws NotTheSameInstanceException, EmptyListException, NullObjectsInTheArrayException {
		if(!CommonNullTests.areNotNull(o1, o2))
			throw new NullObjectsInTheArrayException("The specified array Contains null Objects");

		return !o1.getClass().equals(o2.getClass());
	}

	/**
	 * Test that all elements are instance of the same Class
	 * 
	 * @param objects
	 * @return true if all elements are instance of the same class,<br/> else if just one is different from others return false
	 * @throws EmptyListException
	 * @throws NotTheSameInstanceException 
	 * @throws NullObjectsInTheArrayException 
	 */
	public static Boolean areInstanceOfTheSameClass(Object... objects) throws EmptyListException, NotTheSameInstanceException, NullObjectsInTheArrayException{
		if(objects.length == 0)
			throw new EmptyListException("The list must have at least one element : size = " + objects.length);
		if(!CommonNullTests.areNotNull(objects))
			throw new NullObjectsInTheArrayException("The specified array Contains null Objects");
		
		Class<?> clazz = objects[0].getClass();
		for(int i = 1; i < objects.length; i++){
			if(CommonDifferentTests.areDifferent(clazz, objects[i].getClass()))
				return false;
		}
		return true;
	}
	
	/**
	 * Test if the Object given is belongs the list of classes given
	 * 
	 * @param o
	 * @param classes
	 * @return
	 * @throws EmptyListException
	 */
	public static Boolean isInstanceOfOneFromList(Object o, Class<?>... classes) throws EmptyListException{
		if(classes.length == 0)
			throw new EmptyListException("The list must have at least one element : size = " + classes.length);
		
		for(int i = 0; i < classes.length; i++){
			if(o.getClass().equals(classes[i]))
				return true;
		}
		return false;
	}
	
	public static Boolean areInstanceOfOneFromList(List<Object> objects, List<Class<?>> classes){
		//TODO
		return null;
	}
}
