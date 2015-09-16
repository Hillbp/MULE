import java.util.ArrayList;

public class AllPlayers{

	private ArrayList playerList = new ArrayList<Player>(4);
	private int numPlayers = 0;

	public AllPlayers(int numHumans) {
		//TODO
		//Do we actually need a constructor here?
	}

	/**
	 * this method will tell which player is currently
	 * selecting his options; do this by counting the
	 * first blank space in the array and adding 1 to
	 * the place number
	 * @return int the player number who is choosing his settings
	 */
	public int currentPlayerSettingsNum() {
		//TODO
        return 0;
	}

	/**
	 * this method adds a new player to the array
	 * @param player player to add
	 */
	public void addPlayer(HumanPlayer player) {
		playerList.append(player);
		numPlayers++;
	}

	/**
	 * tells how many human players are already in the array
	 * @return int number of human players already in the array
	 */
	public int playerCount() {
		return numPlayers;
	}

	/**
	 * this method fills the rest of the array
	 * with CPUs and only executes after all the players
	 * have been added
	 *
	 */
	public void addCPUs() {
		int playernum = playerList.playerCount();
		for (int i = playernum; i < 4; i++) {
			playerList.append(new AIPlayer());
		}
	}

	/**
	 * this method checks to see if the array already contains
	 * a player with this name
	 *
	 * need to make a getName() method, but where?
	 *
	 * @param playerName
	 * @return boolean whether contains name or not
	 */
	public boolean containsName(String playerName) {
		for (int i = 0; i < numPlayers; i++) {
			if (playerList[i].getName().equals(playerName)) {
				return true;
			} else {
				return false;
			}
		}
	}

	/*
     *this method checks to see if the array already contains
     * a player with this color
     *
     * need to make a getColor() method, but where?
     *
     * @return boolean whether contains color or not
     */
	public boolean containsColor(Color playerColor) {
		for (int i = 0; i < numPlayers; i++) {
			if (playerList[i].getColor().equals(playerColor)) {
				return true;
			} else {
				return false;
			}
		}
	}


}