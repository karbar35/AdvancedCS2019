import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {
	private static final double CONFIDENCE_95 = 1.96;
	private final double[] trialResults;
	    // perfor m independent trials on an n-by-n grid
	    public PercolationStats(int n, int trials) {
	    	if (n <= 0 || trials <= 0) throw new IllegalArgumentException();
	    	trialResults = new double[trials];
	    	for (int i = 0; i < trials; i++) {
	    		Percolation p = new Percolation(n);
	    		double count = 0;
	    		
	    		while (!p.percolates()) {
	    			int row = StdRandom.uniform(1, n+1);
	    			int col = StdRandom.uniform(1, n+1);
	    			if (p.isOpen(row, col)) {
	    				continue;
	    			} else {
	    				p.open(row, col);
	    				count += 1;
	    			}
	    			
	    				
	    			
	    		}
	    		trialResults[i] = count/(n*n);
	    	}
	    	
	    }

	    // sample mean of percolation threshold
	    public double mean() {
	    	return StdStats.mean(trialResults);
	    }

	    // sample standard deviation of percolation threshold
	    public double stddev() {
	    	return StdStats.stddev(trialResults);
	    }

	    // low endpoint of 95% confidence interval
	    public double confidenceLo() {
	    	return mean() - (CONFIDENCE_95 * stddev()/Math.sqrt(trialResults.length));
	    }

	    // high endpoint of 95% confidence interval
	    public double confidenceHi() {
	    	return mean() + (CONFIDENCE_95 * stddev()/Math.sqrt(trialResults.length));
	    }

	   // test client (see below)
	   public static void main(String[] args) {
		   int a = Integer.parseInt(args[0]);
		   int b = Integer.parseInt(args[1]);
		   
		   PercolationStats p = new PercolationStats(a, b);
		   System.out.println("mean: " + p.mean());
		   System.out.println("stddev: " + p.stddev());
		   System.out.println("95% confidence interval: [" + p.confidenceLo() + ", " + p.confidenceHi() + "]");
	   }

	
}
