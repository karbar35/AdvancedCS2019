import java.util.ArrayList;
import java.util.Comparator;

public class BruteCollinearPoints {
	private ArrayList<LineSegment> segments = new ArrayList<LineSegment>();

	public BruteCollinearPoints(Point[] points) {
		// finds all line segments containing 4 points
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
		for (Point p : points) {
			for (Point q : points) {
				Comparator<Point> comparator = p.slopeOrder();
				if (p.x == q.x && p.y == q.y)
					continue;
				for (Point r : points) {
					Comparator<Point> comparator2 = q.slopeOrder();
					if (comparator.equals(r))
						continue;
					for (Point s : points) {
						Comparator<Point> comparator3 = r.slopeOrder();
						if (comparator.equals(s))
							continue;

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