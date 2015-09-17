package muleproject;
import javafx.beans.property.StringProperty;
import javafx.beans.property.SimpleStringProperty;
public class AIPlayer extends Player {
	
	public AIPlayer(StringProperty name, StringProperty race, StringProperty color) {
		super(name, race, color, "AI");
	}

	public AIPlayer() {
		//TODO change race to actual race
		this(new SimpleStringProperty("comp"), new SimpleStringProperty(
                        "race"), new SimpleStringProperty("blue"));
	}

	/*Methods that only relate to ai players go here*/
}
