package myPackage;

public class Launcher {

	public static void main(String[] args) {

		// instancation du nouveaux deck
		DeckBean deckBean = new DeckBean();
		// appel de la methode printDeck pour afficher la liste des carte dans la
		// console
		System.out.println(deckBean);
		deckBean.shuffleCards();
		System.out.println(deckBean);
	}

}
