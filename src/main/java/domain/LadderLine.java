package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LadderLine {
	private static final int ZERO = 0;
	private static final int ONE = 1;
	private static final String EMPTY = "     ";
	private static final String LINE = "-----";
	private static final String PIPE = "|";
	private final List<Integer> ladderLine;

	public LadderLine(int playerCount) {
		this.ladderLine = Collections.unmodifiableList(line(playerCount));
	}

	private List<Integer> line(int playerCount) {
		List<Integer> lineNumber = new ArrayList<>();
		for (int i = 0; i < playerCount; i++) {
			lineNumber.add(randomLine(getBeforeLine(lineNumber)));
		}

		return lineNumber;
	}

	private int getBeforeLine(List<Integer> lineNumber) {
		if (lineNumber.size() == ZERO) {
			return ZERO;
		}

		return lineNumber.get(lineNumber.size() - ONE);
	}

	private int randomLine(int beforeLine) {
		if (beforeLine == ZERO) {
			return LadderRandom.random();
		}
		return ZERO;
	}

	public int size() {
		return this.ladderLine.size();
	}

	public String findLadderLineNumber() {
		String line = PIPE;
		for (int i = ZERO; i < ladderLine.size() - ONE; i++) {
			line += ladderNumber(i) + PIPE;
		}

		return line;
	}

	private String ladderNumber(int number) {
		int lineNumber = this.ladderLine.get(number);
		if (lineNumber == LadderLine.ONE) {
			return LINE;
		}
		return EMPTY;
	}

	public int moveLadderLine(int position) {
		int leftPosition = leftPosition(position);
		int rightPosition = rightPosition(position);

		return movePosition(position, leftPosition, rightPosition);
	}

	private int leftPosition(int position) {
		if (position != ZERO && ladderLine.get(position - ONE) == ONE) {
			return ONE;
		}

		return ZERO;
	}

	private int rightPosition(int position) {
		int positionMax = ladderLine.size() - ONE;
		if (position != positionMax && ladderLine.get(position) == ONE) {
			return ONE;
		}

		return ZERO;
	}

	private int movePosition(int position, int leftPosition, int rightPosition) {
		if (leftPosition == ONE) {
			return position - ONE;
		}

		if (rightPosition == ONE) {
			return position + ONE;
		}

		return position;
	}
}
