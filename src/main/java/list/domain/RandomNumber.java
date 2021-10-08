package list.domain;

import java.util.Random;

public class RandomNumber {
	private static final int MIN_NUMBER = 1;
	private static final int MAX_NUMBER = 45;
	private static final Random randomNumber = new Random();

	public RandomNumber() {
	}

	public static int randomResult() {
		return randomNumber.nextInt(MAX_NUMBER) + MIN_NUMBER;
	}
}
