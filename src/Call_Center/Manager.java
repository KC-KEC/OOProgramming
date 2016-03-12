package Call_Center;

/**
 * Created by Kyle on 1/4/16.
 */
public class Manager extends Employee {
  public Manager(int id) {
    super(id);
    this.level = 2;
  }

  @Override
  public boolean equals(Object o) {
    if (o == null) {
      return false;
    }
    if (o == this) {
      return true;
    }
    if (!(o instanceof Manager)) {
      return false;
    }
    Manager manage = (Manager) o;
    return manage.getId() == this.getId();
  }

  @Override
  public int hashCode() {
    return this.getId();
  }

  @Override
  public String toString() {
    return "Manager " + this.getId();
  }
}
