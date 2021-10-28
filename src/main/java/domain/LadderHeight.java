package domain;

public class LadderHeight {
	private static final int MINIMUM_LENGTH = 2;
	private static final String HEIGHT_LENGTH_ERROR_MESSAGE = "error : 사다리 높이는 최소 2이상 입니다.";
	private final int height;

	public LadderHeight(int height){
		checkHeightLength(height);
		this.height = height;
	}

	private void checkHeightLength(int height){
		if(height < MINIMUM_LENGTH){
			throw new IllegalArgumentException(HEIGHT_LENGTH_ERROR_MESSAGE);
		}
	}

	public int getHeight() {
		return height;
	}

}
