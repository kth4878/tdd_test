package multiplication.view;

import java.util.Scanner;

public class InputView {
	private static final Scanner scanner = new Scanner(System.in);
	public static final String INPUT_NAME_MESSAGE = "구구단 실행할 사람을 입력하세요(최대5글자)";
	public static final String INPUT_NUMBER_MESSAGE = "구구단의 숫자를 입력하세요";
	public static final String INPUT_NUMBER_RANGE_MESSAGE = "구구단의 범위를 입력하세요";
	public static final String NUMBER_ERROR_MESSAGE = "아라비아 숫자만 입력 가능합니다.";

	public static String inputName() {
		System.out.println(INPUT_NAME_MESSAGE);
		return scanner.nextLine();
	}

	public static int inputNumber() {
		System.out.println(INPUT_NUMBER_MESSAGE);
		return checkNumberType();
	}

	public static int inputNumberRange() {
		System.out.println(INPUT_NUMBER_RANGE_MESSAGE);
		return checkNumberType();
	}

	private static int checkNumberType() {
		if (!scanner.hasNextInt()) {
			throw new IllegalArgumentException(NUMBER_ERROR_MESSAGE);
		}
		return scanner.nextInt();
	}
}
