package Parking_Lot;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
  public static void main(String[] args) {
    Random rand = new Random();
    ParkingLot parkLot = new ParkingLot();

    List<Motocycle> motoList = new ArrayList<>();
    List<Car> carList = new ArrayList<>();
    List<Bus> busList = new ArrayList<>();

    for (int i = 0; i < 20; i++) {
      motoList.add(new Motocycle(i));
      carList.add(new Car(i));
    }
    for (int i = 0; i < 2; i++) {
      busList.add(new Bus(i));
    }

    int iM = 0;
    int iC = 0;
    int iB = 0;
    for (int i = 0; i < 50; i++) {
      System.out.println(i);
      int type = rand.nextInt(4);

      if (type == 0 && iM < 20) {
        System.out.println(motoList.get(iM));
        parkLot.parking(motoList.get(iM++));
      }
      else if (type == 1 && iC < 20) {
        System.out.println(carList.get(iC));
        parkLot.parking(carList.get(iC++));
      }
      else if (type == 2 && iB < 2) {
        System.out.println(busList.get(iB));
        parkLot.parking(busList.get(iB++));
      }
      else if (type == 3) {
        System.out.println("remove");
        if (iB > 0) {
          parkLot.remove(busList.get(--iB));
        }
      }
      else if (iM < 20) {
        System.out.println(motoList.get(iM));
        parkLot.parking(motoList.get(iM++));
      }
      else if (iC < 20) {
        System.out.println(carList.get(iC));
        parkLot.parking(carList.get(iC++));
      }
      else {
        System.out.println(busList.get(iB));
        parkLot.parking(busList.get(iB++));
      }
      parkLot.print();
    }
  }
}
