/**
 * This is a class that tests the Card class.
 */
package Elevens_Lab;
public class CardTester {

	/**
	 * The main method in this class checks the Card operations for consistency.
	 *	@param args is not used.
	 */
	public static void main(String[] args) {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 1 *** */
		Card c1 = new Card("one", "diamonds", 1);
		Card c2 = new Card("three", "clubs", 3);
		Card c3 = new Card("ace", "diamonds", 1);
		
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c3);
		
		System.out.println(c1.getSuit());
		System.out.println(c2.getSuit());
		System.out.println(c3.getSuit());

		System.out.println(c1.getRank());
		System.out.println(c2.getRank());
		System.out.println(c3.getRank());

		System.out.println(c1.getPointValue());
		System.out.println(c2.getPointValue());
		System.out.println(c3.getPointValue());


	}
}