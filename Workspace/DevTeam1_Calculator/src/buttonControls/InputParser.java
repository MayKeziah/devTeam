package buttonControls;

/**
 * This class, given an input string of numbers and operators from a calculator, returns
 * a string representation of the mathematical result.
 * 
 * It can only handle:
 *  > Real numbers
 *  > Addition
 *  > Subtraction
 *  > Multiplication
 *  > Division
 * 
 * Example string:
 * "1x2/2+3+4x5-6-7x2"
 * Would return:
 * "4.0"
 * 
 * @author Keziah May
 * @version v.1 Spring 2019
 */
public class InputParser {
	
	/**
	 * Given an input string, this method will return a string 
	 * representation of the Double created by executing the 
	 * mathematical operations given.
	 * 
	 * @param input a string representing numbers and mathematical operators
	 * @return a string representing the result of those numbers and operators.
	 */
	public static String parse(String input) {
		return "" + parseAddSub(input);
	}
	
	/**
	 * Given an input string containing only expressions of addition
	 * and subtraction, this method will return the sum of these values as a double.
	 * 
	 * @param input an input String
	 * @return the sum of the expression given.
	 */
	private static Double parseAddSub(String input) {
		String[] inList = input.split("\\+");
		Double sum = 0.0;
		for (String elt: inList) {
			//for all the elements that are not subtracted, add them.
			if(!elt.contains("-")) {
					sum += parseMultDiv(elt);
			}
			//for all the elements that ARE subtracted, subtract them.
			else {
				String[] temp = elt.split("-");
					sum += parseMultDiv(temp[0]);
				for(int i = 1; i < temp.length; i++) {
						sum -= parseMultDiv(temp[i]);;
				}
			}
		}
		return sum;
	}
	
	/**
	 * Given an input string containing only expressions of Multiplication and
	 * division, this method will return the product/quotient of these values as a double.
	 * 
	 * @param input an input string
	 * @return the product/quotient of the expression given.
	 */
	private static Double parseMultDiv(String input) {
		String[] inList = input.split("x");
		Double product = 1.0;
		for (String elt: inList) {
			if(!elt.contains("/")) {
				product *= Double.parseDouble(elt);//bad
			}else {
				String[] temp = elt.split("/");
				product *= Double.parseDouble(temp[0]);//Bad
				for(int i = 1; i < temp.length; i++) {
					product /= Double.parseDouble(temp[i]);//BAD
				}
			}
		}
		return product;
	}

}
