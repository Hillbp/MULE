import java.awt.Color;

public abstract class Player {
    private String name;
    private String race;
    private Color color;
    private int money;
    private int food;
    private int energy;
    private int smithore;


    public Player(String name, String race, Color color) {
	this.name = name;
	this.race = race;
	this.color = color;
    }

	/*Here there will be other methods that apply to both Player types,
		such as health, money, etc.*/

    public void initPlayer() {
        if (race.equals("Human")) {
            money = 600;
        } else if (race.equals("Flapper")) {
            money = 1600;
        } else {
            money = 1000;
        }
        food = 0;
        energy = 0;
        smithore = 0;
    }

    public void calculateProduction() {

    }

    public String getName() {
        return name;
    }

    public String getRace() {
        return race;
    }

    public Color getColor() {
        return color;
    }

    public int getMoney() {
        return money;
    }

    public int getFood() {
        return food;
    }

    public int getPower() {
        return power;
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