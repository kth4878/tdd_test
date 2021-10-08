package list.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoBundle {
	List<Lotto> lottoBundle;

	public LottoBundle(List<Lotto> lotto) {
		this.lottoBundle = new ArrayList<>(lotto);
	}

	public Lotto findLotto(int number) {
		return lottoBundle.get(number);
	}

	public int findSize() {
		return lottoBundle.size();
	}
}
