/**
 * 
 */
package buttonControls;

/**
 * @author E
 *
 */
public class ParseClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		InputParser test = new InputParser("1*2+3/4-5*6+7/8");
		String test1 = "1*2+3+4*5-6-7";
		System.out.println("Test 1: \t" + InputParser.parseAddSub(test1));
		System.out.println("Solution 1:\t" + (1*2+3+4*5-6-7));

	}

}
