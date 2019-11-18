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
		return size == 0;
	}
	
	public int size() {
		return size;
	}
	
	public void shuffle() {
		// shuffle code
		Shuffler shuffler = new Shuffler();
		shuffler.selectionShuffle(this.cards);
		size = cards.size();
	}
	
	public Card deal() {
		if(size <= 0) return null;
		size--;
		return cards.get(size);
	}
	@Override
	public String toString() {
		String rtn = "size = " + size + "\nUndealt cards: \n";
		if(size != 0) {
		for (int k = size - 1; k >= 0; k--) {
			rtn = rtn + cards.get(k);
			if (k != 0) {
				rtn = rtn + ", ";
			}
			if ((size - k) % 2 == 0) {
				// Insert carriage returns so entire deck is visible on console.
				rtn = rtn + "\n";
			}
		}
		}

		rtn = rtn + "\nDealt cards: \n";
		for (int k = cards.size() - 1; k >= size; k--) {
			rtn = rtn + cards.get(k);
			if (k != size) {
				rtn = rtn + ", ";
			}
			if ((k - cards.size()) % 2 == 0) {
				// Insert carriage returns so entire deck is visible on console.
				rtn = rtn + "\n";
			}
		}

		rtn = rtn + "\n";
		return rtn;
	}
}


