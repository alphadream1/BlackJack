package myPackage;

import java.util.Scanner;

public class Launcher {

	public static void main(String[] args) {

		GameService game = new GameService();
		game.startNewGame1P("bob");
		Scanner sc = new Scanner(System.in);

		// jeux de test
		System.out.println(game.getMyDeck());

		System.err.println(game.getPlayer1().getName());
		System.err.println(game.getPlayer1().getHand());
		System.err.println(game.getPlayer1().handValuesCalculator());

		System.out.println(game.getBank().getName());
		System.out.println(game.getBank().getHand());
		System.out.println(game.getBank().handValuesCalculator());
		game.getBank().getHand().addCard(game.getMyDeck().pickCard());
		System.out.println(game.getBank().getHand());
		System.out.println(game.getBank().handValuesCalculator());

	}

}
