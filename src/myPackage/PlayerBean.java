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
		for (CardBean cardBean : hand.getHandPlayer()) {
			handValue += cardBean.getFace().getValues();
		}
		return handValue;
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
