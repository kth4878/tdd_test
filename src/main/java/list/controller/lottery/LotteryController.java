package list.controller.lottery;

import list.domain.lottery.LotteryRanking;
import list.domain.lottery.LotteryStore;
import list.domain.lottery.LotteryTicket;
import list.domain.lottery.LotteryTicketCount;
import list.domain.lottery.LotteryTickets;
import list.service.lottery.LotteryService;
import list.view.lottery.InputView;
import list.view.lottery.OutputView;

public class LotteryController {
	public void run(){
		InputView.lotteryPrice();
		LotteryStore lotteryStore = new LotteryStore(InputView.inputLotteryPurchasePrice());
		LotteryTicketCount lotteryTicketCount = new LotteryTicketCount(lotteryStore, InputView.inputManualLotteryCount());
		LotteryTickets lotteryTickets =
			LotteryService.issueLotteryTicket(InputView.inputManualLotteryNumbers(lotteryTicketCount), lotteryTicketCount);

		OutputView.buyLotteryTicket(lotteryTicketCount);

		OutputView.lotteryTicket(lotteryTickets);

		LotteryTicket lastWeekWinningNumber = LotteryService.lastWeekWinningNumber(InputView.inputLastWeekLotteryNumbers());

		LotteryRanking lotteryRanking = new LotteryRanking(LotteryService.lotteryRankingCount(lotteryTickets, lastWeekWinningNumber));

		OutputView.resultWinning(lotteryRanking);
		OutputView.resultRevenue(LotteryService.revenue(lotteryStore, lotteryRanking));
	}
}
