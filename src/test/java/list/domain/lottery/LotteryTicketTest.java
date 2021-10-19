package list.domain.lottery;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LotteryTicketTest {

	@Test
	@DisplayName("수동 복권 번호중복 확인")
	public void checkManualLotteryTicketNumber() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			String[] numbers = {"1", "2", "3", "4", "5", "5"};
			LotteryTicket lotteryTicket = new LotteryTicket(numbers);

			fail("번호중복 에러가 발생해야 한다.");
		});
	}

	@Test
	@DisplayName("복권 당첨번호 일치 확인")
	public void checkLotteryTicketMatch() {
		String[] numbers = {"1", "2", "3", "4", "5", "6"};

		LotteryTicket winningNumber = new LotteryTicket(numbers);
		assertThat(
			winningNumber.matchCount(new LotteryTicket(new String[] {"1", "12", "13", "14", "15", "16"}))).isEqualTo(1);
		assertThat(
			winningNumber.matchCount(new LotteryTicket(new String[] {"1", "2", "13", "14", "15", "16"}))).isEqualTo(2);
		assertThat(
			winningNumber.matchCount(new LotteryTicket(new String[] {"1", "2", "3", "14", "15", "16"}))).isEqualTo(3);
		assertThat(
			winningNumber.matchCount(new LotteryTicket(new String[] {"1", "2", "3", "4", "15", "16"}))).isEqualTo(4);
		assertThat(
			winningNumber.matchCount(new LotteryTicket(new String[] {"1", "2", "3", "4", "5", "16"}))).isEqualTo(5);
		assertThat(
			winningNumber.matchCount(new LotteryTicket(new String[] {"1", "2", "3", "4", "5", "6"}))).isEqualTo(6);
	}

}