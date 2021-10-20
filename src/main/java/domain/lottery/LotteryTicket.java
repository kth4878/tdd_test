package domain.lottery;

import java.util.Set;
import java.util.stream.Collectors;

import service.lottery.LotteryService;

public class LotteryTicket {
	private Set<LotteryNumber> lottery;

	public LotteryTicket(String[] lottery){
		this.lottery = LotteryService.removeLotteryNumberOverlap(lottery);
	}

	public String findLottoNumber() {
		return this.lottery
			.stream()
			.map(i -> "" + i.getLotteryNumber())
			.sorted()
			.collect(Collectors.joining(", "));
	}

	public Set<LotteryNumber> getLottery() {
		return lottery;
	}
}
