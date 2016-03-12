package Parking_Lot;

public class Bus extends Vehicle {

  public Bus(int id) {
    this.id = id;
    this.size = VehicleSize.Large;
  }

  @Override
  public boolean equals(Object o) {
    if (o == null) {
      return false;
    }
    if (o == this) {
      return true;
    }
    if (!(o instanceof Bus)) {
      return false;
    }
    Bus bus = (Bus) o;
    return bus.id == this.id;
  }

  @Override
  public int hashCode() {
    int result = 17;
    return result * 31 + this.id;
  }

  @Override
  public String toString() {
    return "B" + this.id;
  }
}
