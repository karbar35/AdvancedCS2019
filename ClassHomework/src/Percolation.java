
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
	private boolean[][] grid;
	private final int n;
	private final WeightedQuickUnionUF test;
	private final WeightedQuickUnionUF test2;

    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) {
    	if (n <= 0) throw new IllegalArgumentException();
    	grid = new boolean[n][n];
    	this.n = n;
    	test = new WeightedQuickUnionUF(n*n+2);
    	test2 = new WeightedQuickUnionUF(n*n+1);

    }

    // opens the site (row, col) if  it is not open already
    public void open(int row, int col) {
    	if (row <= 0 || col <= 0 || row > n || col > n) throw new IllegalArgumentException();
    	grid[row-1][col-1] = true; // opens in grid
    	
    	if (row == 1) test.union(0, (row-1)*n + col);
    	if (row == 1) test2.union(0, (row-1)*n + col);

    	if (row != 1) { // above block
    		if (grid[row-2][col-1]) {
    			test.union((row-2)*(n) + col, (row-1)*(n) + col);
    			test2.union((row-2)*(n) + col, (row-1)*(n) + col);

    		}
    	}
    	if (row != n) { // below block
    		if (grid[row][col-1]) {
    			test.union((row)*(n) + col, (row-1)*(n) + col);
    			test2.union((row)*(n) + col, (row-1)*(n) + col);

    		}
    	}
    	if (col != 1) { // left block
    		if (grid[row-1][col-2]) {
    			test.union((row-1)*(n) + col-1, (row-1)*(n) + col);
    			test2.union((row-1)*(n) + col-1, (row-1)*(n) + col);

    		}
    	}
    	if (col != n) { // right block
    		if (grid[row-1][col]) {
    			test.union((row-1)*(n) + col+1, (row-1)*(n) + col);
    			test2.union((row-1)*(n) + col+1, (row-1)*(n) + col);

    		}
    	}
    	if (row == n) test.union(n*n+1, (row-1)*n + col); // connect to bottom node

    	
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
    	if (row <= 0 || col <= 0 || row > n || col > n) throw new IllegalArgumentException();
    	
		return grid[row-1][col-1]; // checks in grid
    	
    }

    // is the site (row, col) full? full = connected to top
    public boolean isFull(int row, int col) {
    	if (row <= 0 || col <= 0 || row > n || col > n) throw new IllegalArgumentException();
    	// if (!isOpen(row, col)) return false;
    	 // backwash possible
    	return (test2.find((row-1)*n + col) == test2.find(0));
    	
//    	else { // backwash impossible
//    		return (test.find((row-1)*n + col) == test.find(0));
//    	}
    	// return (test.find((row-1)*n + col) == test.find(0) && test.find((row-1)*n + col) != test.find(n*n+1));
    	
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
    	int count = 0;
		for (boolean[] row : grid) {
			for (boolean num : row) {
				if (num) {
					count++;
				}
			}
		}
		return count;
    }

    // does the system percolate?
    public boolean percolates() {
    	return test.find(0) == test.find(n*n+1);
    }

    // test client (optional)
    public static void main(String[] args) {
    	// empty
    }
}
