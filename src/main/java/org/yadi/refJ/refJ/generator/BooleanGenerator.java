package org.yadi.refJ.generator;

import java.util.*;

import org.yadi.refJ.exceptions.*;
import org.yadi.refJ.model.*;
import org.yadi.refJ.test.*;

/**
 * 
 * @author Yassine Diouri
 *
 */
public class BooleanGenerator {

	/**
	 * Get the Boolean from the Object given
	 * 
	 * @param o
	 * @return
	 * @throws NotBooleanException 
	 */
	public static Boolean getBoolean(Object o) throws NotBooleanException{
		if(!ClassTestsUtils.isBoolean(o))
			throw new NotBooleanException("The object given is not instance of java.lang.Boolean : " + o.getClass().toString());
		
		return (Boolean) o;
	}
	
	/**
	 * Get a Boolean representing the the result of the Logic Operation given on the list
	 * 
	 * @param objects
	 * @return
	 * @throws NotTheSameInstanceException
	 * @throws EmptyException
	 * @throws NullObjectsInTheArrayException
	 * @throws NotNumberException
	 * @throws NotBooleanException
	 */
	public static Boolean getFromLogicOperation(Object... objects) throws NotTheSameInstanceException, EmptyException, 
			NullObjectsInTheArrayException, NotNumberException, NotBooleanException{
		if(objects.length == 0)
			throw new EmptyException("The list must have at least one element : size = " + objects.length);
		//TODO Malformed Logic Operation Exception
		
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
	
	/**
	 * Logic Operation on founding a Closing parenthesis
	 * 
	 * @param pil
	 * @throws NotNumberException
	 * @throws NotBooleanException
	 * @throws EmptyException
	 * @throws NotTheSameInstanceException
	 * @throws NullObjectsInTheArrayException
	 */
	@SuppressWarnings("incomplete-switch")
	private static void doLogicOperation(List<Object> pil) throws NotNumberException, NotBooleanException, EmptyException, NotTheSameInstanceException, NullObjectsInTheArrayException {
		List<Object> operands = new ArrayList<Object>();
		List<Object> operators = new ArrayList<Object>();
		
		Object o = pull(pil);
		while(DifferentTestsUtils.areDifferentWhateverClass(o, LogicOperationOperators.OP)){
			if(ClassTestsUtils.isBoolean(o)) 
				operands.add(o);
			if(o instanceof LogicOperationOperators)
				operators.add(o);
			o = pull(pil);
		}
		
		while(MathTestsUtils.ADifferentFromB(operators.size(), 0)){
			LogicOperationOperators op = (LogicOperationOperators) pull(operators);
			Object o1 = pull(operands);
			Object o2 = pull(operands);
			
			switch(op){
			case AND:
				operands.add(LogicTestsUtils.and(o1, o2));
				break;
			case OR:
				operands.add(LogicTestsUtils.or(o1, o2));
				break;
			}
		}
		
		pil.add(operands.get(0));
	}

	/**
	 * Pull an element from a list<br/>
	 * <i>return and remove the latest element</i>
	 * 
	 * @param list
	 * @return
	 */
	private static Object pull(List<Object> list){
		Object o = list.get(list.size() - 1);
		list.remove(list.size() - 1);
		return o;
	}
	
	/**
	 * Not Completed
	 * 
	 * @param objects
	 * @throws NotTheSameInstanceException
	 * @throws EmptyException
	 * @throws NullObjectsInTheArrayException
	 * @throws NotNumberException
	 * @throws NotBooleanException
	 */
	public static void getAutomatonBooleanResult(Object... objects) throws NotTheSameInstanceException, EmptyException, 
			NullObjectsInTheArrayException, NotNumberException, NotBooleanException{
		if(objects.length == 0)
			throw new EmptyException("The list must have at least one element : size = " + objects.length);
		
		
	}
}
