import javafx.scene.paint.Color;

public class AIPlayer extends Player {

	private static int playerIndex = 0;

	public AIPlayer(String name, String race, String color) {
		super(name, race, color);
        playerIndex++;
	}

	public AIPlayer() {
		super("AI " + String.valueOf(playerIndex), "Mechtron");
		String color = "";
		if (!MuleProject.players.containsColor("gold")) {
			color = "gold";
		} else if (!MuleProject.players.containsColor("black")) {
			color = "black";
		} else if (!MuleProject.players.containsColor("white")) {
			color = "white";
		} else {
			color = "darkblue";
		}
		this.setColor(color);
	}
	/*Methods that only relate to AI players go here*/
}
