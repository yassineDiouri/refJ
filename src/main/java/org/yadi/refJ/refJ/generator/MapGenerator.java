package org.yadi.refJ.generator;

import java.util.*;

import org.yadi.refJ.exceptions.*;
import org.yadi.refJ.test.*;

/**
 * 
 * @author Yassine Diouri
 *
 */
public abstract class MapGenerator {

	/**
	 * get a Map from the object given<br/>
	 * <i>"o" must be an instanceOf java.util.Map</i>
	 * 
	 * @param o
	 * @return
	 * @throws NotStringException
	 */
	public static Map<?, ?> getMap(Object o) throws NotMapException {
		if(!ClassTestsUtils.isMap(o))
			throw new NotMapException("The Object is not instance of java.util.Map");
		
		return (Map<?, ?>) o;
	}
}
