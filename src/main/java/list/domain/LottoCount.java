package list.domain;

public class LottoCount {

	private static final int MIN_MONEY = 1000;
	private final int count;

	public LottoCount(Money money) {
		this.count = moneyByLotto(money);
	}

	private int moneyByLotto(Money money) {
		return money.getMoney() / MIN_MONEY;
	}

	public int getCount() {
		return count;
	}
}
