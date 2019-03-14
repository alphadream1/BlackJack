package myPackage;

import java.util.Scanner;

public class Launcher {

	private static final String RESPONSE_YES = "y";
	private static final String RESPONSE_NO = "n";
	public static Scanner sc;

	public static void main(String[] args) {

		sc = new Scanner(System.in);
		GameService game = new GameService();
		game.startNewGame1P();
		gameSuite(game);
		continuGame(game);

	}

	public static void continuGame(GameService game) {
		boolean res = true;
		do {
			System.out.println("continu game? 'y' for yes ou 'n' for no");
			String playerResponse = sc.nextLine();
			if (RESPONSE_YES.equals(playerResponse)) {
				game.nextGame();
				gameSuite(game);
				continuGame(game);
			} else if (RESPONSE_NO.equals(playerResponse)) {
				System.out.println("ok, bye bye.");
				res = false;
			} else {
				System.out.println("is not the good key, press 'y' or 'n'");
			}
		} while (res);
	}

	public static void gameSuite(GameService game) {
		viewHandPlayers(game);
		playerTurn(game);
		bankTurn(game);
		andTheWinnerIs(game);
		continuGame(game);
	}

	public static void viewHandPlayers(GameService game) {
		System.out.println("bank have " + game.getBank().getHand().viewCardBankStartGame() + " and the score is "
				+ game.getBank().score);
		System.out.println(" ");
		System.out.println("Player have " + game.getPlayer1().getHand() + " and the value is "
				+ game.getPlayer1().handValuesCalculator() + " and the score is " + game.getPlayer1().score);
		System.out.println();
	}

	public static void playerTurn(GameService game) {
		boolean res;
		String str = "";
		do {
			System.out.println("Player 1 do you want to add card? 'y' for yes, 'n' for no");
			str = sc.nextLine();
			res = true;
			if (str.equals(RESPONSE_YES)) {
				game.drawCardPlayer();
				System.out.println(" Player have " + game.getPlayer1().getHand() + " and the value is "
						+ game.getPlayer1().handValuesCalculator());
			} else if (str.equals(RESPONSE_NO)) {
				System.out.println("Ok for the player, bank turn now");
				res = false;
			} else {
				System.out.println("is not the good key, press 'y' or 'n'");
			}
		} while (res);

	}

	public static void bankTurn(GameService game) {
		System.out.println(
				"Bank have " + game.getBank().getHand() + " and the value is " + game.getBank().handValuesCalculator());
		while (game.getBank().handValuesCalculator() < 17) {
			System.out.println("Bank pick a card");
			game.drawCardBank();
			System.out.println();
			System.out.println(" Bank have " + game.getBank().getHand() + " and the value is "
					+ game.getBank().handValuesCalculator());
		}
	}

	public static void andTheWinnerIs(GameService game) {
		if (game.calculateWinner() == null) {
			System.out.println("Egalité");
		} else if (game.calculateWinner()) {
			System.out.println("The Player win!!!");
			game.getPlayer1().score++;
		} else {
			System.out.println("The Bank win!!!");
			game.getBank().score++;
		}
	}
}
