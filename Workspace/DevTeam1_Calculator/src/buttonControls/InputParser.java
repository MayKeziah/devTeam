package buttonControls;

import java.util.Arrays;

public class InputParser {
	String input;
//	String output;
	
	public InputParser() {
		this("");
	}
	public InputParser(String input) {
		this.input = input;
//		this.output = parseMDAS();
	}
	
	/**
	 * Given an input string containing only expressions of addition
	 * and subtraction, this method will return the sum of these values as a double.
	 * @param input an input String
	 * @return the sum of the expression given.
	 */
	public static Double parseAddSub(String input) {
		String[] inList = input.split("\\+");
		Double sum = 0.0;
		System.out.println(Arrays.toString(inList));
		for (String elt: inList) {
			if(!elt.contains("-")) {
				sum += Double.parseDouble(elt);
			}else {
				String[] temp = elt.split("-");
				sum += Double.parseDouble(temp[0]);
				for(int i = 1; i < temp.length; i++) {
					sum -= Double.parseDouble(temp[i]);
				}
			}
		}
		return sum;
	}
	
	/**
	 * Given an input string containing only expressions of Multiplication and
	 * division, this method will return the product/quotient of these values as a double.
	 * @param input an input string
	 * @return the product/quotient of the expression given.
	 */
	public static Double parseMultDiv(String input) {
		String[] inList = input.split("\\*");
		Double product = 1.0;
		System.out.println(Arrays.toString(inList));
		for (String elt: inList) {
			if(!elt.contains("/")) {
				product *= Double.parseDouble(elt);
			}else {
				String[] temp = elt.split("/");
				product *= Double.parseDouble(temp[0]);
				for(int i = 1; i < temp.length; i++) {
					product /= Double.parseDouble(temp[i]);
				}
			}
		}
		return product;
	}
	
	public static Double exp(Double x, Double n) {
		Double product = 0.0;
		return product;
	}

}
