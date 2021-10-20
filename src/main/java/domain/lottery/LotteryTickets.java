package domain.lottery;

import java.util.Collections;
import java.util.List;

public class LotteryTickets {
	private final List<LotteryTicket> lotteryTickets;

	public LotteryTickets(List<LotteryTicket> lotteryTicket) {
		this.lotteryTickets = Collections.unmodifiableList(lotteryTicket);
	}

	public int size() {
		return this.lotteryTickets.size();
	}

	public String findLotteryTicketNumber(int number) {
		return lotteryTickets.get(number).findLottoNumber();
	}

	public LotteryTicket getLotteryTickets(int number) {
		return lotteryTickets.get(number);
	}
}
