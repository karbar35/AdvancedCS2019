import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {
	
	private Node head, tail;
    private int size = 0;
	
	private class Node {
        Item item;
        Node next;
        Node prev;
    }

    // construct an empty deque
    public Deque() {
    	head = new Node();
    	tail = new Node();
    	head.next = tail;
    	tail.prev = head;
    }

    // is the deque empty?
    public boolean isEmpty() {
    	return size == 0;
    }

    // return the number of items on the deque
    public int size() {
    	return size;
    }

    // add the item to the front
    public void addFirst(Item item) {
    	if(item == null) throw new IllegalArgumentException();
    	
    	Node n = new Node();
    	n.item = item;
    	
    	Node oldFirst = head.next;
    	n.next = oldFirst;
    	head.next = n;
    	oldFirst.prev = n;
    	n.prev = head;
    	
    	if (size < 0) {
    		System.out.println("something's wrong: negative size");
    	}
    	
    	size++;
    }

    // add the item to the back
    public void addLast(Item item) {
    	if(item == null) throw new IllegalArgumentException();

    	Node n = new Node();
    	n.item = item;
    	
    	Node oldLast = tail.prev;
    	oldLast.next = n;
    	n.next = tail;
    	tail.prev = n;
    	n.prev = oldLast;
    	
    	if (size < 0) {
    		System.out.println("something's wrong: negative size");
    	}
    	
    	size++;
    }

    // remove and return the item from the front
    public Item removeFirst() {
    	if (size == 0) throw new NoSuchElementException(); // does this stop the rest of the method?
    		Node returnable = head.next;
    		head.next = returnable.next;
    		returnable.next.prev = head;
    		size--;
    		return returnable.item;
    }

    // remove and return the item from the back
    public Item removeLast() {
    	if (size == 0) throw new NoSuchElementException(); // does this stop the rest of the method?
    		Node returnable = tail.prev;
    		tail.prev = returnable.prev;
    		returnable.prev.next = tail;
    		size--;
    		return returnable.item;
    }

    // return an iterator over items in order from front to back
    public Iterator<Item> iterator() {
    	return new ListIterator();
    }
    
    private class ListIterator implements Iterator<Item> {
        private Node current = head.next;

        public boolean hasNext() {
            return current != tail;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Item next()
        {
            if (current == tail) throw new NoSuchElementException();
            Item value = current.item;
            current = current.next;
            return value;
        }
    }
    
    // unit testing (required)
    public static void main(String[] args) {
    	Deque<Integer> testDeck = new Deque<Integer>();
    	System.out.println(testDeck.isEmpty());
    	System.out.println(testDeck.size());
    	
    	testDeck.addFirst(1);
    	testDeck.addFirst(7);
    	testDeck.addLast(3);
    	
    	System.out.println(testDeck.isEmpty());
    	System.out.println(testDeck.size());

    	System.out.println(testDeck.removeFirst());
    	System.out.println(testDeck.removeLast());

    	System.out.println(testDeck.isEmpty());
    	System.out.println(testDeck.size());

    }

}