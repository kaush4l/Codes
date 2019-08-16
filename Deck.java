import java.util.ArrayList;
import java.util.stream.Collectors;

public class Deck {

	private ArrayList<Card> allCards = new ArrayList<Card>();

	public Deck() {
		Suit[] suit = Suit.values();
		for (int i = 1; i <= 13; i++) {
			for (Suit s : suit) {
				allCards.add(new Card(s, i));
			}
		}
	}

	public ArrayList<Card> getSuits(Suit suit) {
		return (ArrayList<Card>) allCards.stream().filter(s -> s.getSuite() == suit).collect(Collectors.toList());
	}

	public ArrayList<Card> getAllCards() {
		return allCards;
	}
}

class Card {

	private int num;
	private Suit suite;
	private String name;
	private int score;

	public int getNum() {
		return num;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getScore() {
		return score;
	}

	public Suit getSuite() {
		return suite;
	}

	public String getValue() {
		return name;
	}

	public void setValue(String value) {
		this.name = value;
	}

	public Card(Suit suit, int num) {
		this.suite = suit;
		this.num = num;
		if (num > 1 && num < 11) {
			this.name = num + "";
			this.score = num;
		} else {
			this.score = 10;
			switch (num) {
			case 1:
				this.name = "A";
				break;
			case 11:
				this.name = "J";
				break;
			case 12:
				this.name = "Q";
				break;
			case 13:
				this.name = "K";
				break;
			}
		}
	}
}

enum Suit {
	SPADE, HEART, DIAMOND, CLUBS;
}