package view.lottery;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import domain.lottery.LotteryTicketCount;

public class InputView {

	private final static Scanner scanner = new Scanner(System.in);
	private static final String LOTTERY_PRICE_MESSAGE = "로또 1장의 가격은 1000원 입니다.";
	private static final String LOTTERY_PURCHASE_MESSAGE = "구매금액을 입력해 주세요.";
	private static final String MANUAL_LOTTERY_MESSAGE = "수동 로또 개수를 입력하세요.";
	private static final String MANUAL_LOTTERY_NUMBERS_MESSAGE = "로또 번호를 입력하세요 (,으로 구분)";
	private static final String INPUT_TYPE_ERROR_MESSAGE = "error : 아라비아 숫자만 입력 가능합니다.";
	private static final String LOTTERY_LENGTH_ERROR_MESSAGE = "error : 로또 번호는 6개 입력해야 합니다.";
	private static final String LAST_WEEK_WINNING_NUMBER_MESSAGE = "지난 주 당첨 번호를 입력하세요. (,으로 구분)";
	private static final String BONUS_BALL_MESSAGE = "보너스 볼을 입력해주세요.";
	private static final String COMMA = ",";
	private static final int ZERO = 0;

	public static void lotteryPrice() {
		System.out.println(LOTTERY_PRICE_MESSAGE);
	}

	public static int inputLotteryPurchasePrice() {
		System.out.println(LOTTERY_PURCHASE_MESSAGE);

		return checkInputTypeNumber();
	}

	public static int inputManualLotteryCount() {
		System.out.println(MANUAL_LOTTERY_MESSAGE);

		return checkInputTypeNumber();
	}

	public static List<String[]> inputManualLotteryNumbers(LotteryTicketCount lotteryTicketCount) {
		if (lotteryTicketCount.getManualLotteryCount() != ZERO) {
			System.out.println(MANUAL_LOTTERY_NUMBERS_MESSAGE);
		}

		List<String[]> lotteryNumbers = inputLotteryNumber(lotteryTicketCount.getManualLotteryCount());

		checkLotteryNumbers(lotteryNumbers);

		return lotteryNumbers;
	}

	public static List<String[]> inputLastWeekLotteryNumbers() {
		System.out.println(LAST_WEEK_WINNING_NUMBER_MESSAGE);

		return inputLotteryNumber(1);
	}

	public static int inputBonusBall() {
		System.out.println(BONUS_BALL_MESSAGE);

		return checkInputTypeNumber();
	}

	private static int checkInputTypeNumber() {
		if (!scanner.hasNextInt()) {
			throw new IllegalArgumentException(INPUT_TYPE_ERROR_MESSAGE);
		}

		int number = scanner.nextInt();
		scanner.nextLine();

		return number;
	}

	private static void checkLotteryNumbers(List<String[]> lotteryNumbers) {
		long count = lotteryNumbers.stream()
			.filter(i -> i.length == 6)
			.count();

		if (count != lotteryNumbers.size()) {
			throw new IllegalArgumentException(LOTTERY_LENGTH_ERROR_MESSAGE);
		}
	}

	private static List<String[]> inputLotteryNumber(int number) {
		return Stream.generate(() -> scanner.nextLine().split(COMMA))
			.limit(number)
			.collect(Collectors.toList());
	}

}
