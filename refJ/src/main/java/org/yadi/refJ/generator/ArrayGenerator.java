package org.yadi.refJ.generator;

import java.util.*;

import org.yadi.refJ.exceptions.*;
import org.yadi.refJ.test.*;

/**
 * 
 * @author Yassine Diouri
 *
 */
public abstract class ArrayGenerator {

	/**
	 * Get an array from the object given<br/>
	 * <i>Object "o" must be an Array</i>
	 * 
	 * @param o
	 * @return Object[]
	 * @throws NotArrayException
	 */
	public static Object[] getArray(Object o) throws NotArrayException {
		if(ClassTestsUtils.isArray(o))
			throw new NotArrayException("The Object given mut be a array of Objects or primitives (array[])");
		
		return (Object[]) o;
	}
	
	/**
	 * create an array from two given arrays<br/>
	 * Whatever the classes<br/>
	 * <i>A & B can be null</i>
	 * 
	 * @param A
	 * @param B
	 * @return
	 */
	public static Object[] concatBToA(Object[] A, Object... B){
		try {
			if(NullTestsUtils.isNull(A)) A = new Object[]{null};
			if(NullTestsUtils.isNull(B)) B = new Object[]{null};
			List<Object> result = new ArrayList<>();
			CollectionGenerator.addAll(result, A, B);
			return result.toArray();
		} catch (EmptyException unused) {}
		return null;
	}
}
