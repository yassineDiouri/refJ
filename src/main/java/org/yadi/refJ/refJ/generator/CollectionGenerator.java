package org.yadi.refJ.generator;

import java.util.*;

import org.yadi.refJ.exceptions.*;
import org.yadi.refJ.test.*;

/**
 * 
 * @author Yassine Diouri
 *
 */
public abstract class CollectionGenerator {

	/**
	 * get a Collection from the object given<br/>
	 * <i>"o" must be an instanceOf java.util.Collection</i>
	 * 
	 * @param o
	 * @return
	 * @throws NotCollectionException
	 */
	public static Collection<?> getCollection(Object o) throws NotCollectionException {
		if(!ClassTestsUtils.isCollection(o))
			throw new NotCollectionException("The Object is not instance of java.util.Collection");
		
		return (Collection<?>) o;
	}
	
	/**
	 * Add all list or arrays to the Collection given<br/>
	 * <i>Collection must be not null, and arrays too<br/>
	 * Based on the java.util.Collections.addAll(Collection<? super Object> c, Object... elements)</i>
	 * 
	 * @param c
	 * @param objects
	 * @return
	 * @throws NullPointerException
	 * @throws EmptyException
	 */
	public static Collection<?> addAll(Collection<Object> c, Object[]... objects) throws NullPointerException, EmptyException{
		try {
			if(NullTestsUtils.isNull(c))
				throw new NullPointerException("The collection given must be not null");
			if(EmptyTestsUtils.isEmpty(objects))
				throw new EmptyException("The list must have at least one element : size = " + objects.length);
			
			for(int i = 0; i < objects.length; i++){
				Collections.addAll(c, objects[i]);
			}
			return c;
		} catch (NotEmptiableObjectException unused) {}
		return null;
	}
}
