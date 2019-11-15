package Elevens_Lab;

import java.util.ArrayList;

public class Deck {
	private ArrayList<Card> cards = new ArrayList<Card>();
	private int size;
	
	public Deck(String[] ranks, String[] suits, int[] pointValues) {
		for(String suit : suits) {
			for(int i = 0; i < suits.length; i++) {
				cards.add(new Card(ranks[i], suit, pointValues[i]));
			}
		}
		size = cards.size();
		/// shuffle 
		
		this.shuffle();
	}
	
	public boolean isEmpty() {
		return cards.size() == 0;
	}
	
	public int size() {
		return size;
	}
	
	public void shuffle() {
		// shuffle code
		Shuffler shuffler = new Shuffler();
		
		size = cards.size();
	}
	
	public Card deal() {
		size--;
		if(size < 0) return null;
		return cards.get(size);
	}
}
