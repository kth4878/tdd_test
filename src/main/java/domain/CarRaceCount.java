package domain;

import java.util.Objects;

public class CarRaceCount {
	private final int carRaceCount;

	public CarRaceCount(int count){
		this.carRaceCount = count;
	}

	public int getCarRaceCount() {
		return carRaceCount;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		CarRaceCount that = (CarRaceCount)o;
		return carRaceCount == that.carRaceCount;
	}

	@Override
	public int hashCode() {
		return Objects.hash(carRaceCount);
	}
}
