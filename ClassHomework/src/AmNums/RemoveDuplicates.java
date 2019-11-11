package AmNums;

import java.util.ArrayList;

public class RemoveDuplicates {
	public static void removeDuplicates(ArrayList<String> list) {
		ArrayList<String> compareList = new ArrayList<String>();
		for(int i = 0; i < list.size(); i++) {
			if(!compareList.contains(list.get(i))) {
				compareList.add(list.get(i));
			} else {
				list.remove(i);
				i--;
			}
		}
	}
	
	public static void main(String[] args) {
		ArrayList<String> testList = new ArrayList<String>();
		testList.add("banana");
		testList.add("grape");
		testList.add("banana");
		testList.add("orange");
		testList.add("lime");
		testList.add("banana");
		testList.add("grape");
		testList.add("banana");
		testList.add("passionfruit");
		testList.add("ginger");
		testList.add("garlic");
		testList.add("garlic");

		System.out.println(testList);
		
		removeDuplicates(testList);
		System.out.println("Removing duplicates");

		System.out.println(testList);


	}
}
