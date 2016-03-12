package Musical_Jukebox;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Playlist {
  private List<Song> playlist;

  public Playlist() {
    this.playlist = new LinkedList<>();
  }

  public void addAll(Playlist otherList) {
    if (otherList != null) {
      playlist.clear();
      playlist.addAll(otherList.getList());
    }
  }

  public void addAll(Album album) {
    if (album != null) {
      playlist.clear();
      playlist.addAll(album.getAlbum());
    }
  }

  public void add(Song song) {
    if (song != null) {
      this.playlist.add(song);
    }
  }

  public void remove(Song song) {
    if (song != null) {
      this.playlist.remove(song);
    }
  }

  public int size() {
    return this.playlist.size();
  }

  public void setSong(Song song) {
    if (song != null) {
      this.playlist.clear();
      this.playlist.add(song);
    }
  }

  public List getList() {
    return Collections.unmodifiableList(this.playlist);
  }
}
