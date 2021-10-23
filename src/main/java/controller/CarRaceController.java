package controller;

import domain.CarRace;
import domain.CarRaceCount;
import domain.CarGroup;
import domain.CarRaceGroup;
import service.CarRaceService;
import view.InputView;
import view.OutputView;

public class CarRaceController {
	public void run(){
		CarGroup carGroup = new CarGroup(InputView.inputRaceCar());
		CarRaceCount carRaceCount = new CarRaceCount(InputView.inputCarRaceCount());
		CarRaceGroup carRaceGroup = new CarRaceGroup(carGroup, carRaceCount);

		OutputView.resultCarRace(carRaceGroup);
		OutputView.winner(carRaceGroup);
	}
}
