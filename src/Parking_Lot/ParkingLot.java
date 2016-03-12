package Parking_Lot;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ParkingLot {
  private static final int LEVELS = 2;
  private List<Level> lot;

  /* Constructor */
  public ParkingLot() {
    lot = new ArrayList<Level>();
    for (int i = 0; i < LEVELS; i++) {
      lot.add(new Level(3));
    }
  }

  /* Park the given car */
  public boolean parking(Vehicle vehicle) {
    if (vehicle != null) {
      for (int i = 0; i < lot.size(); i++) {
        Level currLevel = lot.get(i);
        Spot[] spots = currLevel.nextSpot(vehicle);
        if (spots != null && spots.length != 0) {
          for (Spot spot : spots) {
            spot.park(vehicle);
            vehicle.setSpot(spots);
          }
          return true;
        }
      }
    }
    return false;
  }

  /* Remove the given car from its spot */
  public void remove(Vehicle vehicle) {
    if (vehicle != null && vehicle.getSpots() != null) {
      for (Spot spot : vehicle.getSpots()) {
        spot.remove();
      }
      vehicle.clearSpot();
    }
  }

  /* Getter and Setter */
  public List<Level> getLot() {
    return Collections.unmodifiableList(this.lot);
  }

  /* Print the parking lot */
  public void print() {
    for (int i = 0; i < lot.size(); i++) {
      lot.get(i).print();
      System.out.println();
    }
  }
}
