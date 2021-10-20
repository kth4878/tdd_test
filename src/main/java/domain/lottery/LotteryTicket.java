package domain.lottery;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import service.lottery.LotteryService;

public class LotteryTicket {
	private static final String LOTTERY_NUMBER_OVERLAP_ERROR_MESSAGE = "error : 입력된 번호가 중복되거나 부족합니다.";
	private static final int LOTTERY_NUMBER_COUNT = 6;
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
