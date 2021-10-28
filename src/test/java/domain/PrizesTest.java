package domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PrizesTest {

	private final Players players;

	public PrizesTest(){
		this.players = new Players("a,b");
	}

	@Test
	@DisplayName("당첨 상품 생성")
	public void createPrizes() {
		Prizes prizes = new Prizes(players, "1000,2000");
		assertThat(prizes.findPrize(0)).isEqualTo("1000");
		assertThat(prizes.findPrize(1)).isEqualTo("2000");
	}

	@Test
	@DisplayName("당첨 상품 개수 확인")
	public void checkPrizeCunt() {
		Prizes prizes = new Prizes(players,"1000,2000");
		assertThat(prizes.size()).isEqualTo(2);
	}

	@Test
	@DisplayName("당첨 상품 null 확인")
	public void checkPrizeNull() {
		Prizes prizes = new Prizes(players, "1000,2000");
		assertThat(prizes.findPrize(0)).isNotNull();
	}

	@Test
	@DisplayName("당첨 상품 공백 확인")
	public void checkPrizeEmpty() {
		Prizes prizes = new Prizes(players, "1000,2000");
		assertThat(prizes.findPrize(0).isEmpty()).isFalse();
	}

}