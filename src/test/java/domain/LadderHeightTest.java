package domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderHeightTest {
	@Test
	@DisplayName("사다리 길이 생성")
	public void createLadderHeight(){
		LadderHeight ladderHeight = new LadderHeight(5);
		assertThat(ladderHeight.getHeight()).isEqualTo(5);
	}

	@Test
	@DisplayName("사다리 최소길이 2이상")
	public void checkLadderHeightLength(){
		LadderHeight ladderHeight = new LadderHeight(2);
		assertThat(ladderHeight.getHeight()).isEqualTo(2);
	}
}