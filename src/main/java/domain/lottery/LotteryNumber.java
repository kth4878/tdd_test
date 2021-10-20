package domain.lottery;

public class LotteryNumber {
	private static final String NUMBER_ERROR_MESSAGE = "error : 입력가능한 숫자가 아닙니다.";
	private static final int MIN_NUMBER = 1;
	private static final int MAX_NUMBER = 45;
	private final int lotteryNumber;

	public LotteryNumber(int lotteryNumber) {
		checkLotteryNumber(lotteryNumber);
		this.lotteryNumber = lotteryNumber;
	}

	private void checkLotteryNumber(int lotteryNumber) {
		if (lotteryNumber < MIN_NUMBER || lotteryNumber > MAX_NUMBER) {
			throw new IllegalArgumentException(NUMBER_ERROR_MESSAGE);
		}
	}

	public int getLotteryNumber() {
		return lotteryNumber;
	}
}
