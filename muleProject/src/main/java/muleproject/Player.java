import javafx.beans.property.StringProperty;
import javafx.beans.property.SimpleStringProperty;

public abstract class Player {
    protected StringProperty name;
    protected StringProperty race;
    protected Color color;

    public Player(String name, String race, Color color) {
	this.name = new SimpleStringProperty(name);
	this.race = new SimpleStringProperty(race);
	this.color = color;
    }

	/*Here there will be other methods that apply to both Player types,
		such as health, money, etc.*/

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public String getRace() {
        return race.get();
    }

    public StringProperty raceProperty() {
        return race;
    }

    public Color getColor() {
        return color;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public void setRace(String race) {
        this.race.set(race);
    }

    public void setColor(Color color) {
        this.color = color;
    }
}