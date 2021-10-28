package domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Prizes {
	private static final String COMMA = ",";
	private static final String NULL_ERROR_MESSAGE = "error : 당첨 상품은 null 을 입력할수 없습니다.";
	private static final String EMPTY_ERROR_MESSAGE = "error : 당첨 상품은 공백을 입력할수 없습니다.";
	private static final String PRIZE_COUNT_ERROR_MESSAGE = "error : 참가자 수와 상품 수는 같아야 합니다.";
	private static final String EMPTY = "  ";
	private final List<Prize> prizes;

	public Prizes(Players players, String prize) {
		checkPrizeNull(prize);
		checkPrizeEmpty(prize);
		this.prizes = Collections.unmodifiableList(prizeArray(players, prize));
	}

	private List<Prize> prizeArray(Players players, String prize) {
		String[] prizeArray = ofStringArray(prize);
		checkPrizeCount(players.size(), prizeArray);

		return Arrays.stream(prizeArray)
			.map(Prize::new)
			.collect(Collectors.toList());
	}

	private String[] ofStringArray(String prize) {
		return prize.split(COMMA);
	}

	private void checkPrizeCount(int playerCount, String[] prize){
		long prizeCount = Arrays.stream(prize)
			.count();

		if(playerCount != prizeCount){
			throw new IllegalArgumentException(PRIZE_COUNT_ERROR_MESSAGE);
		}
	}

	private void checkPrizeNull(String prize) {
		if (prize == null) {
			throw new IllegalArgumentException(NULL_ERROR_MESSAGE);
		}
	}

	private void checkPrizeEmpty(String prize) {
		if (prize.isEmpty()) {
			throw new IllegalArgumentException(EMPTY_ERROR_MESSAGE);
		}
	}

	public int size() {
		return this.prizes.size();
	}

	public String findPrize(int number) {
		return this.prizes.get(number).getPrize();
	}

	public String findPrizeGroup(){
		return this.prizes
			.stream()
			.map(i -> i.getPrize())
			.collect(Collectors.joining(EMPTY));
	}

}
