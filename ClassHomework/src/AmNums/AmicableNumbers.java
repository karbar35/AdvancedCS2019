package AmNums;
import java.util.ArrayList;

public class AmicableNumbers {
	public static int allFactors(int a) {
		int sum = 0;
		for(int i = 1; i <= Math.sqrt(a); i++) {
			if((a % i == 0)) {
				sum += i;
				if (i != a / i) {
	                sum += (a / i);
	            }
			}

		}
		return sum-a;
	}

	public static void main(String[] args) {		
		long start = System.currentTimeMillis();

		ArrayList<Integer> checked = new ArrayList<Integer>();
		for(int i = 2; i <= Math.pow(10,6); i++) {

			int y = allFactors(i);
			if((i == allFactors(y)) && !checked.contains(i) && i != y && checked.contains(y)) {
				System.out.println(i + " : " + y);
			}
			checked.add(i);
			checked.add(y);

		}
		long end = System.currentTimeMillis();
		System.out.println(end-start);

	}
}