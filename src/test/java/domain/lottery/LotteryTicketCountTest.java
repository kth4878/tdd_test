package domain.lottery;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LotteryTicketCountTest {

	@Test
	@DisplayName("자동복권 수 생성")
	public void createAutomaticLottery(){
		LotteryTicketCount lotteryTicket = new LotteryTicketCount(new LotteryStore(10),2);
		assertThat(lotteryTicket.getAutomaticLotteryCount()).isEqualTo(8);
	}

}