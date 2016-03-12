package BlackJack_Game;

public class BlackJackApp {
  Deck deck = new Deck(1);
  Player p1 = new Player("p1", deck);
  Player p2 = new Player("p2", deck);

  public void start() {
    p1.initHand();
    p2.initHand();
    int round = 0;
    while (true) {
      System.out.println("Round " + round);
      System.out.println(p1 + " " + p1.getHand() + " " + p1.getScore());
      System.out.println(p2 + " " + p2.getHand() + " " + p2.getScore());

      if (isEnd()) {
        break;
      }

      if (p1.getScore() < 21) p1.addCard();
      if (p2.getScore() < 21) p2.addCard();

      System.out.println();
      round++;
    }
  }

  private boolean isEnd() {
    if (p1.getScore() > 21 && p2.getScore() > 21) {
      System.out.println("======== Draw ========");
      return true;
    }
    if (p1.getScore() > 21) {
      System.out.println("======== p2 win! ========");
      return true;
    }
    if (p2.getScore() > 21) {
      System.out.println("======== p1 win! ========");
      return true;
    }
    if (p1.getScore() == 21 && p2.getScore() != 21) {
      System.out.println("======== p1 win! ========");
      return true;
    }
    if (p1.getScore() != 21 && p2.getScore() == 21) {
      System.out.println("======== p2 win! ========");
      return true;
    }
    return false;
  }
}
