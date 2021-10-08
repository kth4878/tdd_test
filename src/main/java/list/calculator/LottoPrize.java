package list.calculator;

import java.util.Arrays;
import java.util.function.UnaryOperator;

public enum LottoPrize {
	THREE(3,(a) -> a * 5000),
	FOUR(4,(a) -> a * 50000),
	FIVE(5,(a) -> a * 1500000),
	SIX(6,(a) -> a * 2000000000);

	public static final String RANK_ERROR_MESSAGE = "당첨 등수를 확인해주세요";
	private int winningNumber;
	private UnaryOperator<Integer> winningCount;

	LottoPrize(int rank, UnaryOperator<Integer> winningCount){
		this.winningNumber = rank;
		this.winningCount = winningCount;
	}

	public static int winningAmount(int winningNumber, int winningCount){
		return getRank(winningNumber).winningCount.apply(winningCount);
	}

	private static LottoPrize getRank(int winningNumber){
		return Arrays.stream(values())
			.filter(o -> o.winningNumber == winningNumber)
			.findFirst()
			.orElseThrow(() -> new IllegalArgumentException(RANK_ERROR_MESSAGE));
	}
}
