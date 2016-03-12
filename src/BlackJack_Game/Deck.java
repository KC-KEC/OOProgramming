package BlackJack_Game;

import java.util.Random;

public class Deck {
  private Card[] cards;
  private int numCards;
  private int index;

  public Deck(int numDecks) {
    this.numCards = 52 * numDecks;
    this.cards = new Card[52 * numDecks];

    int index = 0;
    for (int k = 0; k < numDecks; k++) {
      for (int i = 1; i <= 52; i++) {
        if (i <= 13) {
          cards[index++] = new Card(Suit.Spade, i);
        }
        else if (i <= 26) {
          cards[index++] = new Card(Suit.Heart, i - 13);
        }
        else if (i <= 39) {
          cards[index++] = new Card(Suit.Club, i - 26);
        }
        else {
          cards[index++] = new Card(Suit.Diamond, i - 39);
        }
      }
    }

    shuffle();
  }

  public Card dealCard() {
    if (index >= numCards) {
      return null;
    }
    return cards[index++];
  }

  private void shuffle() {
    Random rand = new Random();
    for (int i = 0; i < numCards; i++) {
      int j = rand.nextInt(i + 1);
      swap(i, j);
    }
  }

  private void swap(int i, int j) {
    Card tmp = cards[i];
    cards[i] = cards[j];
    cards[j] = tmp;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    for (Card card : cards) {
      sb.append(card).append("\n");
    }
    return sb.toString();
  }
}
