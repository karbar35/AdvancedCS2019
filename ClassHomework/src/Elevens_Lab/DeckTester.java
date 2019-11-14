package Elevens_Lab;

public class DeckTester {
	public static void main(String[] args) {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 1 *** */
		String[] r1 = new String[] {"banana", "grape", "orange"};
		String[] s1 = new String[] {"pant", "shirt", "watch"};
		String[] r2 = new String[] {};
		String[] s2 = new String[] {};
		String[] r3 = new String[] {"purple", "green", "orange"};
		String[] s3 = new String[] {"jump", "skip", "laugh"};
		int[] p1 = new int[] {1, 2, 3};
		int[] p2 = new int[] {};
		int[] p3 = new int[] {6, 6, 81};
		
		Deck d1 = new Deck(r1, s1, p1);
		Deck d2 = new Deck(r2, s2, p2);
		Deck d3 = new Deck(r3, s3, p3);
		
		System.out.println(d1.size());
		System.out.println(d2.size());
		System.out.println(d3.size());
		
		System.out.println(d1.isEmpty());
		System.out.println(d2.isEmpty());
		System.out.println(d3.isEmpty());

		System.out.println(d1.deal());
		System.out.println(d2.deal());
		System.out.println(d3.deal());


	}
}
