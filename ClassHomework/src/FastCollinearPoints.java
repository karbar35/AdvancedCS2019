import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;

public class FastCollinearPoints {
	private ArrayList<LineSegment> segments = new ArrayList<LineSegment>();

	public FastCollinearPoints(Point[] points) {
		// corner cases
		if (points == null)
			throw new IllegalArgumentException();
		for (Point z : points) {
			if (z == null)
				throw new IllegalArgumentException();
			for (int j = 0; j < points.length; j++) {
				for (int k = j + 1; k < points.length; k++) {
					if (k != j && points[k].equals(points[j])) {
						throw new IllegalArgumentException();
					}
				}
			}
		}
		// finds all line segments containing 4 or more points
		// for(Point p : points) {
		Point[] copy1 = Arrays.copyOf(points, points.length);
		Point[] copy2 = Arrays.copyOf(points, points.length);
		Arrays.sort(copy1);

		ArrayList<Point> listOfPointsWithSlopes = new ArrayList<Point>();
		for (int i = 0; i < copy1.length; ++i) {
			Point p = copy1[i];
			Arrays.sort(copy2);
			Arrays.sort(copy2, p.slopeOrder());
			int numOfPoints = 1;
			Point lineBeginning = null;
			for (int j = 0; j < copy2.length - 1; ++j) {
				if (copy2[j].slopeTo(p) == copy2[j + 1].slopeTo(p)) {
					numOfPoints++;
					if (numOfPoints == 2) {
						lineBeginning = copy2[j];
						numOfPoints++;
					} else if (numOfPoints >= 4 && j + 1 == copy2.length - 1) {
						if (lineBeginning.compareTo(p) > 0) {
							segments.add(new LineSegment(p, copy2[j + 1]));
						}
						numOfPoints = 1;
					}
				} else if (numOfPoints >= 4) {
					if (lineBeginning.compareTo(p) > 0) {
						segments.add(new LineSegment(p, copy2[j]));
					}
					numOfPoints = 1;
				} else {
					numOfPoints = 1;
				}

			}
		}

	}

	public int numberOfSegments() {
		// the number of line segments
		return segments.size();
	}

	public LineSegment[] segments() {
		LineSegment[] returnable = new LineSegment[(segments.size())];
		for (int i = 0; i < segments.size(); i++) {
			returnable[i] = segments.get(i);
		}
		return returnable;
		// the line segments
	}

	private void sortPointList(ArrayList<Point> pointList) {

	}
}
