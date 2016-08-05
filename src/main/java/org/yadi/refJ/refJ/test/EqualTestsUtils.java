package org.yadi.refJ.test;

import org.yadi.refJ.exceptions.*;

/**
 * 
 * @author Yassine Diouri
 *
 */
public abstract class EqualTestsUtils {
	
	/**
	 * Test that the two objects are equal<br/>
	 * <i>Condition : Objects must be instance of the same class</i>
	 * 
	 * @param o1
	 * @param o2
	 * @return o1 != o2
	 * @throws NullObjectsInTheArrayException 
	 * @throws EmptyException
	 * @throws NotTheSameInstanceException 
	 */
	public static Boolean areEqual(Object o1, Object o2) throws EmptyException, NullObjectsInTheArrayException, NotTheSameInstanceException{
		if(ClassTestsUtils.areNotInstanceOfTheSameClass(o1, o2))
			throw new NotTheSameInstanceException("Objects must be instance of the same class, "
					+ "o1["+o1.getClass().getCanonicalName()+"] != o2["+o2.getClass().getCanonicalName()+"]");
		
		return o1.equals(o2);
		
	}
	
	/**
	 * Test that all Objects are equal<br/>
	 * <i>Condition : Objects must be instance of the same class</i>
	 * 
	 * @return 
	 * @throws EmptyException 
	 * @throws MinimumNumberOfElementToCompareException 
	 * @throws NullObjectsInTheArrayException
	 */
	public static Boolean areEqual(Object... objects) throws NotTheSameInstanceException, EmptyException, MinimumNumberOfElementToCompareException, NullObjectsInTheArrayException{
		try{
			if(EmptyTestsUtils.isEmpty(objects))
				throw new EmptyException("The list must have at least one element : size = " + objects.length);
			if(MathTestsUtils.ALowerThanB(objects.length, 2))
				throw new MinimumNumberOfElementToCompareException("The list must have at least 2 elements : size = " + objects.length);
			
			for(int i = 1; i < objects.length; i++){
				if(DifferentTestsUtils.areDifferent(objects[0], objects[i]))
					return false;
			}
			return true;
		} catch(NotEmptiableObjectException | NotNumberException unused) {}
		return null;
	}
}
