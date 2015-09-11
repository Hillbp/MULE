public class AllPlayers{

	private Player[] playerList;

	public AllPlayers(int numHumans) {
		for(int i = 0; i < numHumans, i++) {
			playerList.append(new HumanPlayer(<stuff>));
		}
		for(i, i < 4, i ++) {
			playerList.append(new AIPlayer(<stuff>));
		}
	}
}