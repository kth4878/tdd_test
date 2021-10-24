package domain;

public class CarRace {
	private final String car;
	private final String position;

	public CarRace(String car, String position) {
		this.car = car;
		this.position = position;
	}

	public String getCar() {
		return car;
	}

	public String getPosition() {
		return position;
	}
}
