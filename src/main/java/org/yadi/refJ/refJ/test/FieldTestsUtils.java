package org.yadi.refJ.test;

import java.lang.reflect.*;

import org.yadi.refJ.generator.*;

/**
 * 
 * @author Yassine Diouri
 *
 */
public abstract class FieldTestsUtils {

	/**
	 * 
	 * 
	 * @param o
	 * @param fieldName
	 * @return
	 * @throws NullPointerException
	 */
	public static Boolean hasFieldWithName(Object o, String fieldName) throws NullPointerException {
		if(NullTestsUtils.isNull(o))
			throw new NullPointerException("The Object must be not null !");
		
		for(Field ff : FieldGenerator.getAllFieldsOnArrayOfObject(o)){
			if(EqualTestsUtils.areEqual(fieldName, ff.getName()))
				return 
		}
	}
}
