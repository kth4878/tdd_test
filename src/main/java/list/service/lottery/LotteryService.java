package list.service.lottery;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import list.calculator.Calculation;
import list.calculator.LotteryPrize;
import list.domain.lottery.LotteryRandomNumber;
import list.domain.lottery.LotteryRanking;
import list.domain.lottery.LotteryStore;
import list.domain.lottery.LotteryTicket;
import list.domain.lottery.LotteryTicketCount;
import list.domain.lottery.LotteryTickets;

public class LotteryService {
	private static final int ZERO = 0;
	private static final int MIN_WINNING_NUMBER = 3;
	private static final int MAX_WINNING_NUMBER = 6;

	public static LotteryTickets issueLotteryTicket(List<String[]> manualLotteryTicket,
		LotteryTicketCount lotteryTicketCount) {
		return new LotteryTickets(lotteryTickets(manualLotteryTicket, lotteryTicketCount));
	}

	public static List<LotteryTicket> lotteryTickets(List<String[]> manualLotteryTicket,
		LotteryTicketCount lotteryTicketCount) {
		List<LotteryTicket> lotteryTicket = new ArrayList<>();

		for (int i = ZERO; i < lotteryTicketCount.getManualLotteryCount(); i++) {
			lotteryTicket.add(new LotteryTicket(manualLotteryTicket.get(i)));
		}

		for (int j = ZERO; j < lotteryTicketCount.getAutomaticLotteryCount(); j++) {
			lotteryTicket.add(new LotteryTicket(lotteryRandom()));
		}

		return lotteryTicket;
	}

	private static String[] lotteryRandom() {
		Set<String> lottery = new HashSet<>();
		while (lottery.size() != 6) {
			lottery.add(""+LotteryRandomNumber.randomResult());
		}

		String[] lotteryNumber = lottery.toArray(new String[0]);

		return lotteryNumber;
	}

	public static LotteryTicket lastWeekWinningNumber(List<String[]> lastWeekWinningNumber) {
		return new LotteryTicket(lastWeekWinningNumber.get(0));
	}

	public static Map<Integer, Integer> lotteryRankingCount(LotteryTickets lotteryTickets, LotteryTicket lastWeekWinningNumber) {
		List<Integer> rankingList = winningLottery(lotteryTickets, lastWeekWinningNumber);

		Map<Integer, Integer> rankingCount = new HashMap<>();
		for (int i = MIN_WINNING_NUMBER; i <= MAX_WINNING_NUMBER; i++) {
			rankingCount.put(i, Collections.frequency(rankingList, i));
		}

		return rankingCount;
	}

	private static List<Integer> winningLottery(LotteryTickets lotteryTickets, LotteryTicket lastWeekWinningNumber) {
		List<Integer> numbers = new ArrayList<>();
		for (int i = 0; i < lotteryTickets.size(); i++) {
			numbers.add(lastWeekWinningNumber.matchCount(lotteryTickets.getLotteryTickets(i)));
		}

		return numbers;
	}

	public static double revenue(LotteryStore lotteryStore, LotteryRanking lotteryRanking) {
		int money = 0;
		for (int key : lotteryRanking.keySet()) {
			money += LotteryPrize.winningAmount(key, lotteryRanking.countWinningNumber(key));
		}
		return Math.round(Calculation.calculate("/", money, lotteryStore.getPrice()) * 100) / 100.0;
	}

}
