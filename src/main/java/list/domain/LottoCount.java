package list.domain;

import list.calculator.Calculation;

public class LottoCount {
	private static final int MIN_MONEY = 1000;
	private final int lottoCount;

	public LottoCount(Money money){
		this.lottoCount = moneyCalculation(money);
	}

	private int moneyCalculation(Money money) {
		return Calculation.calculate("/", money.getMoney(), MIN_MONEY);
	}

	public int getLottoCount() {
		return lottoCount;
	}
}
