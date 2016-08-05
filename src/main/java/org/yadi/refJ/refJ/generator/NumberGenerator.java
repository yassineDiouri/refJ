package org.yadi.refJ.generator;

import org.yadi.refJ.exceptions.NotNumberException;
import org.yadi.refJ.test.ClassTestsUtils;

/**
 * 
 * @author Yassine Diouri
 *
 */
public class NumberGenerator {
	
	/**
	 * Get the equivalent number for the object given
	 * 
	 * @param o
	 * @return
	 * @throws NotNumberException
	 */
	public static Number getNumber(Object o) throws NotNumberException{
		if(!ClassTestsUtils.isNumber(o))
			throw new NotNumberException("The object given is not instance of java.lang.Number : " + o.getClass().toString());
			
		return (Number) o;
	}
}
