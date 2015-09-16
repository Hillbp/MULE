package muleproject;

public class AIPlayer extends Player {
	
	public AIPlayer(String name, String race, String color) {
		super(name, race, color, "AI");
	}

	public AIPlayer() {
		//TODO change race to actual race
		this("comp", "race", "blue");
	}

	/*Methods that only relate to ai players go here*/
}
