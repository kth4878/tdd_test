package domain;

import java.util.Objects;

public class Car {
	private final String car;

	public Car(String car){
		this.car = car;
	}

	public String getCar() {
		return car;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Car raceCar1 = (Car)o;
		return Objects.equals(car, raceCar1.car);
	}

	@Override
	public int hashCode() {
		return Objects.hash(car);
	}
}
