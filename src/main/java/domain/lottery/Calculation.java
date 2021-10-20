package domain.lottery;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Calculation {
	PLUS("+", (a, b) -> a + b),
	MINUS("-", (a, b) -> a - b),
	MULTIPLE("*", (a, b) -> a * b),
	DIVIDE("/", (a, b) -> {
		validToDivideByZero(b);
		return a / b;
	});

	public static final String OPERATOR_ERROR_MESSAGE = "올바른 연산자가 아닙니다.";
	public static final String DIVIDE_ERROR_MESSAGE = "0으로 나눗셈은 불가능 합니다.";
	private String operator;
	private BiFunction<Integer, Integer, Integer> calculateValue;

	Calculation(String operator, BiFunction<Integer, Integer, Integer> calculateValue) {
		this.operator = operator;
		this.calculateValue = calculateValue;
	}

	public static int calculate(String operator, int firstValue, int lastValue) {
		return getOperator(operator).calculateValue.apply(firstValue, lastValue);
	}

	private static Calculation getOperator(String operator) {
		return Arrays.stream(values())
			.filter(o -> o.operator.equals(operator))
			.findFirst()
			.orElseThrow(() -> new IllegalArgumentException(OPERATOR_ERROR_MESSAGE));
	}

	private static void validToDivideByZero(Integer lastValue) {
		if (lastValue == 0) {
			throw new IllegalArgumentException(DIVIDE_ERROR_MESSAGE);
		}
	}
}
