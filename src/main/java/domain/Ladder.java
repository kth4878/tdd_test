package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ladder {
	private final List<LadderLine> ladder;

	public Ladder(Players players, LadderHeight ladderHeight){
		this.ladder = Collections.unmodifiableList(ladderLines(players, ladderHeight));
	}

	private List<LadderLine> ladderLines(Players players, LadderHeight ladderHeight){
		List<LadderLine> ladderLines = new ArrayList<>();

		for(int i=0; i<ladderHeight.getHeight(); i++){
			ladderLines.add(new LadderLine(players.size()));
		}

		return ladderLines;
	}

	public int size(){
		return this.ladder.size();
	}

	public String findLadderLine(int number){
		return this.ladder.get(number).findLadderLineNumber();
	}

	public String findLadderResult(String playerName, Players players, Prizes prizes){
		int position = players.findPosition(playerName);

		for(int i=0; i<ladder.size(); i++){
			position = ladder.get(i).moveLadderLine(position);
		}

		return prizes.findPrize(position);
	}

}
