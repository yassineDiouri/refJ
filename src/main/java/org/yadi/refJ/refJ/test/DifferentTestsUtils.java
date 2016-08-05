package org.yadi.refJ.test;

import org.yadi.refJ.exceptions.*;

/**
 * 
 * @author Yassine Diouri
 *
 */
public abstract class DifferentTestsUtils {
	
	/**
	 * Test that the two objects are different<br/>
	 * <i>Condition : Objects must be instance of the same class</i>
	 * 
	 * @param o1
	 * @param o2
	 * @return o1 != o2
	 * @throws NotTheSameInstanceException 
	 * @throws NullObjectsInTheArrayException 
	 * @throws EmptyException 
	 */
	public static Boolean areDifferent(Object o1, Object o2) throws NotTheSameInstanceException, EmptyException, NullObjectsInTheArrayException {
		if(ClassTestsUtils.areNotInstanceOfTheSameClass(o1, o2))
			throw new NotTheSameInstanceException("Objects must be instance of the same class, "
					+ "o1["+o1.getClass().getCanonicalName()+"] != o2["+o2.getClass().getCanonicalName()+"]");
			
		return !o1.equals(o2);

	}
	
	/**
	 * Test that the two objects are different<br/>
	 * Whatever the class of the Objects
	 * 
	 * @param o1
	 * @param o2
	 * @return true if they are from different class or if they are from the same class but not equal
	 * @throws NullObjectsInTheArrayException 
	 * @throws EmptyException 
	 */
	public static Boolean areDifferentWhateverClass(Object o1, Object o2) throws EmptyException, NullObjectsInTheArrayException {
		if(ClassTestsUtils.areNotInstanceOfTheSameClass(o1, o2))
			return true;
			
		return !o1.equals(o2);

	}
	
	/**
	 * Test that all Objects are different from each others
	 * 
	 * @param objects
	 * @return false if exist two element or plus that are equal
	 * @throws NullObjectsInTheArrayException 
	 * @throws EmptyException
	 */
	public static Boolean areDifferentFromEachOthers(Object... objects) throws NotTheSameInstanceException, EmptyException, NullObjectsInTheArrayException {
		for(int i = 0; i < objects.length; i++){
			for(int j = i + 1; j < objects.length; j++){
				if(EqualTestsUtils.areEqual(objects[i], objects[j]))
					return false;
			}
		}
		return true;
	}
}
