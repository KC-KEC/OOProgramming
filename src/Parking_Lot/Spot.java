package Parking_Lot;

public class Spot {

  private VehicleSize size;
  private boolean isAvailable;
  private Vehicle vehicle;

  public Spot(VehicleSize size) {
    this.size = size;
    this.isAvailable = true;
  }

  public boolean isAvailable() {
    return this.isAvailable;
  }

  public void park(Vehicle vehicle) {
    if (vehicle != null) {
      this.vehicle = vehicle;
      this.isAvailable = false;
    }
  }

  public void remove() {
    if (this.vehicle != null) {
      this.vehicle = null;
      this.isAvailable = true;
    }
  }

  public VehicleSize getSize() {
    return this.size;
  }

  public void print() {
    if (vehicle == null) {
      System.out.print("#");
    }
    else {
      System.out.print(vehicle);
    }
  }
}

