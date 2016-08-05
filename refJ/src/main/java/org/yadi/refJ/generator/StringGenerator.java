package org.yadi.refJ.generator;

import org.yadi.refJ.exceptions.*;
import org.yadi.refJ.test.*;

/**
 * 
 * @author Yassine Diouri
 *
 */
public class StringGenerator {
	
	/**
	 * get a String from the object given<br/>
	 * <i>"o" must be an instanceOf java.lang.String</i>
	 * 
	 * @param o
	 * @return
	 * @throws NotStringException
	 */
	public static String getString(Object o) throws NotStringException{
		if(!ClassTestsUtils.isString(o))
			throw new NotStringException("The Object is not instance of java.lang.String");
		
		return (String) o;
	}
}
