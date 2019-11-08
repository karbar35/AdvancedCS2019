package APCSWork;

public class Limerick extends Poem{

	@Override
	public int numLines() {
		// TODO Auto-generated method stub
		return 5;
	}

	@Override
	public int getSyllables(int k) {
		// TODO Auto-generated method stub
		if(k == 1) {
			return 9;
		} else if(k == 2) {
			return 9;
		} else if(k == 3) {
			return 6;
		} else if(k == 4) {
			return 6;
		} else if(k == 5) {
			return 9;
		}
		return -1;
	}

}
