package org.yadi.refJ.test;

import org.yadi.refJ.exceptions.EmptyListException;
import org.yadi.refJ.exceptions.MinimumNumberOfElementToCompareException;
import org.yadi.refJ.exceptions.NotTheSameInstanceException;
import org.yadi.refJ.exceptions.NullObjectsInTheArrayException;

/**
 * 
 * @author Yassine Diouri
 *
 */
public class CommonEqualTests {
	
	/**
	 * Test that the two objects are equal
	 * Condition : Objects must be instance of the same class
	 * 
	 * @param o1
	 * @param o2
	 * @return o1 != o2
	 * @throws NullObjectsInTheArrayException 
	 * @throws EmptyListException 
	 * @throws Exception 
	 */
	public static Boolean areEqual(Object o1, Object o2) throws NotTheSameInstanceException, EmptyListException, NullObjectsInTheArrayException{
		if(CommonClassTests.areNotInstanceOfTheSameClass(o1, o2))
			throw new NotTheSameInstanceException("Objects must be instance of the same class, "
					+ "o1["+o1.getClass().getCanonicalName()+"] != o2["+o2.getClass().getCanonicalName()+"]");
		
		return o1.equals(o2);
		
	}
	
	/**
	 * Test that all Objects are equal
	 * Condition : Objects must be instance of the same class
	 * 
	 * @return 
	 * @throws EmptyListException 
	 * @throws MinimumNumberOfElementToCompareException 
	 * @throws NullObjectsInTheArrayException 
	 * @throws Exception 
	 */
	public static Boolean areEqual(Object... objects) throws NotTheSameInstanceException, EmptyListException, MinimumNumberOfElementToCompareException, NullObjectsInTheArrayException{
		if(objects.length == 0)
			throw new EmptyListException("The list must have at least one element : size = " + objects.length);
		if(objects.length < 2)
			throw new MinimumNumberOfElementToCompareException("The list must have at least 2 elements : size = " + objects.length);
		
		for(int i = 1; i < objects.length; i++){
			if(CommonDifferentTests.areDifferent(objects[0], objects[i]))
				return false;
		}
		return true;
	}
}
