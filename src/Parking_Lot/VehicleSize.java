package Parking_Lot;

public enum VehicleSize {
  Small(0),
  Compact(1),
  Large(2);

  final int value;
  VehicleSize(int value) {
    this.value = value;
  }
}