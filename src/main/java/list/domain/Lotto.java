package list.domain;

import java.util.HashSet;
import java.util.Objects;
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
		Set<Integer> lottoNumbers = new HashSet<>();
		for( int number : numbers){
			lottoNumbers.add(number);
		}
		checkOverlap(lottoNumbers);

		return new Lotto(setLotto(lottoNumbers));
	}

	private static void checkOverlap(Set<Integer> lotto) {
		if (lotto.size() < GAME_MAX_NUMBER) {
			throw new IllegalArgumentException(OVERLAP_ERROR_MESSAGE);
		}
	}

	private static Set<LottoNumber> setLotto(Set<Integer> lottoNumbers){
		Set<LottoNumber> lotto = new HashSet<>();
		for (int number : lottoNumbers) {
			lotto.add(new  LottoNumber(number));
		}
		return lotto;
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

	public Set<LottoNumber> getLotto() {
		return lotto;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Lotto lotto1 = (Lotto)o;
		return Objects.equals(lotto, lotto1.lotto);
	}

	@Override
	public int hashCode() {
		return Objects.hash(lotto);
	}
}
