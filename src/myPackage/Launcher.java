package myPackage;

import java.util.ArrayList;

public class Launcher {

	public static void main(String[] args) {

		// instancation du nouveaux deck
		DeckBean deckBean = new DeckBean();

		// appel la methode createDeck pour remplir le deck
		ArrayList<CardBean> myDeck = deckBean.createDeck();

		// appel de la methode printDeck pour afficher la liste des carte dans la
		// console
		deckBean.printDeck(myDeck);
	}

}
