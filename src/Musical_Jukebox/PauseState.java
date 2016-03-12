package Musical_Jukebox;

public class PauseState implements State {

  private Player player;

  public PauseState(Player player) {
    this.player = player;
  }

  @Override
  public void play(Song song, int start) {
    player.setState(player.getPlayState());
    if (song != null) {
      try {
        if (song.getName().equals("baby") && start == 0) {
          Thread.sleep(1000);
          pause();
          play(song, 1);
          Thread.sleep(song.getLength() * 1000 - 1000);
        }
        else{
          Thread.sleep((song.getLength() - start) * 1000);
        }
        System.out.println(song + " is playing. From " + start + " to " + song.getLength());
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

  @Override
  public void pause() {}

  @Override
  public void stop() {
    player.setState(player.getStopState());
    player.getSelector().reset();
    System.out.println("The player is stop");
  }
}
