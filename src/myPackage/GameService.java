package myPackage;

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
		deck.shuffleCards();
		player1 = new PlayerBean("Player");
		bank = new PlayerBean("Bank");
		giveHandPlayers();
	}

	public void nextGame() {
		player1.setHand(new HandBean());
		bank.setHand(new HandBean());
		giveHandPlayers();
	}

	public void giveHandPlayers() {
		player1.getHand().addCardStartGame(deck.pickCard(), deck.pickCard());
		bank.getHand().addCardStartGame(deck.pickCard(), deck.pickCard());
	}

	public void drawCardPlayer() {
		getPlayer1().getHand().addCard(getMyDeck().pickCard());
	}

	public void drawCardBank() {
		getBank().getHand().addCard(getMyDeck().pickCard());
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
