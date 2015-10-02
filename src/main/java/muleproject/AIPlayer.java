import javafx.scene.paint.Color;

public class AIPlayer extends Player {

	private static int playerIndex = 0;

	public AIPlayer(String name, String race, String color) {
		super(name, race, color);
        playerIndex++;
	}

	public AIPlayer() {
		super("AI " + String.valueOf(playerIndex), "Mechtron");
		int colorNum = (int) Math.random() * 4;
		boolean colorSuccess = false;
		String color = "";
		while (!colorSuccess) {
			if (colorNum == 0) {
				if (MuleProject.players.containsColor("gold")) {
					colorNum = (int) Math.random() * 4;
				} else {
					color = "gold";
					colorSuccess = true;
				}
			}
			if (colorNum == 1) {
				if (MuleProject.players.containsColor("black")) {
					colorNum = (int) Math.random() * 4;
				} else {
					color = "black";
					colorSuccess = true;
				}
			}
			if (colorNum == 2) {
				if (MuleProject.players.containsColor("white")) {
					colorNum = (int) Math.random() * 4;
				} else {
					color = "white";
					colorSuccess = true;
				}
			}
			if (colorNum == 3) {
				if (MuleProject.players.containsColor("darkblue")) {
					colorNum = (int) Math.random() * 4;
				} else {
					color = "darkblue";
					colorSuccess = true;
				}
			}
		}
		this.setColor(color);
	}
	/*Methods that only relate to AI players go here*/
}
