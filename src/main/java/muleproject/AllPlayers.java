import java.awt.Color;

public class AllPlayers{

	private Player[] playerList = new Player[4];
	private int numPlayers = 0;

    /**
     * this method will tell which player is currently
     * selecting his options; do this by counting the
     * first blank space in the array and adding 1 to
     * the place number
     * @return int the player number who is choosing his settings
     */
    public int currentPlayerSettingsNum() {
        return numPlayers + 1;
    }

    /**
     * this method adds a new player to the array
     * @param player player to add
     */
    public void addPlayer(HumanPlayer player) {
        playerList[this.currentPlayerSettingsNum()] = player;
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
        int playernum = playerCount();
        for (int i = playernum - 1; i < 4; i++) {
            playerList[i] = new AIPlayer();
        }
    }

    /**
     * this method checks to see if the array already contains
     * a player with this name
     *
     * need to make a getName() method, but where?
     *
     * @param playerName name of player
     * @return boolean whether contains name or not
     */
    public boolean containsName(String playerName) {
        for (int i = 0; i <= numPlayers; i++) {
            if (playerList[i] != null) {
                if (playerList[i].getName().equalsIgnoreCase(playerName)) {
                    return true;
                }
            }
        }
        return false;
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
        for (int i = 0; i <= numPlayers; i++) {
            if (playerList[i] != null) {
                if (playerList[i].getColor().equals(playerColor)) {
                    return true;
                }
            }
        }
        return false;
    }

}