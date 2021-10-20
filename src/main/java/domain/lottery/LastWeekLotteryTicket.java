package domain.lottery;

import java.util.Set;

import service.lottery.LotteryService;

public class LastWeekLotteryTicket {
	public static final int MIN_NUMBER = 3;
	private final Set<LotteryNumber> lastWeekLotteryTicket;

	public LastWeekLotteryTicket(String[] lastWeekLotteryTicket) {
		this.lastWeekLotteryTicket = LotteryService.removeLotteryNumberOverlap(lastWeekLotteryTicket);
	}

	public int lotteryMatchCount(LotteryTicket lotteryTicket) {
		int count = 0;
		for (LotteryNumber lotteryNumber : this.lastWeekLotteryTicket) {
			count += lotteryMatch(lotteryNumber.getLotteryNumber(), lotteryTicket);
		}

		return validLotteryRank(count);
	}

	private int validLotteryRank(int count) {
		int validNumber = 0;
		if (count >= MIN_NUMBER) {
			validNumber = count;
		}
		return validNumber;
	}

	private int lotteryMatch(int lotteryNumber, LotteryTicket lotteryTicket) {
		return (int)lotteryTicket.getLottery()
			.stream()
			.map(LotteryNumber::getLotteryNumber)
			.filter(i -> lotteryNumber == i)
			.count();
	}

}
