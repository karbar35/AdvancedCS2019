package Elevens_Lab;

public class Card {
	private final int DIAMOND = 101;
	private final int HEART = 102;
	private final int CLUB = 103;
	private final int SPADE = 104;
	

	private String rank;
	private String suit;
	private boolean face;
	
	public Card(String rank, String suit) {
		this.rank = rank;
		this.suit = suit;
	}
	public String getRank() {
		return rank;
	}
	
	public String getSuit() {
		return suit;
	}
	
	public boolean isFace() {
		return face;
	}
	
	public boolean equalsCard(Card c) {
		if(c.equals(this)) {
			return true;
		}
		return false;
	}
}
