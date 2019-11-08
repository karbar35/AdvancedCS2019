package APCSWork;

public class Haiku extends Poem{

	@Override
	public int numLines() {
		// TODO Auto-generated method stub
		return 3;
	}

	@Override
	public int getSyllables(int k) {
		// TODO Auto-generated method stub
		if(k == 1) {
			return 5;
		} else if(k == 2) {
			return 7;
		} else if(k == 3) {
			return 5;
		}
		return -1;
	}

}
