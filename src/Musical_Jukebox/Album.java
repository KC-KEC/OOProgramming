package Musical_Jukebox;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Album {
  private List<Song> album;

  public Album() {
    this.album = new ArrayList<>();
  }
  public Album(List<Song> list) {
    this.album = list;
  }

  public void add(Song song) {
    if (song != null) {
      this.album.add(song);
    }
  }

  public void remove(Song song) {
    if (song != null) {
      this.album.remove(song);
    }
  }

  public List<Song> getAlbum() {
    return Collections.unmodifiableList(this.album);
  }
}
