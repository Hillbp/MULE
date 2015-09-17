package muleproject;

import javafx.beans.property.StringProperty;
import javafx.beans.property.SimpleStringProperty;
public class HumanPlayer extends Player {
	
	public HumanPlayer(StringProperty name, StringProperty race, StringProperty color) {
		super(name, race, color, "Human");
	}

	/*Methods that only relate to human players go here*/
}