package wcs.blackjack.model;

public class Player {

	private String name;
	private Deck playerDeck;
	private Integer score;
	
	public Player(String name) {
		this.name = name;
		this.playerDeck = new Deck();
		this.score = 0;
	}

	public String getName() {
		return name;
	}

	public Deck getPlayerDeck() {
		return playerDeck;
	}

	public void setPlayerDeck(Deck playerDeck) {
		this.playerDeck = playerDeck;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}
	
}
