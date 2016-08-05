package org.yadi.refJ.test;

import org.yadi.refJ.exceptions.*;
import org.yadi.refJ.generator.*;

/**
 * 
 * @author Yassine Diouri
 *
 */
public class LogicTestsUtils {
	
	/**
	 * Test that all element of list are Boolean
	 * 
	 * @param objects
	 * @return
	 * @throws EmptyException
	 */
	public static Boolean areBoolean(Object... objects) throws EmptyException{
		if(objects.length == 0)
			throw new EmptyException("The list must have at least one element : size = " + objects.length);
		
		for(int i = 0; i < objects.length; i++){
			if(!ClassTestsUtils.isBoolean(objects[i]))
				return false;
		}
		return true;
	}

	/**
	 * Do the AND operation between all element of the list given<br/>
	 * <i>Condition : All element of the list must be Boolean</i>
	 * 
	 * @param objects
	 * @return
	 * @throws NotBooleanException 
	 * @throws EmptyException 
	 */
	public static Boolean and(Object... objects) throws NotBooleanException, EmptyException{
		if(!areBoolean(objects))
			throw new NotBooleanException("Some Objects given are not instance of java.lang.Boolean");
		
		for(int i = 0; i < objects.length; i++){
			if(!BooleanGenerator.getBoolean(objects[i]))
				return false;
		}
		return true;
	}

	/**
	 * Do the OR operation between all element of the list given<br/>
	 * <i>Condition : All element of the list must be Boolean</i>
	 * 
	 * @param objects
	 * @return
	 * @throws NotBooleanException 
	 * @throws EmptyException 
	 */
	public static Boolean or(Object... objects) throws NotBooleanException, EmptyException{
		if(!areBoolean(objects))
			throw new NotBooleanException("Some Objects given are not instance of java.lang.Boolean");
		
		for(int i = 0; i < objects.length; i++){
			if(BooleanGenerator.getBoolean(objects[i]))
				return true;
		}
		return false;
	}
	
	/**
	 * Test if all element are true<br/>
	 * <i>Condition : All element of the list must be Boolean</i>
	 * 
	 * @param objects
	 * @return
	 * @throws NotBooleanException
	 * @throws EmptyException
	 */
	public static Boolean areTrue(Object... objects) throws NotBooleanException, EmptyException{
		return and(objects);
	}
	
	/**
	 * Test if at least one element from the list is true<br/>
	 * <i>Condition : All element of the list must be Boolean</i>
	 * 
	 * @param objects
	 * @return
	 * @throws NotBooleanException
	 * @throws EmptyException
	 */
	public static Boolean atLeastOneIsTrue(Object... objects) throws NotBooleanException, EmptyException{
		return or(objects);
	}
	
	/**
	 * Test if all element are false<br/>
	 * <i>Condition : All element of the list must be Boolean</i>
	 * 
	 * @param objects
	 * @return
	 * @throws NotBooleanException
	 * @throws EmptyException
	 */
	public static Boolean areFalse(Object... objects) throws NotBooleanException, EmptyException{
		if(!areBoolean(objects))
			throw new NotBooleanException("Some Objects given are not instance of java.lang.Boolean");
		
		for(int i = 0; i < objects.length; i++){
			if(BooleanGenerator.getBoolean(objects[i]))
				return false;
		}
		return true;
	}
	
	/**
	 * Test if at least one element from the list is false<br/>
	 * <i>Condition : All element of the list must be Boolean</i>
	 * 
	 * @param objects
	 * @return
	 * @throws NotBooleanException
	 * @throws EmptyException
	 */
	public static Boolean atLeastOneIsFlase(Object... objects) throws NotBooleanException, EmptyException{
		if(!areBoolean(objects))
			throw new NotBooleanException("Some Objects given are not instance of java.lang.Boolean");
		
		for(int i = 0; i < objects.length; i++){
			if(BooleanGenerator.getBoolean(objects[i]))
				return true;
		}
		return false;
	}
}
