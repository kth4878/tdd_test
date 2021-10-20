package domain.lottery;

import java.util.Collections;
import java.util.Map;
import java.util.Set;

public class LotteryRank {
	private final Map<Integer, Integer> rankingCount;

	public LotteryRank(Map<Integer, Integer> rankingCount) {
		this.rankingCount = Collections.unmodifiableMap(rankingCount);
	}

	public int countWinningNumber(int number){
		return rankingCount.get(number);
	}

	public Set<Integer> keySet() {
		return this.rankingCount.keySet();
	}


}
