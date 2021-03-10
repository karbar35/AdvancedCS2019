import java.util.ArrayList;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// 5YW3UZ6W
	// KD

	private Animal createNewAnimal(String name, String type, double age) {
		int countOfType = 0;
		int cost = 0;
		for(Animal a : allAnimals) {
			if(a.getType().equals(type)) {
				countOfType++;
			}
		}
		if(age < 1 && countOfType < 5) {
			cost = 25;
		} else if(age < 1 && countOfType >= 5) {
			cost = 20;
		} else {
			cost = 15;
		}
		
		return new Animal(name, type, age, cost);
		
	}
	
	public void addAnimal(String name, String type, double age) {
		int index = 0;
		
		for(int i = 0; i < allAnimals.size(); i++) {
			if(allAnimals.get(i).getAge() < age) {
				index++;
			} else {
				break;
			}
		}
		
		allAnimals.add(index, createNewAnimal(name, type, age));
		
	}
	
	/*
	 * To make this change, I would create a new public field in the 
	 * Animal class that records how many questions are asked about the 
	 * animal and is initially equal to 0. This field could be called "questionsAsked". There would also
	 * need to be a new method in the AnimalShelter class that increments
	 * this value up by 1 whenever a question is asked about the animal in the 
	 * allAnimals List. The field "questionsAsked" would be public so the
	 * AnimalShelter class can modify it. An alternative is to make the field
	 * private and use getter and setter methods to modify it.
	 * 
	 * If the programmer wants other classes to be able to see the
	 * animal with the most interest, the method header would look like this:
	 * public Animal getAnimalWithMostInterest()
	 * If they don't want other classes to have access, they would change
	 * the method to be private instead of public so only the Animal Shelter
	 * can have access. This method would traverse the allAnimals list to find
	 * the Animal with the most questions asked by comparing each animal's
	 * questionsAsked field.
	 */
	
	
	
	
	// 5YW3UZ6W
	// KD
	
	public static boolean wordChecker(String firstLetter, int maxLength, int n) {
		int goodWords = 0;
		int totalWords = n;
		
		for(int i = 0; i < n; i++) {
			String word = getWord();
			if(word.substring(0, 1).equals(firstLetter) && word.length <= maxLength) {
				goodWords++;
			}
		}
		
		if(((double)goodWords) / totalWords < 0.1) {
			return true;
		} else {
			return false;
		}
	}
	
	/*
	 * To make this change, I would create a new field in the WordTester
	 * class called threshold. This field would be a private double variable
	 * between 1 and 100 representing the percent of words that wordChecker 
	 * should use when determining whether to return true or false.
	 * 
	 * If the programmer would like to modify this threshold from outside the
	 * WordTester class, they can also implement a public setter method to 
	 * set the value of the private threshold field.
	 * 
	 * Inside the wordChecker method, instead of comparing the proportion of
	 * words that meet the condition to 0.1 (10%), I would compare it to 
	 * (threshold / 100.0), which is really the proportion represented by threshold.
	 * 
	 */
	
	
	
	
	
	
	
	
	
}
