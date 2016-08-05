package org.yadi.refJ.test;

import org.yadi.refJ.exceptions.*;

/**
 * This Class contain static functions that offers<br/>
 * Boolean null tests of Object or array of Objects
 * 
 * @author Yassine Diouri
 *
 */
public abstract class NullTestsUtils {

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
	 * @throws EmptyException 
	 */
	public static Boolean areNotNull(Object... objects) throws EmptyException {
		try {
			if(EmptyTestsUtils.isEmpty(objects))
				throw new EmptyException("The list must have at least one element : size = " + objects.length);
		
			for (int i = 0; i < objects.length; i++) {
				if (isNull(objects[i]))
					return false;
			}
			return true;
		} catch (NotEmptiableObjectException unsued) {}
		return true;
	}

	/**
	 * All Objects of the array are null
	 * 
	 * @param objects
	 * @return true if all objects are null, false if just one is not null
	 * @throws EmptyException 
	 */
	public static Boolean areNull(Object... objects) throws EmptyException {
		try{
			if(EmptyTestsUtils.isEmpty(objects))
				throw new EmptyException("The list must have at least one element : size = " + objects.length);
			
			for (int i = 0; i < objects.length; i++) {
				if (isNotNull(objects[i]))
					return false;
			}
			return true;
		} catch(NotEmptiableObjectException unused){}
		return null;
	}

	/**
	 * Test if only the first Object is null and others are not null<br/>
	 * Whatever the classes
	 * 
	 * @param objects
	 * @return
	 * @throws EmptyException 
	 */
	public static Boolean onlyTheFirstIsNull(Object... objects) throws EmptyException {
		try{
			if(EmptyTestsUtils.isEmpty(objects))
				throw new EmptyException("The list must have at least one element : size = " + objects.length);
			
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
		} catch(NotEmptiableObjectException unused){}
		return null;
	}

	/**
	 * Test if only the latest Object is null and others are not null<br/>
	 * Whatever the classes
	 * 
	 * @param objects
	 * @return
	 * @throws EmptyException 
	 */
	public static Boolean onlyTheLatestIsNull(Object... objects) throws EmptyException {
		try{
			if(EmptyTestsUtils.isEmpty(objects))
				throw new EmptyException("The list must have at least one element : size = " + objects.length);
		
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
		} catch(NotEmptiableObjectException unused){}
		return null;
	}

	/**
	 * Test if only the Object in the position X is null and others are not null<br/>
	 * Whatever the classes
	 * 
	 * @param position : start from '1'
	 * @param objects
	 * @return
	 * @throws EmptyException 
	 * @throws PositionOutOfListException 
	 */
	public static Boolean onlyThePositionIsNull(Integer position, Object... objects) throws EmptyException, PositionOutOfListException {
		try{
			if(EmptyTestsUtils.isEmpty(objects))
				throw new EmptyException("The list must have at least one element : size = " + objects.length);
			if(!MathTestsUtils.ABetweenBAndCOrEqualToBAndC(position, 0, objects.length))
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
		} catch(NotEmptiableObjectException | NotNumberException unused){}
		return null;
	}

	/**
	 * Test if only X Objects are null and others are not null<br/>
	 * Whatever the classes
	 * @param x : maximum number of Objects that can be null
	 * @param objects
	 * @return 
	 * @throws EmptyException 
	 * @throws NotPositiveNumberException 
	 * @throws NumberGreaterThanSizeListException 
	 */
	public static Boolean onlyXObjectsAreNull(Integer x, Object... objects) throws EmptyException, NotPositiveNumberException, NumberGreaterThanSizeListException {
		try{
			if(EmptyTestsUtils.isEmpty(objects))
				throw new EmptyException("The list must have at least one element : size = " + objects.length);
			if(MathTestsUtils.isNegative(x))
				throw new NotPositiveNumberException("The number of Object X must be greater or Equal to 0 : x = " + x);
			if(MathTestsUtils.AGreaterThanB(x, objects.length))
				throw new NumberGreaterThanSizeListException("The number given must be lower than the size of the list : " + x + " > " + objects.length);
			
			int n = 0;
			for(int i = 0; i < objects.length; i++){
				if(isNull(objects[i]))
					n++;
			}
			return n == x;
		} catch(NotNumberException | NotEmptiableObjectException unsued) {}
		return null;
	}

	/**
	 * Test if at Least X Objects are not null from the list<br/>
	 * Whatever the classes<br/>
	 * <i>x > 0 </i>
	 * 
	 * @param x : minimum number of null Objects
	 * @param objects
	 * @return
	 * @throws EmptyException
	 * @throws NotPositiveNumberException
	 */
	public static Boolean atLeastXObjectsAreNull(Integer x, Object... objects) throws EmptyException, NotPositiveNumberException {
		try {
			if (EmptyTestsUtils.isEmpty(objects))
				throw new EmptyException("The list must have at least one element : size = " + objects.length);
			if (MathTestsUtils.isNegative(x))
				throw new NotPositiveNumberException("The number of Object X must be greater or Equal to 0 : x = " + x);

			int n = 0;
			for (int i = 0; i < objects.length; i++) {
				if (isNull(objects[i]))
					n++;
			}
			return n <= x;
		} catch (NotEmptiableObjectException | NotNumberException e) {}
		return null;
	}

	/**
	 * Test if at Least X Objects are not null from the list<br/>
	 * Whatever the classes<br/>
	 * <i>x > 0 </i>
	 * 
	 * @param x : minimum number of not null Objects
	 * @param objects
	 * @return
	 * @throws EmptyException
	 * @throws NotPositiveNumberException
	 */
	public static Boolean atLeastXObjectsAreNotNull(Integer x, Object... objects) throws EmptyException, NotPositiveNumberException {
		try {
			if (EmptyTestsUtils.isEmpty(objects))
				throw new EmptyException("The list must have at least one element : size = " + objects.length);
			if (MathTestsUtils.isNegative(x))
				throw new NotPositiveNumberException("The number of Object X must be greater or Equal to 0 : x = " + x);

			int n = 0;
			for (int i = 0; i < objects.length; i++) {
				if (isNotNull(objects[i]))
					n++;
			}
			return n <= x;
		} catch (NotEmptiableObjectException | NotNumberException e) {}
		return null;
	}
}
