package controller.lottery;

import domain.lottery.BonusBall;
import domain.lottery.LastWeekLotteryTicket;
import domain.lottery.LotteryRank;
import domain.lottery.LotteryStore;
import domain.lottery.LotteryTicketCount;
import domain.lottery.LotteryTickets;
import service.lottery.LotteryService;
import view.lottery.InputView;
import view.lottery.OutputView;

public class LotteryController {
	public void run(){
		InputView.lotteryPrice();
		LotteryStore lotteryStore = new LotteryStore(InputView.inputLotteryPurchasePrice());
		LotteryTicketCount lotteryTicketCount = new LotteryTicketCount(lotteryStore, InputView.inputManualLotteryCount());
		LotteryTickets lotteryTickets =
			LotteryService.issueLotteryTicket(InputView.inputManualLotteryNumbers(lotteryTicketCount), lotteryTicketCount);

		OutputView.buyLotteryTicket(lotteryTicketCount);

		OutputView.lotteryTicket(lotteryTickets);

		LastWeekLotteryTicket lastWeekWinningNumber = LotteryService.lastWeekWinningNumber(InputView.inputLastWeekLotteryNumbers());
		BonusBall bonusBall = new BonusBall(InputView.inputBonusBall());

		LotteryRank lotteryRank = new LotteryRank(
				LotteryService.lotteryRankingCount(lotteryTickets, lastWeekWinningNumber, bonusBall));

		OutputView.resultWinning(lotteryRank);
		OutputView.resultRevenue(LotteryService.revenue(lotteryStore, lotteryRank));
	}
}
