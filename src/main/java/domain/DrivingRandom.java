package domain;

import java.util.Random;

public class DrivingRandom {
	private static final Random random = new Random();
	private static final String HYPHEN = "-";
	private static final String EMPTY = "";
	private static final int VALID_NUMBER = 2;

	public DrivingRandom(){
	}

	public static String driving(){
		int number = random();
		if(number == 0){
			return EMPTY;
		}
		return HYPHEN;
	}

	private static int random(){
		return random.nextInt(VALID_NUMBER);
	}
}
