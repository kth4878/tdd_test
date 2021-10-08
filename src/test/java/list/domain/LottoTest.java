package list.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoTest {

	@Test
	@DisplayName("게임별 번호 생성")
	public void createGameByNumber() {
		Lotto lotto = Lotto.ofInt(2, 6, 7, 10, 22, 10);
		assertThat(lotto).isEqualTo(Lotto.ofInt(2, 6, 7, 10, 22, 10));
	}

	@Test
	@DisplayName("게임 번호 중복 체크")
	public void checkNumberOverlap() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Lotto.ofInt(2, 2, 3, 4, 5, 6);

			fail("증복번호 에러가 발생해야 한다.");
		});
	}

	@Test
	@DisplayName("번호 일치 검증")
	public void checkLottoNumberMatch() {
		Lotto winning = Lotto.ofInt(1, 2, 3, 4, 5, 6);
		assertThat(winning.matchCount(Lotto.ofInt(1, 12, 13, 14, 15, 16))).isEqualTo(1);
		assertThat(winning.matchCount(Lotto.ofInt(1, 2, 13, 14, 15, 16))).isEqualTo(2);
		assertThat(winning.matchCount(Lotto.ofInt(1, 2, 3, 14, 15, 16))).isEqualTo(3);
		assertThat(winning.matchCount(Lotto.ofInt(1, 2, 3, 4, 15, 16))).isEqualTo(4);
		assertThat(winning.matchCount(Lotto.ofInt(1, 2, 3, 4, 5, 16))).isEqualTo(5);
		assertThat(winning.matchCount(Lotto.ofInt(1, 2, 3, 4, 5, 6))).isEqualTo(6);
	}

}
