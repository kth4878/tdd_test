package domain.lottery;

import java.util.Arrays;

public enum LotteryRankCalculation {
	FIRST_RANK(6, 0, 1),
	SECOND_RANK(5, 1, 2),
	THIRD_RANK(5, 0, 3),
	FOURTH_RANK(4, 0, 4),
	FIFTH_RANK(3, 0, 5),
	ZERO(0, 0, 0);

	private static final String RANK_ERROR_MESSAGE = "error : 당첨 개수를 확인해주세요";
	private int winningNumber;
	private int bonusBall;
	private int ranking;

	LotteryRankCalculation(int winningNumber, int bonusBall, int ranking) {
		this.winningNumber = winningNumber;
		this.bonusBall = bonusBall;
		this.ranking = ranking;
	}

	public static int ranking(int winningNumber, int bonusBall) {
		return getRanking(winningNumber, bonusBall).ranking;
	}

	private static LotteryRankCalculation getRanking(int winningNumber, int bonusBall) {
		return Arrays.stream(values())
			.filter(o -> o.winningNumber == winningNumber && o.bonusBall == bonusBall)
			.findFirst()
			.orElseThrow(() -> new IllegalArgumentException(RANK_ERROR_MESSAGE));
	}
}
