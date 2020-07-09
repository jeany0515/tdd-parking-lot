package com.tdd;

public class ParkingBoy {
    public CarTicket park(ParkingLot parkingLot, Car car) {
        return parkingLot.park(car);
    }

    public Car fetch(ParkingLot parkingLot, CarTicket ticket) {
        return parkingLot.fetchCar(ticket);
    }
}
