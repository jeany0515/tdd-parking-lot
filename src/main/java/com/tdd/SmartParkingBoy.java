package com.tdd;

import java.util.Comparator;
import java.util.List;

public class SmartParkingBoy extends ParkingBoy {
    public SmartParkingBoy(ParkingLot... parkingLots) {
        super(parkingLots);
    }

    @Override
    public CarTicket park(Car car) {
        List<ParkingLot> availableLots = super.getAvailableParkingLots();
        return availableLots.stream().max((Comparator.comparing(ParkingLot::getAvailableNumber))).get().park(car);
    }
}
