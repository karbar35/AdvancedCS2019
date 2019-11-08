package APCSWork;

import java.util.ArrayList;

public class AmicableNumbers {
	static ArrayList<Integer> checked = new ArrayList<Integer>();
	
	public static int allFactors(int a) {
		ArrayList<Integer> factorList = new ArrayList<Integer>();
		int sum = 0;
		for(int i = 1; i <= a/2; i++) {
			if((a % i == 0) && !factorList.contains(i)) {
				factorList.add(i);
				sum += i;
			}
			
		}
		
		return sum;
	}
	
	
	public static void main(String[] args) {
		ArrayList<String> amNums = new ArrayList<String>();
		for(int i = 1; i <= Math.pow(10,3); i++) {
			
			//System.out.println("loading");
			int y = allFactors(i);
			if((y == allFactors(y)) ) {
				amNums.add(i + " " + y);
			}
			checked.add(i);
			checked.add(y);

			
		}
		System.out.println(amNums);
	}
}
