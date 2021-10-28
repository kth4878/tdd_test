package domain;

import java.util.Random;

public class LadderRandom {
	private static final Random random = new Random();
	private static final int VALID_NUMBER_RANGE = 2;

	public LadderRandom(){
	}

	public static int random(){
		return random.nextInt(VALID_NUMBER_RANGE);
	}
}
