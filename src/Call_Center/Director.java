package Call_Center;

public class Director extends Employee {
  public Director(int id) {
    super(id);
    this.level = 3;
  }

  @Override
  public boolean equals(Object o) {
    if (o == null) {
      return false;
    }
    if (o == this) {
      return true;
    }
    if (!(o instanceof Director)) {
      return false;
    }
    Director director = (Director) o;
    return director.getId() == this.getId();
  }

  @Override
  public int hashCode() {
    return this.getId();
  }

  @Override
  public String toString() {
    return "Director " + this.getId();
  }
}
