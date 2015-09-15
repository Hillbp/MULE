import javafx.beans.property.StringProperty;
import javafx.beans.property.SimpleStringProperty;

public abstract class Player {
    protected StringProperty type;
    protected StringProperty name;
    protected StringProperty race;
    protected StringProperty color;

    public Player(String name, String race, String color, String type) {
	this.name = new SimpleStringProperty(name);
	this.race = new SimpleStringProperty(race);
	this.color = new SimpleStringProperty(color);
	this.type = new SimpleStringProperty(type);
    }

	/*Here there will be other methods that apply to both Player types,
		such as health, money, etc.*/
}