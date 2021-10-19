package list.domain.lottery;

import java.util.Collections;
import java.util.Map;
import java.util.Set;

public class LotteryRanking {
	private final Map<Integer, Integer> rankingCount;

	public LotteryRanking(Map<Integer, Integer> rankingCount) {
		this.rankingCount = Collections.unmodifiableMap(rankingCount);
	}

	public int countWinningNumber(int number){
		return rankingCount.get(number);
	}

	public Set<Integer> keySet() {
		return this.rankingCount.keySet();
	}
}
