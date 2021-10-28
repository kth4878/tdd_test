package view;

import java.util.Scanner;

import domain.Players;

public class InputView {
	private static final Scanner scanner = new Scanner(System.in);
	private static final String INPUT_PLAYER_MESSAGE = "참여할 사람의 이름을 입력하세요. (이름은 쉼표(,)로 구분)";
	private static final String INPUT_PRIZE_MESSAGE = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분)";
	private static final String INPUT_LADDER_HEIGHT_MESSAGE = "사다리 높이를 입력하세요.";
	private static final String NUMBER_TYPE_ERROR_MESSAGE = "error : 아라비아 숫자만 입력할수 있습니다.";
	private static final String INPUT_PLAYER_RESULT_MESSAGE = "결과를 보고 싶은 사람은?";

	public static String inputPlayer() {
		System.out.println(INPUT_PLAYER_MESSAGE);

		return scanner.nextLine();
	}

	public static String inputPrize() {
		System.out.println(INPUT_PRIZE_MESSAGE);

		return scanner.nextLine();
	}

	public static int inputLadderHeight() {
		System.out.println(INPUT_LADDER_HEIGHT_MESSAGE);

		return checkNumberType();
	}

	public static String inputPlayerResult(Players players) {
		System.out.println(INPUT_PLAYER_RESULT_MESSAGE);

		return checkPlayerName(players);
	}

	private static int checkNumberType() {
		if (!scanner.hasNextInt()) {
			throw new IllegalArgumentException(NUMBER_TYPE_ERROR_MESSAGE);
		}

		int number = scanner.nextInt();
		scanner.nextLine();

		return number;
	}

	private static String checkPlayerName(Players players) {
		return players.checkPlayer(scanner.nextLine());
	}

}
