package domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {

	@Test
	@DisplayName("경주용 자동차 생성")
	public void createRaceCar(){
		CarGroup carGroup = new CarGroup("a,b,c");

		assertThat(carGroup.findCarName(0)).isEqualTo("a");
		assertThat(carGroup.findCarName(1)).isEqualTo("b");
		assertThat(carGroup.findCarName(2)).isEqualTo("c");
	}

}
