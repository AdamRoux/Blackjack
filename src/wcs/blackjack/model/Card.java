package wcs.blackjack.model;

public class Card {

	private Integer value;
	private String type;
	private String rank;
	
	public Card(Integer value, String type, String rank) {
		this.value = value;
		this.type = type;
		this.rank = rank;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

}
