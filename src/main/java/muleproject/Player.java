import javafx.scene.paint.Color;

public abstract class Player {
    private String name;
    private String race;
    private Color color;
    private int money;
    private int food;
    private int energy;
    private int smithore;

    private Property[] properties = new Property[32];
    private int propertyLength = 0;


    public Player(String name, String race, Color color) {
	this.name = name;
	this.race = race;
	this.color = color;
    initPlayer();
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
        food = 8;
        energy = 4;
        smithore = 0;
    }

    public void addProperty(Property p) {
        properties[propertyLength] = p;
        propertyLength++;
    }

    //TODO Implement this method
    public Property removeProperty(Property p) {
        return null;
    }

    public void calculateProduction() {
        int i = 0;
        int moneyProd = 0;
        int foodProd = 0;
        int eProd = 0;
        int smithProd = 0;
        while (i < propertyLength) {
            Property prop = properties[i];
        }
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

    public int getEnergy() {
        return energy;
    }

    public int getSmithore() {
        return smithore;
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

    public void setMoney(int money) {
        this.money = money;
    }

    public void addMoney(int money) {
        this.money = this.money + money;
    }

    public void setFood(int food) {
        this.food = food;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public void setSmithore(int smithore) {
        this.smithore = smithore;
    }
}