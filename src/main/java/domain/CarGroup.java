package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CarGroup {
	private static final String COMMA = ",";
	private final List<Car> carGroup;

	public CarGroup(String car) {
		this.carGroup = Collections.unmodifiableList(carNameList(car));
	}

	private List<Car> carNameList(String car) {
		String[] carArray = ofStringArray(car);

		List<Car> carGroup = Arrays.stream(carArray)
			.map(Car::new)
			.collect(Collectors.toList());

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
