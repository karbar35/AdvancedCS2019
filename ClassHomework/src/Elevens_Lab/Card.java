package Elevens_Lab;

public class Card {
	private String rank;
	private String suit;
	private int pointValue;
	
	public Card(String rank, String suit, int point) {
		this.rank = rank;
		this.suit = suit;
		this.pointValue = point;

	}
	public String getRank() {
		return rank;
	}
	
	public String getSuit() {
		return suit;
	}
	
	
	public int getPointValue() {
		return pointValue;
	}
	
	public boolean equalsCard(Card c) {
		if(c.equals(this)) {
			return true;
		}
		return false;
	}
	
	public String toString() {
		return rank + " of " + suit + " (point value = " + pointValue + ")";
	}
}
