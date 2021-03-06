import javafx.scene.paint.Color;

public abstract class Player {
    private String name;
    private String race;
    private String color;
    private int money;
    private int food;
    private int energy;
    private int smithore;
    private int score;

    private Mule[] mules =  new Mule[20];
    private Property[] properties = new Property[32];
    private int propertyLength = 0;
    private int muleNum;


    public Player(String name, String race) {
        this.name = name;
        this.race = race;
        initPlayer();
    }
    public Player(String name, String race, String color) {
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
            score = 600;
        } else if (race.equals("Flapper")) {
            money = 1600;
            score = 1600;
        } else {
            money = 1000;
            score = 1000;
        }
        food = 8;
        energy = 4;
        smithore = 0;
        muleNum = 0;
    }

    public void addProperty(Property p) {
        properties[propertyLength] = p;
        propertyLength++;
    }

    public void addMule(Mule m) {
        m.setOwner(this);
        mules[muleNum] = m;
        muleNum++;
    }

    public Property removeProperty(Property p) {
        Property removed = null;
        for (int i = 0; i < propertyLength; i++) {
            if (properties[i].equals(p)) {
                removed = properties[i];
                for (int j = i + 1; j < properties.length; j++) {
                    properties[j - 1] = properties[j];
                }
                properties[properties.length - 1] = null;
                propertyLength--;
            }
        }
        return removed;
    }

    public Mule removeMule(Mule m) {
        Mule removed = null;
        for (int i = 0; i < muleNum; i++) {
            if (mules[i].equals(m)) {
                removed = mules[i];
                for (int j = i + 1; j < mules.length; j++) {
                    mules[j - 1] = mules[j];
                }
                mules[mules.length - 1] = null;
                muleNum--;
            }
        }
        return removed;
    }

    public Property[] getProperties() {
        return properties;
    }
    
    public Mule[] getMules() {
        return mules;
    }
    public int calculateScore() {
        score = ((propertyLength*500) + getMoney() +
                getFood()*30 + getEnergy()*25 + getSmithore()*50);
        return score;
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

    public int getScore() {
        score = calculateScore();
        return score;
    }

    /*
     *supposed to compare the players by score
     * so the priority queue knows which to remove
     * in what order
     */

    //@Override
    public int compareTo(Player p) {
        if (this.getScore() < p.getScore()) {
            return -1;
        } else if (this.getScore() > p.getScore()) {
            return 1;
        } else {
            return 0;
        }
    }


    public String getName() {
        return name;
    }

    public String getRace() {
        return race;
    }

    public String getColor() {
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

    public void setColor(String color) {
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

    public void addFood(int food) {
        this.food = this.food + food;
        if (this.food < 0) {
            this.food = 0;
        }
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public void setSmithore(int smithore) {
        this.smithore = smithore;
    }
}