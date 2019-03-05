package myPackage;

public class PlayerBean {

	private String name;
	private HandBean hand;

	public PlayerBean() {
		super();
		hand = new HandBean();
	}

	public PlayerBean(String name) {
		this.name = name;
		hand = new HandBean();
	}

	public void addHand(HandBean handBean) {
		hand = handBean;
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
