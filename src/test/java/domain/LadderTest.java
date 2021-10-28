package domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderTest {

	private final Players players;
	private final LadderHeight ladderHeight;

	public LadderTest() {
		this.players = new Players("a,b,c");
		this.ladderHeight = new LadderHeight(3);
	}

	@Test
	@DisplayName("사다리 생성")
	public void createLadder() {
		Ladder ladder = new Ladder(players, ladderHeight);
		assertThat(ladder.size()).isEqualTo(3);
	}
}