public class Mule {
    private String type;
    private Property property;
    private Player owner;

    public Mule() {
        type = "";
    }

    public Mule(String type) {
        this.type = type;
    }

    public void setType(String s) {
        type = s;
    }

    public void setProperty(Property property) {
        this.property = property;
    }
    public String getType() {
        return type;
    }

    public Property getProperty() {
        return property;
    }

    public Player getOwner() {
        return owner;
    }

    public void setOwner(Player p) {
        owner = p;
    }
    @Override
    public boolean equals(Object o) {
        boolean result = false;
        if (o instanceof Mule) {
            Mule that = (Mule) o;
            result = (this.getType().equals(that.getType()) && this.getProperty().equals(that.getProperty()));
        }
        return result;
    }
}