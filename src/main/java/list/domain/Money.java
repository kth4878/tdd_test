package list.domain;

import java.util.Objects;

public class Money {
	private static final int MIN_MONEY = 1000;
	private static final String MIN_MONEY_ERROR_MESSAGE = "최소 금액은 1000원 입니다.";
	private final int money;

	public Money(int money) {
		checkMoneyMin(money);
		this.money = discard(money);
	}

	private void checkMoneyMin(int money) {
		if (money < MIN_MONEY) {
			throw new IllegalArgumentException(MIN_MONEY_ERROR_MESSAGE);
		}
	}

	private int discard(int money) {
		return Math.round(money / MIN_MONEY) * MIN_MONEY;
	}

	public int getMoney() {
		return money;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Money money1 = (Money)o;
		return money == money1.money;
	}

	@Override
	public int hashCode() {
		return Objects.hash(money);
	}
}
