package org.yadi.refJ.test;

import java.math.*;

/**
 * 
 * @author Yassine Diouri
 *
 */
public class BigDecimalTestsUtils {
	
	/**
	 * 
	 * @param dec1 BigDecimal
	 * @param dec2 BigDecimal
	 * @return true if the two numbers are equal
	 */
	public static Boolean compareBigDecimalNumbersBasedOnTheLowestFractionalDigits(BigDecimal dec1, BigDecimal dec2){
		boolean c1 = dec1.scale() >= 0;
		boolean c2 = dec2.scale() >= 0;
		int fraction = 0;
		
		if (c1 && c2)
			fraction = dec1.scale() <= dec2.scale() ? dec1.scale() : dec2.scale();
		if (!c1 && c2)
			fraction = dec2.scale();
		if (c1 && !c2)
			fraction = dec1.scale();
		
		return dec1.setScale(fraction, RoundingMode.DOWN)
				.compareTo(dec2.setScale(fraction, RoundingMode.DOWN)) == 0 ? true : false;
	}
}
