package list.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import list.calculator.Calculation;
import list.calculator.LottoPrize;
import list.domain.Lotto;
import list.domain.LottoCount;
import list.domain.LottoBundle;
import list.domain.Money;
import list.domain.RandomNumber;

public class LottoService {
	private static final int MIN_WINNING_NUMBER = 3;
	private static final int MAX_WINNING_NUMBER = 6;

	public static LottoBundle lottoRandom(LottoCount lottoCount) {
		List<Lotto> lottoBundle = new ArrayList<>();
		for (int i = 0; i < lottoCount.getCount(); i++) {
			lottoBundle.add(randomLottoSetting());
		}
		return new LottoBundle(lottoBundle);
	}

	public static Lotto winningNumber() {
		return randomLottoSetting();
	}

	public static Map<Integer, Integer> winning(LottoBundle lottos, Lotto winningNumber) {
		List<Integer> numbers = winningLotto(lottos, winningNumber);

		Map<Integer, Integer> map = new HashMap<>();
		for(int i = MIN_WINNING_NUMBER; i<= MAX_WINNING_NUMBER; i++){
			map.put(i, Collections.frequency(numbers, i));
		}

		return map;
	}

	private static List<Integer> winningLotto(LottoBundle lottos, Lotto winningNumber){
		List<Integer> numbers = new ArrayList<>();
		for (int i = 0; i < lottos.findSize(); i++) {
			numbers.add(winningNumber.matchCount(lottos.findLotto(i)));
		}
		return numbers;
	}

	public static double revenue(Money seedMoney, Map<Integer, Integer> map) {
		double money = 0;
		for (int key : map.keySet()) {
			money += LottoPrize.winningAmount(key, map.get(key));
		}
		return Math.round(Calculation.calculate("/",money, seedMoney.getMoney()) * 100) / 100.0;
	}

	private static Lotto randomLottoSetting() {
		Set<Integer> lotto = new HashSet<>();
		while (lotto.size() != 6) {
			lotto.add(RandomNumber.randomResult());
		}

		List<Integer> list = new ArrayList<>(lotto);

		return Lotto.ofInt(list.get(0), list.get(1), list.get(2), list.get(3), list.get(4), list.get(5));
	}

}
