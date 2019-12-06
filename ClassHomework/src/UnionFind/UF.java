package UnionFind;

import java.io.File;
import java.util.Scanner;

public class UF {
	
	int N = 0;
	int[] id;
	
	public UF(int elements) {
		N = elements;
		id = new int[N];
		for(int i = 0; i < id.length; i++) {
			id[i] = i;
		}
	}
	
	public void union(int p, int q) {
		/*
		 * stem means an id that doesn't equal its index
		 * root means an id which does equal its index
		 */
		if(id[p] != p && id[q] == q /*stem and root*/) {
			//id[q] = id[p]; //root id = stem id
			for(int i = 0; i < id.length; i++) {
				if(id[i] == q) {
					id[i] = id[p];
				}
			}
		} else if(id[p] == p && id[q] == q/*root and root*/) {			
			//id[p] = q;
			for(int i = 0; i < id.length; i++) {
				if(id[i] == p) {
					id[i] = q;
				}
			}
		} else if(id[p] == p && id[q] != q/*root and stem*/) {
			//id[p] = id[q]; //id of root = id of stem
			for(int i = 0; i < id.length; i++) {
				if(id[i] == p) {
					id[i] = id[q];
				}
			}
		} else if(id[p] != p && id[q] != q/*stem and stem*/) {
			for(int i = 0; i < id.length; i++) {
				if(id[i] == id[q]) {
					id[i] = id[p];
				}
			}
		} else {
			System.out.println("Whoops");
		}
		
	}
	
	public boolean connected(int p, int q) {
		
		return id[p] == id[q];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			Scanner s = new Scanner(new File("tinyText.txt"));
			int N = s.nextInt();
			System.out.println("N = " + N);
			UF tester = new UF(N);
			while(s.hasNext()) {
				int p = s.nextInt();
				int q = s.nextInt();
				
				tester.union(p, q);
				System.out.println("Pair: [" + p + ", " + q + "]");
			}
			s.close();
			System.out.println("");
			System.out.println("Results:");

			System.out.println("Connected(4, 3): " + tester.connected(4, 3));
			System.out.println("Connected(1, 2): " + tester.connected(1, 2));
			System.out.println("Connected(8, 4): " + tester.connected(8, 4));
			System.out.println("Connected(6, 0): " + tester.connected(6, 0));
			System.out.println("Connected(4, 7): " + tester.connected(4, 7));
			System.out.println("Connected(2, 2): " + tester.connected(2, 2));
			System.out.println("Connected(0, 9): " + tester.connected(0, 9));
			System.out.println("Connected(6, 1): " + tester.connected(6, 1));
			for(int i = 0; i < 10; i++) {
				int testint1 = (int) (Math.random() * 10);
				int testint2 =  (int) (Math.random() * N);

				System.out.println("Connected("+ testint1 + ", " + testint2 +"): " + tester.connected(testint1, testint2));

			}

 		} catch(Exception e) {
 			System.out.println("File opening issue");
 		}
	}

}
