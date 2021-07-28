import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Deck class to create a deck, shuffle and filter based on suite
 */
public class Deck {

	private ArrayList<Card> allCards = new ArrayList<Card>();

	public Deck() {
		Stream.of(Suit.values()).forEach(s -> IntStream.rangeClosed(1, 13).forEach(i -> allCards.add(new Card(s, i))));
	}

	public ArrayList<Card> getSuits(Suit suit) {
		return (ArrayList<Card>) allCards.stream().filter(s -> s.getSuite() == suit).collect(Collectors.toList());
	}

	public ArrayList<Card> shuffle() {
		Collections.shuffle(allCards);
		return allCards;
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
