package BlackJack_Game;

public class Card {
  private final Suit suit;
  private final int value;

  public Card(Suit suit, int value) {
    if (suit == null || value < 1 || value > 13) {
      throw new IllegalArgumentException();
    }
    this.suit = suit;
    this.value = value;
  }

  public Suit getSuit() {
    return this.suit;
  }

  public int getValue() {
    return this.value;
  }

  @Override
  public boolean equals(Object o) {
    if (o == null) {
      return false;
    }
    if (o == this) {
      return true;
    }
    if (!(o instanceof Card)) {
      return false;
    }
    Card card = (Card) o;
    return card.getSuit() == this.getSuit() && card.getValue() == this.getValue();
  }

  @Override
  public int hashCode() {
    int result = 17;
    result = 31 * result + this.suit.hashCode();
    result = 31 * result + this.value;
    return result;
  }

  @Override
  public String toString() {
    return this.suit.toString() + " " + this.value;
  }
}
