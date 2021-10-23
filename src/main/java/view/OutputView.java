package view;

import domain.CarRaceGroup;

public class OutputView {
	private static final String RESULT_MESSAGE = "실행결과";
	private static final String CAR_RACE_RESULT_MESSAGE = "%s : %s";
	private static final String WINNER_MESSAGE = "%s가 최종 우승했습니다";

	public static void resultCarRace(CarRaceGroup carRaceGroup){
		System.out.println(RESULT_MESSAGE);

		for(int i=0; i<carRaceGroup.size(); i++){
			System.out.printf(CAR_RACE_RESULT_MESSAGE,carRaceGroup.findCar(i),carRaceGroup.findPosition(i));
			System.out.println("");
		}
	}

	public static void winner(CarRaceGroup carRaceGroup){
		System.out.printf(WINNER_MESSAGE,carRaceGroup.findWinner());
	}
}
