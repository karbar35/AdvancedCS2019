import java.util.ArrayList;
import java.util.List;

public class Test {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> s = new ArrayList<String>();
		s.add("a");
		s.add("b");
		s.add("c");
		System.out.println(s.set(0, "f"));

		
	}
	
	public static int arraySum(int[] arr) {
		int total = 0;
		for(int e : arr) {
			total += e;
		}
		return total;
	}
	
	public static int[] rowSums(int[][] arr2D) {
		int[] returnable = new int[arr2D.length];
		for(int i = 0; i < arr2D.length; i++) {
			returnable[i] = arraySum(arr2D[i]);
		}
		return returnable;
	}
	
	
	public static boolean isDiverse(int[][] arr2D) {
		int[] sums = rowSums(arr2D);
		for(int i = 0; i < sums.length; i++) {
			for(int j = i; j < sums.length; j++) {
				if(sums[i] == sums[j]) {
					return false;
				}
			}
		}
		return true;
	}
	
	 public int getValueAt(int row, int col) {
		 for(SparseArrayEntry entry : entries) {
			 if(entry.getRow() == row && entry.getCol() == col) {
				 return entry.getValue();
			 }
		 }
	 }
	 
	 public void removeColumn(int col) {
		 for(SparseArrayEntry entry : entries) {
			 if(entry.getCol() == col) {
				 entries.remove(entry);
			 } else if(entry.getCol() > col) {
				 entries.add(new SparseArrayEntry(entry.getRow(), entry.getCol()-1, entry.getValue()));
				 entries.remove(entry);
			 }
		 }
		 numCols--;
	 }
}
