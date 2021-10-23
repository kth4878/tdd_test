package view;

import java.util.Scanner;

public class InputView {
	private final static Scanner scanner = new Scanner(System.in);
	private static final String RACE_CAR_INPUT_MESSAGE = "경주용 자동차 이름을 입력하세요(이름은 콤마(,) 를 기준으로 구분합니다.)";
	private static final String CAR_RACE_COUNT_INPUT_MESSAGE = "경주 횟수를 입력하세요(아라비아 숫자)";
	private static final String NUMBER_TYPE_ERROR_MESSAGE = "error : 아라비아 숫자만 입력 가능합니다.";
	private static final String NULL_ERROR_MESSAGE = "error : NULL 값은 입력할수 없습니다.";
	private static final String EMPTY_ERROR_MESSAGE = "error : 공백은 입력할수 없습니다.";

	public static String inputRaceCar() {
		System.out.println(RACE_CAR_INPUT_MESSAGE);

		String carName = scanner.nextLine();
		checkCarNameNull(carName);
		checkCarNameEmpty(carName);

		return carName;
	}

	public static int inputCarRaceCount() {
		System.out.println(CAR_RACE_COUNT_INPUT_MESSAGE);

		return checkNumberType();
	}

	private static void checkCarNameNull(String carName) {
		if (carName == null) {
			throw new IllegalArgumentException(NULL_ERROR_MESSAGE);
		}
	}

	private static void checkCarNameEmpty(String carName) {
		if (carName.isEmpty()) {
			throw new IllegalArgumentException(EMPTY_ERROR_MESSAGE);
		}
	}

	private static int checkNumberType() {
		if (!scanner.hasNextInt()) {
			throw new IllegalArgumentException(NUMBER_TYPE_ERROR_MESSAGE);
		}

		return scanner.nextInt();
	}

}
