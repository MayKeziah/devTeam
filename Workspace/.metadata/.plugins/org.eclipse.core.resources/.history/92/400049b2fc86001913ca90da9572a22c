package buttonControls;

import java.util.Arrays;

public class InputParser {
	String input;
	Double output;
	
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
	 * @param input an input string
	 * @return the product/quotient of the expression given.
	 */
	public static Double parseMultDiv(String input) {
		String[] inList = input.split("x");
		Double product = 1.0;
		for (String elt: inList) {
			if(!elt.contains("/")) {
				product *= parseExp(elt);//bad
			}else {
				String[] temp = elt.split("/");
				product *= parseExp(temp[0]);//Bad
				for(int i = 1; i < temp.length; i++) {
					product /= parseExp(temp[i]);//BAD
				}
			}
		}
		return product;
	}
	
	public static Double parseParenthesis(String input) {
		
		return null;
	}
	
	
	//BAD
	public static Double parseExp(String input) {
		String[] inList = input.split("\\^");
		Double base;
		Double solution = 1.0;
		Double currSolution;
		for (int i = 0; i < inList.length; i+=2) {
			base = Double.parseDouble(inList[i]);
			currSolution = 1.0;
			for (int j = 0; j < Integer.parseInt(inList[i + 1]); j++) {
				currSolution *= base;
			}
			solution += currSolution;
		}
		return solution;
	}

}
