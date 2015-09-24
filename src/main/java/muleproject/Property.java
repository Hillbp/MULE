public class Property {
    private int propNum;
    private int propValue;
    private String propType;
    private boolean isBought = false;
    private Player owner;

    public Property(int num, int value, String type) {
        propNum = num;
        propValue = value;
        propType = type;
    }

    public int getNum() {
        return propNum;
    }

    public int getValue() {
        return propValue;
    }

    public String getType() {
        return propType;
    }

    public void setNum(int newNum) {
        propNum = newNum;
    }

    public void setValue(int value) {
        propValue = value;
    }

    public void setType(String type) {
        propType = type;
    }

    public boolean isBought() {
        return isBought;
    }

    public void toggleBought() {
        if (!isBought) {
            isBought = true;
        } else {
            isBought = false; 
        }
    }

    public Player getOwner() {
        return owner;
    }

    public void setOwner(Player newOwner) {
        owner = newOwner;
    }
}