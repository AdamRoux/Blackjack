package wcs.blackjack.model;

public class Dealer {

	private String name;
	private Deck dealerDeck;
	private Integer score;
	
	public Dealer() {
		this.name = "Croupier";
		this.dealerDeck = new Deck();
		this.score = 0;
	}

	public String getName() {
		return name;
	}

	public Deck getDealerDeck() {
		return dealerDeck;
	}

	public void setDealerDeck(Deck dealerDeck) {
		this.dealerDeck = dealerDeck;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}
	
}
