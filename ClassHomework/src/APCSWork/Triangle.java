package APCSWork;

import java.util.ArrayList;

public class Triangle extends Polygon{
	public Triangle() {
		super(3, new ArrayList<Point>());
	}
	public Triangle(ArrayList<Point> coors) {
		super(3, coors);
	}

	
	public double area() {
		// TODO Auto-generated method stub
		double base = 0; 
		Point a = coordinates.get(0);
		Point b = coordinates.get(1);
		Point c = coordinates.get(2);

		return Math.abs(((a.x * (b.y - c.y) + b.x * (c.y - a.y) + c.x * (a.y - b.y))) / 2);
	}

	@Override
	public boolean isEquilateral() {
		// TODO Auto-generated method stub
		Point a = coordinates.get(0);
		Point b = coordinates.get(1);
		Point c = coordinates.get(2);
		return (distanceBetween(a,b) == distanceBetween(a,c) && distanceBetween(b,c)==distanceBetween(a,c));
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
		
		Polygon t2 = new Triangle();
		System.out.println(t2.area());
		System.out.println(t2.isEquilateral());

	}
}
