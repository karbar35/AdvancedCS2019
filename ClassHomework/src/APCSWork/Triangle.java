package APCSWork;

import java.util.ArrayList;

public class Triangle extends Polygon{
	public Triangle() {
		super(3, new ArrayList<Point>());
	}
	public Triangle(ArrayList<Point> coors) {
		super(3, coors);
	}

	public Triangle(Point a, Point b, Point c) {
		super(3, new ArrayList<Point>());
		super.addOneCoordinate(a.x, a.y);
		super.addOneCoordinate(b.x, b.y);
		super.addOneCoordinate(c.x, c.y);
		
	}
	
	@Override
	public double area() {
		// TODO Auto-generated method stub
		double base = 0; 
		return Math.abs((coordinates.get(0).x * 
				(coordinates.get(1).y - coordinates.get(2).y) 
				+ coordinates.get(1).x * (coordinates.get(2).y - 
				coordinates.get(0).y) + coordinates.get(2).x * 
				(coordinates.get(0).y - coordinates.get(1).y))/2);
	}

	@Override
	public boolean isEquilateral() {
		// TODO Auto-generated method stub
		
		return (distanceBetween(coordinates.get(0), coordinates.get(1)) == 
				distanceBetween(coordinates.get(0), coordinates.get(2))
				&& distanceBetween(coordinates.get(1), coordinates.get(2)) == 
				distanceBetween(coordinates.get(0), coordinates.get(1)));
	}
	
	private double distanceBetween(Point a, Point b) {
		
		return Math.sqrt((a.x -b.x) * (a.x -b.x) + 
				(a.y -b.y) * (a.y -b.y));
	}
	
	public static void main(String[] args) {
		
		Polygon t1 = new Triangle(new ArrayList<Point>());
		t1.addOneCoordinate(93, 2);
		t1.addOneCoordinate(2,93);
		t1.addOneCoordinate(1,1);
		System.out.println(t1.area());
		System.out.println(t1.isEquilateral());

		/*ArrayList<Point> coors = new ArrayList<Point>();
		coors.add(new Point(27,1));
		coors.add(new Point(3,0));
		coors.add(new Point(0,0));
		*/
		
		Polygon t2 = new Triangle(new Point(27,1), new Point(3,0), new Point(0,0));
		System.out.println(t2.area());
		System.out.println(t2.isEquilateral());

	}
}
