package Parking_Lot;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kyle on 1/6/16.
 */
public abstract class Vehicle {
  int id;
  VehicleSize size;
  List<Spot> spots;

  public Vehicle() {
    this.spots = new ArrayList<>();
  }

  public int getId() {
    return this.id;
  }

  public VehicleSize getSize() {
    return this.size;
  }

  public List<Spot> getSpots() {
    return this.spots;
  }

  public void setSpot(Spot[] spots) {
    this.spots.clear();
    for (Spot spot : spots) {
      this.spots.add(spot);
    }
  }

  public void clearSpot() {
    this.spots.clear();
  }
}
