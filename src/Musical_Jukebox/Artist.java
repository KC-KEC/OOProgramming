package Musical_Jukebox;

public class Artist {
  private final String name;

  public Artist(String name) {
    this.name = name;
  }

  public String getName() {
    return this.name;
  }

  @Override
  public boolean equals(Object o) {
    if (o == null) {
      return false;
    }
    if (o == this) {
      return true;
    }
    if (!(o instanceof Artist)) {
      return false;
    }
    Artist a = (Artist) o;
    return a.name.equals(this.name);
  }

  @Override
  public int hashCode() {
    int result = 17;
    return result * 31 + this.name.hashCode();
  }

  @Override
  public String toString() {
    return this.name;
  }
}
