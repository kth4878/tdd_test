package multiplication.domain;

import java.util.Objects;

public class NumberRange extends RuntimeException {
	private static final String RANGE_ERROR_MESSAGE = "구구단은 1부터 50까지 가능합니다.";
	private static final int MIN_NUMBER = 1;
	private static final int MAX_NUMBER = 50;
	private final int numberRange;

	public NumberRange(int number) {
		checkNumberLength(number);

		this.numberRange = number;
	}

	private void checkNumberLength(int number) {
		if (number < MIN_NUMBER && number > MAX_NUMBER) {
			throw new IllegalArgumentException(RANGE_ERROR_MESSAGE);
		}
	}

	public int getNumberRange() {
		return numberRange;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		NumberRange number1 = (NumberRange)o;
		return numberRange == number1.numberRange;
	}

	@Override
	public int hashCode() {
		return Objects.hash(numberRange);
	}
}
