package myPackage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DeckBean {

	private List<CardBean> cardList;

	public DeckBean() {
		cardList = new ArrayList<>();

		for (Color color : Color.values()) {
			for (Face face : Face.values()) {
				CardBean card = new CardBean(color, face);
				cardList.add(card);
			}
		}
	}

	public void shuffleCards() {
		Collections.shuffle(cardList);
	}

	public CardBean pickCard() {
		CardBean pickCard;
		pickCard = cardList.remove(0);
		return pickCard;
	}

	@Override
	public String toString() {
		StringBuffer deckToString = new StringBuffer();
		for (CardBean cardBean : cardList) {
			deckToString.append(cardBean.toString() + "\n");
		}
		return deckToString.toString();
	}

	public void printNumberOfCards() {
		System.out.println(cardList.size());
	}

	// methode deprecated
	@Deprecated
	public void printDeck() {
		for (CardBean cardBean : cardList) {
			System.out.println(cardBean.getFace() + " of " + cardBean.getColor());
		}
	}

}
