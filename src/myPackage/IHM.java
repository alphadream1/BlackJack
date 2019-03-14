package myPackage;

import java.util.Scanner;

public class IHM {

	private static final int BLACK_JACK = 21;
	private static final String RESPONSE_YES = "y";
	private static final String RESPONSE_NO = "n";
	public static Scanner scannerConsole;

	public IHM() {
		scannerConsole = new Scanner(System.in);
	}

	public boolean continuGame(boolean response) {
		System.out.println("continu game? 'y' for yes ou 'n' for no");
		String playerResponse = scannerConsole.nextLine();
		boolean whileContinu = true;
		while (whileContinu) {
			if (RESPONSE_YES.equals(playerResponse)) {
				System.out.println("cool, go next game!");
				response = true;
				whileContinu = false;
			} else if (RESPONSE_NO.equals(playerResponse)) {
				System.out.println("ok, bye bye.");
				whileContinu = false;
				response = false;
			} else {
				System.out.println("is not the good key, press 'y' or 'n'");
			}
		}
		return response;
	}

	public void gameSuite(GameService game) {
		viewHandPlayers(game);
		playerTurn(game);
		bankTurn(game);
		andTheWinnerIs(game);
	}

	public void viewHandPlayers(GameService game) {
		System.out.println("bank have " + game.getBank().getHand().viewCardBankStartGame() + " and the score is "
				+ game.getBank().score);
		System.out.println(" ");
		System.out.println("Player have " + game.getPlayer1().getHand() + " and the value is "
				+ game.getPlayer1().handValuesCalculator() + " and the score is " + game.getPlayer1().score);
		System.out.println();
	}

	public void playerTurn(GameService game) {
		boolean doWhileStatement = true;
		String playerResponse = "";
		do {
			if (game.getPlayer1().handValuesCalculator() == BLACK_JACK
					&& game.getPlayer1().getHand().showNbCard() == 2) {
				System.out.println("Black Jack !");
				doWhileStatement = false;
			} else if (game.getPlayer1().handValuesCalculator() == BLACK_JACK) {
				System.out.println("Yeah 21 !!!");
				doWhileStatement = false;
			} else if (game.getPlayer1().handValuesCalculator() > BLACK_JACK) {
				System.out.println("sorry to big !");
				doWhileStatement = false;
			} else {
				System.out.println("Player 1 do you want to add card? 'y' for yes, 'n' for no");
				playerResponse = scannerConsole.nextLine();
				if (RESPONSE_YES.equals(playerResponse)) {
					game.drawCardPlayer();
					System.out.println(" Player have " + game.getPlayer1().getHand() + " and the value is "
							+ game.getPlayer1().handValuesCalculator());
					doWhileStatement = true;
				} else if (RESPONSE_NO.equals(playerResponse)) {
					System.out.println("Ok for the player, bank turn now");
					doWhileStatement = false;
				} else {
					System.out.println("is not the good key, press 'y' or 'n'");
				}
			}
		} while (doWhileStatement);

	}

	public void bankTurn(GameService game) {
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

	public void andTheWinnerIs(GameService game) {
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
