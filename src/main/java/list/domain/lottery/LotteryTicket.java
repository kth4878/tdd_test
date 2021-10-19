package list.domain.lottery;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class LotteryTicket {
	private static final String LOTTERY_NUMBER_OVERLAP_ERROR_MESSAGE = "error : 입력된 번호가 중복되거나 부족합니다.";
	private static final int ZERO = 0;
	private static final int LOTTERY_NUMBER_COUNT = 6;
	private Set<LotteryNumber> lottery;

	public LotteryTicket(String[] lottery){
		this.lottery = removeLotteryNumberOverlap(lottery);
	}

	private Set<LotteryNumber> removeLotteryNumberOverlap(String[] lottery){
		Set<Integer> lotteryTicket = Arrays.stream(lottery)
			.map(Integer::parseInt)
			.collect(Collectors.toSet());

		checkLotteryNumberOverlap(lotteryTicket);

		return lotteryTicket.stream()
			.map(LotteryNumber::new)
			.collect(Collectors.toCollection(HashSet::new));
	}

	private void checkLotteryNumberOverlap(Set<Integer> lotteryNumbers) {
		if (lotteryNumbers.size() < LOTTERY_NUMBER_COUNT) {
			throw new IllegalArgumentException(LOTTERY_NUMBER_OVERLAP_ERROR_MESSAGE);
		}
	}

	public int matchCount(LotteryTicket lotteryTicket) {
		int count = 0;
		for(LotteryNumber lotteryNumber : this.lottery){
			count += match(lotteryNumber.getLotteryNumber(), lotteryTicket);
		}

		return count;
	}

	private int match(int lotteryNumber, LotteryTicket lotteryTicket) {
		return (int)lotteryTicket.getLottery()
			.stream()
			.map(LotteryNumber::getLotteryNumber)
			.filter(i -> lotteryNumber == i)
			.count();
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
