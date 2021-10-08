package list.controller;

import java.util.Map;

import list.domain.Lotto;
import list.domain.LottoCount;
import list.domain.LottoBundle;
import list.domain.Money;
import list.service.LottoService;
import list.view.InputView;
import list.view.OutputView;

public class LottoController {
	public void run() {
		InputView.title();

		Money money = new Money(InputView.inputMoney());
		LottoCount lottoCount = new LottoCount(money);

		OutputView.buyLotto(lottoCount);

		LottoBundle lottoBundle = LottoService.lottoRandom(lottoCount);
		Lotto lotto = LottoService.winningNumber();

		OutputView.resultGameNumber(lottoBundle);
		OutputView.winningNumber(lotto);

		Map<Integer, Integer> map = LottoService.winning(lottoBundle, lotto);

		OutputView.resultWinning(map);
		OutputView.printRevenue(LottoService.revenue(money, map));
	}
}
