package myPackage;

import java.util.Scanner;

public class GameService {

	private PlayerBean player1, bank;
	private DeckBean deck;

	public GameService() {
		super();
		player1 = new PlayerBean();
		bank = new PlayerBean();
		deck = new DeckBean();
	}

	// ------------------
	// methodes
	// -------------------

	public void startNewGame1P() {
		deck = new DeckBean();
		deck.shuffleCards();
		player1 = new PlayerBean("Player");
		bank = new PlayerBean("Bank");
		Scanner sc = new Scanner(System.in);
		giveHandPlayers();
		viewHandPlayers();
		playerTurn(sc);
		bankTurn(sc);
		andTheWinnerIs();
		continuGame(sc);
	}

	public void continuGame(Scanner sc) {
		System.out.println("continu game? 'y' for yes ou 'n' for no");
		String str = sc.nextLine();
		if (str.equals("y")) {
			player1.setHand(new HandBean());
			bank.setHand(new HandBean());
			giveHandPlayers();
			viewHandPlayers();
			playerTurn(sc);
			bankTurn(sc);
			andTheWinnerIs();
			continuGame(sc);
		} else if (str.equals("n")) {
			System.out.println("ok, bye bye.");
		} else {
			System.out.println("is not the good key, press 'y' or 'n'");
		}
	}

	public void giveHandPlayers() {
		player1.getHand().addCardStartGame(deck.pickCard(), deck.pickCard());
		bank.getHand().addCardStartGame(deck.pickCard(), deck.pickCard());
	}

	public void viewHandPlayers() {
		System.err.println(
				"bank have " + getBank().getHand().viewCardBankStartGame() + " and the score is " + bank.score);
		System.out.println(" ");
		System.out.println("Player have " + getPlayer1().getHand() + " and the value is "
				+ getPlayer1().handValuesCalculator() + " and the score is " + player1.score);
		System.out.println();
	}

	public void playerTurn(Scanner sc) {
		boolean res;
		String str = "";
		do {
			System.out.println("Player 1 do you want to add card? 'y' for yes, 'n' for no");
			str = sc.nextLine();
			res = true;
			if (str.equals("y")) {
				getPlayer1().getHand().addCard(getMyDeck().pickCard());
				System.out.println(" Player have " + getPlayer1().getHand() + " and the value is "
						+ getPlayer1().handValuesCalculator());
			} else if (str.equals("n")) {
				System.out.println("Ok for the player, bank turn now");
				res = false;
			} else {
				System.out.println("is not the good key, press 'y' or 'n'");
			}
		} while (res);

	}

	public void bankTurn(Scanner sc) {
		boolean res;
		String str = "";
		System.err.println("Bank have " + bank.getHand() + " and the value is " + bank.handValuesCalculator());
		do {
			System.err.println("Bank do you want to add card? 'y' for yes, 'n' for no");
			str = sc.nextLine();
			res = true;
			if (str.equals("y")) {
				getBank().getHand().addCard(getMyDeck().pickCard());
				System.err.println(
						" Bank have " + getBank().getHand() + " and the value is " + getBank().handValuesCalculator());
			} else if (str.equals("n")) {
				System.err.println("Ok for Bank!");
				res = false;
			} else {
				System.err.println("is not the good key, press 'y' or 'n'");
			}
		} while (res);

	}

	public void andTheWinnerIs() {
		if (calculateWinner() == null) {
			System.out.println("Egalité");
		} else if (calculateWinner()) {
			System.out.println("The Player win!!!");
			player1.score++;
		} else {
			System.err.println("The Bank win!!!");
			bank.score++;
		}
	}

	public Boolean calculateWinner() {
		Boolean winner = false;
		if (player1.handValuesCalculator() > 21) {
			winner = false;
		} else if (bank.handValuesCalculator() > 21) {
			winner = true;
		} else if (player1.handValuesCalculator() > bank.handValuesCalculator()) {
			winner = true;
		} else if (player1.handValuesCalculator() == bank.handValuesCalculator()) {
			if (player1.getHand().showNbCard() < bank.getHand().showNbCard()) {
				winner = true;
			} else if (player1.getHand().showNbCard() == bank.getHand().showNbCard()) {
				winner = null;
			} else {
				winner = false;
			}
		} else {
			winner = false;
		}
		return winner;
	}

	// -------------------
	// getter & setter
	// -----------------

	public PlayerBean getPlayer1() {
		return player1;
	}

	public PlayerBean getBank() {
		return bank;
	}

	public DeckBean getMyDeck() {
		return deck;
	}

	public void setPlayer1(PlayerBean player1) {
		this.player1 = player1;
	}

	public void setBank(PlayerBean bank) {
		this.bank = bank;
	}

	public void setMyDeck(DeckBean myDeck) {
		deck = myDeck;
	}

}
