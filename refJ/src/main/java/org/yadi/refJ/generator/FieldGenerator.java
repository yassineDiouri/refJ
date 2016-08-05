package org.yadi.refJ.generator;

import java.lang.reflect.*;

import org.yadi.refJ.exceptions.*;
import org.yadi.refJ.test.*;

/**
 * 
 * @author Yassine Diouri
 *
 */
public abstract class FieldGenerator {

	/**
	 * Return an array containing all fields of the object given
	 * 
	 * @param o
	 * @return
	 * @throws NullPointerException
	 */
	public static Field[] getAllFieldsOnArrayOfTheObject(Object o) throws NullPointerException {
		if(NullTestsUtils.isNull(o))
			throw new NullPointerException("The Object must be not null !");
		
		return o.getClass().getDeclaredFields();
	}
	
	/**
	 * 
	 * @param o
	 * @param fieldName
	 * @return
	 * @throws NullPointerException
	 * @throws EmptyException
	 * @throws NullObjectsInTheArrayException
	 * @throws NotNumberException
	 * @throws NotStringException
	 * @throws NotCollectionException
	 * @throws NotMapException
	 * @throws NotEmptiableObjectException
	 * @throws NotExistingFieldException
	 */
	public static Field getFiledWithNameOfObject(Object o, String fieldName) throws NullPointerException, EmptyException, NullObjectsInTheArrayException, NotNumberException, NotStringException, NotCollectionException, NotMapException, CanNotBeEmptyObjectException, NotExistingFieldException {
		try{
			if(NullTestsUtils.isNull(o))
				throw new NullPointerException("The Object must be not null !");
			if(EmptyTestsUtils.isEmpty(fieldName))
				throw new EmptyException("The field name can not be empty");
			
			for(Field f : getAllFieldsOnArrayOfTheObject(o)){
				if(EqualTestsUtils.areEqual(fieldName, f.getName()))
					return f;
			}
			throw new NotExistingFieldException("The object did not contains a filed with name : " + fieldName);
		} catch (NotTheSameInstanceException | )
	}
}
