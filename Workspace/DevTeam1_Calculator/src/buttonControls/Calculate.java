/**
 * 
 */
package buttonControls;

/**
 * @author E
 *
 */
public class Calculate implements Calculator{

	@Override
	public double add(double a, double b) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double subtract(double a, double b) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double multiply(double a, double b) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double divide(double a, double b) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	/**
	 * This is an exponent method which takes a real number and an integer and raises
	 * the number to the integer power. 
	 * @param x the number to multiply
	 * @param n the power to raise x to. 
	 * @return x^n
	 */
	public static Double exp(Double x, int n) {
		Double product = 1.0;
		for (int i = 0; i < n; i++) {
			product *= x;
		}
		
		return product;
	}

	@Override
	public double parenthesis(String a) {
		// TODO Auto-generated method stub
		return 0;
	}

}
