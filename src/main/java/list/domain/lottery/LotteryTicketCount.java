package list.domain.lottery;

import list.calculator.Calculation;

public class LotteryTicketCount {
	private static final String MANUAL_LOTTERY_ERROR_MESSAGE = "error : 구매한 복권개수보다 입력된 복권 개수가 많습니다.";
	private final int manualLotteryCount;
	private final int automaticLotteryCount;

	public LotteryTicketCount(LotteryStore lotteryStore, int manualLotteryCount) {
		checkLotteryTicketCount(lotteryStore, manualLotteryCount);
		this.manualLotteryCount = manualLotteryCount;
		this.automaticLotteryCount = automaticLotteryCalculation(lotteryStore.buyLottery(), manualLotteryCount);
	}

	private void checkLotteryTicketCount(LotteryStore lotteryStore, int manualLotteryCount){
		if(lotteryStore.buyLottery() < manualLotteryCount){
			throw new IllegalArgumentException(MANUAL_LOTTERY_ERROR_MESSAGE);
		}
	}

	private int automaticLotteryCalculation(int lotteryCount, int manualLotteryCount) {
		return Calculation.calculate("-", lotteryCount, manualLotteryCount);
	}

	public int getManualLotteryCount() {
		return manualLotteryCount;
	}

	public int getAutomaticLotteryCount() {
		return automaticLotteryCount;
	}
}
