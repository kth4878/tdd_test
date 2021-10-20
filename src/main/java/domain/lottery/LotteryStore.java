package domain.lottery;

public class LotteryStore {
	private static final int LOTTERY_PRICE = 1000;
	private static final String LOTTERY_PRICE_ERROR_MESSAGE = "error : 최소 금액은 1000원 입니다.";
	private final int price;
	private final int lotteryCount;

	public LotteryStore(int price) {
		checkLotteryPrice(price);
		this.price = price;
		this.lotteryCount = lotteryCalculation(discard(price));
	}

	private void checkLotteryPrice(int price) {
		if (price < LOTTERY_PRICE) {
			throw new IllegalArgumentException(LOTTERY_PRICE_ERROR_MESSAGE);
		}
	}

	private int discard(int price) {
		return Math.round(Calculation.calculate("/", price, LOTTERY_PRICE)) * LOTTERY_PRICE;
	}

	private int lotteryCalculation(int price) {
		return Calculation.calculate("/", price, LOTTERY_PRICE);
	}

	public int getPrice() {
		return price;
	}

	public int buyLottery() {
		return this.lotteryCount;
	}

}
