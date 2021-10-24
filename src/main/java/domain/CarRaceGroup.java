package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CarRaceGroup {
	private static final String MAX_NUMBER_ERROR_MESSAGE = "MAX 값을 찾을수 없습니다.";
	private final List<CarRace> carRaceGroup;

	public CarRaceGroup(CarGroup carGroup, CarRaceCount carRaceCount) {
		this.carRaceGroup = carRaceSetting(carGroup, carRaceCount);
	}

	private List<CarRace> carRaceSetting(CarGroup carGroup, CarRaceCount carRaceCount) {
		List<CarRace> carRace = new ArrayList<>();
		for (int i = 0; i < carRaceCount.getCarRaceCount(); i++) {
			for (int j = 0; j < carGroup.size(); j++) {
				carRace.add(new CarRace(carGroup.findCarName(j), rand(carGroup.size(), carRace)));
			}
		}

		return carRace;
	}

	private String rand(int carGroupSize, List<CarRace> carRace) {
		int count = carRace.size() - carGroupSize;
		if (count >= 0) {
			return carRace.get(count).getPosition() + DrivingRandom.driving();
		}
		return DrivingRandom.driving();
	}

	public String findCar(int number) {
		return this.carRaceGroup.get(number).getCar();
	}

	public String findPosition(int number) {
		return this.carRaceGroup.get(number).getPosition();
	}

	public int size() {
		return this.carRaceGroup.size();
	}

	public String findWinner() {
		int max = max();

		return this.carRaceGroup
			.stream()
			.filter(i -> i.getPosition().length() == max)
			.map(i -> i.getCar())
			.distinct()
			.sorted()
			.collect(Collectors.joining(", "));
	}

	private int max() {
		return this.carRaceGroup
			.stream()
			.mapToInt(i -> i.getPosition().length())
			.max()
			.orElseThrow(() -> new IllegalArgumentException(MAX_NUMBER_ERROR_MESSAGE));
	}

}
