package wcs.blackjack;

import wcs.blackjack.model.Deck;
import wcs.blackjack.model.Player;
import wcs.blackjack.model.Dealer;
import java.util.Scanner;

public class BlackJack {

	public static void main(String[] args) {
		// Message de début
		System.out.println("Bienvenue sur la table de Black Jack !");
		System.out.println();

		// Demander le nom du joueur
		Scanner scanner = new Scanner(System.in);
		System.out.print("Pour commencer, entrez le nom du joueur : ");
		String playerName = scanner.next();
		// Créer le joueur avec le nom renseigné
		Player player = new Player(playerName);

		// Créer un croupier
		Dealer dealer = new Dealer();

		// Créer un deck vide
		Deck deck = new Deck();
		// Remplir le deck avec les bonnes cartes
		deck.createDeck();
		// Mélanger le deck
		deck.shuffleDeck();
		System.out.println("Un deck de 52 cartes vient d'être généré et mélangé.");
		System.out.println("----------");

		// 1 - Le joueur obtient 2 cartes
		player.getPlayerDeck().hitCard(deck);
		player.getPlayerDeck().hitCard(deck);
		// Mise à jour du score du joueur
		player.setScore(player.getPlayerDeck().calculateScore());
		System.out.println("Le joueur " + player.getName() + " obtient les cartes : ");
		// Liste des 2 cartes obtenues
		player.getPlayerDeck().showDeck();
		// Affiche la valeur de la main actuelle
		System.out.println("La main de " + player.getName() + " vaut actuellement " + player.getScore() + " points.");
		// Si le joueur obtient un Black Jack (21 points), le préciser
		if (player.getScore() == 21)
			System.out.println(" BLACK JACK !!");
		System.out.println("----------");

		// 2 - Le croupier obtient 2 cartes
		dealer.getDealerDeck().hitCard(deck);
		// Mise à jour du score du croupier
		dealer.setScore(dealer.getDealerDeck().calculateScore());
		System.out.println("Le " + dealer.getName() + " obtient deux cartes dont une est retournée : ");
		// Liste des 2 cartes obtenues
		dealer.getDealerDeck().showDeck();
		System.out.println("- Carte retournée");
		// Affiche la valeur de la main actuelle
		System.out.println("La main de " + dealer.getName() + " vaut actuellement " + dealer.getScore() + " points.");
		dealer.getDealerDeck().hitCard(deck);
		dealer.setScore(dealer.getDealerDeck().calculateScore());
		System.out.println("----------");

		// 3 - Demander au joueur s'il continue ou pas
		if (player.getScore() < 21) {
			System.out.println(player.getName() + " souhaitez-vous tirer (t) ou rester (r) ?");
			String firstPlayerChoice = scanner.next();

			if (firstPlayerChoice.equals("t")) {
				player.getPlayerDeck().hitCard(deck);
				player.setScore(player.getPlayerDeck().calculateScore());
				System.out.println("Le joueur " + player.getName() + " dispose de la main suivante : ");
				player.getPlayerDeck().showDeck();
				// Affiche la valeur de la main actuelle
				System.out.println(
						"La main de " + player.getName() + " vaut actuellement " + player.getScore() + " points.");

				System.out.println("La carte retournée du croupier est révélée. Il dispose de la main suivante : ");
				dealer.getDealerDeck().showDeck();
				System.out.println(
						"La main du croupier vaut actuellement " + dealer.getScore() + " points.");
				
				if (player.getScore() > 21) {
					System.out.println("Le croupier gagne la partie !");
					System.out.println("----------");
				} else if(player.getScore() == 21) {
					System.out.println(player.getName() + " gagne la partie !");
					System.out.println("----------");
					firstPlayerChoice = "r";
				} else {
					System.out.println(player.getName() + " souhaitez-vous tirer (t) ou rester (r) ?");
					String secondPlayerChoice = scanner.next();

					if (secondPlayerChoice.equals("t")) {
						player.getPlayerDeck().hitCard(deck);
						player.setScore(player.getPlayerDeck().calculateScore());
						System.out.println("Le joueur " + player.getName() + " dispose de la main suivante : ");
						player.getPlayerDeck().showDeck();
						// Affiche la valeur de la main actuelle
						System.out.println(
								"La main de " + player.getName() + " vaut actuellement " + player.getScore() + " points. " + player.getName() + " dispose de 4 cartes en main, il ne peut plus obtenir de nouvelle carte.");
						if (player.getScore() <= 21) {
							while (dealer.getScore() <= 16) {
								System.out.println("Le croupier tire une nouvelle carte.");
								dealer.getDealerDeck().hitCard(deck);
								dealer.setScore(dealer.getDealerDeck().calculateScore());
								System.out.println("Le croupier dispose de la main suivante : ");
								dealer.getDealerDeck().showDeck();
								// Affiche la valeur de la main actuelle
								System.out.println("La main du croupier vaut actuellement " + dealer.getScore() + " points.");
							} 
							if (dealer.getScore() > 16 && dealer.getScore() <= 21) {
								if (dealer.getScore() > player.getScore()) System.out.println("Le croupier gagne la partie !");
								else if (dealer.getScore() < player.getScore()) System.out.println(player.getName() + " gagne la partie !");
								else if (dealer.getScore() == player.getScore()) System.out.println(player.getName() + " et le croupier ont le même score. Match nul !");
							} else if (dealer.getScore() > 21) System.out.println("Le croupier a dépassé 21 points, " + player.getName() + " gagne la partie !");
						} else {
							System.out.println(player.getName() + " a dépassé les 21 points, le croupier gagne la partie !");
						}
						
						
						
					} else if (secondPlayerChoice.equals("r")) {
						System.out.println("Le joueur " + player.getName() + " a décider de rester.");
						while (dealer.getScore() <= 16) {
							System.out.println("Le croupier tire une nouvelle carte.");
							dealer.getDealerDeck().hitCard(deck);
							dealer.setScore(dealer.getDealerDeck().calculateScore());
							System.out.println("Le croupier dispose de la main suivante : ");
							dealer.getDealerDeck().showDeck();
							// Affiche la valeur de la main actuelle
							System.out.println("La main du croupier vaut actuellement " + dealer.getScore() + " points.");
						} 
						if (dealer.getScore() > 16 && dealer.getScore() <= 21) {
							if (dealer.getScore() > player.getScore()) System.out.println("Le croupier gagne la partie !");
							else if (dealer.getScore() < player.getScore()) System.out.println(player.getName() + " gagne la partie !");
							else if (dealer.getScore() == player.getScore()) System.out.println(player.getName() + " et le croupier ont le même score. Match nul !");
						} else if (dealer.getScore() > 21) System.out.println("Le croupier a dépassé 21 points, " + player.getName() + " gagne la partie !");
					}
				}				

				// Si le joueur décider de RESTER
			} else if (firstPlayerChoice.equals("r")) {
				System.out.println("Le joueur " + player.getName() + " a décider de rester.");
				System.out.println("La carte retournée du croupier est révélée. Il dispose de la main suivante : ");
				dealer.getDealerDeck().showDeck();
				System.out.println(
						"La main du croupier vaut actuellement " + dealer.getScore() + " points.");
				
				while (dealer.getScore() <= 16) {
					System.out.println("Le croupier tire une nouvelle carte.");
					dealer.getDealerDeck().hitCard(deck);
					dealer.setScore(dealer.getDealerDeck().calculateScore());
					System.out.println("Le croupier dispose de la main suivante : ");
					dealer.getDealerDeck().showDeck();
					// Affiche la valeur de la main actuelle
					System.out.println("La main du croupier vaut actuellement " + dealer.getScore() + " points.");
				} 
				if (dealer.getScore() > 16 && dealer.getScore() <= 21) {
					if (dealer.getScore() > player.getScore()) System.out.println("Le croupier gagne la partie !");
					else if (dealer.getScore() < player.getScore()) System.out.println(player.getName() + " gagne la partie !");
					else if (dealer.getScore() == player.getScore()) System.out.println(player.getName() + " et le croupier ont le même score. Match nul !");
				} else if (dealer.getScore() > 21) System.out.println("Le croupier a dépassé 21 points, " + player.getName() + " gagne la partie !");
			}
				
		} else if (player.getScore() == 21){
			System.out.println(player.getName() + " gagne la partie.");
		}
	}
}
