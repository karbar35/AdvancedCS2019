package APCSWork;

public class City implements Place{
	private int x;
	public City(int x) {
		this.x = x; 
	} 
	public int getX() {
		return x; 
	}

	@Override
	public int distance(Place other) {
		// TODO Auto-generated method stub
		return Math.abs(this.getX() - ((City) other).getX());
	}
	public boolean sameDistance(Place p1, Place p2, Place p3) {
		return p1.distance(p2) == p1.distance(p3);
	}
	
	public static void main(String[] args) {
		City p1 = new City(0);
		City p2 = new City(-1);
		City p3 = new City(2);
		City test = new City(0); 
		System.out.println(test.sameDistance(p1, p2, p3));
	}
}
