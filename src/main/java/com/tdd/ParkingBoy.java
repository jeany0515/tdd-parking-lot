package com.tdd;

import java.util.Arrays;
import java.util.List;

public class ParkingBoy {

    private final List<ParkingLot> parkingLots;

    public ParkingBoy(ParkingLot... parkingLots){
        this.parkingLots = Arrays.asList(parkingLots);
    }

    public CarTicket park(Car car) {
        return parkingLots.get(0).park(car);
    }

    public Car fetch(CarTicket ticket) {
        return parkingLots.get(0).fetchCar(ticket);
    }
}
