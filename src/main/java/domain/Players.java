package domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Players {
	private static final String COMMA = ",";
	private static final int MINIMUM_NAME_LENGTH = 1;
	private static final int MAXIMUM_NAME_LENGTH = 5;
	private static final int MINIMUM_PLAYER_COUNT = 2;
	private static final String EMPTY = "  ";
	private static final String LENGTH_ERROR_MESSAGE = "error : 참가자 이름은 1이상 5이하 길이만 입력가능 합니다.";
	private static final String NULL_ERROR_MESSAGE = "error : 참가자는 NULL 을 가질수 없습니다.";
	private static final String EMPTY_ERROR_MESSAGE = "error : 참가자는 공백을 입력할수 없습니다.";
	private static final String PLAYER_COUNT_ERROR_MESSAGE = "error : 참가자는 최소 2명 이상입니다.";
	private static final String PLAYER_ERROR_MESSAGE = "error : 해당 플레이어 는 없습니다.";
	private static final String PLAYER_ALL = "all";

	private final List<Player> players;

	public Players(String player) {
		checkPlayerNull(player);
		checkPlayerEmpty(player);
		this.players = Collections.unmodifiableList(playerArray(player));
	}

	private List<Player> playerArray(String player) {
		String[] playerArray = ofStringArray(player);
		checkPlayerCount(playerArray);
		checkPlayerNameLength(playerArray);

		return Arrays.stream(playerArray)
			.map(Player::new)
			.collect(Collectors.toList());
	}

	private String[] ofStringArray(String player) {
		return player.split(COMMA);
	}

	private void checkPlayerCount(String[] player){
		long playerCount = Arrays.stream(player)
			.count();

		if(playerCount < MINIMUM_PLAYER_COUNT){
			throw new IllegalArgumentException(PLAYER_COUNT_ERROR_MESSAGE);
		}
	}

	private void checkPlayerNameLength(String[] player) {
		long playerNameLength = Arrays.stream(player)
			.filter(i -> i.length() >= MINIMUM_NAME_LENGTH && i.length() <= MAXIMUM_NAME_LENGTH)
			.count();

		if (playerNameLength != player.length) {
			throw new IllegalArgumentException(LENGTH_ERROR_MESSAGE);
		}
	}

	private void checkPlayerNull(String player) {
		if (player == null) {
			throw new IllegalArgumentException(NULL_ERROR_MESSAGE);
		}
	}

	private void checkPlayerEmpty(String player) {
		if (player.isEmpty()) {
			throw new IllegalArgumentException(EMPTY_ERROR_MESSAGE);
		}
	}

	public int size() {
		return this.players.size();
	}

	public String findPlayer(int number) {
		return this.players.get(number).getPlayer();
	}

	public String findPlayerGroup(){
		return this.players
			.stream()
			.map(i -> i.getPlayer())
			.collect(Collectors.joining(EMPTY));
	}

	public String checkPlayer(String player){
		if(player.equals(PLAYER_ALL)){
			return player;
		}

		return this.players
			.stream()
			.map(i -> i.getPlayer())
			.filter(i -> i.equals(player))
			.findFirst()
			.orElseThrow(() -> new IllegalArgumentException(PLAYER_ERROR_MESSAGE));
	}

	public int findPosition(String playerName){
		for(int i=0; i<players.size(); i++){
			if(players.get(i).getPlayer() == playerName){
				return i;
			}
		}

		return 0;
	}
}
