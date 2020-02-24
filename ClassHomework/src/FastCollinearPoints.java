import java.util.ArrayList;

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
			
			// finds all line segments containing 4 or more points
		//for(Point p : points) {
			
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
}
