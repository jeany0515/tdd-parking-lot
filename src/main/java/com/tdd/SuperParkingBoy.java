package com.tdd;

import java.util.Comparator;
import java.util.List;

public class SuperParkingBoy extends ParkingBoy {
    public SuperParkingBoy(ParkingLot... parkingLots) {
        super(parkingLots);
    }

    @Override
    public CarTicket park(Car car) {
        List<ParkingLot> availableLots = super.getAvailableParkingLots();
        return availableLots.stream().max((Comparator.comparing(ParkingLot::getEmptyRate))).get().park(car);
    }
}
