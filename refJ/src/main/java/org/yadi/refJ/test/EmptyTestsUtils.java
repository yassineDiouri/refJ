package org.yadi.refJ.test;

import java.util.*;

import org.yadi.refJ.exceptions.*;
import org.yadi.refJ.generator.*;

/**
 * This Class contain static functions that offers<br/>
 * Boolean empty tests of Object or array of Objects<br/>
 * <i>Objects must be emptiable :
 * <ul>
 * <li>String</li>
 * <li>Collection</li>
 * <li>Map</li>
 * <li>Array</li>
 * </ul></i><br/>
 * 
 * @author Yassine Diouri
 *
 */
public abstract class EmptyTestsUtils {

	/**
	 * Verify if the Object given is empty or not<br/>
	 * <i>Condition : the Object must be emptiable and not null</i><br/>
	 * <i>emptiable list : String, Collection, Array, Map</i>
	 * 
	 * @param o
	 * @return
	 * @throws EmptyException
	 * @throws NotEmptiableObjectException
	 * @throws NullPointerException
	 */
	public static Boolean isEmpty(Object o) throws NullPointerException, EmptyException, NotEmptiableObjectException{
		try{
			if(NullTestsUtils.isNull(o))
				throw new NullPointerException("The Object must be not null !");
			if(!ClassTestsUtils.isInstanceOfOneFromListOfClasses(o, String.class, Collection.class, Map.class))
				throw new NotEmptiableObjectException("The object given can not be empty");
			
			if(ClassTestsUtils.isString(o))
				return !MathTestsUtils.AGreaterThanB(StringGenerator.getString(o).length(), 0);
			if(ClassTestsUtils.isCollection(o))
				return !MathTestsUtils.AGreaterThanB(CollectionGenerator.getCollection(o).size(), 0);
			if(ClassTestsUtils.isMap(o))
				return !MathTestsUtils.AGreaterThanB(MapGenerator.getMap(o).size(), 0);
			if(ClassTestsUtils.isArray(o))
				return !MathTestsUtils.AGreaterThanB(ArrayGenerator.getArray(o).length, 0);
				
			return true;
		} catch(NotStringException | NotMapException | NotArrayException | NotCollectionException
				| NotNumberException unused) {
			
		}
		return true;
	}

	/**
	 * Verify if the array of Objects given are empty or not<br/>
	 * <i>Condition : the Objects must be emptiable and not null</i><br/>
	 * <i>emptiable list : String, Collection, Array, Map</i>
	 * 
	 * @param objects
	 * @return
	 * @throws NullPointerException
	 * @throws EmptyException
	 * @throws NotEmptiableObjectException
	 */
	public static Boolean areEmpty(Object... objects) throws NullPointerException, EmptyException, NotEmptiableObjectException {
		if(NullTestsUtils.areNotNull(objects))
			throw new NullPointerException("the given array must not contain a null Emptiable Objects");
		
		for(int i = 0; i < objects.length; i++){
			if(!isEmpty(objects[i]))
				return false;
		}
		return true;
	}
}
