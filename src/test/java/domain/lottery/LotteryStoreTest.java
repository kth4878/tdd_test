package domain.lottery;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LotteryStoreTest {

	@Test
	@DisplayName("금액에 맞는 로또개수 생성")
	public void createLotteryTicket(){
		LotteryStore lotteryStore = new LotteryStore(3500);
		assertThat(lotteryStore.buyLottery()).isEqualTo(3);
	}

}