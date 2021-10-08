package list.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import list.service.LottoService;

public class MoneyTest {

	@Test
	@DisplayName("구매금액 입력")
	public void inputMoney(){
		Money money = new Money(1000);
		assertThat(money).isEqualTo(new Money(1000));
	}

	@Test
	@DisplayName("천원단위 절삭")
	public void discard(){
		Money money = new Money(3100);
		assertThat(money).isEqualTo(new Money(3000));
	}

	@Test
	@DisplayName("금액만큼 로또개수 생성")
	public void createLottoCount(){
		Money money = new Money(3000);
		int lottoCount = LottoService.lottoCount(money);

		assertThat(lottoCount).isEqualTo(3);
	}
}
