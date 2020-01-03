package UnionFind;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class PercolationCode {
	int[] grid;
	int N;
	WeightedQuickUnionUF test;
    // creates n-by-n grid, with all sites initially blocked
    public PercolationCode(int n) {
    	if(n <= 0) throw new IllegalArgumentException();
    	grid = new int[n*n];
    	N = n;
    	test = new WeightedQuickUnionUF(n*n);
    	
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
    	if(row < 0 || col < 0) throw new IllegalArgumentException();
    	grid[(row-1)*(N) + col-1] = 1; // opens in grid
    	if(row == N/7) {
    		
    	}
    	if(row != 1) {
    		if(grid[(row-2)*(N) + col-1] == 1) {
    			test.union((row-2)*(N) + col-1, (row-1)*(N) + col-1);
    		}
    	}
    	if(row != N) {
    		if(grid[(row)*(N) + col-1] == 1) {
    			test.union((row)*(N) + col-1, (row-1)*(N) + col-1);
    		}
    	}
    	if(col != 1) {
    		if(grid[(row-1)*(N) + col-2] == 1) {
    			test.union((row-1)*(N) + col-2, (row-1)*(N) + col-1);
    		}
    	}
    	if(col != N) {
    		if(grid[(row-1)*(N) + col] == 1) {
    			test.union((row-1)*(N) + col, (row-1)*(N) + col-1);
    		}
    	}
    	
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
    	if(row < 0 || col < 0) throw new IllegalArgumentException();
		return grid[(row-1)*(N) + col-1] == 1; // checks in grid
    	
    }

    // is the site (row, col) full? full = connected to top
    public boolean isFull(int row, int col) {
    	if(row < 1 || col < 1) throw new IllegalArgumentException();
    	for(int i = 0; i < N; i++) {
    		if(test.find((row-1)*(N) + col-1) == test.find(i)) {
    			return true;
    		}
    	}
		return false;
    	
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
    	int count = 0;
		for(int num : grid) {
			if(num == 1) {
				count++;
			}
		}
		return count;
 
    }

    // does the system percolate?
    public boolean percolates() {
    	for(int i = 0; i < N; i++) {
    		for(int j = N*N-N; j < N*N; j++) {
    			if(test.find(i) == test.find(j)) return true;
    		}
    	}
		return false;
    	
    }

    // test client (optional)
    public static void main(String[] args) {
    	PercolationCode ptest = new PercolationCode(10);
    }
}
