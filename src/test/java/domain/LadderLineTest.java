package domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderLineTest {
	
	@Test
	@DisplayName("사다리 줄 생성")
	public void createLadderLine(){
		LadderLine ladderLine = new LadderLine(5);
		assertThat(ladderLine.size()).isEqualTo(5);
	}

}