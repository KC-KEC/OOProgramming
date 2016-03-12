package Musical_Jukebox;

interface State {
  void play(Song song, int start);
  void pause();
  void stop();
}
