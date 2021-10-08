package list.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoCountTest {
	@Test
	@DisplayName("금액만큼 로또개수 생성")
	public void createLottoCount(){
		Money money = new Money(3000);
		LottoCount lottoCount = new LottoCount(money);

		assertThat(lottoCount.getCount()).isEqualTo(3);
	}
}
