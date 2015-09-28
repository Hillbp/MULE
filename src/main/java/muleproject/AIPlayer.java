import java.awt.Color;

public class AIPlayer extends Player {

	private static int playerIndex = 0;
	
	public AIPlayer(String name, String race, Color color) {
        playerIndex++;
		super(name, race, color);
	}

	public AIPlayer() {
		this("AI " + String.valueOf(playerIndex) , "Mechtron", Color.BLUE);
	}

	/*Methods that only relate to AI players go here*/
}
