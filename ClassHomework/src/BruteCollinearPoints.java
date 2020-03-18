import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class BruteCollinearPoints {
	private ArrayList<LineSegment> segments = new ArrayList<LineSegment>();

	public BruteCollinearPoints(Point[] points) {
		// checks argument validity
		if (points == null)
			throw new IllegalArgumentException();

		for (Point p : points) {
			if (p == null)
				throw new IllegalArgumentException();
		}
		for (int j = 0; j < points.length; j++) {
			for (int k = j + 1; k < points.length; k++) {
				if (k != j && points[k].equals(points[j])) {
					throw new IllegalArgumentException();
				}
			}
		}

		Point[] newPoints = points.clone(); /////////// change made here
		Arrays.sort(newPoints);
		// finds all line segments containing 4 points
		for (int i = 0; i < newPoints.length - 3; i++) {
			Point p = newPoints[i];
			for (int j = i + 1; j < newPoints.length - 2; j++) {
				Point q = newPoints[j];
				if (p.equals(q))
					continue;
				for (int k = j + 1; k < newPoints.length - 1; k++) {
					Point r = newPoints[k];
					if (q.equals(r))
						continue;
					for (int l = k + 1; l < newPoints.length; l++) {
						Point s = newPoints[l];
						if (r.equals(s))
							continue;
						// we now have 4 different points, p q r s

						if (p.slopeTo(q) == p.slopeTo(r) && p.slopeTo(q) == p.slopeTo(s)) {
							LineSegment temp1 = new LineSegment(p, s);
							LineSegment temp2 = new LineSegment(s, p);

							if (!segments.contains(temp1) && !segments.contains(temp2)) {
								segments.add(temp1);
							}
						}
					}
				}
			}
		}
	}

	public int numberOfSegments() {
		return segments.size();
		// the number of line segments
	}

	public LineSegment[] segments() {
		LineSegment[] returnable = new LineSegment[(segments.size())];
		for (int i = 0; i < segments.size(); i++) {
			returnable[i] = segments.get(i);
		}
		return returnable;
		// the line segments
	}
}