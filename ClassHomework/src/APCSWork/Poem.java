package APCSWork;

public abstract class Poem {
	public abstract int numLines();
	public abstract int getSyllables(int k);
	public void printRhythm() {
		for(int i = 1; i <= this.numLines(); i++) {
			for(int j = 0; j < getSyllables(i)-1; j++) {
				System.out.print("ta-");
			}
			System.out.print("ta");
			System.out.println("");
		}
	}
	
	public static void main(String[] args) {
		Poem p = new Haiku();
		p.printRhythm();
		System.out.println("");
		Poem s = new Limerick();
		s.printRhythm();
	}
	
}
