package myPackage;

import java.util.ArrayList;

public class DeckBean {

	private ArrayList<CardBean> cardList;

	public DeckBean() {
		cardList = new ArrayList<>();

		for (Color color : Color.values()) {
			for (Face face : Face.values()) {
				CardBean card = new CardBean(color, face);
				cardList.add(card);
			}
		}
	}

	@Override
	public String toString() {
		String deckToString = "";
		for (CardBean cardBean : cardList) {
			deckToString += cardBean.toString() + " ||| ";
		}
		return deckToString;
	}

	// methode deprecated
	@Deprecated
	public void printDeck() {
		for (CardBean cardBean : cardList) {
			System.out.println(cardBean.getFace() + " of " + cardBean.getColor());
		}
	}

}
