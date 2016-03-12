package Musical_Jukebox;

public class PlayState implements State {

  private Player player;

  public PlayState(Player player) {
    this.player = player;
  }

  @Override
  public void play(Song song, int start) {
    if (song != null) {
      try {
        if (song.getName().equals("baby") && start == 0) {
          Thread.sleep(1000);
          System.out.println(song + " is playing. From " + start + " to " + 1);
          pause();
          player.play(song, 1);
          Thread.sleep(song.getLength() * 1000 - 1000);
        }
        else {
          Thread.sleep((song.getLength() - start) * 1000);
          System.out.println(song + " is playing. From " + start + " to " + song.getLength());
        }
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

  @Override
  public void pause() {
    player.setState(player.getPauseState());
    System.out.println("The player is pause");
  }

  @Override
  public void stop() {
    player.setState(player.getStopState());
    player.getSelector().reset();
    System.out.println("The player is stop");
  }
}
