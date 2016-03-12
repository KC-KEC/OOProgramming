package Musical_Jukebox;

public class Song {
  private final String name;
  private final Artist artist;
  private final int length;

  public Song(String name, Artist artist, int length) {
    this.name = name;
    this.artist = artist;
    this.length = length;
  }

  public String getName() {
    return this.name;
  }

  public Artist getArtist() {
    return this.artist;
  }

  public int getLength() {
    return this.length;
  }

  @Override
  public boolean equals(Object o) {
    if (o == null) {
      return false;
    }
    if (o == this) {
      return true;
    }
    if (!(o instanceof Song)) {
      return false;
    }
    Song s = (Song) o;
    return s.name.equals(this.name) && s.artist == this.artist;
  }

  @Override
  public int hashCode() {
    int result = 17;
    result = result * 31 + name.hashCode();
    result = result * 31 + artist.hashCode();
    return result;
  }

  @Override
  public String toString() {
    return this.name + " - " + this.artist;
  }
}
