package org.yadi.refJ.generator;

import java.util.ArrayList;
import java.util.List;

import org.yadi.refJ.exceptions.EmptyListException;
import org.yadi.refJ.exceptions.NotBooleanException;
import org.yadi.refJ.exceptions.NotNumberException;
import org.yadi.refJ.exceptions.NotTheSameInstanceException;
import org.yadi.refJ.exceptions.NullObjectsInTheArrayException;
import org.yadi.refJ.model.LogicOperationOperators;
import org.yadi.refJ.test.CommonClassTests;
import org.yadi.refJ.test.CommonDifferentTests;
import org.yadi.refJ.test.CommonLogicTests;
import org.yadi.refJ.test.CommonMathTests;

/**
 * 
 * @author Yassine Diouri
 *
 */
public class CommonBooleanGenerator {

	/**
	 * Get the Boolean from the Object given
	 * 
	 * @param o
	 * @return
	 * @throws NotBooleanException 
	 */
	public static Boolean getBoolean(Object o) throws NotBooleanException{
		if(!CommonClassTests.isBoolean(o))
			throw new NotBooleanException("The object given is not instance of java.lang.Boolean : " + o.getClass().toString());
		
		return (Boolean) o;
	}
	
	public static Boolean getFromLogicOperation(Object... objects) throws NotTheSameInstanceException, EmptyListException, 
			NullObjectsInTheArrayException, NotNumberException, NotBooleanException{
		if(objects.length == 0)
			throw new EmptyListException("The list must have at least one element : size = " + objects.length);
		//TODO
		
		List<Object> pil = new ArrayList<>();
		for(int i = 0; i < objects.length; i++){
			if(objects[i] instanceof java.lang.Boolean){
				pil.add(objects[i]);
			}
			if(objects[i] instanceof LogicOperationOperators){
				switch((LogicOperationOperators) objects[i]){
				case AND:
					pil.add(objects[i]);
					break;
				case OR:
					pil.add(objects[i]);
					break;
				case CP:
					doLogicOperation(pil);
					break;
				case OP:
					pil.add(objects[i]);
					break;
				default:
					break;
				}
			}
		}
		return (Boolean) pil.get(0);
	}
	
	@SuppressWarnings("incomplete-switch")
	private static void doLogicOperation(List<Object> pil) throws NotNumberException, NotBooleanException, EmptyListException, NotTheSameInstanceException, NullObjectsInTheArrayException {
		List<Object> operands = new ArrayList<Object>();
		List<Object> operators = new ArrayList<Object>();
		
		Object o = pull(pil);
		while(CommonDifferentTests.areDifferentWhateverClass(o, LogicOperationOperators.OP)){
			if(CommonClassTests.isBoolean(o)) 
				operands.add(o);
			if(o instanceof LogicOperationOperators)
				operators.add(o);
			o = pull(pil);
		}
		
		while(CommonMathTests.ADifferentFromB(operators.size(), 0)){
			LogicOperationOperators op = (LogicOperationOperators) pull(operators);
			Object o1 = pull(operands);
			Object o2 = pull(operands);
			
			switch(op){
			case AND:
				operands.add(CommonLogicTests.and(o1, o2));
				break;
			case OR:
				operands.add(CommonLogicTests.or(o1, o2));
				break;
			}
		}
		
		pil.add(operands.get(0));
	}

	private static Object pull(List<Object> list){
		Object o = list.get(list.size() - 1);
		list.remove(list.size() - 1);
		return o;
	}
}
