package list.domain;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {
	private static final String OVERLAP_ERROR_MESSAGE = "중복 번호가 있습니다.";
	private static final int GAME_MAX_NUMBER = 6;
	private Set<LottoNumber> lotto;

	public Lotto(Set<LottoNumber> lotto) {
		this.lotto = lotto;
	}

	public static Lotto ofInt(Integer... numbers) {
		Set<LottoNumber> lottoNumbers = new HashSet<>();

		for (int number : numbers) {
			lottoNumbers.add(new LottoNumber(number));
		}

		return new Lotto(checkOverlap(lottoNumbers));
	}

	public int matchCount(Lotto targetLotto) {
		int count = 0;
		for (LottoNumber lottoNumber : this.lotto) {
			count += match(lottoNumber.getLottoNumber(), targetLotto);
		}

		return count;
	}

	private int match(int lottoNumber, Lotto targetLotto) {
		return (int)targetLotto.getLotto()
			.stream()
			.map(LottoNumber::getLottoNumber)
			.filter(i -> lottoNumber == i)
			.count();
	}

	public String findLottoNumber() {
		return this.lotto
			.stream()
			.map(i -> "" + i.getLottoNumber())
			.collect(Collectors.joining(", "));
	}

	private static Set<LottoNumber> checkOverlap(Set<LottoNumber> lotto) {
		if (lotto.size() < GAME_MAX_NUMBER) {
			throw new IllegalArgumentException(OVERLAP_ERROR_MESSAGE);
		}
		return lotto;
	}

	public Set<LottoNumber> getLotto() {
		return lotto;
	}
}
