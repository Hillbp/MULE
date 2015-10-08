import javafx.scene.paint.Color;

public class Property {
    private int propNum;
    private int propValue;
    private String propType;
    private boolean isBought = false;
    private boolean hasMule;
    private Player owner;
    private int col;
    private int row;

    public Property(int num, int value, String type, int row, int col) {
        propNum = num;
        propValue = value;
        propType = type;
        this.row = row;
        this.col = col;
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
        isBought = !isBought;
    }

    public Player getOwner() {
        return owner;
    }

    public void setOwner(Player newOwner) {
        owner = newOwner;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setCol(int col) {
        this.col = col;
    }

    @Override
    public boolean equals(Object o) {
        boolean result = false;
        if (o instanceof Property) {
            Property that = (Property) o;
            result = (this.getNum() == that.getNum());
        }
        return result;
    }
}