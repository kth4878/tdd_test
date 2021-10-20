package domain.lottery;

import java.util.Arrays;
import java.util.function.UnaryOperator;

public enum LotteryPrize {
	FIRST_RANK_PRIZE(1, (a) -> a * 2_000_000_000),
	SECOND_RANK_PRIZE(2, (a) -> a * 30_000_000),
	THIRD_RANK_PRIZE(3, (a) -> a * 1_500_000),
	FOURTH_RANK_PRIZE(4, (a) -> a * 50_000),
	FIFTH_RANK_PRIZE(5, (a) -> a * 5_000),
	ZERO(0, (a) -> 0);

	private static final String RANK_ERROR_MESSAGE = "error : 당첨 등수를 확인해주세요";
	private int rank;
	private UnaryOperator<Integer> count;

	LotteryPrize(int rank, UnaryOperator<Integer> winningCount) {
		this.rank = rank;
		this.count = winningCount;
	}

	public static int winningAmount(int rank, int count) {
		return getRank(rank).count.apply(count);
	}

	private static LotteryPrize getRank(int rank) {
		return Arrays.stream(values())
			.filter(o -> o.rank == rank)
			.findFirst()
			.orElseThrow(() -> new IllegalArgumentException(RANK_ERROR_MESSAGE));
	}
}
