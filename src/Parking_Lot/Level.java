package Parking_Lot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Each Level has many rows.
 * Each row has 10 spots.
 * The size of spots on the same row are of the same.
 * 1/3 rows are of small size, 1/3 are of large size, and the remainings are all compact size.
 *
 */
public class Level {
  private int rows;
  private static final int NUM_PER_ROW = 5;
  private List<List<Spot>> spots;// rows * NUM_PER_ROW matrix
  private Map<Integer, List<Integer>> rowIndex; // size.value -> list of rows

  public Level(int rows) {
    this.rows = rows;
    int smallRows = 0;
    int largeRows = 0;
    int compactRows = 0;

    if (rows < 3) {
      compactRows = rows;
    }
    else {
      smallRows = rows / 3;
      largeRows = rows / 3;
      compactRows = rows - smallRows - largeRows;
    }
    this.spots = new ArrayList<List<Spot>>();
    this.rowIndex = new HashMap<Integer, List<Integer>>();

    /* Initialize each row */
    for (int i = 0; i < rows; i++) {
      spots.add(new ArrayList<Spot>());
    }

    /* Initialize rowIndex map */
    for (int i = 0; i < VehicleSize.values().length; i++) {
      rowIndex.put(i, new ArrayList<Integer>());
    }

    /* Initialize each spot */
    /* Initialize rowIndex map */
    for (int i = 0; i < rows; i++) {
      if (i < smallRows) {
        for (int j = 0; j < NUM_PER_ROW; j++) {
          spots.get(i).add(new Spot(VehicleSize.Small));
        }
        rowIndex.get(VehicleSize.Small.value).add(i);
      }
      else if (i < smallRows + largeRows) {
        for (int j = 0; j < NUM_PER_ROW; j++) {
          spots.get(i).add(new Spot(VehicleSize.Large));
        }
        rowIndex.get(VehicleSize.Large.value).add(i);
      }
      else {
        for (int j = 0; j < NUM_PER_ROW; j++) {
          spots.get(i).add(new Spot(VehicleSize.Compact));
        }
        rowIndex.get(VehicleSize.Compact.value).add(i);
      }
    }
  }

  /* Check if there is any available spot for given vehicle */
  public Spot[] nextSpot(Vehicle vehicle) {
    if (vehicle != null) {
      VehicleSize size = vehicle.getSize();
      for (int i = size.value; i < rowIndex.size(); i++) {
        List<Integer> rowList = rowIndex.get(i);
        for (int currRow : rowList) {
          for (int j = 0; j < NUM_PER_ROW; j++) {
            Spot spot = spots.get(currRow).get(j);
            if (spot.isAvailable() && canFit(currRow, j, vehicle)) {
              if (vehicle.getSize() == VehicleSize.Large) {
                Spot[] result = new Spot[5];
                for (int k = 0; k < 5; k++) {
                  result[k] = spots.get(currRow).get(j + k);
                }
                return result;
              }
              else {
                Spot[] result = new Spot[1];
                result[0] = spot;
                return result;
              }
            }
          }
        }
      }
    }
    return null;
  }

  private boolean canFit(int row, int col, Vehicle vehicle) {
    if (vehicle.getSize() != VehicleSize.Large) {
      return true;
    }
    else if (NUM_PER_ROW - col < 5) {
      return false;
    }
    else {
      for (int j = col; j < col + 5; j++) {
        if (!spots.get(row).get(j).isAvailable()) {
          return false;
        }
      }
      return true;
    }
  }

  public void print() {
    for (int i = 0; i < spots.size(); i++) {
      for (int j = 0; j < spots.get(i).size(); j++) {
        spots.get(i).get(j).print();
        System.out.print(" ");
      }
      System.out.println();
    }
  }

}
