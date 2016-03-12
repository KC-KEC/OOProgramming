package Musical_Jukebox;

/**
 *
 * pause() and stop() method use state pattern
 * selector use strategy pattern
 *
 * Created by Kyle on 1/5/16.
 */
public class Player {
  private static Player instance = null;
  private Playlist playlist;
  private Song currSong;
  private SongSelector selector;
  private State playState;
  private State pauseState;
  private State stopState;
  private int currLength;

  private State state;

  private Player() {
    this.playlist = new Playlist();
    this.selector = new OrderPlay();
    this.playState = new PlayState(this);
    this.pauseState = new PauseState(this);
    this.stopState = new StopState(this);
    this.state = stopState;
  }

  /* singleton static method */
  public static Player getInstance() {
    if (instance == null) {
      instance = new Player();
    }
    return instance;
  }

  /* play given song */
  public void playSong(Song song) {
    state.play(song, 0);
  }

  /* select next song from play list according to select strategy */
  public void play() {
    if (this.playlist != null) {
      this.selector.setList(this.playlist.getList());
      int count = 0;
      while (this.selector.hasNext()) {
        currSong = this.selector.nextSong();
        play(currSong, 0);
        if (count == 5) {
          stop();
//          break;
        }
        count++;
      }
    }
  }

  /* simulate the playing */
  public void play(Song song, int start) {
    state.play(song, start);
  }

  /* stop playing */
  public void stop() {
    state.stop();
  }

  /* pause current playing */
  public void pause() {
    state.pause();
  }

  /* add a song to play list */
  public void add(Song song) {
    if (song != null) {
      this.playlist.add(song);
    }
  }

  /* remove a song from play list */
  public void remove(Song song) {
    if (song != null) {
      this.playlist.remove(song);
    }
  }

  /* add all songs to play list */
  public void setAlbum(Album album) {
    if (album != null) {
      this.playlist.addAll(album);
    }
  }

  public void setState(State state) {
    this.state = state;
  }

  /* getter and setter for playlist and album */
  public Playlist getPlaylist() {
    return this.playlist;
  }

  public void setPlaylist(Playlist newPlaylist) {
    this.playlist = newPlaylist;
  }

  public SongSelector getSelector() {
    return this.selector;
  }

  public void setSelector(SongSelector newSelector) {
    this.selector = newSelector;
  }

  public Song getSong() {
    return this.currSong;
  }

  public void setSong(Song song) {
    this.currSong = song;
  }

  public State getPlayState() {
    return this.playState;
  }

  public State getPauseState() {
    return this.pauseState;
  }

  public State getStopState() {
    return this.stopState;
  }
}
