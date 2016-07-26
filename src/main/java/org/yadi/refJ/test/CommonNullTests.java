package org.yadi.refJ.test;

import org.yadi.refJ.exceptions.EmptyListException;
import org.yadi.refJ.exceptions.NotPositiveNumberException;
import org.yadi.refJ.exceptions.NumberGreaterThanSizeListException;
import org.yadi.refJ.exceptions.PositionOutOfListException;

/**
 * 
 * @author Yassine Diouri
 *
 */
public class CommonNullTests {

	public static Boolean isNotNull(Object obj) {
		return obj != null;
	}

	public static Boolean isNull(Object obj) {
		return obj == null;
	}

	/**
	 * All Objects of the array are not null
	 * 
	 * @param objects
	 * @return true if all objects are not null, false if just one is null
	 * @throws EmptyListException 
	 */
	public static Boolean areNotNull(Object... objects) throws EmptyListException {
		if(objects.length == 0)
			throw new EmptyListException("The list must have at least one element : size = " + objects.length);
		
		for (int i = 0; i < objects.length; i++) {
			if (isNull(objects[i]))
				return false;
		}
		return true;
	}

	/**
	 * All Objects of the array are null
	 * 
	 * @param objects
	 * @return true if all objects are null, false if just one is not null
	 * @throws EmptyListException 
	 */
	public static Boolean areNull(Object... objects) throws EmptyListException {
		if(objects.length == 0)
			throw new EmptyListException("The list must have at least one element : size = " + objects.length);
		
		for (int i = 0; i < objects.length; i++) {
			if (isNotNull(objects[i]))
				return false;
		}
		return true;
	}

	/**
	 * Test if only the first Object is null and others are not null<br/>
	 * Whatever the classes
	 * 
	 * @param objects
	 * @return
	 * @throws EmptyListException 
	 */
	public static Boolean onlyTheFirstIsNull(Object... objects) throws EmptyListException {
		if(objects.length == 0)
			throw new EmptyListException("The list must have at least one element : size = " + objects.length);
		
		for (int i = 0; i < objects.length; i++) {
			if (i == 0) {
				if (isNotNull(objects[i]))
					return false;
			} else {
				if (isNull(objects[i]))
					return false;
			}
		}
		return true;
	}

	/**
	 * Test if only the latest Object is null and others are not null<br/>
	 * Whatever the classes
	 * 
	 * @param objects
	 * @return
	 * @throws EmptyListException 
	 */
	public static Boolean onlyTheLatestIsNull(Object... objects) throws EmptyListException {
		if(objects.length == 0)
			throw new EmptyListException("The list must have at least one element : size = " + objects.length);
	
		for (int i = 0; i < objects.length; i++) {
			if (i == objects.length - 1) {
				if (isNotNull(objects[i]))
					return false;
			} else {
				if (isNull(objects[i]))
					return false;
			}
		}
		return true;
	}

	/**
	 * Test if only the Object in the position X is null and others are not null<br/>
	 * Whatever the classes
	 * 
	 * @param position : start from '1'
	 * @param objects
	 * @return
	 * @throws EmptyListException 
	 * @throws PositionOutOfListException 
	 */
	public static Boolean onlyThePositionIsNull(Integer position, Object... objects) throws EmptyListException, PositionOutOfListException {
		if(objects.length == 0)
			throw new EmptyListException("The list must have at least one element : size = " + objects.length);
		if(position < 0 || position > objects.length)
			throw new PositionOutOfListException("The position is out of the list : position = " + position);
	
		for (int i = 0; i < objects.length; i++) {
			if (i == position - 1) {
				if (isNotNull(objects[i]))
					return false;
			} else {
				if (isNull(objects[i]))
					return false;
			}
		}
		return true;
	}

	/**
	 * Test if only X Objects are null and others are not null<br/>
	 * Whatever the classes
	 * @param x : number of Objects that can be null
	 * @param objects
	 * @return 
	 * @throws EmptyListException 
	 * @throws NotPositiveNumberException 
	 * @throws NumberGreaterThanSizeListException 
	 */
	public static Boolean onlyXObjectsAreNull(Integer x, Object... objects) throws EmptyListException, NotPositiveNumberException, NumberGreaterThanSizeListException {
		if(objects.length == 0)
			throw new EmptyListException("The list must have at least one element : size = " + objects.length);
		if(x < 0)
			throw new NotPositiveNumberException("The number of Object X must be greater or Equal to 0 : x = " + x);
		if(x > objects.length)
			throw new NumberGreaterThanSizeListException("The number given must be lower than the size of the list : " + x + " > " + objects.length);
		
		int n = 0;
		for(int i = 0; i < objects.length; i++){
			if(isNull(objects[i]))
				n++;
		}
		return n == x;
	}

	/**
	 * Test if at Least X Objects are not null from the list<br/>
	 * Whatever the classes
	 * 
	 * @param x : number of Objects that can be null (>0)
	 * @param objects
	 * @return
	 * @throws EmptyListException
	 * @throws NotPositiveNumberException
	 */
	public static Boolean atLeastXObjectsAreNotNull(Integer x, Object... objects)
			throws EmptyListException, NotPositiveNumberException {
		if (objects.length == 0)
			throw new EmptyListException("The list must have at least one element : size = " + objects.length);
		if (x < 0)
			throw new NotPositiveNumberException(
					"The number of Object X must be greater or Equal to 0 : x = " + x);

		int n = 0;
		for (int i = 0; i < objects.length; i++) {
			if (isNotNull(objects[i]))
				n++;
		}
		return n <= x;
	}
}
