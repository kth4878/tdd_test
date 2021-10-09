package list.service;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import list.domain.LottoBundle;
import list.domain.LottoCount;
import list.domain.Money;

class LottoServiceTest {

	@Test
	@DisplayName("로또번호 랜덤생성")
	public void lottoRandom(){
		LottoCount lottoCount = new LottoCount(new Money(1000));
		LottoBundle lottoBundle = LottoService.lottoRandom(lottoCount);

		assertThat(lottoBundle.findLotto(0).getLotto()).isNotNull();
	}
}