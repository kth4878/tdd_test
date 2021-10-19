package list.view.lottery;

import list.domain.lottery.LotteryPrize;
import list.domain.lottery.LotteryRanking;
import list.domain.lottery.LotteryTicketCount;
import list.domain.lottery.LotteryTickets;

public class OutputView {

	private static final String BUY_LOTTERY_TICKET_MESSAGE = "수동으로 %d장, 자동으로 %d장 을 구매했습니다.%n";
	private static final String LOTTERY_TICKET_NUMBER_MESSAGE = "[%s]%n";
	private static final String WINNING_COUNT_LIST_MESSAGE = "당첨 통계";
	private static final String LINE_MESSAGE = "--------------------";
	private static final String LOTTERY_PRIZE_MESSAGE = "%d개 일치 (%d) - %d %n";
	private static final String REVENUE_MESSAGE = "총 수익률은 %.2f 입니다. (금액 대비 기준은 1 입니다.)";

	public static void buyLotteryTicket(LotteryTicketCount lotteryTicketCount) {
		System.out.printf(BUY_LOTTERY_TICKET_MESSAGE,
			lotteryTicketCount.getManualLotteryCount(), lotteryTicketCount.getAutomaticLotteryCount());
	}

	public static void lotteryTicket(LotteryTickets lotteryTickets) {
		for (int i = 0; i < lotteryTickets.size(); i++) {
			System.out.printf(LOTTERY_TICKET_NUMBER_MESSAGE, lotteryTickets.findLotteryTicketNumber(i));
		}
	}

	public static void resultWinning(LotteryRanking lotteryRanking) {
		System.out.println("");
		System.out.println(WINNING_COUNT_LIST_MESSAGE);
		System.out.println(LINE_MESSAGE);
		for (int key : lotteryRanking.keySet()) {
			System.out.printf(LOTTERY_PRIZE_MESSAGE, key, LotteryPrize.winningAmount(key, 1),
				lotteryRanking.countWinningNumber(key));
		}
	}

	public static void resultRevenue(double revenue) {
		System.out.printf(REVENUE_MESSAGE, revenue);
	}
}
