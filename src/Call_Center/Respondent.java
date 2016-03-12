package Call_Center;

public class Respondent extends Employee {
  public Respondent(int id) {
    super(id);
    this.level = 1;
  }

  @Override
  public boolean equals(Object o) {
    if (o == null) {
      return false;
    }
    if (o == this) {
      return true;
    }
    if (!(o instanceof Respondent)) {
      return false;
    }
    Respondent respondent = (Respondent) o;
    return respondent.getId() == this.getId();
  }

  @Override
  public int hashCode() {
    return this.getId();
  }

  @Override
  public String toString() {
    return "Respondent " + this.getId();
  }
}
