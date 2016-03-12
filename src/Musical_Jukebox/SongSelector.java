package Musical_Jukebox;

import java.util.List;

/**
 *
 * Created by Kyle on 1/5/16.
 */
interface SongSelector {
  Song nextSong();
  void setList(List<Song> songList);
  void reset();
  boolean hasNext();
}
