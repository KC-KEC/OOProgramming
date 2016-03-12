package Musical_Jukebox;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class RandomPlay implements SongSelector {
  private static Random rand;
  private List<Song> songList;
  private Set<Integer> hs;

  public RandomPlay() {
    hs = new HashSet<Integer>();
    rand = new Random();
  }

  @Override
  public Song nextSong() {
    int i = rand.nextInt(songList.size());
    while (this.hs.contains(i)) {
      i = rand.nextInt(songList.size());
    }
    hs.add(i);
    return songList.get(i);
  }

  @Override
  public boolean hasNext() {
    return hs.size() != songList.size();
  }

  @Override
  public void reset() {
    hs.clear();
  }

  @Override
  public void setList(List<Song> songList) {
    this.songList = songList;
  }
}
