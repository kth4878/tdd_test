package domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarRaceCountTest {
	@Test
	@DisplayName("자동차 경주횟수 생성")
	public void createCarRaceCount(){
		CarRaceCount carRaceCount = new CarRaceCount(3);
		assertThat(carRaceCount.getCarRaceCount()).isEqualTo(3);
	}
}
