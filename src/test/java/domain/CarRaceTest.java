package domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarRaceTest {

	private final CarGroup carGroup;
	private final CarRaceCount carRaceCount;

	public CarRaceTest() {
		this.carGroup = new CarGroup("a,b");
		this.carRaceCount = new CarRaceCount(3);
	}

	@Test
	@DisplayName("자동차 경주 데이터 생성")
	public void createCarRaceData(){
		CarRaceGroup carRaceGroup = new CarRaceGroup(carGroup, carRaceCount);
		assertThat(carRaceGroup.size()).isNotZero();
	}

	@Test
	@DisplayName("자동차 경주 우승자 생성")
	public void createCarRaceWinning() {
		CarRaceGroup carRaceGroup = new CarRaceGroup(carGroup, carRaceCount);
		assertThat(!carRaceGroup.findWinner().isEmpty());
	}
}
