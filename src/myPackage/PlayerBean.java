package myPackage;

public class PlayerBean {

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
		if (handValue > 21 && checkAceInHand()) {
			handValue -= 10;
		}
		return handValue;
	}

	public boolean checkAceInHand() {
		boolean aceResponse = false;
		for (CardBean cardBean : hand.getCardList()) {
			if (cardBean.getFace() == Face.ace) {
				aceResponse = true;
			}
		}
		return aceResponse;
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
