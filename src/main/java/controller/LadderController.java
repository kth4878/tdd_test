package controller;

import domain.Ladder;
import domain.LadderHeight;
import domain.Players;
import domain.Prizes;
import view.InputView;
import view.ResultView;

public class LadderController {
	public void run() {
		Players players = new Players(InputView.inputPlayer());
		Prizes prizes = new Prizes(players, InputView.inputPrize());
		LadderHeight ladderHeight = new LadderHeight(InputView.inputLadderHeight());

		Ladder ladder = new Ladder(players, ladderHeight);
		ResultView.resultLadder(players, prizes, ladder);

		while (true) {
			ResultView.resultPrize(InputView.inputPlayerResult(players), players, ladder, prizes);
		}
	}
}
