package myPackage;

public class Launcher {

	public static void main(String[] args) {

		// instancation du nouveaux deck
		DeckBean deck = new DeckBean();
		// appel de la methode printDeck pour afficher la liste des carte dans la
		// console
		System.out.println(deck);
		deck.shuffleCards();
		System.out.println(deck);
		deck.printNumberOfCards();

		HandBean hand = new HandBean();
		hand.addCard(deck.pickCard());
		hand.addCard(deck.pickCard());
		System.err.println();
		System.err.println(hand);
		deck.printNumberOfCards();

		PlayerBean player1 = new PlayerBean();
		player1.addHand(hand);
		System.out.println(player1.getHand().toString());
		player1.getHand().addCard(deck.pickCard());
		System.out.println(player1.getHand().toString());

	}

}
