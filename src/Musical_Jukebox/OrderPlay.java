package Musical_Jukebox;

import java.util.Iterator;
import java.util.List;

public class OrderPlay implements SongSelector {
  private List<Song> songList;
  private int i;

  @Override
  public void reset() {
    this.i = 0;
  }

  @Override
  public boolean hasNext() {
    return i != this.songList.size();
  }

  @Override
  public Song nextSong() {
    return this.songList.get(i++);
  }

  @Override
  public void setList(List<Song> songList) {
    this.songList = songList;
    this.i = 0;
  }
}
