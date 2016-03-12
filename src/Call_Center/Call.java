package Call_Center;

public class Call {
  private final int id;
  private int level;

  public Call(int id, int level) {
    this.id = id;
    this.level = level;
  }

  public void incrementLevel() {
    this.level++;
  }

  public int getId() {
    return this.id;
  }

  public int getLevel() {
    return this.level;
  }

  public void disconnect() {
    System.out.println("Call " + this.id + " end. Thanks for calling!");
  }

  @Override
  public boolean equals(Object o) {
    if (o == null) {
      return false;
    }
    if (o == this) {
      return true;
    }
    if (!(o instanceof Call)) {
      return false;
    }
    Call newCall = (Call) o;
    return newCall.getId() == this.getId();
  }

  @Override
  public int hashCode() {
    return this.getId();
  }

  @Override
  public String toString() {
    return "Call " + this.getId() + " of level " + this.getLevel();
  }
}
