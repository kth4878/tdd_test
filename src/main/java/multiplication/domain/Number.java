package multiplication.domain;

import java.util.Objects;

public class Number extends RuntimeException {
	private static final String RANGE_ERROR_MESSAGE = "구구단은 1부터 50까지 가능합니다.";
	private static final int MIN_NUMBER = 1;
	private static final int MAX_NUMBER = 50;
	private final int number;

	public Number(int number) {
		checkNumberLength(number);

		this.number = number;
	}

	private void checkNumberLength(int number) {
		if (number < MIN_NUMBER && number > MAX_NUMBER) {
			throw new IllegalArgumentException(RANGE_ERROR_MESSAGE);
		}
	}

	public int getNumber() {
		return number;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Number number1 = (Number)o;
		return number == number1.number;
	}

	@Override
	public int hashCode() {
		return Objects.hash(number);
	}
}
