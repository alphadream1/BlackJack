package myPackage;

public class PlayerBean {

	private static final int BLACK_JACK = 21;
	private String name;
	private HandBean hand;
	int score;

	public PlayerBean() {
		super();
		hand = new HandBean();
		score = 0;
	}

	public PlayerBean(String name) {
		this.name = name;
		hand = new HandBean();
		score = 0;
	}

	// ---------------------
	// methode
	// ---------------------

	public int handValuesCalculator() {
		int handValue = 0;
		for (CardBean cardBean : hand.getCardList()) {
			handValue += cardBean.getFace().getValues();
		}
		if (handValue > BLACK_JACK) {
			for (int numberOfAce = checkAceInHand(); numberOfAce > 0; numberOfAce--) {
				handValue -= 10;
			}
		}
		return handValue;
	}

	public int checkAceInHand() {
		int aceCount = 0;
		for (CardBean cardBean : hand.getCardList()) {
			if (cardBean.getFace() == Face.ace) {
				aceCount++;
			}
		}
		return aceCount;
	}

	public boolean checkBlackJack() {
		boolean blackJackResponse = false;
		if (handValuesCalculator() == BLACK_JACK && hand.showNbCard() == 2) {
			blackJackResponse = true;
		}
		return blackJackResponse;
	}

	// ----------------
	// getter & setter
	// ----------------

	public String getName() {
		return name;
	}

	public HandBean getHand() {
		return hand;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setHand(HandBean hand) {
		this.hand = hand;
	}
}
