package myPackage;

public class Launcher {

	public static void main(String[] args) {

		boolean playerResponse = true;

		GameService game = new GameService();
		IHM ihm = new IHM();
		game.startNewGame1P();
		do {
			ihm.gameSuite(game);
			if (playerResponse) {
				game.nextGame();
			}
		} while (ihm.continuGame(playerResponse));
	}
}
