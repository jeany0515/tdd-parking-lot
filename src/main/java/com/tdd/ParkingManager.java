package com.tdd;

public class ParkingManager extends ParkingBoy {
    public ParkingManager(ParkingLot... parkingLots) {
        super(parkingLots);
    }

    public CarTicket assignPark(ParkingBoy parkingBoy, Car car) {
        return parkingBoy.park(car);
    }

    public Car assignFetch(ParkingBoy parkingBoy, CarTicket ticket) {
        return parkingBoy.fetch(ticket);
    }
}
