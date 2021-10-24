package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CarGroup {
	private static final String COMMA = ",";
	private final List<Car> carGroup;

	public CarGroup(String car) {
		this.carGroup = Collections.unmodifiableList(carNameList(car));
	}

	private List<Car> carNameList(String car) {
		String[] carArray = ofStringArray(car);

		List<Car> carGroup = new ArrayList<>();
		for (String carName : carArray) {
			carGroup.add(new Car(carName));
		}

		return carGroup;
	}

	private String[] ofStringArray(String car) {
		return car.split(COMMA);
	}

	public String findCarName(int number) {
		return carGroup.get(number).getCar();
	}

	public int size() {
		return carGroup.size();
	}
}
