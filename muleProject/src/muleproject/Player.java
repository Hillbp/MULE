public abstract class Player {

	protected String type;
	protected String name;
	protected String race;
	protected String color;

	public Player(String name, String race, String color, String type) {
		this.name = name;
		this.race = race;
		this.color = color;
		this.type = type;
	}

	/*Here there will be other methods that apply to both Player types,
		such as health, money, etc.*/
}