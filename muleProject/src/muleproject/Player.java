import javafx.beans.property.StringProperty;
import javafx.beans.property.SimpleStringProperty;

package muleproject;

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
    public String getType() {
        return type.get();
    }

    public StringProperty typeProperty() {
        return type;
    }

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

    public String getColor() {
        return color.get();
    }

    public StringProperty colorProperty() {
        return color;
    }

    public void setType(String type) {
        this.type.set(type);
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public void setRace(String race) {
        this.race.set(race);
    }

    public void setColor(String color) {
        this.color.set(color);
    }
}