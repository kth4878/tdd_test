package domain.lottery;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LotteryPrizeTest {

	@Test
	@DisplayName("로또 금액 확인")
	public void checkLotteryNumberPrize(){
		assertThat(LotteryPrize.winningAmount(5,1)).isEqualTo(5000);
		assertThat(LotteryPrize.winningAmount(4,1)).isEqualTo(50000);
		assertThat(LotteryPrize.winningAmount(3,1)).isEqualTo(1500000);
		assertThat(LotteryPrize.winningAmount(2,1)).isEqualTo(30000000);
		assertThat(LotteryPrize.winningAmount(1,1)).isEqualTo(2000000000);
	}

}