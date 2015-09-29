import javafx.scene.paint.Color;

public class AIPlayer extends Player {

	private static int playerIndex = 0;
	
	public AIPlayer(String name, String race, Color color) {
		super(name, race, color);
        playerIndex++;
	}

	public AIPlayer() {
		this("AI " + String.valueOf(playerIndex) , "Mechtron", Color.BLUE);
	}

	/*Methods that only relate to AI players go here*/
}
