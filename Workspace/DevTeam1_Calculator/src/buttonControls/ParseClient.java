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
		InputParser test = new InputParser("1+2+3+4-5-6-7");
		System.out.println(InputParser.parseAddSub("1+2+3+4-5-6-7"));
		System.out.println("" + (1+2+3+4-5-6-7));
		
		System.out.println(InputParser.parseMultDiv("1*2*3*4/5/6/7"));
		System.out.println("" + (1.0*2*3*4/5/6/7));

	}

}
