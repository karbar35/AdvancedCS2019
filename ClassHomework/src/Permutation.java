import java.util.Iterator;

import edu.princeton.cs.algs4.StdIn;

public class Permutation {
public static void main(String[] args) {
	RandomizedQueue<String> r = new RandomizedQueue<String>();
	   int k = Integer.parseInt(args[0]);
	   while(!StdIn.isEmpty()) {
		   r.enqueue(StdIn.readString());
	   }
	Iterator<String> it = r.iterator();
	   for(int i = 0; i < k; i++) {
		   System.out.println(it.next());
	   }
   }
   
}