package domain.lottery;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LotteryRankCalculationTest {
	@Test
	@DisplayName("로또 당첨등수 계산")
	public void changeLotteryTicketRank(){
		assertThat(LotteryRankCalculation.ranking(3,0)).isEqualTo(5);
		assertThat(LotteryRankCalculation.ranking(4,0)).isEqualTo(4);
		assertThat(LotteryRankCalculation.ranking(5,0)).isEqualTo(3);
		assertThat(LotteryRankCalculation.ranking(5,1)).isEqualTo(2);
		assertThat(LotteryRankCalculation.ranking(6,0)).isEqualTo(1);
	}

}