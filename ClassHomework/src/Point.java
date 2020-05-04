
/******************************************************************************
 *  Compilation:  javac Point.java
 *  Execution:    java Point
 *  Dependencies: none
 *  
 *  An immutable data type for points in the plane.
 *  For use on Coursera, Algorithms Part I programming assignment.
 *
 ******************************************************************************/

import java.util.Comparator;
import edu.princeton.cs.algs4.StdDraw;

public class Point implements Comparable<Point> {

	private final int x; // x-coordinate of this point
	private final int y; // y-coordinate of this point

	/**
	 * Initializes a new point.
	 *
	 * @param x the <em>x</em>-coordinate of the point
	 * @param y the <em>y</em>-coordinate of the point
	 */
	public Point(int x, int y) {
		/* DO NOT MODIFY */
		this.x = x;
		this.y = y;
	}

	/**
	 * Draws this point to standard draw.
	 */
	public void draw() {
		/* DO NOT MODIFY */
		StdDraw.point(x, y);
	}

	/**
	 * Draws the line segment between this point and the specified point to standard
	 * draw.
	 *
	 * @param that the other point
	 */
	public void drawTo(Point that) {
		/* DO NOT MODIFY */
		StdDraw.line(this.x, this.y, that.x, that.y);
	}

	/**
	 * Returns the slope between this point and the specified point. Formally, if
	 * the two points are (x0, y0) and (x1, y1), then the slope is (y1 - y0) / (x1 -
	 * x0). For completeness, the slope is defined to be +0.0 if the line segment
	 * connecting the two points is horizontal; Double.POSITIVE_INFINITY if the line
	 * segment is vertical; and Double.NEGATIVE_INFINITY if (x0, y0) and (x1, y1)
	 * are equal.
	 *
	 * @param that the other point
	 * @return the slope between this point and the specified point
	 */
	public double slopeTo(Point that) {
		/* YOUR CODE HERE */
		if (this.y == that.y && this.x != that.x)
			return 0;
		if (this.x == that.x && this.y == that.y)
			return Double.NEGATIVE_INFINITY;
		else if (this.x == that.x && this.y != that.y)
			return Double.POSITIVE_INFINITY;
		else if (this.y == that.y)
			return 0;
		return ((double) this.y - (double) that.y) / ((double) this.x - (double) that.x);
	}

	/**
	 * Compares two points by y-coordinate, breaking ties by x-coordinate. Formally,
	 * the invoking point (x0, y0) is less than the argument point (x1, y1) if and
	 * only if either y0 < y1 or if y0 = y1 and x0 < x1.
	 *
	 * @param that the other point
	 * @return the value <tt>0</tt> if this point is equal to the argument point (x0
	 *         = x1 and y0 = y1); a negative integer if this point is less than the
	 *         argument point; and a positive integer if this point is greater than
	 *         the argument point
	 */
	public int compareTo(Point that) {
		/* YOUR CODE HERE */
		if (this.y < that.y) {
			return -1;
		} else if (this.y == that.y && this.x < that.x) {
			return -1;
		} else if (this.y == that.y && this.x == that.x) {
			return 0;
		} else {
			return 1;
		}
	}

	/**
	 * Compares two points by the slope they make with this point. The slope is
	 * defined as in the slopeTo() method.
	 *
	 * @return the Comparator that defines this ordering on points
	 */
	public Comparator<Point> slopeOrder() {
		/* YOUR CODE HERE */
		return new SlopeComparator(this);
	}

	private class SlopeComparator implements Comparator<Point> {
		Point invoking;

		public SlopeComparator(Point p) {
			invoking = p;
		}

		public int compare(Point p1, Point p2) {
			if (invoking.slopeTo(p1) < invoking.slopeTo(p2))
				return -1;
			else if (invoking.slopeTo(p1) == invoking.slopeTo(p2))
				return 0;
			else
				return 1;
		}

		public boolean equals(Point p) {
			if (invoking.x == p.x && invoking.y == p.y)
				return true;
			return false;
		}
	}

	/**
	 * Returns a string representation of this point. This method is provide for
	 * debugging; your program should not rely on the format of the string
	 * representation.
	 *
	 * @return a string representation of this point
	 */
	public String toString() {
		/* DO NOT MODIFY */
		return "(" + x + ", " + y + ")";
	}

	public static double methodA(double arg) {
		return arg + 1.5;
	}

	public static void adjust(double max, double min, double total, double n) {
		total = total - max - min;
		n = n - 2.0;
		System.out.println(total / n);
	}

	/**
	 * Unit tests the Point data type.
	 */

	public static String reverseString(String str) {

		String result = "";

		for(int i = str.length()-1; i >= 0; i--) {

		result = result + str.substring(i, i +1);

		}

		return result;

		}
	
	public static void longestStreak(String str) {

        int longStreak = 0;

        char longStreakChar = str.charAt(0);

        int streak = 0;

        char streakChar = str.charAt(0);

        for(int i = 0; i < str.length(); i++) {

                if(str.charAt(i) == streakChar) streak++;

                else {

                        if(streak > longStreak) {

                               longStreak = streak;

                               longStreakChar = streakChar;

                       }

                       streakChar = str.charAt(i);

                       streak = 0;

                        

                }

        }   
        System.out.println(longStreak);
        System.out.println(longStreakChar);


}

 

	
	public static void main(String[] args) {
		/* YOUR CODE HERE */
		String str = "1100000111";
		String segment = "00";
		String newSeq;
		
		double sum = 0.0;
		int a = 5;
		int b = 7;
		int[] n = new int[4];
		System.out.println(n[2]);
		
		
	}
}
