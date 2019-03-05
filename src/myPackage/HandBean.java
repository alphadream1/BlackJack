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

	public void addCardStartGame(CardBean card1, CardBean card2) {
		handPlayer.add(card1);
		handPlayer.add(card2);
	}

	public void addCard(CardBean card) {
		handPlayer.add(card);
	}

	@Override
	public String toString() {
		String handToString = "";
		for (CardBean cardBean : handPlayer) {
			handToString += cardBean.toString() + "\n";
		}
		return handToString;
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
