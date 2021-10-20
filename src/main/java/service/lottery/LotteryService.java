package list.service.lottery;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import list.calculator.Calculation;
import list.domain.lottery.BonusBall;
import list.domain.lottery.LastWeekLotteryTicket;
import list.domain.lottery.LotteryNumber;
import list.domain.lottery.LotteryPrize;
import list.domain.lottery.LotteryRandomNumber;
import list.domain.lottery.LotteryRank;
import list.domain.lottery.LotteryRankCalculation;
import list.domain.lottery.LotteryStore;
import list.domain.lottery.LotteryTicket;
import list.domain.lottery.LotteryTicketCount;
import list.domain.lottery.LotteryTickets;

public class LotteryService {
	private static final int ZERO = 0;
	private static final int MIN_LANK = 1;
	private static final int MAX_LANK = 5;
	private static final int LOTTERY_NUMBER_COUNT = 6;
	private static final String LOTTERY_NUMBER_OVERLAP_ERROR_MESSAGE = "error : 입력된 번호가 중복되거나 부족합니다.";

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
			lottery.add("" + LotteryRandomNumber.randomResult());
		}

		String[] lotteryNumber = lottery.toArray(new String[0]);

		return lotteryNumber;
	}

	public static LastWeekLotteryTicket lastWeekWinningNumber(List<String[]> lastWeekWinningNumber) {
		return new LastWeekLotteryTicket(lastWeekWinningNumber.get(0));
	}

	public static Map<Integer, Integer> lotteryRankingCount(LotteryTickets lotteryTickets,
		LastWeekLotteryTicket lastWeekWinningNumber, BonusBall bonusBall) {

		List<Integer> winningLottery = winningLottery(lotteryTickets, lastWeekWinningNumber, bonusBall);

		Map<Integer, Integer> rankingCount = new HashMap<>();

		for (int i = MIN_LANK; i <= MAX_LANK; i++) {
			rankingCount.put(i, Collections.frequency(winningLottery, i));
		}

		return rankingCount;
	}

	private static List<Integer> winningLottery(LotteryTickets lotteryTickets,
		LastWeekLotteryTicket lastWeekWinningNumber, BonusBall bonusBall) {
		List<Integer> numbers = new ArrayList<>();
		for (int i = 0; i < lotteryTickets.size(); i++) {
			numbers.add(
				LotteryRankCalculation.ranking(
					lastWeekWinningNumber.lotteryMatchCount(lotteryTickets.getLotteryTickets(i)), 0
					/*bonusBall.BonusBallMatch(lotteryTickets.getLotteryTickets(i))*/
				)
			);
		}

		return numbers;
	}

	public static double revenue(LotteryStore lotteryStore, LotteryRank lotteryRank) {
		int money = 0;
		for (int key : lotteryRank.keySet()) {
			money += LotteryPrize.winningAmount(key, lotteryRank.countWinningNumber(key));
		}
		return Math.round(Calculation.calculate("/", money, lotteryStore.getPrice()) * 100) / 100.0;
	}

	public static Set<LotteryNumber> removeLotteryNumberOverlap(String[] lottery) {
		Set<Integer> lotteryTicket = Arrays.stream(lottery)
			.map(Integer::parseInt)
			.collect(Collectors.toSet());

		checkLotteryNumberOverlap(lotteryTicket);

		return changeToLotteryNumber(lotteryTicket);
	}

	private static void checkLotteryNumberOverlap(Set<Integer> lotteryNumbers) {
		if (lotteryNumbers.size() < LOTTERY_NUMBER_COUNT) {
			throw new IllegalArgumentException(LOTTERY_NUMBER_OVERLAP_ERROR_MESSAGE);
		}
	}

	private static Set<LotteryNumber> changeToLotteryNumber(Set<Integer> lotteryTicket) {
		return lotteryTicket.stream()
			.map(LotteryNumber::new)
			.collect(Collectors.toCollection(HashSet::new));
	}

}
