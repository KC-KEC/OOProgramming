package Parking_Lot;

public class Motocycle extends Vehicle {

  public Motocycle(int id) {
    this.id = id;
    this.size = VehicleSize.Small;
  }

  @Override
  public boolean equals(Object o) {
    if (o == null) {
      return false;
    }
    if (o == this) {
      return true;
    }
    if (!(o instanceof Motocycle)) {
      return false;
    }
    Motocycle moto = (Motocycle) o;
    return moto.id == this.id;
  }

  @Override
  public int hashCode() {
    int result = 17;
    return result * 31 + this.id;
  }

  @Override
  public String toString() {
    return "M" + this.id;
  }
}
