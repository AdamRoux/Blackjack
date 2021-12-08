package wcs.blackjack.model;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
	
	private ArrayList<Card> deck = new ArrayList<Card>();

	public void createDeck() {
		// Cartes de valeur 2
		this.deck.add(new Card(2, "Carreau", "Deux"));
		this.deck.add(new Card(2, "Trèfle", "Deux"));
		this.deck.add(new Card(2, "Coeur", "Deux"));
		this.deck.add(new Card(2, "Pique", "Deux"));
		// Cartes de valeur 3
		this.deck.add(new Card(3, "Carreau", "Trois"));
		this.deck.add(new Card(3, "Trèfle", "Trois"));
		this.deck.add(new Card(3, "Coeur", "Trois"));
		this.deck.add(new Card(3, "Pique", "Trois"));
		// Cartes de valeur 4
		this.deck.add(new Card(4, "Carreau", "Quatre"));
		this.deck.add(new Card(4, "Trèfle", "Quatre"));
		this.deck.add(new Card(4, "Coeur", "Quatre"));
		this.deck.add(new Card(4, "Pique", "Quatre"));
		// Cartes de valeur 5
		this.deck.add(new Card(5, "Carreau", "Cinq"));
		this.deck.add(new Card(5, "Trèfle", "Cinq"));
		this.deck.add(new Card(5, "Coeur", "Cinq"));
		this.deck.add(new Card(5, "Pique", "Cinq"));
		// Cartes de valeur 6
		this.deck.add(new Card(6, "Carreau", "Six"));
		this.deck.add(new Card(6, "Trèfle", "Six"));
		this.deck.add(new Card(6, "Coeur", "Six"));
		this.deck.add(new Card(6, "Pique", "Six"));
		// Cartes de valeur 7
		this.deck.add(new Card(7, "Carreau", "Sept"));
		this.deck.add(new Card(7, "Trèfle", "Sept"));
		this.deck.add(new Card(7, "Coeur", "Sept"));
		this.deck.add(new Card(7, "Pique", "Sept"));
		// Cartes de valeur 8
		this.deck.add(new Card(8, "Carreau", "Huit"));
		this.deck.add(new Card(8, "Trèfle", "Huit"));
		this.deck.add(new Card(8, "Coeur", "Huit"));
		this.deck.add(new Card(8, "Pique", "Huit"));
		// Cartes de valeur 9
		this.deck.add(new Card(9, "Carreau", "Neuf"));
		this.deck.add(new Card(9, "Trèfle", "Neuf"));
		this.deck.add(new Card(9, "Coeur", "Neuf"));
		this.deck.add(new Card(9, "Pique", "Neuf"));
		// Cartes de valeur 10
		this.deck.add(new Card(10, "Carreau", "Dix"));
		this.deck.add(new Card(10, "Trèfle", "Dix"));
		this.deck.add(new Card(10, "Coeur", "Dix"));
		this.deck.add(new Card(10, "Pique", "Dix"));
		// Cartes de valeur Valet
		this.deck.add(new Card(10, "Carreau", "Valet"));
		this.deck.add(new Card(10, "Trèfle", "Valet"));
		this.deck.add(new Card(10, "Coeur", "Valet"));
		this.deck.add(new Card(10, "Pique", "Valet"));
		// Cartes de valeur Dame
		this.deck.add(new Card(10, "Carreau", "Dame"));
		this.deck.add(new Card(10, "Trèfle", "Dame"));
		this.deck.add(new Card(10, "Coeur", "Dame"));
		this.deck.add(new Card(10, "Pique", "Dame"));
		// Cartes de valeur Roi
		this.deck.add(new Card(10, "Carreau", "Roi"));
		this.deck.add(new Card(10, "Trèfle", "Roi"));
		this.deck.add(new Card(10, "Coeur", "Roi"));
		this.deck.add(new Card(10, "Pique", "Roi"));
		// Cartes de valeur As
		this.deck.add(new Card(11, "Carreau", "As"));
		this.deck.add(new Card(11, "Trèfle", "As"));
		this.deck.add(new Card(11, "Coeur", "As"));
		this.deck.add(new Card(11, "Pique", "As"));
		
	}
	
	// Affiche le deck dans la console
	public void showDeck() {
		for (Card card : this.deck) {
			System.out.println("- " + card.getRank() + " de " + card.getType() + " (" + card.getValue() + ")");
		}
	}
	
	public int calculateScore() {
		Integer score = 0;
		for (Card card : this.deck) {
			score += card.getValue();
		}
		return score;
	}
	
	public int calculateCards() {
		Integer cards = 0;
		for (Card card : this.deck) {
			cards++;
		}
		return cards;
	}
	
	// Mélange le deck
	public void shuffleDeck() {
		Collections.shuffle(deck);
	}
	
	public void removeCard() {
		this.deck.remove(0);
	}
	
	// Pioche une carte dans un deck à renseigner
	public void hitCard(Deck hitDeck) {
		// Ajouter au deck en cours (dépend de l'instance qui appelle la méthode) la première carte du deck choisi en argument
		this.deck.add(hitDeck.deck.get(0));
		// Retirer la carte piochée du deck choisi en argument
		hitDeck.removeCard();
	}
	
	
}
