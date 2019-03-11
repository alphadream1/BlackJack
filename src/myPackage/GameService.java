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

	public void startNewGame1P(String namePlayer1) {
		deck = new DeckBean();
		deck.shuffleCards();
		player1 = new PlayerBean(namePlayer1);
		bank = new PlayerBean("Bank");
		player1.getHand().addCardStartGame(deck.pickCard(), deck.pickCard());
		bank.getHand().addCardStartGame(deck.pickCard(), deck.pickCard());

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
