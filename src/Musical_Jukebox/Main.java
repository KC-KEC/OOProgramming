package Musical_Jukebox;

import java.util.ArrayList;
import java.util.List;

public class Main {

  private Artist Mayday = new Artist("Mayday");
  private Artist Justin = new Artist("Justin Biber");
  private Artist Jay = new Artist("Jay Chou");

  private Album makeJayAlbum() {
    Album album = new Album();
    for (int i = 0; i < 10; i++) {
      Song song = new Song("Jay" + i, Jay, 3);
      album.add(song);
    }
    return album;
  }

  private Album makeMaydayAlbum() {
    List<Song> list = new ArrayList<Song>();
    for (int i = 0; i < 10; i++) {
      Song song = new Song("Mayday" + i, Mayday, 3);
      list.add(song);
    }
    Album album = new Album(list);
    return album;
  }

  public static void main(String[] args) {
    Main main = new Main();
    Song baby = new Song("baby", main.Justin, 3);
    Playlist playlist = new Playlist();
    playlist.addAll(main.makeJayAlbum());
    Player player = Player.getInstance();
    player.setPlaylist(playlist);

    player.add(baby);
//    player.setSelector(new RandomPlay());
    player.play();

  }
}
