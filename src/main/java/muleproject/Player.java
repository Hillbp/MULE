import java.awt.Color;

public abstract class Player {
    private String name;
    private String race;
    private Color color;


    public Player(String name, String race, Color color) {
	this.name = name;
	this.race = race;
	this.color = color;
    }

	/*Here there will be other methods that apply to both Player types,
		such as health, money, etc.*/

    public String getName() {
        return name;
    }

    public String getRace() {
        return race;
    }

    public Color getColor() {
        return color;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}