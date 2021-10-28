package view;

import domain.Ladder;
import domain.Players;
import domain.Prizes;

public class ResultView {
	private static final String RESULT_LADDER_MESSAGE = "사다리 결과";
	private static final String RESULT_PRIZE_MESSAGE = "실행 결과";

	public static void resultLadder(Players players, Prizes prizes, Ladder ladder) {
		System.out.println(RESULT_LADDER_MESSAGE);
		System.out.println(players.findPlayerGroup());
		for (int i = 0; i < ladder.size(); i++) {
			System.out.println(ladder.findLadderLine(i));
		}
		System.out.println(prizes.findPrizeGroup());
	}

	public static void resultPrize(String player, Players players, Ladder ladder, Prizes prizes) {
		System.out.println(RESULT_PRIZE_MESSAGE);
		if (player.equals("all")) {
			resultPrizeAll(players, ladder, prizes);
		}
		System.out.println(player + " : " + ladder.findLadderResult(player, players, prizes));
	}

	private static void resultPrizeAll(Players players, Ladder ladder, Prizes prizes) {
		String name = "";
		for (int i = 0; i < players.size(); i++) {
			name = players.findPlayer(i);
			System.out.println(name + " : " + ladder.findLadderResult(name, players, prizes));
		}
		System.exit(0);
	}
}
