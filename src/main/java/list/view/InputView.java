package list.view;

import java.util.Scanner;

public class InputView {
	private final static Scanner scanner = new Scanner(System.in);
	private static final String INPUT_NUMBER_ERROR_MESSAGE = "아라비아 숫자만 입력 가능합니다.";
	private static final String LOTTO_PRICE_MESSAGE = "로또 1장의 가격은 1000원 입니다.";
	private static final String INPUT_MONEY_MESSAGE = "구매금액을 입력해 주세요.";

	public static void title() {
		System.out.println(LOTTO_PRICE_MESSAGE);
	}

	public static int inputMoney() {
		System.out.println(INPUT_MONEY_MESSAGE);

		return checkInputNumber();
	}

	private static int checkInputNumber() {
		if (!scanner.hasNextInt()) {
			throw new IllegalArgumentException(INPUT_NUMBER_ERROR_MESSAGE);
		}
		return scanner.nextInt();
	}

}
