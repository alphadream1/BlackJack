package myPackage;

import java.util.ArrayList;

public class DeckBean {

	public ArrayList<CardBean> createDeck() {
		ArrayList<CardBean> cardList = new ArrayList<>();

		for (Color color : Color.values()) {
			for (Face face : Face.values()) {
				CardBean card = new CardBean(color, face);
				cardList.add(card);
			}
		}
		return cardList;
	}

	public void printDeck(ArrayList<CardBean> myDeck) {
		for (CardBean cardBean : myDeck) {
			System.out.println(cardBean.getFace() + " of " + cardBean.getColor());
		}
	}

}
