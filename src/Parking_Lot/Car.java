package Parking_Lot;

public class Car extends Vehicle {

  public Car(int id) {
    this.id = id;
    this.size = VehicleSize.Compact;
  }

  @Override
  public boolean equals(Object o) {
    if (o == null) {
      return false;
    }
    if (o == this) {
      return true;
    }
    if (!(o instanceof Car)) {
      return false;
    }
    Car car = (Car) o;
    return car.id == this.id;
  }

  @Override
  public int hashCode() {
    int result = 17;
    return result * 31 + this.id;
  }

  @Override
  public String toString() {
    return "C" + this.id;
  }
}
