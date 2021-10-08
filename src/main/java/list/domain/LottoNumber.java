package list.domain;

public class LottoNumber {
	private static final String NUMBER_ERROR_MESSAGE = "입력가능한 숫자가 아닙니다.";
	private static final int MIN_NUMBER = 1;
	private static final int MAX_NUMBER = 45;
	private final int lottoNumber;

	public LottoNumber(int lottoNumber) {
		checkLottoNumber(lottoNumber);
		this.lottoNumber = lottoNumber;
	}

	private void checkLottoNumber(int lottoNumber) {
		if (lottoNumber < MIN_NUMBER || lottoNumber > MAX_NUMBER) {
			throw new IllegalArgumentException(NUMBER_ERROR_MESSAGE);
		}
	}

	public int getLottoNumber() {
		return lottoNumber;
	}
}
