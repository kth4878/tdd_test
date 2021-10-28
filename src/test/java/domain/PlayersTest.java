package domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayersTest {

	private static final int MIN_LENGTH = 1;
	private static final int MAX_LENGTH = 5;
	public static final int MINIMUM_PLAYER_COUNT = 2;

	@Test
	@DisplayName("참가자 여러명 생성")
	public void createPlayers() {
		Players players = new Players("a,b,c");
		assertThat(players.findPlayer(0)).isEqualTo("a");
		assertThat(players.findPlayer(1)).isEqualTo("b");
		assertThat(players.findPlayer(2)).isEqualTo("c");
	}

	@Test
	@DisplayName("참가자 최소인원 확인")
	public void checkPlayerCount() {
		Players players = new Players("a,b");
		assertThat(players.size() >= MINIMUM_PLAYER_COUNT).isTrue();
	}

	@Test
	@DisplayName("참가자 이름 길이 1이상 5이하 확인")
	public void checkPlayerNameLength() {
		Players players = new Players("a");
		assertThat(players.findPlayer(0).length()).isBetween(MIN_LENGTH, MAX_LENGTH);
	}

	@Test
	@DisplayName("참가자 null 확인")
	public void checkPlayerNull() {
		Players players = new Players("a");
		assertThat(players.findPlayer(0)).isNotNull();
	}

	@Test
	@DisplayName("참가자 공백 확인")
	public void checkPlayerEmpty() {
		Players players = new Players("a");
		assertThat(players.findPlayer(0).isEmpty()).isFalse();
	}
}