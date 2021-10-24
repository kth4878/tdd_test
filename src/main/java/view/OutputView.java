package view;

import java.util.Arrays;

import domain.CarRaceGroup;

public class OutputView {
	private static final String RESULT_MESSAGE = "실행결과";
	private static final String CAR_RACE_RESULT_MESSAGE = "%s : %s %n";
	private static final String WINNER_MESSAGE = "%s가 최종 우승했습니다.";

	public static void resultCarRace(CarRaceGroup carRaceGroup) {
		System.out.println(RESULT_MESSAGE);

		carRaceGroup.getCarRaceGroup()
			.stream()
			.forEach(i -> System.out.printf(CAR_RACE_RESULT_MESSAGE, i.getCar(), i.getPosition()));
	}

	public static void winner(CarRaceGroup carRaceGroup) {
		System.out.printf(WINNER_MESSAGE, carRaceGroup.findWinner());
	}
}
