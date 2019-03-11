package myPackage;

import java.util.ArrayList;
import java.util.List;

public class HandBean {

	private List<CardBean> cardList;

	// ----------------
	// constructor
	// -----------------

	public HandBean() {
		super();
		cardList = new ArrayList<>();
	}

	// -------------------
	// methode
	// ------------------

	public void addCardStartGame(CardBean card1, CardBean card2) {
		cardList.add(card1);
		cardList.add(card2);
	}

	public void addCard(CardBean card) {
		cardList.add(card);
	}

	public CardBean viewCardBankStartGame() {
		return cardList.get(1);
	}

	public int showNbCard() {
		int nbCard = 0;
		for (; nbCard > cardList.size(); nbCard++) {
		}
		return nbCard;
	}

	@Override
	public String toString() {
		StringBuffer handToString = new StringBuffer();
		for (CardBean cardBean : cardList) {
			handToString.append(cardBean.toString() + "\n");
		}
		return handToString.toString();
	}

	public List<CardBean> getCardList() {
		return cardList;
	}

	// ----------------
	// getter & setter
	// ----------------

}
