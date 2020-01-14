import java.util.Iterator;
import edu.princeton.cs.algs4.StdRandom;

public class RandomizedQueue<Item> implements Iterable<Item> {
	private int size = 0;
    private Item[] randomizedQueueList;
    
    // construct an empty randomized queue
	public RandomizedQueue() {    	
    	randomizedQueueList = (Item[]) new Object[1]; 
    }

    // is the randomized queue empty?
    public boolean isEmpty() {
    	return size == 0;
    }

    // return the number of items on the randomized queue
    public int size() {
    	return size;
    }

    // add the item
    public void enqueue(Item item) {
    	if(item == null) throw new IllegalArgumentException();
    	
    	if(size == randomizedQueueList.length) resize(randomizedQueueList.length * 2);
    	
    	randomizedQueueList[size] = item;
    	
    	size++;
    }

    // remove and return a random item
    public Item dequeue() {
    	if(size <= 0) throw new java.util.NoSuchElementException();
    	
    	int indexToRemove = (int) (StdRandom.uniform() * size());
    	Item N = randomizedQueueList[indexToRemove];
    	randomizedQueueList[indexToRemove] = null;
    	randomizedQueueList[indexToRemove] = randomizedQueueList[size-1];
    	randomizedQueueList[size-1] = null;
    	size--;
    	if(size > 0 && size == randomizedQueueList.length/4) resize(randomizedQueueList.length/2);
    	
    	return N;
    	
    }

    // return a random item (but do not remove it)
    public Item sample() {
    	if(size <= 0) throw new java.util.NoSuchElementException();
    	
    	int indexToChoose = (int) (StdRandom.uniform() * size());
    	return randomizedQueueList[indexToChoose];
    }

    // return an independent iterator over items in random order
    public Iterator<Item> iterator() {
    	return new RandomIterator();
    }
    
    private class RandomIterator implements Iterator<Item> {
    	
		Item[] iteratorCopy;
		int iterated = 0;
		
		public RandomIterator() { 
		// copies queue into iterator copy array
			iteratorCopy = (Item[]) new Object[size];
			for (int i = 0; i < size; i++) {
	    		iteratorCopy[i] = randomizedQueueList[i];
	    	}
			
			StdRandom.shuffle(iteratorCopy);
		}
		
        public boolean hasNext() {
            return iterated < iteratorCopy.length;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Item next()
        {
        	if (iterated == iteratorCopy.length) throw new java.util.NoSuchElementException();
        	return iteratorCopy[iterated++];       	
        	
        }
    }

    // unit testing (required)
	public static void main(String[] args) {
    	RandomizedQueue<Integer> testDeck = new RandomizedQueue<Integer>();
    	System.out.println("empty: " + testDeck.isEmpty());
    	System.out.println("size: " + testDeck.size());
    	
    	testDeck.enqueue(1);
    	testDeck.enqueue(7);
    	testDeck.enqueue(3);
    	Iterator<Integer> l1 = testDeck.iterator();
    	while (l1.hasNext()) {
    		System.out.print(l1.next() + ", ");
    	}
    	System.out.println("done");

    	System.out.println("empty: " + testDeck.isEmpty());
    	System.out.println("size: " + testDeck.size());

    	System.out.println(testDeck.dequeue());
    	System.out.println(testDeck.dequeue());

    	System.out.println("empty: " + testDeck.isEmpty());
    	System.out.println("size: " + testDeck.size());
    }
    
    private void resize(int capacity) {
		Item[] copy = (Item[]) new Object[capacity];
    	for (int i = 0; i < size; i++) {
    		copy[i] = randomizedQueueList[i];
    	}
    	randomizedQueueList = copy;
    }

}