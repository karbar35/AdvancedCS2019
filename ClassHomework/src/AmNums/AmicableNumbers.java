package AmNums;
import java.util.ArrayList;

public class AmicableNumbers {
	public static int allFactors(int input) {
		int sum = 0;
		for(int num = 1; num <= Math.sqrt(input); num++) {
			if((input % num == 0)) {
				sum += num;
				if (num != input / num) {
	                sum += (input / num);
	            }
			}

		}
		return sum-input;
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