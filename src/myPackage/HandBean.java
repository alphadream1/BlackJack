package myPackage;

import java.util.ArrayList;
import java.util.List;

public class HandBean {

	private List<CardBean> handPlayer;

	// ----------------
	// constructor
	// -----------------

	public HandBean() {
		super();
		handPlayer = new ArrayList<>();
	}

	// -------------------
	// methode
	// ------------------

	public void addCardStartGame(CardBean card1, CardBean card2) {
		handPlayer.add(card1);
		handPlayer.add(card2);
	}

	public void addCard(CardBean card) {
		handPlayer.add(card);
	}

	public CardBean viewCardBankStartGame() {
		return getHandPlayer().get(1);
	}

	@Override
	public String toString() {
		StringBuffer handToString = new StringBuffer();
		for (CardBean cardBean : handPlayer) {
			handToString.append(cardBean.toString() + "\n");
		}
		return handToString.toString();
	}

	// ----------------
	// getter & setter
	// ----------------

	public List<CardBean> getHandPlayer() {
		return handPlayer;
	}

	public void setHandPlayer(List<CardBean> handPlayer) {
		this.handPlayer = handPlayer;
	}

}
