package muleproject;

/**
 * @author Brandon Hill
 * @version 1.0
 *
 */

public class Settings {
    /**
     * The number of players
     * <p>
     * The number of human players for this game. Determined by the player(s) at the startup screen.
     */
    private static int numPlayers;

    /**
     * The type of the map
     * <p>
     * An enum that contains the three possible map types that a player can choose.
     */
    public enum Maptype {
        STANDARD,
        WETLAND,
        MOUNTAIN;
    }

    /**
     * The difficulty setting of the game
     * <p>
     * An enum that contains the three possible difficulties of the game. Selected by the player in the startup screen.
     * <p>
     * In this project, only EASY difficulty will actually be implemented.
     */
    public enum Difficulty {
        EASY,
        NORMAL,
        TOURNAMENT
    }

    /**
     * The difficulty selected by the player(s)
     */
    private static Difficulty diff;
    /**
     * The type of map selected by the player
     */
    private static Maptype map;

    /**
     * Sets the difficulty of the game
     * @param difficult The difficulty that the player(s) selected at startup
     */
    public static void setDifficulty(Difficulty difficult) {
        diff = difficult;
    }

    /**
     * Sets the number of human players for the game
     * @param num The number of players the player(s) selected at startup (1-4)
     */
    public static void setNumPlayers(int num) {
        numPlayers = num;
    }

    /**
     * Sets the map type for the game
     * @param mapper The type of map the player(s) selected at startup
     */
    public static void setMapType(Maptype mapper) {
        map = mapper;
    }

    /**
     * Returns the current game's difficulty
     * @return The difficulty of the game
     */
    public Difficulty getDifficulty() {
        return diff;
    }

    /**
     * Returns the current game's map type
     * @return The type of mape for the game
     */
    public Maptype getMaptype() {
        return map;
    }

    /**
     * Returns the current game's number of human players
     * @return The number of human players of the game
     */
    public int getPlayers() {
        return numPlayers;
    }
}