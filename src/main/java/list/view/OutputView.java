package list.view;

import java.util.Map;

import list.domain.Lotto;
import list.domain.LottoBundle;
import list.domain.LottoCount;

public class OutputView {

	private static final String BUY_LOTTO_MESSAGE = "개를 구매했습니다.";

	public static void buyLotto(LottoCount lottoCount) {
		System.out.println(lottoCount.getLottoCount() + BUY_LOTTO_MESSAGE);
	}

	public static void resultGameNumber(LottoBundle lottoBundle) {
		for (int i = 0; i < lottoBundle.findSize(); i++) {
			System.out.println("[" + lottoBundle.findLotto(i).findLottoNumber() + "]");
		}
	}

	public static void winningNumber(Lotto winningNumber) {
		System.out.println("");
		System.out.println("지난 주 당첨 번호");
		System.out.println(winningNumber.findLottoNumber());
	}

	public static void resultWinning(Map<Integer, Integer> map) {
		System.out.println("");
		System.out.println("당첨 통계");
		System.out.println("--------------------");
		System.out.println("3개 일치 (5000원) - " + map.get(3));
		System.out.println("4개 일치 (50000원) - " + map.get(4));
		System.out.println("5개 일치 (1500000원) - " + map.get(5));
		System.out.println("6개 일치 (2500000000원) - " + map.get(6));
	}

	public static void printRevenue(double revenue) {
		System.out.println("총 수익률은 " + revenue + "입니다. (기준은 1입니다.) ");
	}
}
