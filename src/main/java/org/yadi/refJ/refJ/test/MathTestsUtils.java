package org.yadi.refJ.test;

import org.yadi.refJ.exceptions.*;
import org.yadi.refJ.generator.*;

/**
 * 
 * @author Yassine Diouri
 *
 */
public class MathTestsUtils {
	
	/**
	 * Test that all element of list are Numbers
	 * 
	 * @param objects
	 * @return
	 * @throws EmptyException
	 */
	public static Boolean areNumbers(Object... objects) throws EmptyException {
		try {
			if(EmptyTestsUtils.isEmpty(objects))
				throw new EmptyException("The list must have at least one element : size = " + objects.length);
			
			for(int i = 0; i < objects.length; i++){
				if(!ClassTestsUtils.isNumber(objects[i]))
					return false;
			}
			return true;
		} catch (NotEmptiableObjectException unused) {}
		return null;
	}
	
	/**
	 * Verify that the Object given is Positive Number<br/>
	 * 
	 * @param o : instance of java.lang.Number
	 * @return
	 * @throws NotNumberException
	 */
	public static Boolean isPositive(Object o) throws NotNumberException {
		if(!ClassTestsUtils.isNumber(o))
			throw new NotNumberException("The object given is not instance of java.lang.Number");
		
		return AGreaterThanB(NumberGenerator.getNumber(o), 0);
	}
	
	public static Boolean arePositive(Object... objects){
		//TODO
	}
	
	/**
	 * Verify that the Object given is Negative Number<br/>
	 * 
	 * @param o : instance of java.lang.Number
	 * @return
	 * @throws NotNumberException
	 */
	public static Boolean isNegative(Object o) throws NotNumberException{
		if(!ClassTestsUtils.isNumber(o))
			throw new NotNumberException("The object given is not instance of java.lang.Number");
		
		return ALowerThanB(NumberGenerator.getNumber(o), 0);
	}
	
	public static Boolean areNegative(Object... objects){
		//TODO
	}
	
	/**
	 * Test that the Object A is greater than B<br/>
	 * <i>Condition : A and B are Numbers (primitive numbers or java.lang.Number)</i>
	 * 
	 * @param A
	 * @param B
	 * @return
	 * @throws NotNumberException
	 */
	public static Boolean AGreaterThanB(Object A, Object B) throws NotNumberException{
		Number varA = NumberGenerator.getNumber(A);
		Number varB = NumberGenerator.getNumber(B);
		
		return varA.doubleValue() > varB.doubleValue();
	}
	
	/**
	 * Test that the Object A is greater or equal to B<br/>
	 * <i>Condition : A and B are Numbers (primitive numbers or java.lang.Number)</i>
	 * 
	 * @param A
	 * @param B
	 * @return
	 * @throws NotNumberException
	 */
	public static Boolean AGreaterOrEqualToB(Object A, Object B) throws NotNumberException{
		Number varA = NumberGenerator.getNumber(A);
		Number varB = NumberGenerator.getNumber(B);
		
		return varA.doubleValue() >= varB.doubleValue();
	}

	/**
	 * Test that the first element is greater than other elements of the list<br/>
	 * <i>Condition : elements are Numbers (primitive numbers or java.lang.Number)</i>
	 * 
	 * @param objects
	 * @throws EmptyException
	 * @throws NotNumberException
	 */
	public static Boolean firstGreaterThanOthers(Object... objects) throws EmptyException, NotNumberException{
		if(!areNumbers(objects))
			throw new NotNumberException("Some Objects given are not instance of java.lang.Number");
		
		Number first = NumberGenerator.getNumber(objects[0]);
		for(int i = 1; i < objects.length; i++){
			if(ALowerOrEqualToB(first, objects[i]))
				return false;
		}
		return true;
	}

	/**
	 * Test that the first element is greater or equal to other elements of the list<br/>
	 * Accept that there is an other element with the same value in other position<br/>
	 * <i>Condition : elements are Numbers (primitive numbers or java.lang.Number)</i>
	 * 
	 * @param objects
	 * @throws EmptyException
	 * @throws NotNumberException
	 */
	public static Boolean firstGreaterOrEqualToOthers(Object... objects) throws EmptyException, NotNumberException{
		if(!areNumbers(objects))
			throw new NotNumberException("Some Objects given are not instance of java.lang.Number");
		
		Number first = NumberGenerator.getNumber(objects[0]);
		for(int i = 1; i < objects.length; i++){
			if(ALowerThanB(first, objects[i]))
				return false;
		}
		return true;
	}

	/**
	 * Test that the last element is greater than other elements of the list<br/>
	 * <i>Condition : elements are Numbers (primitive numbers or java.lang.Number)</i>
	 * 
	 * @param objects
	 * @throws EmptyException
	 * @throws NotNumberException
	 */
	public static Boolean latestGreaterThanOthers(Object... objects) throws EmptyException, NotNumberException{
		if(!areNumbers(objects))
			throw new NotNumberException("Some Objects given are not instance of java.lang.Number");
		
		Number latest = NumberGenerator.getNumber(objects[objects.length - 1]);
		for(int i = 0; i < objects.length - 1; i++){
			if(ALowerOrEqualToB(latest, objects[i]))
				return false;
		}
		return true;
	}

	/**
	 * Test that the last element is greater or equal to other elements of the list<br/>
	 * Accept that there is an other element with the same value in other position<br/>
	 * <i>Condition : elements are Numbers (primitive numbers or java.lang.Number)</i>
	 * 
	 * @param objects
	 * @throws EmptyException
	 * @throws NotNumberException
	 */
	public static Boolean latestGreaterOrEqualToOthers(Object... objects) throws EmptyException, NotNumberException{
		if(!areNumbers(objects))
			throw new NotNumberException("Some Objects given are not instance of java.lang.Number");
		
		Number latest = NumberGenerator.getNumber(objects[objects.length - 1]);
		for(int i = 0; i < objects.length - 1; i++){
			if(ALowerThanB(latest, objects[i]))
				return false;
		}
		return true;
	}

	/**
	 * Test that the element in the position POS is greater than other elements of the list<br/>
	 * <i>Condition : elements are Numbers (primitive numbers or java.lang.Number)</i>
	 * 
	 * @param position : start from 1
	 * @param objects
	 * @throws EmptyException
	 * @throws NotNumberException
	 * @throws PositionOutOfListException 
	 */
	public static Boolean positionXGreaterThanOthers(Integer position, Object... objects) throws EmptyException, NotNumberException, PositionOutOfListException{
		if(!areNumbers(objects))
			throw new NotNumberException("Some Objects given are not instance of java.lang.Number");
		if(position < 0 || position > objects.length)
			throw new PositionOutOfListException("The position is out of the list : position = " + position);
		
		Number nPosition = NumberGenerator.getNumber(objects[position - 1]);
		for(int i = 0; i < position; i++){
			if(ALowerOrEqualToB(nPosition, objects[i]))
				return false;
		}
		for(int i = position; i < objects.length; i++){
			if(ALowerOrEqualToB(nPosition, objects[i]))
				return false;
		}
		return true;
	}

	/**
	 * Test that the element in the position POS is greater or equal to other elements of the list<br/>
	 * <i>Condition : elements are Numbers (primitive numbers or java.lang.Number)</i>
	 * 
	 * @param position : start from 1
	 * @param objects
	 * @throws EmptyException
	 * @throws NotNumberException
	 * @throws PositionOutOfListException 
	 */
	public static Boolean positionXGreaterOrEqualToOthers(Integer position, Object... objects) throws EmptyException, NotNumberException, PositionOutOfListException{
		if(!areNumbers(objects))
			throw new NotNumberException("Some Objects given are not instance of java.lang.Number");
		if(position < 0 || position > objects.length)
			throw new PositionOutOfListException("The position is out of the list : position = " + position);
		
		Number nPosition = NumberGenerator.getNumber(objects[position - 1]);
		for(int i = 0; i < position; i++){
			if(ALowerThanB(nPosition, objects[i]))
				return false;
		}
		for(int i = position; i < objects.length; i++){
			if(ALowerThanB(nPosition, objects[i]))
				return false;
		}
		return true;
	}
	
	/**
	 * Test that the Object A is greater than B<br/>
	 * <i>Condition : A and B are Numbers (primitive numbers or java.lang.Number)</i>
	 * 
	 * @param A
	 * @param B
	 * @return
	 * @throws NotNumberException
	 */
	public static Boolean ALowerThanB(Object A, Object B) throws NotNumberException{
		Number varA = NumberGenerator.getNumber(A);
		Number varB = NumberGenerator.getNumber(B);
		
		return varA.doubleValue() < varB.doubleValue();
	}
	
	/**
	 * Test that the Object A is greater than or equal to B<br/>
	 * <i>Condition : A and B are Numbers (primitive numbers or java.lang.Number)</i>
	 * 
	 * @param A
	 * @param B
	 * @return
	 * @throws NotNumberException
	 */
	public static Boolean ALowerOrEqualToB(Object A, Object B) throws NotNumberException{
		Number varA = NumberGenerator.getNumber(A);
		Number varB = NumberGenerator.getNumber(B);
		
		return varA.doubleValue() <= varB.doubleValue();
	}

	/**
	 * Test that the first element is lower than other elements of the list<br/>
	 * <i>Condition : elements are Numbers (primitive numbers or java.lang.Number)</i>
	 * 
	 * @param objects
	 * @throws EmptyException
	 * @throws NotNumberException
	 */
	public static Boolean firstLowerThanOthers(Object... objects) throws EmptyException, NotNumberException{
		if(!areNumbers(objects))
			throw new NotNumberException("Some Objects given are not instance of java.lang.Number");
		
		Number first = NumberGenerator.getNumber(objects[0]);
		for(int i = 1; i < objects.length; i++){
			if(AGreaterOrEqualToB(first, objects[i]))
				return false;
		}
		return true;
	}

	/**
	 * Test that the first element is lower or equal to other elements of the list<br/>
	 * Accept that there is an other element with the same value in other position<br/>
	 * <i>Condition : elements are Numbers (primitive numbers or java.lang.Number)</i>
	 * 
	 * @param objects
	 * @throws EmptyException
	 * @throws NotNumberException
	 */
	public static Boolean firstLowerOrEqualToOthers(Object... objects) throws EmptyException, NotNumberException{
		if(!areNumbers(objects))
			throw new NotNumberException("Some Objects given are not instance of java.lang.Number");
		
		Number first = NumberGenerator.getNumber(objects[0]);
		for(int i = 1; i < objects.length; i++){
			if(AGreaterThanB(first, objects[i]))
				return false;
		}
		return true;
	}

	/**
	 * Test that the last element is lower than other elements of the list<br/>
	 * <i>Condition : elements are Numbers (primitive numbers or java.lang.Number)</i>
	 * 
	 * @param objects
	 * @throws EmptyException
	 * @throws NotNumberException
	 */
	public static Boolean latestLowerThanOthers(Object... objects) throws EmptyException, NotNumberException{
		if(!areNumbers(objects))
			throw new NotNumberException("Some Objects given are not instance of java.lang.Number");
		
		Number latest = NumberGenerator.getNumber(objects[objects.length - 1]);
		for(int i = 0; i < objects.length - 1; i++){
			if(AGreaterOrEqualToB(latest, objects[i]))
				return false;
		}
		return true;
	}

	/**
	 * Test that the last element is lower or equal to other elements of the list<br/>
	 * Accept that there is an other element with the same value in other position<br/>
	 * <i>Condition : elements are Numbers (primitive numbers or java.lang.Number)</i>
	 * 
	 * @param objects
	 * @throws EmptyException
	 * @throws NotNumberException
	 */
	public static Boolean latestLowerOrEqualToOthers(Object... objects) throws EmptyException, NotNumberException{
		if(!areNumbers(objects))
			throw new NotNumberException("Some Objects given are not instance of java.lang.Number");
		
		Number latest = NumberGenerator.getNumber(objects[objects.length - 1]);
		for(int i = 0; i < objects.length - 1; i++){
			if(AGreaterThanB(latest, objects[i]))
				return false;
		}
		return true;
	}

	/**
	 * Test that the element in the position POS is lower than other elements of the list<br/>
	 * <i>Condition : elements are Numbers (primitive numbers or java.lang.Number)</i>
	 * 
	 * @param position : start from 1
	 * @param objects
	 * @throws EmptyException
	 * @throws NotNumberException
	 * @throws PositionOutOfListException 
	 */
	public static Boolean positionXLowerThanOthers(Integer position, Object... objects) throws EmptyException, NotNumberException, PositionOutOfListException{
		if(!areNumbers(objects))
			throw new NotNumberException("Some Objects given are not instance of java.lang.Number");
		if(position < 0 || position > objects.length)
			throw new PositionOutOfListException("The position is out of the list : position = " + position);
		
		Number nPosition = NumberGenerator.getNumber(objects[position - 1]);
		for(int i = 0; i < position; i++){
			if(AGreaterOrEqualToB(nPosition, objects[i]))
				return false;
		}
		for(int i = position; i < objects.length; i++){
			if(AGreaterOrEqualToB(nPosition, objects[i]))
				return false;
		}
		return true;
	}

	/**
	 * Test that the element in the position POS is lower or equal to other elements of the list<br/>
	 * <i>Condition : elements are Numbers (primitive numbers or java.lang.Number)</i>
	 * 
	 * @param position : start from 1
	 * @param objects
	 * @throws EmptyException
	 * @throws NotNumberException
	 * @throws PositionOutOfListException 
	 */
	public static Boolean positionXLowerOrEqualToOthers(Integer position, Object... objects) throws EmptyException, NotNumberException, PositionOutOfListException{
		if(!areNumbers(objects))
			throw new NotNumberException("Some Objects given are not instance of java.lang.Number");
		if(position < 0 || position > objects.length)
			throw new PositionOutOfListException("The position is out of the list : position = " + position);
		
		Number nPosition = NumberGenerator.getNumber(objects[position - 1]);
		for(int i = 0; i < position; i++){
			if(AGreaterThanB(nPosition, objects[i]))
				return false;
		}
		for(int i = position; i < objects.length; i++){
			if(AGreaterThanB(nPosition, objects[i]))
				return false;
		}
		return true;
	}
	
	/**
	 * Test that the Object A is equal to B<br/>
	 * <i>Condition : A and B are Numbers (primitive numbers or java.lang.Number)</i>
	 * 
	 * @param A
	 * @param B
	 * @return
	 * @throws NotNumberException
	 */
	public static Boolean AEqualToB(Object A, Object B) throws NotNumberException{
		Number varA = NumberGenerator.getNumber(A);
		Number varB = NumberGenerator.getNumber(B);
		
		return varA.doubleValue() == varB.doubleValue();
	}

	/**
	 * Test that all elements of the list are equal<br/>
	 * <i>Condition : elements are Numbers (primitive numbers or java.lang.Number)</i>
	 * 
	 * @param objects
	 * @throws EmptyException
	 * @throws NotNumberException
	 */
	public static Boolean areEqual(Object... objects) throws EmptyException, NotNumberException{
		if(!areNumbers(objects))
			throw new NotNumberException("Some Objects given are not instance of java.lang.Number");
		
		Number first = NumberGenerator.getNumber(objects[0]);
		for(int i = 1; i < objects.length; i++){
			if(ADifferentFromB(first, objects[i]))
				return false;
		}
		return true;
	}
	
	/**
	 * Test that the Object A is different to B<br/>
	 * <i>Condition : A and B are Numbers (primitive numbers or java.lang.Number)</i>
	 * 
	 * @param A
	 * @param B
	 * @return
	 * @throws NotNumberException
	 */
	public static Boolean ADifferentFromB(Object A, Object B) throws NotNumberException{
		Number varA = NumberGenerator.getNumber(A);
		Number varB = NumberGenerator.getNumber(B);
		
		return varA.doubleValue() != varB.doubleValue();
	}

	/**
	 * Test that all elements of the list are different<br/>
	 * <i>Condition : elements are Numbers (primitive numbers or java.lang.Number)</i>
	 * 
	 * @param objects
	 * @throws EmptyException
	 * @throws NotNumberException
	 */
	public static Boolean areDifferentFromEachOthers(Object... objects) throws EmptyException, NotNumberException{
		if(!areNumbers(objects))
			throw new NotNumberException("Some Objects given are not instance of java.lang.Number");
		
		for(int i = 0; i < objects.length; i++){
			for(int j = i + 1; j < objects.length; j++){
				if(areEqual(objects[i], objects[j]))
					return false;
			}
		}
		return true;
	}
	
	/**
	 * Test that A is greater than B and lower than C<br/>
	 * B < A < C<br/>
	 * <i>Condition : elements are Numbers (primitive numbers or java.lang.Number)</i>
	 * 
	 * @param A
	 * @param B
	 * @param C
	 * @return
	 * @throws EmptyException
	 * @throws NotNumberException
	 * @throws NotBooleanException 
	 */
	public static Boolean ABetweenBAndC(Object A, Object B, Object C) throws EmptyException, NotNumberException, NotBooleanException{
		if(!areNumbers(A, B, C))
			throw new NotNumberException("Some Objects given are not instance of java.lang.Number");
		
		return LogicTestsUtils.and(AGreaterThanB(A, B), ALowerThanB(A, C));
	}
	
	/**
	 * Test that A is greater or Equal to B and lower than C<br/>
	 * B <= A < C<br/>
	 * <i>Condition : elements are Numbers (primitive numbers or java.lang.Number)</i>
	 * 
	 * @param A
	 * @param B
	 * @param C
	 * @return
	 * @throws EmptyException
	 * @throws NotNumberException
	 * @throws NotBooleanException 
	 */
	public static Boolean ABetweenBAndCOrEqualToB(Object A, Object B, Object C) throws EmptyException, NotNumberException, NotBooleanException{
		if(!areNumbers(A, B, C))
			throw new NotNumberException("Some Objects given are not instance of java.lang.Number");
		
		return LogicTestsUtils.and(AGreaterOrEqualToB(A, B), ALowerThanB(A, C));
	}
	
	/**
	 * Test that A is greater than B and lower or equal to C<br/>
	 * B < A <= C<br/>
	 * <i>Condition : elements are Numbers (primitive numbers or java.lang.Number)</i>
	 * 
	 * @param A
	 * @param B
	 * @param C
	 * @return
	 * @throws EmptyException
	 * @throws NotNumberException
	 * @throws NotBooleanException 
	 */
	public static Boolean ABetweenBAndCOrEqualToC(Object A, Object B, Object C) throws EmptyException, NotNumberException, NotBooleanException{
		if(!areNumbers(A, B, C))
			throw new NotNumberException("Some Objects given are not instance of java.lang.Number");
		
		return LogicTestsUtils.and(AGreaterThanB(A, B), ALowerOrEqualToB(A, C));
	}
	
	/**
	 * Test that A is greater or equal to B and lower or equal to C<br/>
	 * B <= A <= C<br/>
	 * <i>Condition : elements are Numbers (primitive numbers or java.lang.Number)</i>
	 * 
	 * @param A
	 * @param B
	 * @param C
	 * @return
	 * @throws EmptyException
	 * @throws NotNumberException
	 */
	public static Boolean ABetweenBAndCOrEqualToBAndC(Object A, Object B, Object C) throws EmptyException, NotNumberException{
		try{
			if(!areNumbers(A, B, C))
				throw new NotNumberException("Some Objects given are not instance of java.lang.Number");
			
			return LogicTestsUtils.and(AGreaterOrEqualToB(A, B), ALowerOrEqualToB(A, C));
		} catch(NotBooleanException unused){}
		return null;
	}
}
