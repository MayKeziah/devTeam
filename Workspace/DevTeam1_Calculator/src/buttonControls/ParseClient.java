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
		String test1 = "1x2/2+3+4x5-6-7x2";
		System.out.println("Test 1: \t" + InputParser.parse(test1));
		System.out.println("Solution 1:\t" + (1.0*2.0/2+3+4.0*5-6-7.0*2));
		

	}

}
