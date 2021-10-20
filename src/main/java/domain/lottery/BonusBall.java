package domain.lottery;

public class BonusBall {
	public static final int BONUS_BULL_CHECK_NUMBER = 5;
	private final int bonusBall;

	public BonusBall(int bonusBall) {
		this.bonusBall = bonusBall;
	}

	public int BonusBallMatch(int winningNumber, LotteryTicket lotteryTicket) {
		if (winningNumber == BONUS_BULL_CHECK_NUMBER) {
			return (int)lotteryTicket.getLottery()
				.stream()
				.map(LotteryNumber::getLotteryNumber)
				.filter(i -> bonusBall == i)
				.count();
		}
		return 0;
	}
}
