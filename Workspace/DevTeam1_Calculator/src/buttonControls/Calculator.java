/**
 * 
 */
package buttonControls;

/**
 * @author E
 *
 */
public interface Calculator {
	public double add(double a, double b);
	public double subtract(double a, double b);
	public double multiply(double a, double b);
	public double divide(double a, double b);
//	public double exponent(double a, double b);
	public double parenthesis(String a);
}