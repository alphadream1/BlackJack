package myPackage;

public class Launcher {

	public static void main(String[] args) {

		boolean playerResponse = true;

		GameService gameService = new GameService();
		IHM ihm = new IHM();
		gameService.startNewGame1P();
		do {
			ihm.gameSuite(gameService);
			if (playerResponse) {
				gameService.nextGame();
			}
		} while (ihm.continuGame(playerResponse));
	}
}
