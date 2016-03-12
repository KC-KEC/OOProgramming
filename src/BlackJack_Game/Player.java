package BlackJack_Game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Player {
  private String name;
  private List<Card> hand;
  private Deck deck;

  public Player(String name, Deck deck) {
    this.name = name;
    this.hand = new ArrayList<Card>();
    this.deck = deck;
  }

  public void initHand() {
    Card card1 = deck.dealCard();
    Card card2 = deck.dealCard();
    if (card1 != null && card2 != null) {
      hand.add(card1);
      hand.add(card2);
    }
    else {
      System.err.println("card is null");
    }
  }

  public void addCard() {
    Card card = deck.dealCard();
    if (card != null) {
      hand.add(card);
    }
    else {
      System.err.println("card is null");
    }
  }

  public void emptyHand() {
    this.hand.clear();
  }

  public int getScore() {
    int result = 0;
    int numAce = 0;
    for (Card card : hand) {
      if (card.getValue() == 1) {
        result += 11;
        numAce++;
      }
      else if (card.getValue() >= 10) {
        result += 10;
      }
      else {
        result += card.getValue();
      }
    }

    while (result > 21 && numAce > 0) {
      result -= 10;
      numAce--;
    }

    return result;
  }

  public String getName() {
    return this.name;
  }

  public List<Card> getHand() {
    return Collections.unmodifiableList(this.hand);
  }

  @Override
  public boolean equals(Object o) {
    if (o == null) {
      return false;
    }
    if (o == this) {
      return true;
    }
    if (!(o instanceof Player)) {
      return false;
    }
    Player player = (Player) o;
    return player.getName().equals(this.getName());
  }

  @Override
  public int hashCode() {
    int result = 17;
    if (this.name != null) result = 31 * result + this.name.hashCode();
    return result;
  }

  @Override
  public String toString() {
    return "PLayer " + this.name;
  }

}
